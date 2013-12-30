package org.nirvana;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class CustomizedClassLoader extends ClassLoader {

	@Override
	protected Class findClass(String name) throws ClassNotFoundException {
		byte[] b = null;
		String fileName = name.replaceAll("\\.", "/") + ".class";
		for (URL url : ((URLClassLoader) ClassLoader.getSystemClassLoader()).getURLs()) {
			try {
				InputStream is = null;
				if (url.getPath().endsWith(".jar")) {
					JarFile jar = new JarFile(url.getPath());
					JarEntry entry = (JarEntry) jar.getEntry(fileName);
					if (entry != null) {
						is = jar.getInputStream(jar.getEntry(fileName));
						b = new byte[is.available()];
						is.read(b);
						is.close();
					}
				} else {
					is = new FileInputStream(new File(url.getPath() + fileName));
					b = new byte[is.available()];
					is.read(b);
					is.close();
				}
			} catch (FileNotFoundException e) {
			} catch (IOException e) {
			} finally {
				if (b != null) {
					break;
				}
			}
		}
		if(b==null)
			throw new ClassNotFoundException(name);
		return super.defineClass(name, b, 0, b.length);
	}

	@Override
	protected URL findResource(String name) {
		URL url = null;
		try {
			url = new URL(name);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return url;
	}
}
