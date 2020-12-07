package main.java.ulibs.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import main.java.ulibs.Main;

public final class Console {
	
	public static boolean showThread;
	private static final WarningType[] DISABLED_TYPES = { WarningType.RegisterDebug, WarningType.TextureDebug };
	
	/** Prints date info to the console Example: <p> [12:34:56:789] [Info] [ExampleClass.exampleMethod.69] [Hour/Minute/Second/Millisecond] */
	public static void getTimeExample() {
		System.out.println(
				"[" + new SimpleDateFormat("hh:mm:ss:SSS").format(new Date()) + "]" + (showThread ? " [T/" + Thread.currentThread().getName() + "] " : " ") + "[" +
						WarningType.Info + "] [" + getCallerInfo(Console.class.getName()) + "] [Hour/Minute/Second/Millisecond]");
	}
	
	/** Prints date info plus the given string to the console Example: <p> [12:34:56:789] [Debug] [ExampleClass.exampleMethod.69] : Hello! */
	public static void print(WarningType type, String string, boolean shouldThrow) {
		if (type == null) {
			System.out.println(
					"[" + new SimpleDateFormat("hh:mm:ss:SSS").format(new Date()) + "] [Debug] [" + getCallerInfo(Console.class.getName()) + "] : " + string);
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
							"[" + type.toString() + "] [" + getCallerInfo(Console.class.getName()) + "] : " + string);
		} else {
			System.out.println(
					"[" + new SimpleDateFormat("hh:mm:ss:SSS").format(new Date()) + "]" + (showThread ? " [T/" + Thread.currentThread().getName() + "] " : " ") +
							"[" + type.toString() + "] [" + getCallerInfo(Console.class.getName()) + "] : " + string);
		}
		
		if (shouldThrow) {
			try {
				throw new Exception(string);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/** Prints date info plus the given string to the console Example: <p> [12:34:56:789] [Debug] [ExampleClass.exampleMethod.69] : Hello! */
	public static void print(WarningType type, String string) {
		print(type, string, false);
	}
	
	/** Prints date info plus the given string to the console Example: <p> [12:34:56:789] [Debug] [ExampleClass.exampleMethod.69] : Hello! */
	public static void print(String string) {
		print(null, string);
	}
	
	/** Gets what class is called */
	public static String getCallerInfo(String className) {
		StackTraceElement[] stElements = Thread.currentThread().getStackTrace();
		for (int i = 1; i < stElements.length; i++) {
			StackTraceElement ste = stElements[i];
			if (!ste.getClassName().equals(className) && ste.getClassName().indexOf("java.lang.Thread") != 0) {
				return (ste.getClassName().replaceAll(ste.getClassName().substring(0, ste.getClassName().lastIndexOf('.') + 1), "") + "." + ste.getMethodName() +
						"." + ste.getLineNumber()).replace("$", ".").replace("<", "").replace(">", "");
			}
		}
		
		return null;
	}
	
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
