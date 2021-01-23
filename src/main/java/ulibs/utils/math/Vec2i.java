package main.java.ulibs.utils.math;

import main.java.ulibs.utils.ICopyable;

@SuppressWarnings("javadoc")
public class Vec2i implements ICopyable<Vec2i> {
	protected int x, y;
	
	public Vec2i() {
		x = 0;
		y = 0;
	}
	
	public Vec2i(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Vec2i(int xy) {
		this.x = xy;
		this.y = xy;
	}
	
	public Vec2i(Vec2i vec) {
		this(vec.getX(), vec.getY());
	}
	
	public Vec2i(Vec2f vec) {
		this(Math.round(vec.getX()), Math.round(vec.getY()));
	}
	
	public Vec2i(Vec2d vec) {
		this(Math.round((float) vec.getX()), Math.round((float) vec.getY()));
	}
	
	public Vec2i add(Vec2i vec) {
		this.x += vec.x;
		this.y += vec.y;
		return this;
	}
	
	public Vec2i add(int x, int y) {
		this.x += x;
		this.y += y;
		return this;
	}
	
	public Vec2i addX(int x) {
		this.x += x;
		return this;
	}
	
	public Vec2i addY(int y) {
		this.y += y;
		return this;
	}
	
	public Vec2i multiply(Vec2i vec) {
		this.x *= vec.x;
		this.y *= vec.y;
		return this;
	}
	
	public Vec2i multiply(int x, int y) {
		this.x *= x;
		this.y *= y;
		return this;
	}
	
	public Vec2i multiplyX(int x) {
		this.x *= x;
		return this;
	}
	
	public Vec2i multiplyY(int y) {
		this.y *= y;
		return this;
	}
	
	public Vec2i divide(Vec2i vec) {
		this.x /= vec.x;
		this.y /= vec.y;
		return this;
	}
	
	public Vec2i divide(int x, int y) {
		this.x /= x;
		this.y /= y;
		return this;
	}
	
	public Vec2i divideX(int x) {
		this.x /= x;
		return this;
	}
	
	public Vec2i divideY(int y) {
		this.y /= y;
		return this;
	}
	
	public Vec2i set(Vec2i vec) {
		this.x = vec.x;
		this.y = vec.y;
		return this;
	}
	
	public Vec2i set(int x, int y) {
		this.x = x;
		this.y = y;
		return this;
	}
	
	public Vec2i setX(int x) {
		this.x = x;
		return this;
	}
	
	public Vec2i setY(int y) {
		this.y = y;
		return this;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Vec2i inverse() {
		return new Vec2i(-x, -y);
	}
	
	public int difference(Vec2i vec) {
		return Math.abs(x - vec.x) + Math.abs(y - vec.y);
	}
	
	public boolean isZero() {
		return (x == 0 && y == 0) ? true : false;
	}
	
	@Override
	public Vec2i copy() {
		return new Vec2i(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vec2i) {
			if (((Vec2i) obj).x == x && ((Vec2i) obj).y == y) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		int result = 1;
		result = 31 * result + x;
		result = 31 * result + y;
		return result;
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
