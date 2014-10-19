package org.nirvana;

import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Main {

	public static void main(String[] args) throws Exception {

		Class.forName("org.springframework.context.ApplicationContext");
		Class.forName("org.springframework.web.package-info");
		Class.forName("org.springframework.aop.package-info");
		Class.forName("org.springframework.beans.package-info");
		Class.forName("org.apache.velocity.VelocityContext");
		// Class.forName("org.apache.hadoop.package-info");

		for (Package pkg : Package.getPackages()) {
			if (pkg.getName().startsWith("org")) {
				URL url = Thread.currentThread().getContextClassLoader().getResource(pkg.getName().replace('.', '/'));
				if (url.getProtocol().equals("jar")) {
					JarFile jar = ((JarURLConnection) url.openConnection()).getJarFile();
					Enumeration<JarEntry> entries = jar.entries();
					while (entries.hasMoreElements()) {
						JarEntry entry = entries.nextElement();
						if (entry.getName().endsWith(".class")) {
							// System.out.println(entry.getName().replaceAll("\\.class",
							// "").replaceAll("/", "."));
							try {
								Class.forName(entry.getName().replaceAll("\\.class", "").replaceAll("/", "."));
							} catch (java.lang.ClassNotFoundException e) {
							} catch (java.lang.NoClassDefFoundError e) {
							} catch (java.lang.ExceptionInInitializerError e) {
							} catch (Exception e) {
							}
						}
					}
				}
			}
		}

		new Runnable() {
			public void run() {
				while (true) {
					System.out.print("[Heap] Max : " + Runtime.getRuntime().maxMemory() / 1024 / 1024 + "M");
					System.out.print(" | Total: " + Runtime.getRuntime().totalMemory() / 1024 / 1024 + "M");
					System.out.println(" | Free: " + Runtime.getRuntime().freeMemory() / 1024 / 1024 + "M");
					try {
						Thread.currentThread().sleep(60000);
					} catch (InterruptedException e) {
					}
				}
			}
		}.run();

		Thread.currentThread().sleep(600000);
	}
}
