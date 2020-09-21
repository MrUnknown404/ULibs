package main.java.ulibs.utils.math;

import main.java.ulibs.utils.Console;

public class MathH {
	public static int floor(float value) {
		int i = (int) value;
		return value < i ? i - 1 : i;
	}
	
	public static int floor(double value) {
		return floor((float) value);
	}
	
	public static int ceil(float value) {
		int i = (int) value;
		return value > i ? i + 1 : i;
	}
	
	public static int ceil(double value) {
		int i = (int) value;
		return value > i ? i + 1 : i;
	}
	
	public static int fClamp(float num, float min, float max) {
		return floor(clamp(num, min, max));
	}
	
	public static int fClamp(double num, double min, double max) {
		return floor(clamp(num, min, max));
	}
	
	public static float clamp(float num, float min, float max) {
		return num < min ? min : (num > max ? max : num);
	}
	
	public static double clamp(double num, double min, double max) {
		return num < min ? min : (num > max ? max : num);
	}
	
	public static int clamp(int num, int min, int max) {
		return fClamp(num, min, max);
	}
	
	public static double roundTo(double number, int decimal) {
		double tempDecimal = 1;
		for (int i = 0; i < decimal; i++) {
			tempDecimal *= 10;
		}
		
		return Math.round(number * tempDecimal) / tempDecimal;
	}
	
	public static float roundTo(float number, int decimal) {
		double tempDecimal = 1;
		for (int i = 0; i < decimal; i++) {
			tempDecimal *= 10;
		}
		
		return (float) (Math.round(number * tempDecimal) / tempDecimal);
	}
	
	public static double normalize(float number, float min, float max) {
		if (number > max) {
			Console.print(Console.WarningType.Error, "the specified number is more than the specified max!");
			return max;
		} else if (number < min) {
			Console.print(Console.WarningType.Error, "the specified number cannot be less than the specified min!");
			return 0;
		}
		
		return (number - min) / (max - min);
	}
	
	public static double normalize(double number, double min, double max) {
		if (number > max) {
			Console.print(Console.WarningType.Error, "the specified number is more than the specified max!");
			return max;
		} else if (number < min) {
			Console.print(Console.WarningType.Error, "the specified number cannot be less than the specified min!");
			return 0;
		}
		
		return (number - min) / (max - min);
	}
	
	public static float percentage(float number, float max) {
		return (number / max) * 100f;
	}
	
	public static double percentage(double number, double max) {
		return (number / max) * 100f;
	}
}
