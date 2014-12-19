import idv.hsiehpinghan.resourceutility.utility.ResourceUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Vector;

import jcx.xbrl.data.XbrlContext;
import jcx.xbrl.data.XbrlDocument;
import jcx.xbrl.taxonomy.XbrlTaxonomy;

public class Test {
	public static void main(String[] args) throws Exception {
		// Get taxonomy.
		File schema = ResourceUtility
				.getFileResource(
						new Test().getClass().getClassLoader(),
						"xbrl-schema/tifrs-20130331/XBRL_TW_Entry_Points/CI/CR/tifrs-ci-cr-2013-03-31.xsd");
		XbrlTaxonomy t1 = new XbrlTaxonomy(schema.getParent(), schema.getName());
		XbrlDocument xd = new XbrlDocument();
		File instance = ResourceUtility
				.getFileResource(new Test().getClass().getClassLoader(),
						"xbrl-instance/2013-01-sii-01-C/tifrs-fr0-m1-ci-cr-1101-2013Q1.xml");
		InputStream is = new FileInputStream(instance.getAbsolutePath());
		xd.load(t1, is);

		Vector<?> objVector = xd.getPureContext();
		for (int i = 0, size = objVector.size(); i < size; ++i) {
			XbrlContext objContext = (XbrlContext) objVector.elementAt(i);
			String contextId = objContext.getID();
			System.err.println(contextId);
		}

	}
}
