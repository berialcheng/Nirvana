package com.nirvana;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NIO New I/O
 */
public class NIO {
	public static void main(String[] args) throws IOException {
		FileInputStream fin = new FileInputStream(NIO.class.getClassLoader().getResource("data.json").getFile());
		FileChannel fc = fin.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		fc.read(buffer);
		System.out.println(buffer);
		System.out.write(buffer.array());
	}
}
