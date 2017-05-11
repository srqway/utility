package idv.hsiehpinghan.resourceutility.utility;

import java.io.File;
import java.nio.charset.Charset;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import idv.hsiehpinghan.resourceutility.configuration.SpringConfiguration;

@Profile("test")
@ContextConfiguration(classes = { SpringConfiguration.class })
public class CsvUtilityTest extends AbstractTestNGSpringContextTests {
	@Autowired
	private ResourceLoader resourceLoader;

	@Test
	public void getParserAtDataStartRow() throws Exception {
		File file = resourceLoader.getResource("sample/sii_24.csv").getFile();
		String[] targetTitles = getTargetTitles();
		CSVParser parser = CsvUtility.getParserAtDataStartRow(file, Charset.forName("big5"), CSVFormat.EXCEL,
				targetTitles);
		CSVRecord record = parser.iterator().next();
		Assert.assertEquals("9th Fl.,No 320,Sec.4, Chung Hsiao E. RD.,Taipei Taiwan R.O.C", record.get(25));
	}

	private String[] getTargetTitles() {
		return new String[] { "公司代號", "公司名稱", "住址", "營利事業統一編號", "董事長", "總經理", "發言人", "發言人職稱", "代理發言人", "總機電話", "成立日期",
				"上市日期", "普通股每股面額", "實收資本額(元)", "已發行普通股數或TDR原發行股數", "私募普通股(股)", "特別股(股)", "編製財務報告類型", "股票過戶機構", "過戶電話",
				"過戶地址", "簽證會計師事務所", "簽證會計師1", "簽證會計師2", "英文簡稱", "英文通訊地址", "傳真機號碼", "電子郵件信箱", "網址" };
	}
}
