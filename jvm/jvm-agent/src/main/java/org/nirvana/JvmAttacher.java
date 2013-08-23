package org.nirvana;

import java.io.IOException;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

public class JvmAttacher
{
    public static void main(String args[])
        throws InterruptedException, AgentLoadException, AgentInitializationException, IOException,
        AttachNotSupportedException
    {
        VirtualMachine virtualMachine = com.sun.tools.attach.VirtualMachine.attach(args[0]);

        virtualMachine.loadAgentPath(args[1], null);

        virtualMachine.detach();
    }
}
