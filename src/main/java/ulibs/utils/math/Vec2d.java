package main.java.ulibs.utils.math;

import main.java.ulibs.utils.ICopyable;

public class Vec2d implements ICopyable<Vec2d> {
	public static final Vec2d ZERO = new Vec2d();
	protected double x, y;
	
	public Vec2d() {
		x = 0;
		y = 0;
	}
	
	public Vec2d(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Vec2d(double xy) {
		this.x = xy;
		this.y = xy;
	}
	
	public Vec2d(Vec2i vec) {
		this(vec.getX(), vec.getY());
	}
	
	public Vec2d(Vec2f vec) {
		this(vec.getX(), vec.getY());
	}
	
	public Vec2d(Vec2d vec) {
		this(vec.getX(), vec.getY());
	}
	
	public void add(Vec2d vec) {
		this.x += vec.x;
		this.y += vec.y;
	}
	
	public void add(double x, double y) {
		this.x += x;
		this.y += y;
	}
	
	public void addX(double x) {
		this.x += x;
	}
	
	public void addY(double y) {
		this.y += y;
	}
	
	public void set(Vec2d vec) {
		this.x = vec.x;
		this.y = vec.y;
	}
	
	public void set(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getBothMulti() {
		return x * y;
	}
	
	public double difference(Vec2d vec) {
		return Math.abs(x - vec.x) + Math.abs(y - vec.y);
	}
	
	@Override
	public Vec2d copy() {
		return new Vec2d(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vec2d) {
			if (((Vec2d) obj).x == x && ((Vec2d) obj).y == y) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
