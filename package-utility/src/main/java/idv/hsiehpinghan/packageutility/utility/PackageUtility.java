package idv.hsiehpinghan.packageutility.utility;

import idv.hsiehpinghan.regexutility.RegexUtility;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PackageUtility {
	public static PackageUtility getInstance() {
		return new PackageUtility();
	}
	
	/**
	 * Get spring configuration packages.
	 * @return
	 * @throws IOException
	 */
	public String[] getSpringConfigurationPackages() throws IOException {
		return getPackageNames(RegexUtility.SPRING_CONFIGURATION_PACKAGE_REGEX);
	}

	private String[] getPackageNames(String regex) throws IOException {
		List<String> pkgNames = new ArrayList<String>();
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		Enumeration<URL> resources = classLoader.getResources("");
		while (resources.hasMoreElements()) {
			String loc = resources.nextElement().getPath();
			List<String> pkgNms = getPackagesInDirectory(null, new File(loc), regex);
			pkgNames.addAll(pkgNms);
		}
		return pkgNames.toArray(new String[pkgNames.size()]);
	}
	
	private List<String> getPackagesInDirectory(String packageName, File directory, String regex) {
		List<String> dirs = new ArrayList<String>();
		String[] subFiles = directory.list();
		for (String subFile : subFiles) {
			File sf = new File(directory, subFile);
			if (sf.isDirectory()) {
				String pkgName;
				if(packageName == null) {
					pkgName = sf.getName();
				} else {
					pkgName = packageName + "." + sf.getName();
				}
				if(pkgName.matches(regex)) {
					dirs.add(pkgName);
				}
				// Find sub-directory.
				List<String> ds = getPackagesInDirectory(pkgName, sf, regex);
				dirs.addAll(ds);
			}
		}
		return dirs;
	}
}
