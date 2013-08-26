package org.nirvana;

import java.lang.instrument.Instrumentation;

public class AgentMain
{
    public static void agentmain(String agentArgs, Instrumentation inst)
    {
        System.out.println("Enter agentmain()");
    }
}
