package main.java.ulibs.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import main.java.ulibs.Main;

/** @author -Unknown- */
public final class Console {
	
	/** Weather or not to show the thread in the debug information */
	public static boolean showThread;
	private static final WarningType[] DISABLED_TYPES = { WarningType.RegisterDebug, WarningType.TextureDebug };
	
	/** Prints date info to the console Example: <p> [12:34:56:789] [Info] [ExampleClass.exampleMethod.69] [Hour/Minute/Second/Millisecond] */
	public static void getTimeExample() {
		System.out.println(
				"[" + new SimpleDateFormat("hh:mm:ss:SSS").format(new Date()) + "]" + (showThread ? " [T/" + Thread.currentThread().getName() + "] " : " ") + "[" +
						WarningType.Info + "] [" + getCallerInfo(Console.class) + "] [Hour/Minute/Second/Millisecond]");
	}
	
	/** Prints date info plus the given string to the console Example: <p> [12:34:56:789] [Debug] [ExampleClass.exampleMethod.69] : Hello! 
	 * @param type The type of warning to display. Defaults to {@link WarningType#Debug}
	 * @param string The string to print
	 * @param shouldThrow Weather or not to throw an exception
	 */
	public static void print(WarningType type, String string, boolean shouldThrow) {
		if (type == null) {
			System.out.println(
					"[" + new SimpleDateFormat("hh:mm:ss:SSS").format(new Date()) + "] [Debug] [" + getCallerInfo(Console.class) + "] : " + string);
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
			System.err.println(
					"[" + new SimpleDateFormat("hh:mm:ss:SSS").format(new Date()) + "]" + (showThread ? " [T/" + Thread.currentThread().getName() + "] " : " ") +
							"[" + type.toString() + "] [" + getCallerInfo(Console.class) + "] : " + string);
		} else {
			System.out.println(
					"[" + new SimpleDateFormat("hh:mm:ss:SSS").format(new Date()) + "]" + (showThread ? " [T/" + Thread.currentThread().getName() + "] " : " ") +
							"[" + type.toString() + "] [" + getCallerInfo(Console.class) + "] : " + string);
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
