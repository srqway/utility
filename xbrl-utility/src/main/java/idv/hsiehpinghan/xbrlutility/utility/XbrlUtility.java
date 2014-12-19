package idv.hsiehpinghan.xbrlutility.utility;

import idv.hsiehpinghan.resourceutility.utility.ResourceUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import jcx.xbrl.data.XbrlDocument;
import jcx.xbrl.taxonomy.XbrlTaxonomy;

public class XbrlUtility {
	// private Logger logger = Logger.getLogger(this.getClass().getName());

	/**
	 * Get taxonomy.
	 * @param taxonomyPath
	 * @return
	 * @throws Exception
	 */
	public static XbrlTaxonomy getXbrlTaxonomy(String taxonomyPath) throws Exception {
		ClassLoader classLoader = XbrlUtility.class.getClassLoader();
		File taxonomy = ResourceUtility.getFileResource(classLoader,taxonomyPath);
		return new XbrlTaxonomy(taxonomy.getParent(), taxonomy.getName());
	}
	
	/**
	 * Load instance.
	 * @param taxonomy
	 * @param instancePath
	 * @return
	 * @throws Exception
	 */
	public static XbrlDocument loadXbrlDocument(XbrlTaxonomy taxonomy, String instancePath) throws Exception {
		ClassLoader classLoader = XbrlUtility.class.getClassLoader();
		File instance = ResourceUtility.getFileResource(classLoader, instancePath);
		XbrlDocument xDoc = new XbrlDocument();
		InputStream is = new FileInputStream(instance.getAbsolutePath());
		xDoc.load(taxonomy, is);
		return xDoc;
	}
	

}
