package org.nirvana;

import java.net.URL;
import java.net.URLClassLoader;

public class Main2 {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		CustomizedClassLoader loader = new CustomizedClassLoader();
		Class clz = loader.findClass("org.springframework.context.ApplicationContext");
		System.out.println(clz.getName());
		for (Package pkg : Package.getPackages()) {
			if (pkg.getName().startsWith("org.")) {
				System.out.println(pkg.getName());
			}
		}
	}
}
