package main.java.ulibs.utils.math;

import main.java.ulibs.utils.ICopyable;

public class Vec3f implements ICopyable<Vec3f> {
	public static final Vec3f ZERO = new Vec3f();
	protected float x, y, z;
	
	public Vec3f() {
		x = 0;
		y = 0;
		z = 0;
	}
	
	public Vec3f(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vec3f(float xyz) {
		this.x = xyz;
		this.y = xyz;
		this.z = xyz;
	}
	
	public Vec3f(Vec3i vec) {
		this(vec.getX(), vec.getY(), vec.getZ());
	}
	
	public Vec3f(Vec3f vec) {
		this(vec.getX(), vec.getY(), vec.getZ());
	}
	
	public Vec3f(Vec3d vec) {
		this((float) vec.getX(), (float) vec.getY(), (float) vec.getZ());
	}
	
	public Vec3f add(Vec3f vec) {
		this.x += vec.x;
		this.y += vec.y;
		this.z += vec.z;
		return this;
	}
	
	public Vec3f add(float x, float y, float z) {
		this.x += x;
		this.y += y;
		this.z += z;
		return this;
	}
	
	public Vec3f addX(float x) {
		this.x += x;
		return this;
	}
	
	public Vec3f addY(float y) {
		this.y += y;
		return this;
	}
	
	public Vec3f addZ(float z) {
		this.z += z;
		return this;
	}
	
	public void set(Vec3f vec) {
		this.x = vec.x;
		this.y = vec.y;
		this.z = vec.z;
	}
	
	public void set(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public void setZ(float z) {
		this.z = z;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public float getZ() {
		return z;
	}
	
	public float difference(Vec3f vec) {
		return Math.abs(x - vec.x) + Math.abs(y - vec.y) + Math.abs(z - vec.z);
	}
	
	@Override
	public Vec3f copy() {
		return new Vec3f(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vec3f) {
			if (((Vec3f) obj).x == x && ((Vec3f) obj).y == y && ((Vec3f) obj).z == z) {
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
		result = 31 * result + Float.floatToIntBits(z);
		return result;
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ")";
	}
}
