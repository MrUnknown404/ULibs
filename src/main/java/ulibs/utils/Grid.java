package main.java.ulibs.utils;

import java.util.ArrayList;
import java.util.List;

import main.java.ulibs.utils.Console.WarningType;
import main.java.ulibs.utils.math.Vec2i;

public class Grid<T> {
	private final List<T> grid;
	private final int width, height;
	
	public Grid(T t, int width, int height) {
		this.width = width;
		this.height = height;
		this.grid = CollectionUtils.fill(width * height, t);
	}
	
	public Grid(int width, int height) {
		this(null, width, height);
	}
	
	public Grid(T t, Vec2i vec) {
		this(t, vec.getX(), vec.getY());
	}
	
	public Grid(Vec2i vec) {
		this(null, vec.getX(), vec.getY());
	}
	
	public List<T> get() {
		return grid;
	}
	
	public T get(Vec2i vec) {
		return get(vec.getX(), vec.getY());
	}
	
	public T get(int x, int y) {
		try {
			return checkValid(x, y) ? grid.get(x + (y * width)) : null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Grid<T> add(T t, Vec2i vec) {
		return add(t, vec.getX(), vec.getY());
	}
	
	public Grid<T> add(T t, int x, int y) {
		try {
			if (checkValid(x, y)) {
				grid.set(y * width + x, t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return this;
	}
	
	public Grid<T> remove(Vec2i vec) {
		return remove(vec.getX(), vec.getY());
	}
	
	public Grid<T> remove(int x, int y) {
		try {
			if (checkValid(x, y)) {
				grid.set(y * width + x, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return this;
	}
	
	public Grid<T> addFirstEmpty(T t) {
		if (grid.indexOf(null) != -1) {
			grid.set(grid.indexOf(null), t);
			return this;
		} else if (grid.indexOf("") != -1) {
			grid.set(grid.indexOf(""), t);
			return this;
		}
		
		Console.print(WarningType.Warning, "Could not find any null or empty values!");
		return this;
	}
	
	private boolean checkValid(int x, int y) throws Exception {
		if (x < 0) {
			Console.print(WarningType.Error, "'X' Cannot be lower than 0! (was " + x + ")", true);
			return false;
		} else if (x >= width) {
			Console.print(WarningType.Error, "'X' Cannot be " + width + " or above! (was " + x + ")", true);
			return false;
		} else if (y < 0) {
			Console.print(WarningType.Error, "'Y' Cannot be lower than 0! (was " + y + ")", true);
			return false;
		} else if (y >= height) {
			Console.print(WarningType.Error, "'Y' Cannot be " + height + " or above! (was " + y + ")", true);
			return false;
		}
		
		return true;
	}
	
	public List<String> toStringList() {
		List<String> strs = new ArrayList<String>(grid.size());
		String str = "";
		for (int i = 0; i < grid.size(); i++) {
			str += grid.get(i);
			if (i % width == width - 1) {
				strs.add(str);
				str = "";
			} else {
				str += ", ";
			}
		}
		
		return strs;
	}
	
	public int size() {
		return grid.size();
	}
	
	public boolean isEmpty() {
		return grid.size() == 0;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	@Override
	public String toString() {
		return grid.toString();
	}
}
