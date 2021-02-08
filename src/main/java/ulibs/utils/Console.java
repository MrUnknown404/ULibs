package main.java.ulibs.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import main.java.ulibs.Main;

/** @author -Unknown- */
public final class Console {
	
	static PrintWriter prt;
	
	/** Weather or not to show the thread in the debug information */
	public static boolean showThread;
	private static final WarningType[] DISABLED_TYPES = { WarningType.RegisterDebug, WarningType.TextureDebug };
	
	/**Sets up a {@link PrintWriter} to save the console output to file.
	 * Also automatically deletes any logs after
	 * @param logFolder The folder to write logs to
	 * @param maxAmountOfLogs The amount of logs to keep
	 */
	public static void setupLogFile(File logFolder, int maxAmountOfLogs) {
		SimpleDateFormat sdf = new SimpleDateFormat("hh-mm-ss-SSS");
		String curDate = sdf.format(new Date());
		
		if (!logFolder.exists()) {
			logFolder.mkdirs();
		} else {
			int curAmount = 0;
			for (File f : logFolder.listFiles()) {
				if (f.getName().endsWith(".log") && f.getName().length() == 20) {
					try {
						sdf.parse(f.getName().substring(4, f.getName().length() - 4));
						curAmount++;
					} catch (ParseException e) {
						continue;
					}
				}
			}
			
			if (curAmount >= maxAmountOfLogs) {
				while (curAmount >= maxAmountOfLogs) {
					File oldest = null;
					for (File f : logFolder.listFiles()) {
						if (f.getName().endsWith(".log") && f.getName().length() == 20) {
							try {
								Date d = sdf.parse(f.getName().substring(4, f.getName().length() - 4));
								
								if (oldest != null) {
									if (d.before(sdf.parse(oldest.getName().substring(4, oldest.getName().length() - 4)))) {
										oldest = f;
									}
								} else {
									oldest = f;
								}
							} catch (ParseException e) {
								continue;
							}
						} else {
							continue;
						}
					}
					
					oldest.delete();
					
					curAmount = 0;
					for (File f : logFolder.listFiles()) {
						if (f.getName().endsWith(".log") && f.getName().length() == 20) {
							try {
								sdf.parse(f.getName().substring(4, f.getName().length() - 4));
								curAmount++;
							} catch (ParseException e) {
								continue;
							}
						}
					}
				}
			}
		}
		
		File log = new File(logFolder + "\\Log-" + curDate + ".log");
		
		try {
			FileOutputStream os = new FileOutputStream(log);
			System.setOut(new ConsolePrintStream(os, System.out));
			System.setErr(new ConsolePrintStream(os, System.err));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			prt = new PrintWriter(log);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/** Prints date info to the console Example: <p> [12:34:56:789] [Info] [ExampleClass.exampleMethod.69] [Hour/Minute/Second/Millisecond] */
	public static void getTimeExample() {
		String msg = "[" + new SimpleDateFormat("hh:mm:ss:SSS").format(new Date()) + "]" + (showThread ? " [T/" + Thread.currentThread().getName() + "] " : " ") +
				"[" + WarningType.Info + "] [" + getCallerInfo(Console.class) + "] [Hour/Minute/Second/Millisecond]";
		
		System.out.println(msg);
	}
	
	/** Prints date info plus the given string to the console Example: <p> [12:34:56:789] [Debug] [ExampleClass.exampleMethod.69] : Hello! 
	 * @param type The type of warning to display. Defaults to {@link WarningType#Debug} if null
	 * @param string The string to print
	 * @param shouldThrow Weather or not to throw an exception
	 */
	public static void print(WarningType type, String string, boolean shouldThrow) {
		if (type == null) {
			String msg = "[" + new SimpleDateFormat("hh:mm:ss:SSS").format(new Date()) + "] [Debug] [" + getCallerInfo(Console.class) + "] : " + string;
			
			System.out.println(msg);
			return;
		}
		
		if (!Main.isDebug) {
			for (WarningType t : DISABLED_TYPES) {
				if (t == type) {
					return;
				}
			}
		}
		
		if (type == WarningType.Error || type == WarningType.FatalError) {
			String msg = "[" + new SimpleDateFormat("hh:mm:ss:SSS").format(new Date()) + "]" +
					(showThread ? " [T/" + Thread.currentThread().getName() + "] " : " ") + "[" + type.toString() + "] [" + getCallerInfo(Console.class) + "] : " +
					string;
			System.err.println(msg);
		} else {
			String msg = "[" + new SimpleDateFormat("hh:mm:ss:SSS").format(new Date()) + "]" +
					(showThread ? " [T/" + Thread.currentThread().getName() + "] " : " ") + "[" + type.toString() + "] [" + getCallerInfo(Console.class) + "] : " +
					string;
			System.out.println(msg);
		}
		
		if (shouldThrow) {
			try {
				throw new Exception(string);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/** Prints date info plus the given string to the console Example: <p> [12:34:56:789] [Debug] [ExampleClass.exampleMethod.69] : Hello!
	 * @param type The type of warning to display. Defaults to {@link WarningType#Debug}
	 * @param string The string to print
	 */
	public static void print(WarningType type, String string) {
		print(type, string, false);
	}
	
	/** Prints date info plus the given string to the console Example: <p> [12:34:56:789] [Debug] [ExampleClass.exampleMethod.69] : Hello! <br>
	 * Defaults to {@link WarningType#Debug}
	 * @param string The string to print
	 */
	public static void print(String string) {
		print(null, string);
	}
	
	private static String getCallerInfo(Class<?> clazz) {
		StackTraceElement[] stElements = Thread.currentThread().getStackTrace();
		for (int i = 1; i < stElements.length; i++) {
			StackTraceElement ste = stElements[i];
			if (!ste.getClassName().equals(clazz.getName()) && ste.getClassName().indexOf("java.lang.Thread") != 0) {
				return (ste.getClassName().replaceAll(ste.getClassName().substring(0, ste.getClassName().lastIndexOf('.') + 1), "") + "." + ste.getMethodName() +
						"." + ste.getLineNumber()).replace("$", ".").replace("<", "").replace(">", "");
			}
		}
		
		return null;
	}
	
	@SuppressWarnings("javadoc")
	public enum WarningType {
		Debug,
		Info,
		Warning,
		Error,
		FatalError,
		
		TextureDebug,
		RegisterDebug;
	}
}
