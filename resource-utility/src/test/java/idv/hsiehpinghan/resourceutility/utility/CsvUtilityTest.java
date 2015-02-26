package idv.hsiehpinghan.resourceutility.utility;

import idv.hsiehpinghan.datatypeutility.utility.CharsetUtility;
import idv.hsiehpinghan.testutility.utility.SystemResourceUtility;

import java.io.File;

import junit.framework.Assert;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.testng.annotations.Test;

public class CsvUtilityTest {

	@Test
	public void getParserAtDataStartRow() throws Exception {
		File file = SystemResourceUtility.getFileResource("sample/sii_24.csv");
		String[] targetTitles = getTargetTitles();
		CSVParser parser = CsvUtility.getParserAtDataStartRow(file,
				CharsetUtility.BIG5, CSVFormat.EXCEL, targetTitles);
		CSVRecord record = parser.iterator().next();
		Assert.assertEquals(
				"9th Fl.,No 320,Sec.4, Chung Hsiao E. RD.,Taipei Taiwan R.O.C",
				record.get(25));
	}

	private String[] getTargetTitles() {
		return new String[] { "公司代號", "公司名稱", "住址", "營利事業統一編號", "董事長", "總經理",
				"發言人", "發言人職稱", "代理發言人", "總機電話", "成立日期", "上市日期", "普通股每股面額",
				"實收資本額(元)", "已發行普通股數或TDR原發行股數", "私募普通股(股)", "特別股(股)",
				"編製財務報告類型", "股票過戶機構", "過戶電話", "過戶地址", "簽證會計師事務所", "簽證會計師1",
				"簽證會計師2", "英文簡稱", "英文通訊地址", "傳真機號碼", "電子郵件信箱", "網址" };
	}
}
