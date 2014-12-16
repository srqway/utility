package idv.hsiehpinghan.hbaseutility.utility;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class HbaseUtility {
	@Autowired
	@Qualifier("hbaseConfiguration")
	private Configuration config;
	@Autowired
	private HBaseAdmin admin;

	/**
	 * Create table.
	 * @param tableName
	 * @param families
	 * @throws IOException
	 */
	public void createTable(String tableName, String[] families)
			throws IOException {
		HTableDescriptor tDesc = new HTableDescriptor(
				TableName.valueOf(tableName));
		for (int i = 0; i < families.length; i++) {
			HColumnDescriptor cDesc = new HColumnDescriptor(families[i]);
			tDesc.addFamily(cDesc);
		}
		admin.createTable(tDesc);
	}

	/**
	 * Drop table.
	 * @param tableName
	 * @throws IOException
	 */
	public void dropTable(String tableName) throws IOException {
		if(admin.isTableEnabled(tableName)) {
			admin.disableTable(tableName);
		}
		admin.deleteTable(tableName);
	}
	
	/**
	 * Judging if table exists.
	 * @param tableName
	 * @return
	 * @throws IOException
	 */
	public boolean isTableExists(String tableName) throws IOException {
		return admin.tableExists(tableName);
	}

}
