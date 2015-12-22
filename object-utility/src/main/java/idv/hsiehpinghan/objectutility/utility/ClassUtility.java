package idv.hsiehpinghan.objectutility.utility;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.core.type.filter.TypeFilter;

public class ClassUtility {
	// private Logger logger = Logger.getLogger(this.getClass().getName());

	/**
	 * Get annotated class from basePackage.
	 * 
	 * @param basePackage
	 * @param annotation
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static Class<?>[] getAnnotatedClasses(String basePackage,
			Class<? extends Annotation> annotation)
			throws ClassNotFoundException {
		return getClassesByFilter(basePackage, new AnnotationTypeFilter(
				annotation));
	}

	/**
	 * Get assignable class of clazz from basePackage.
	 * 
	 * @param basePackage
	 * @param clazz
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static Class<?>[] getAssignableClasses(String basePackage,
			Class<?> clazz) throws ClassNotFoundException {
		return getClassesByFilter(basePackage, new AssignableTypeFilter(clazz));
	}

	/**
	 * Get classes in a package.
	 * 
	 * @param packageName
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static List<Class<?>> getClasses(String packageName)
			throws IOException, ClassNotFoundException {
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		String path = packageName.replace('.', '/');
		Enumeration<URL> resources = classLoader.getResources(path);
		List<Class<?>> classes = new ArrayList<Class<?>>();
		while (resources.hasMoreElements()) {
			String loc = resources.nextElement().getPath();
			List<Class<?>> clses = getClassesInDirectory(packageName, new File(
					loc));
			classes.addAll(clses);
		}
		return classes;
	}

	/**
	 * Cast object to clazz.
	 * 
	 * @param object
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T find(Object object, Class<T> clazz) {
		return (T) object;
	}

	private static List<Class<?>> getClassesInDirectory(String packageName,
			File directory) throws ClassNotFoundException {
		String[] subFiles = directory.list();
		List<Class<?>> classes = new ArrayList<Class<?>>();
		for (String subFile : subFiles) {
			File sf = new File(directory, subFile);
			if (sf.isDirectory()) {
				String pkgName = packageName + "." + sf.getName();
				List<Class<?>> clses = getClassesInDirectory(pkgName, sf);
				classes.addAll(clses);
			} else {
				String className = StringUtils
						.removeEnd(sf.getName(), ".class");
				classes.add(Class.forName(packageName + "." + className));
			}
		}

		return classes;
	}

	private static Class<?>[] getClassesByFilter(String basePackage,
			TypeFilter filter) throws ClassNotFoundException {
		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(
				false);
		scanner.addIncludeFilter(filter);
		List<Class<?>> classes = new ArrayList<Class<?>>();
		for (BeanDefinition beanDef : scanner
				.findCandidateComponents(basePackage)) {
			Class<?> clazz = Class.forName(beanDef.getBeanClassName());
			classes.add(clazz);
		}
		Class<?>[] clsArr = new Class<?>[classes.size()];
		classes.toArray(clsArr);
		return clsArr;
	}
}
