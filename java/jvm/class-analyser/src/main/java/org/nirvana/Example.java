package org.nirvana;

import java.io.Serializable;

@ClassAnno("dummy")
public class Example implements Serializable,Comparable {
	
	public static Object staticMember;
	
	private String name;
	
	@MemberAnno(columnName = "ha")
	private int haha;

	public Example(String name, int haha) throws Exception{
		super();
		this.name = name;
		this.haha = haha;
	}
	
	private static int privateStaticMethod(){
		return 0;
	}
	
	private int privateMethod(){
		final int localVar = 1;
		class LocalClass{
			int localClassMember ;
			
			int localClassMethod(){
				return localVar + haha;
			}
		}
		new Runnable(){
			int anonymousMember = 2;	
			public void run() {
				System.out.println(localVar + anonymousMember);
			}
		}.run();
		return 0;
	}

	public int compareTo(Object o) {
		return 0;
	}
	
	@Override
	public String toString(){
		return "abc";
	}
	
	static class StaticNestedClass {
		public String innerMethod(){
			privateStaticMethod();
			return "";
		}
	}
	
	class NestedClass {
		public String innerMethod(){
			privateMethod();
			return "";
		}
    }
}
