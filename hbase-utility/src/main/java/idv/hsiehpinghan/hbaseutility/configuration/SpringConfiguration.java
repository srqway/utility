package idv.hsiehpinghan.hbaseutility.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.hadoop.hbase.HbaseTemplate;

@Configuration("hbaseUtilitySpringConfiguration")
@ComponentScan(basePackages = { "idv.hsiehpinghan.hbaseutility.utility" })
public class SpringConfiguration {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	@Autowired
	private org.apache.hadoop.conf.Configuration hbaseConfiguration;
	
	@Bean
	public HbaseTemplate hbaseTemplate() throws IOException {
		HbaseTemplate hbaseTemplate = new HbaseTemplate(hbaseConfiguration);
		return hbaseTemplate;
	}

	@Bean
	public org.apache.hadoop.conf.Configuration hbaseConfiguration()
			throws IOException {
		org.apache.hadoop.conf.Configuration config = new org.apache.hadoop.conf.Configuration();
		addConfiguration(config);

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

	private void addConfiguration(org.apache.hadoop.conf.Configuration config)
			throws IOException {
		String fileName = "hbase-site.xml";
		Resource resource = new ClassPathResource(fileName);
		File file = resource.getFile();
		if (file.exists() == false) {
			throw new RuntimeException(fileName + " not exists !!!");
		}
		config.addResource(new FileInputStream(file));
	}
}
