package main.java.ulibs.utils.math;

import main.java.ulibs.utils.ICopyable;

@SuppressWarnings("javadoc")
public class Vec4i implements ICopyable<Vec4i> {
	protected int x, y, z, w;
	
	public Vec4i() {
		x = 0;
		y = 0;
		z = 0;
		w = 0;
	}
	
	public Vec4i(int x, int y, int z, int w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	public Vec4i(int xyzw) {
		this.x = xyzw;
		this.y = xyzw;
		this.z = xyzw;
		this.w = xyzw;
	}
	
	public Vec4i(Vec4i vec) {
		this(vec.getX(), vec.getY(), vec.getZ(), vec.getW());
	}
	
	public Vec4i(Vec4f vec) {
		this(Math.round(vec.getX()), Math.round(vec.getY()), Math.round(vec.getZ()), Math.round(vec.getW()));
	}
	
	public Vec4i(Vec4d vec) {
		this(Math.round((float) vec.getX()), Math.round((float) vec.getY()), Math.round((float) vec.getZ()), Math.round((float) vec.getW()));
	}
	
	public Vec4i add(Vec4i vec) {
		this.x += vec.x;
		this.y += vec.y;
		this.z += vec.z;
		this.w += vec.w;
		return this;
	}
	
	public Vec4i add(int x, int y, int z, int w) {
		this.x += x;
		this.y += y;
		this.z += z;
		this.w += w;
		return this;
	}
	
	public Vec4i addX(int x) {
		this.x += x;
		return this;
	}
	
	public Vec4i addY(int y) {
		this.y += y;
		return this;
	}
	
	public Vec4i addZ(int z) {
		this.z += z;
		return this;
	}
	
	public Vec4i addW(int w) {
		this.w += w;
		return this;
	}
	
	public Vec4i multiply(Vec4i vec) {
		this.x *= vec.x;
		this.y *= vec.y;
		this.z *= vec.z;
		this.w *= vec.w;
		return this;
	}
	
	public Vec4i multiply(int x, int y, int z, int w) {
		this.x *= x;
		this.y *= y;
		this.z *= z;
		this.w *= w;
		return this;
	}
	
	public Vec4i multiplyX(int x) {
		this.x *= x;
		return this;
	}
	
	public Vec4i multiplyY(int y) {
		this.y *= y;
		return this;
	}
	
	public Vec4i multiplyZ(int z) {
		this.z *= z;
		return this;
	}
	
	public Vec4i multiplyW(int w) {
		this.w *= w;
		return this;
	}
	
	public Vec4i divide(Vec4i vec) {
		this.x /= vec.x;
		this.y /= vec.y;
		this.z /= vec.z;
		this.w /= vec.w;
		return this;
	}
	
	public Vec4i divide(int x, int y, int z, int w) {
		this.x /= x;
		this.y /= y;
		this.z /= z;
		this.w /= w;
		return this;
	}
	
	public Vec4i divideX(int x) {
		this.x /= x;
		return this;
	}
	
	public Vec4i divideY(int y) {
		this.y /= y;
		return this;
	}
	
	public Vec4i divideZ(int z) {
		this.z /= z;
		return this;
	}
	
	public Vec4i divideW(int w) {
		this.w /= w;
		return this;
	}
	
	public Vec4i set(Vec4i vec) {
		this.x = vec.x;
		this.y = vec.y;
		this.z = vec.z;
		this.w = vec.w;
		return this;
	}
	
	public Vec4i set(int x, int y, int z, int w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
		return this;
	}
	
	public Vec4i setX(int x) {
		this.x = x;
		return this;
	}
	
	public Vec4i setY(int y) {
		this.y = y;
		return this;
	}
	
	public Vec4i setZ(int z) {
		this.z = z;
		return this;
	}
	
	public Vec4i setW(int w) {
		this.w = w;
		return this;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getZ() {
		return z;
	}
	
	public int getW() {
		return w;
	}
	
	public Vec4i inverse() {
		return new Vec4i(-x, -y, -z, -w);
	}
	
	public int difference(Vec4i vec) {
		return Math.abs(x - vec.x) + Math.abs(y - vec.y) + Math.abs(z - vec.z) + Math.abs(w - vec.w);
	}
	
	public boolean isZero() {
		return (x == 0 && y == 0 && z == 0 && w == 0) ? true : false;
	}
	
	@Override
	public Vec4i copy() {
		return new Vec4i(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vec4i) {
			if (((Vec4i) obj).x == x && ((Vec4i) obj).y == y && ((Vec4i) obj).z == z && ((Vec4i) obj).w == w) {
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
		result = 31 * result + z;
		result = 31 * result + w;
		return result;
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ", " + w + ")";
	}
}
