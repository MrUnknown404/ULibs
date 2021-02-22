package main.java.ulibs.utils.math;

import main.java.ulibs.utils.ICopyable;

@SuppressWarnings("javadoc")
public class Vec2f implements ICopyable<Vec2f> {
	protected float x, y;
	
	public Vec2f() {
		x = 0;
		y = 0;
	}
	
	public Vec2f(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public Vec2f(float xy) {
		this.x = xy;
		this.y = xy;
	}
	
	public Vec2f(Vec2i vec) {
		this(vec.getX(), vec.getY());
	}
	
	public Vec2f(Vec2f vec) {
		this(vec.getX(), vec.getY());
	}
	
	public Vec2f(Vec2d vec) {
		this((float) vec.getX(), (float) vec.getY());
	}
	
	public Vec2f add(Vec2f vec) {
		this.x += vec.x;
		this.y += vec.y;
		return this;
	}
	
	public Vec2f add(float x, float y) {
		this.x += x;
		this.y += y;
		return this;
	}
	
	public Vec2f addX(float x) {
		this.x += x;
		return this;
	}
	
	public Vec2f addY(float y) {
		this.y += y;
		return this;
	}
	
	public Vec2f subtract(Vec2f vec) {
		this.x -= vec.x;
		this.y -= vec.y;
		return this;
	}
	
	public Vec2f subtract(float x, float y) {
		this.x -= x;
		this.y -= y;
		return this;
	}
	
	public Vec2f subtractX(float x) {
		this.x -= x;
		return this;
	}
	
	public Vec2f subtractY(float y) {
		this.y -= y;
		return this;
	}
	
	public Vec2f multiply(Vec2f vec) {
		this.x *= vec.x;
		this.y *= vec.y;
		return this;
	}
	
	public Vec2f multiply(float x, float y) {
		this.x *= x;
		this.y *= y;
		return this;
	}
	
	public Vec2f multiplyX(float x) {
		this.x *= x;
		return this;
	}
	
	public Vec2f multiplyY(float y) {
		this.y *= y;
		return this;
	}
	
	public Vec2f divide(Vec2f vec) {
		this.x /= vec.x;
		this.y /= vec.y;
		return this;
	}
	
	public Vec2f divide(float x, float y) {
		this.x /= x;
		this.y /= y;
		return this;
	}
	
	public Vec2f divideX(float x) {
		this.x /= x;
		return this;
	}
	
	public Vec2f divideY(float y) {
		this.y /= y;
		return this;
	}
	
	public Vec2f set(Vec2f vec) {
		this.x = vec.x;
		this.y = vec.y;
		return this;
	}
	
	public Vec2f set(float x, float y) {
		this.x = x;
		this.y = y;
		return this;
	}
	
	public Vec2f setX(float x) {
		this.x = x;
		return this;
	}
	
	public Vec2f setY(float y) {
		this.y = y;
		return this;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public Vec2f inverse() {
		return new Vec2f(-x, -y);
	}
	
	public float difference(Vec2f vec) {
		return Math.abs(x - vec.x) + Math.abs(y - vec.y);
	}
	
	public boolean isZero() {
		return (x == 0 && y == 0) ? true : false;
	}
	
	@Override
	public Vec2f copy() {
		return new Vec2f(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vec2f) {
			if (((Vec2f) obj).x == x && ((Vec2f) obj).y == y) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int result = 1;
		result = 31 * result + Float.floatToIntBits(x);
		result = 31 * result + Float.floatToIntBits(y);
		return result;
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
