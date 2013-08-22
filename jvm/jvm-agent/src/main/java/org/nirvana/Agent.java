package org.nirvana;

import java.lang.instrument.Instrumentation;

public class Agent {
	public static void premain(String args,Instrumentation instr){
		System.out.println("Enter premain()");
	}
	
	public static void agentmain(String agentArgs, Instrumentation inst){
		System.out.println("Enter agentmain()");
	}
}
