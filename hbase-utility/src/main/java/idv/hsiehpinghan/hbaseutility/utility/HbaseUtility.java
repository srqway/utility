package idv.hsiehpinghan.hbaseutility.utility;

import idv.hsiehpinghan.classutility.utility.ClassUtility;
import idv.hsiehpinghan.hbaseutility.annotation.ColumnFamily;
import idv.hsiehpinghan.hbaseutility.annotation.Table;
import idv.hsiehpinghan.hbaseutility.enumeration.TableOperation;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.data.hadoop.hbase.TableCallback;
import org.springframework.stereotype.Component;

@Component
public class HbaseUtility {
	@Autowired
	@Qualifier("hbaseConfiguration")
	private Configuration config;
	@Autowired
	private HBaseAdmin admin;
	@Autowired
	private ClassUtility classUtility;
	@Autowired
	private HbaseTemplate hbaseTemplate;

	/**
	 * Scan package and create table.
	 * 
	 * @param packageName
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public void scanAndCreateTable(String packageName, TableOperation operation)
			throws ClassNotFoundException, IOException {
		List<Class<?>> classes = classUtility.getClasses(packageName);
		for (Class<?> cls : classes) {
			Table table = cls.getAnnotation(Table.class);
			if (table == null) {
				continue;
			}
			String tableNm = table.value();

			Field[] fields = cls.getDeclaredFields();
			List<String> colFamNms = new ArrayList<String>();
			for (Field field : fields) {
				ColumnFamily colFam = field.getAnnotation(ColumnFamily.class);
				if (colFam != null) {
					colFamNms.add(field.getName());
				}
			}
			String[] colFamArr = colFamNms
					.toArray(new String[colFamNms.size()]);

			if (isTableExists(tableNm)) {
				switch (operation) {
				case ADD_NONEXISTS:
					continue;
				case DROP_CREATE:
					dropTable(tableNm);
					break;
				default:
					throw new RuntimeException("Not implements !!!");
				}
			}
			createTable(tableNm, colFamArr);
		}
	}

	/**
	 * Create table.
	 * 
	 * @param tableName
	 * @param families
	 * @throws IOException
	 */
	void createTable(String tableName, String[] columnFamilies)
			throws IOException {
		HTableDescriptor tDesc = new HTableDescriptor(
				TableName.valueOf(tableName));
		for (int i = 0; i < columnFamilies.length; i++) {
			HColumnDescriptor cDesc = new HColumnDescriptor(columnFamilies[i]);
			tDesc.addFamily(cDesc);
		}
		admin.createTable(tDesc);
	}

	/**
	 * Drop table.
	 * 
	 * @param tableName
	 * @throws IOException
	 */
	void dropTable(String tableName) throws IOException {
		if (admin.isTableEnabled(tableName)) {
			admin.disableTable(tableName);
		}
		admin.deleteTable(tableName);
	}

	/**
	 * Judging if table exists.
	 * 
	 * @param tableName
	 * @return
	 * @throws IOException
	 */
	boolean isTableExists(String tableName) throws IOException {
		return admin.tableExists(tableName);
	}
	
	void put(Object entity, final String rowKey) {
		Class<?> cls = entity.getClass(); 
		Table table = cls.getAnnotation(Table.class);
		if(table == null) {
			throw new RuntimeException("Not a table entity !!!");
		}
		String tableName = table.value();
		// Get column families
		Field[] fields = cls.getDeclaredFields();
		for (Field field : fields) {
			ColumnFamily colFam = field.getAnnotation(ColumnFamily.class);
			if(colFam == null) {
				continue;
			}
			String colFamNm = field.getName();
		}

//		String qualifier;
//		String value;
//		hbaseTemplate.execute(tableName, new TableCallback<String>() {
//			@Override
//			public String doInTable(HTableInterface table) throws Throwable {
//				Put p = new Put(Bytes.toBytes(rowKey));
//				p.add(family, qualifier, value)
//			}
//		});

//		return hbaseTemplate.execute(tableName, new TableCallback<User>() {
//			public User doInTable(HTableInterface table) throws Throwable {
//				User user = new User(userName, email, password);
//				Put p = new Put(Bytes.toBytes(user.getName()));
//				p.add(CF_INFO, qUser, Bytes.toBytes(user.getName()));
//				p.add(CF_INFO, qEmail, Bytes.toBytes(user.getEmail()));
//				p.add(CF_INFO, qPassword, Bytes.toBytes(user.getPassword()));
//				table.put(p);
//				return user;
//
//			}
//		});
	}

}
