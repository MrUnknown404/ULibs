package main.java.ulibs.utils;

import java.io.OutputStream;
import java.io.PrintStream;

class ConsolePrintStream extends PrintStream {
	
	private final PrintStream def;
	
	public ConsolePrintStream(OutputStream out, PrintStream def) {
		super(out, true);
		this.def = def;
	}
	
	@Override
	public void write(byte[] buf, int off, int len) {
		char[] cbuf = new char[buf.length];
		for (int i = 0; i < buf.length; i++) {
			cbuf[i] = (char) buf[i];
		}
		
		Console.prt.write(cbuf, off, len);
		Console.prt.flush();
		def.write(buf, off, len);
	}
}
