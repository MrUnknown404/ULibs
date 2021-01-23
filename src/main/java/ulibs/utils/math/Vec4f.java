package main.java.ulibs.utils.math;

import main.java.ulibs.utils.ICopyable;

@SuppressWarnings("javadoc")
public class Vec4f implements ICopyable<Vec4f> {
	protected float x, y, z, w;
	
	public Vec4f() {
		x = 0;
		y = 0;
		z = 0;
		w = 0;
	}
	
	public Vec4f(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	public Vec4f(float xyzw) {
		this.x = xyzw;
		this.y = xyzw;
		this.z = xyzw;
		this.w = xyzw;
	}
	
	public Vec4f(Vec4i vec) {
		this(vec.getX(), vec.getY(), vec.getZ(), vec.getW());
	}
	
	public Vec4f(Vec4f vec) {
		this(vec.getX(), vec.getY(), vec.getZ(), vec.getW());
	}
	
	public Vec4f(Vec4d vec) {
		this((float) vec.getX(), (float) vec.getY(), (float) vec.getZ(), (float) vec.getW());
	}
	
	public Vec4f add(Vec4f vec) {
		this.x += vec.x;
		this.y += vec.y;
		this.z += vec.z;
		this.w += vec.w;
		return this;
	}
	
	public Vec4f add(float x, float y, float z, float w) {
		this.x += x;
		this.y += y;
		this.z += z;
		this.w += w;
		return this;
	}
	
	public Vec4f addX(float x) {
		this.x += x;
		return this;
	}
	
	public Vec4f addY(float y) {
		this.y += y;
		return this;
	}
	
	public Vec4f addZ(float z) {
		this.z += z;
		return this;
	}
	
	public Vec4f addW(float w) {
		this.w += w;
		return this;
	}
	
	public Vec4f multiply(Vec4f vec) {
		this.x *= vec.x;
		this.y *= vec.y;
		this.z *= vec.z;
		this.w *= vec.w;
		return this;
	}
	
	public Vec4f multiply(float x, float y, float z, float w) {
		this.x *= x;
		this.y *= y;
		this.z *= z;
		this.w *= w;
		return this;
	}
	
	public Vec4f multiplyX(float x) {
		this.x *= x;
		return this;
	}
	
	public Vec4f multiplyY(float y) {
		this.y *= y;
		return this;
	}
	
	public Vec4f multiplyZ(float z) {
		this.z *= z;
		return this;
	}
	
	public Vec4f multiplyW(float w) {
		this.w *= w;
		return this;
	}
	
	public Vec4f divide(Vec4f vec) {
		this.x /= vec.x;
		this.y /= vec.y;
		this.z /= vec.z;
		this.w /= vec.w;
		return this;
	}
	
	public Vec4f divide(float x, float y, float z, float w) {
		this.x /= x;
		this.y /= y;
		this.z /= z;
		this.w /= w;
		return this;
	}
	
	public Vec4f divideX(float x) {
		this.x /= x;
		return this;
	}
	
	public Vec4f divideY(float y) {
		this.y /= y;
		return this;
	}
	
	public Vec4f divideZ(float z) {
		this.z /= z;
		return this;
	}
	
	public Vec4f divideW(float w) {
		this.w /= w;
		return this;
	}
	
	public Vec4f set(Vec4f vec) {
		this.x = vec.x;
		this.y = vec.y;
		this.z = vec.z;
		this.w = vec.w;
		return this;
	}
	
	public Vec4f set(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
		return this;
	}
	
	public Vec4f setX(float x) {
		this.x = x;
		return this;
	}
	
	public Vec4f setY(float y) {
		this.y = y;
		return this;
	}
	
	public Vec4f setZ(float z) {
		this.z = z;
		return this;
	}
	
	public Vec4f setW(float w) {
		this.w = w;
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
	
	public float getW() {
		return w;
	}
	
	public Vec4f inverse() {
		return new Vec4f(-x, -y, -z, -w);
	}
	
	public float difference(Vec4f vec) {
		return Math.abs(x - vec.x) + Math.abs(y - vec.y) + Math.abs(z - vec.z) + Math.abs(w - vec.w);
	}
	
	public boolean isZero() {
		return (x == 0 && y == 0 && z == 0 && w == 0) ? true : false;
	}
	
	@Override
	public Vec4f copy() {
		return new Vec4f(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vec4f) {
			if (((Vec4f) obj).x == x && ((Vec4f) obj).y == y && ((Vec4f) obj).z == z && ((Vec4f) obj).w == w) {
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
		result = 31 * result + Float.floatToIntBits(2);
		return result;
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ", " + w + ")";
	}
}
