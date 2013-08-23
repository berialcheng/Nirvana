package org.nirvana;

import java.lang.instrument.Instrumentation;

public class PreMain {

    static Instrumentation instr;

	public static void premain(String args,Instrumentation instr){
        PreMain.instr = instr;
		System.out.println("Enter premain()");
	}

    public static long getObjectSize(Object obj)
    {
        return instr.getObjectSize(obj);
    }
}
