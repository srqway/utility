package idv.hsiehpinghan.htmlutility.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.core.io.ClassPathResource;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

public class HtmlUtilityTest {
	private String html;

	@BeforeClass
	public void beforeClass() throws SAXException, IOException {
		try (InputStream inputStream = new ClassPathResource("html/htmlutility.html").getInputStream();
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);) {

			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				sb.append(line);
			}
			html = sb.toString();
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
		System.err.println(HtmlUtility.replaceTagAttribute(html, "a", "href", "javascript:void(0)"));
	}

	// @Test
	public void appendLinkHrefDomain() {
		System.err.println(HtmlUtility.appendTagAttributeDomain(html, "link", "href", "http://www.google.com/test/"));
	}

	// @Test
	public void appendImgSrcDomain() {
		System.err.println(HtmlUtility.appendTagAttributeDomain(html, "img", "src", "http://www.google.com/test/"));
	}

	// @Test
	public void addStringToTag() {
		String string = "<style type=\"text/css\">.target {background-color: red;</style>";
		System.err.println(HtmlUtility.addStringToTag(html, "head", string));
	}

	// @Test
	public void replaceMetaCharset() {
		String replaceStr = "testCharset";
		System.err.println(HtmlUtility.replaceMetaCharset(html, replaceStr));
	}

	@Test
	public void replaceMetaContentLanguage() {
		String replaceStr = "testCharset";
		System.err.println(HtmlUtility.replaceMetaContentLanguage(html, replaceStr));
	}
}
