package org.nirvana;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Analyser {

	private final static int TAB_SIZE = 8;

	private final static int TAB_COUNT = 3;

	public static void main(String[] args) throws Exception {

		/*
		 * if(args.length == 0 ){ return; }
		 * 
		 * String className = args[0];
		 */
//		Class clz = Class.forName("org.nirvana.GenericClass");
		Class clz = new GenericClass<Integer>().getClass();
		
		System.out.println(clz.getTypeParameters()[0]);
		System.out.println("****************************************Meta*****************************************");
		System.out.println(clz.getPackage().getName());
		System.out.println();
		if (clz.getEnclosingClass() != null) {
			System.out.print("Enclosing class: " + clz.getEnclosingClass().getCanonicalName());
		}
		if (clz.getEnclosingMethod() != null) {
			System.out.println(" ==> Enclosing method: " + clz.getEnclosingMethod());
		}else{
			System.out.println();
		}
		if (clz.getAnnotations().length > 0) {
			for (Annotation anno : clz.getDeclaredAnnotations()) {
				System.out.println(parseAnnotation(anno));
			}
		}

		System.out.print(clz.getSimpleName());
		if (Object.class.equals(clz.getSuperclass())) {
			System.out.print(" extends " + clz.getSuperclass().getSimpleName());
		}

		if (clz.getInterfaces().length != 0) {
			int count = 0;
			for (Class interfaceClz : clz.getInterfaces()) {
				if (count == 0) {
					System.out.print(" implements " + interfaceClz.getSimpleName());
				} else {
					System.out.print(", " + interfaceClz.getSimpleName());
				}
				count++;
			}
		}
		System.out.println();

		System.out.println("****************************************Field*****************************************");
		printWithTab("Modifier");
		printWithTab("FieldName");
		printWithTab("FieldType");
		printWithTab("Static");
		printWithTab("Annotation");
		printTab();
		for (Field field : clz.getDeclaredFields()) {
			printWithTab(Integer.toString(field.getModifiers()));
			printWithTab(field.getName());
			printWithTab(field.getType().getSimpleName());
			printWithTab((Modifier.isStatic(field.getModifiers()) == true ? "+" : "-"));
			String annoStr = "";
			for (Annotation anno : field.getDeclaredAnnotations()) {
				annoStr += parseAnnotation(anno) + " ";
			}
			printWithTab("[" + annoStr + "]");
			printTab();
		}
		System.out.println("**************************************Constructor**************************************");
		printWithTab("Modifier");
		printWithTab("ParamType");
		printWithTab("Exception");
		printTab();
		for (Constructor constructor : clz.getConstructors()) {
			printWithTab(Integer.toString(constructor.getModifiers()));
			String paramStr = "";
			for (Class paramType : constructor.getParameterTypes()) {
				paramStr += paramType.getSimpleName() + " ";
			}
			printWithTab("[" + paramStr + "]");

			String exceptionStr = "";
			for (Class exception : constructor.getExceptionTypes()) {
				exceptionStr += exception.getSimpleName() + " ";
			}
			printWithTab("[" + exceptionStr + "]");

			printTab();
		}
		System.out.println("****************************************Method*****************************************");
		printWithTab("Modifier");
		printWithTab("MethodName");
		printWithTab("ReturnType");
		printWithTab("ParamType");
		printWithTab("Exception");
		printWithTab("Annotation");
		printTab();
		for (Method method : clz.getDeclaredMethods()) {
			printWithTab(Integer.toString(method.getModifiers()));
			printWithTab(method.getName());
			printWithTab(method.getReturnType().getSimpleName());
			String paramStr = "";
			for (Class paramType : method.getParameterTypes()) {
				paramStr += paramType.getSimpleName() + " ";
			}
			printWithTab("[" + paramStr + "]");

			String exceptionStr = "";
			for (Class exception : method.getExceptionTypes()) {
				exceptionStr += exception.getSimpleName() + " ";
			}
			printWithTab("[" + exceptionStr + "]");

			String annoStr = "";
			for (Annotation anno : method.getDeclaredAnnotations()) {
				annoStr += parseAnnotation(anno) + " ";
			}
			printWithTab("[" + annoStr + "]");
			printTab();
		}
	}

	public static void printWithoutTab(String str) {
		System.out.print(str);
	}

	public static void printWithTab(String str) {
		int remain = TAB_COUNT - str.length() / TAB_SIZE;
		System.out.print(str);
		for (int i = 0; i < remain; i++) {
			System.out.print("\t");
		}
	}

	public static void printTab() {
		System.out.println();
	}

	public static String parseAnnotation(Annotation anno) throws Exception {
		String retval = "@" + anno.annotationType().getSimpleName() + "(";
		int count = 0;
		for (Method method : anno.annotationType().getDeclaredMethods()) {
			if (count != 0) {
				retval += ",";
			}
			retval += method.getName() + "=" + method.invoke(anno);
			count++;
		}
		return retval + ")";
	}

}
