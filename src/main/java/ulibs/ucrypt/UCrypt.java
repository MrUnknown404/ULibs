package main.java.ulibs.ucrypt;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

import main.java.ulibs.utils.Console;
import main.java.ulibs.utils.Console.WarningType;

/** @author -Unknown- */
public class UCrypt {
	
	/** Encodes the given string using a randomized cipher based around the given seed
	 * @param seed The seed to use for the randomized cipher algorithm
	 * @param str The string to encode
	 * @return The given string encoded with a randomized cipher based around the given seed
	 */
	public static String encode(String seed, String str) {
		return encode(seed.hashCode(), str);
	}
	
	/** Decodes the given string using a reversed randomized cipher based around the given seed
	 * @param seed The seed to use for the randomized cipher algorithm
	 * @param str The string to decode
	 * @return The given string decoded with a reversed randomized cipher based around the given seed
	 */
	public static String decode(String seed, String str) {
		return decode(seed.hashCode(), str);
	}
	
	/** Encodes the given string using a randomized cipher based around the given seed
	 * @param seed The seed to use for the randomized cipher algorithm
	 * @param str The string to encode
	 * @return The given string encoded with a randomized cipher based around the given seed
	 */
	public static String encode(long seed, String str) {
		Random r = new Random(seed);
		StringBuilder sb = new StringBuilder();
		
		for (char c : str.toCharArray()) {
			int num = (c + r.nextInt(1000)) % 127;
			sb.append((char) num);
		}
		
		return sb.toString();
	}
	
	/** Encodes the given bytes using a randomized cipher based around the given seed
	 * @param seed The seed to use for the randomized cipher algorithm
	 * @param bytes The bytes to encode
	 * @return The given bytes encoded with a randomized cipher based around the given seed as a string
	 */
	public static String encode(long seed, byte[] bytes) {
		Random r = new Random(seed);
		StringBuilder sb = new StringBuilder();
		
		for (byte b : bytes) {
			int num = (b + r.nextInt(1000)) % 127;
			sb.append((char) num);
		}
		
		return sb.toString();
	}
	
	/** Decodes the given string using a reversed randomized cipher based around the given seed
	 * @param seed The seed to use for the randomized cipher algorithm
	 * @param str The string to decode
	 * @return The given string decoded with a reversed randomized cipher based around the given seed
	 */
	public static String decode(long seed, String str) {
		Random r = new Random(seed);
		StringBuilder sb = new StringBuilder();
		
		for (char c : str.toCharArray()) {
			int num = (1270 + c - r.nextInt(1000)) % 127;
			sb.append((char) num);
		}
		
		return sb.toString();
	}
	
	/** Encodes the given {@link ICryptable} using a randomized cipher based around the given seed
	 * @param seed The seed to use for the randomized cipher algorithm
	 * @param obj The {@link ICryptable} to encode
	 * @return The given {@link ICryptable} encoded with a randomized cipher based around the given seed as a string
	 */
	public static String encode(long seed, ICryptable<?> obj) {
		Random r = new Random(seed);
		StringBuilder sb = new StringBuilder();
		
		for (byte b : obj.toBytes()) {
			int num = (b + r.nextInt(1000)) % 127;
			sb.append((char) num);
		}
		
		return sb.toString();
	}
	
	/** Decodes the given string using a reversed randomized cipher based around the given seed
	 * @param seed The seed to use for the randomized cipher algorithm
	 * @param str The string to decode into an {@link ICryptable}
	 * @param clazz The {@link ICryptable} Class
	 * @return The given string decoded with a reversed randomized cipher based around the given seed
	 */
	@SuppressWarnings("unchecked")
	public static <T extends ICryptable<T>> T decode(long seed, String str, Class<T> clazz) {
		Random r = new Random(seed);
		StringBuilder sb = new StringBuilder();
		
		for (char c : str.toCharArray()) {
			int num = (1270 + c - r.nextInt(1000)) % 127;
			sb.append((char) num);
		}
		
		try {
			T t = clazz.getDeclaredConstructor().newInstance();
			Method m = clazz.getMethod("fromString", String.class);
			return (T) m.invoke(t, sb.toString());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e1) {
			Console.print(WarningType.FatalError, "Class '" + clazz.getSimpleName() + "' does not have a public empty constructor!", true);
			return null;
		}
	}
}
