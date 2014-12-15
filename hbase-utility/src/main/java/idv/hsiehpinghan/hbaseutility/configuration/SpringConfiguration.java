package idv.hsiehpinghan.hbaseutility.configuration;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.hadoop.hbase.HbaseTemplate;

@Configuration
@ComponentScan(basePackages = { "idv.hsiehpinghan.hbaseutility.utility" })
@PropertySource("classpath:hbase-utility.properties")
public class SpringConfiguration {
	private Logger logger = Logger.getLogger(this.getClass().getName());

	@Autowired
	private Environment environment;

	@Bean
	public HbaseTemplate hbaseTemplate() {
		HbaseTemplate hbaseTemplate = new HbaseTemplate(hbaseConfiguration());
		return hbaseTemplate;
	}

	@Bean
	public org.apache.hadoop.conf.Configuration hbaseConfiguration() {
		org.apache.hadoop.conf.Configuration config = new org.apache.hadoop.conf.Configuration();
		addProperties(config);

		// Show properties info.
		Iterator<Map.Entry<String, String>> iter = config.iterator();
		while (iter.hasNext()) {
			Map.Entry<String, String> entry = iter.next();
			logger.info("hbase-utility configuration :" + entry.getKey()
					+ " : " + entry.getValue());
		}

		return config;
	}

	@Bean
	public HBaseAdmin hBaseAdmin() throws Exception {
		return new HBaseAdmin(hbaseConfiguration());
	}

	private void addProperties(org.apache.hadoop.conf.Configuration config) {
		String[] items = { "hbase.zookeeper.quorum" };
		for (String item : items) {
			String prop = environment.getProperty(item);
			if (prop == null) {
				throw new RuntimeException(item + " not set !!!");
			} else {
				config.set(item, prop);
			}
		}
	}
}
