package main.java.ulibs.utils.math;

import main.java.ulibs.utils.ICopyable;

@SuppressWarnings("javadoc")
public class Vec3f implements ICopyable<Vec3f> {
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
	
	public Vec3f multiply(Vec3f vec) {
		this.x *= vec.x;
		this.y *= vec.y;
		this.z *= vec.z;
		return this;
	}
	
	public Vec3f multiply(float x, float y, float z) {
		this.x *= x;
		this.y *= y;
		this.z *= z;
		return this;
	}
	
	public Vec3f multiplyX(float x) {
		this.x *= x;
		return this;
	}
	
	public Vec3f multiplyY(float y) {
		this.y *= y;
		return this;
	}
	
	public Vec3f multiplyZ(float z) {
		this.z *= z;
		return this;
	}
	
	public Vec3f divide(Vec3f vec) {
		this.x /= vec.x;
		this.y /= vec.y;
		this.z /= vec.z;
		return this;
	}
	
	public Vec3f divide(float x, float y, float z) {
		this.x /= x;
		this.y /= y;
		this.z /= z;
		return this;
	}
	
	public Vec3f divideX(float x) {
		this.x /= x;
		return this;
	}
	
	public Vec3f divideY(float y) {
		this.y /= y;
		return this;
	}
	
	public Vec3f divideZ(float z) {
		this.z /= z;
		return this;
	}
	
	public Vec3f set(Vec3f vec) {
		this.x = vec.x;
		this.y = vec.y;
		this.z = vec.z;
		return this;
	}
	
	public Vec3f set(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
		return this;
	}
	
	public Vec3f setX(float x) {
		this.x = x;
		return this;
	}
	
	public Vec3f setY(float y) {
		this.y = y;
		return this;
	}
	
	public Vec3f setZ(float z) {
		this.z = z;
		return this;
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
	
	public Vec3f inverse() {
		return new Vec3f(-x, -y, -z);
	}
	
	public float difference(Vec3f vec) {
		return Math.abs(x - vec.x) + Math.abs(y - vec.y) + Math.abs(z - vec.z);
	}
	
	public boolean isZero() {
		return (x == 0 && y == 0 && z == 0) ? true : false;
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
