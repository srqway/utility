package idv.hsiehpinghan.htmlutility.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.core.io.ClassPathResource;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.xml.sax.SAXException;

public class HtmlUtilityTest {
	private String html;

	@BeforeClass
	public void beforeClass() throws SAXException, IOException {
		BufferedReader bufferedReader = null;
		try {
			InputStream inputStream = new ClassPathResource("html/htmlutility.html").getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			bufferedReader = new BufferedReader(inputStreamReader);
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				sb.append(line);
			}
			html = sb.toString();
		} finally {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
		}
	}

	// @Test
	public void removeComment() {
		Assert.assertFalse(HtmlUtility.removeComment(html).contains("<!--"));
	}

	// @Test
	public void removeTag() {
		Assert.assertFalse(HtmlUtility.removeTag(html, "ScRiPt").contains("<script"));
	}

	// @Test
	public void replaceTagAttribute() {
		System.err.println(HtmlUtility.replaceTagAttribute(html, "a", "href", "#"));
	}
}
