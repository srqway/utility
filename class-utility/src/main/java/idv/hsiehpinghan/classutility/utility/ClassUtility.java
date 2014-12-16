package idv.hsiehpinghan.classutility.utility;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class ClassUtility {
	// private Logger logger = Logger.getLogger(this.getClass().getName());

	/**
	 * Get classes in a package.
	 * @param packageName
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public List<Class<?>> getClasses(String packageName) throws IOException, ClassNotFoundException {
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		String path = packageName.replace('.', '/');
		Enumeration<URL> resources = classLoader.getResources(path);
		List<Class<?>> classes = new ArrayList<Class<?>>();
		while (resources.hasMoreElements()) {
			String loc = resources.nextElement().getPath();
			List<Class<?>> clses = getClassesInDirectory(packageName, new File(loc));
			classes.addAll(clses);
		}
		return classes;
	}
	
	private List<Class<?>> getClassesInDirectory(String packageName, File directory) throws ClassNotFoundException {
		String[] subFiles = directory.list();
		List<Class<?>> classes = new ArrayList<Class<?>>();
		for (String subFile : subFiles) {
			File sf = new File(directory, subFile);
			if (sf.isDirectory()) {
				String pkgName = packageName + "." + sf.getName();
				List<Class<?>> clses = getClassesInDirectory(pkgName, sf);
				classes.addAll(clses);
			} else {
				String className = StringUtils.removeEnd(sf.getName(), ".class");
				classes.add(Class.forName(packageName + "." + className));
			}
		}

		return classes;
	}

}
