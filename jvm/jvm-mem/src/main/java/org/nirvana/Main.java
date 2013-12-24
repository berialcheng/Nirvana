package org.nirvana;

import java.net.URL;

public class Main {

	public static void main(String[] args) throws Exception {
		Class clz = Main.class;
		for(Package pkg : Package.getPackages()){	
			URL url = clz.getClassLoader().getResource(pkg.getName().replace('.', '/'));
			System.out.println(pkg.getName() + " " + url);
		}
		
		
		System.out.println(Runtime.getRuntime().maxMemory());
		System.out.println(Runtime.getRuntime().totalMemory());
		System.out.println(Runtime.getRuntime().freeMemory());
		//Thread.currentThread().sleep(600000);
	}

}
