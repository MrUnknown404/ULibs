package main.java.ulibs.ucrypt;

import java.util.Random;

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
}
