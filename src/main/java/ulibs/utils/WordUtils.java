package main.java.ulibs.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordUtils {
	public static String wrap(final String str, int wrapLength, String newLineStr, final boolean wrapLongWords, String wrapOn) {
		final Pattern patternToWrapOn = Pattern.compile(wrapOn);
		final int inputLineLength = str.length();
		int offset = 0;
		final StringBuilder wrappedLine = new StringBuilder(inputLineLength + 32);
		
		while (offset < inputLineLength) {
			int spaceToWrapAt = -1;
			Matcher matcher = patternToWrapOn.matcher(str.substring(offset, Math.min((int) Math.min(Integer.MAX_VALUE, offset + wrapLength + 1L), inputLineLength)));
			if (matcher.find()) {
				if (matcher.start() == 0) {
					offset += matcher.end();
					continue;
				}
				spaceToWrapAt = matcher.start() + offset;
			}
			
			if (inputLineLength - offset <= wrapLength) {
				break;
			}
			
			while (matcher.find()) {
				spaceToWrapAt = matcher.start() + offset;
			}
			
			if (spaceToWrapAt >= offset) {
				wrappedLine.append(str, offset, spaceToWrapAt);
				wrappedLine.append(newLineStr);
				offset = spaceToWrapAt + 1;
				
			} else {
				if (wrapLongWords) {
					wrappedLine.append(str, offset, wrapLength + offset);
					wrappedLine.append(newLineStr);
					offset += wrapLength;
				} else {
					matcher = patternToWrapOn.matcher(str.substring(offset + wrapLength));
					if (matcher.find()) {
						spaceToWrapAt = matcher.start() + offset + wrapLength;
					}
					
					if (spaceToWrapAt >= 0) {
						wrappedLine.append(str, offset, spaceToWrapAt);
						wrappedLine.append(newLineStr);
						offset = spaceToWrapAt + 1;
					} else {
						wrappedLine.append(str, offset, str.length());
						offset = inputLineLength;
					}
				}
			}
		}
		
		wrappedLine.append(str, offset, str.length());
		
		return wrappedLine.toString();
	}
}
