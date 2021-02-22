package main.java.ulibs.utils.math;

import main.java.ulibs.utils.ICopyable;

@SuppressWarnings("javadoc")
public class Vec3i implements ICopyable<Vec3i> {
	protected int x, y, z;
	
	public Vec3i() {
		x = 0;
		y = 0;
		z = 0;
	}
	
	public Vec3i(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vec3i(int xyz) {
		this.x = xyz;
		this.y = xyz;
		this.z = xyz;
	}
	
	public Vec3i(Vec3i vec) {
		this(vec.getX(), vec.getY(), vec.getZ());
	}
	
	public Vec3i(Vec3f vec) {
		this(Math.round(vec.getX()), Math.round(vec.getY()), Math.round(vec.getZ()));
	}
	
	public Vec3i(Vec3d vec) {
		this(Math.round((float) vec.getX()), Math.round((float) vec.getY()), Math.round((float) vec.getZ()));
	}
	
	public Vec3i add(Vec3i vec) {
		this.x += vec.x;
		this.y += vec.y;
		this.z += vec.z;
		return this;
	}
	
	public Vec3i add(int x, int y, int z) {
		this.x += x;
		this.y += y;
		this.z += z;
		return this;
	}
	
	public Vec3i addX(int x) {
		this.x += x;
		return this;
	}
	
	public Vec3i addY(int y) {
		this.y += y;
		return this;
	}
	
	public Vec3i addZ(int z) {
		this.z += z;
		return this;
	}
	
	public Vec3i subtract(Vec3i vec) {
		this.x -= vec.x;
		this.y -= vec.y;
		this.z -= vec.z;
		return this;
	}
	
	public Vec3i subtract(int x, int y, int z) {
		this.x -= x;
		this.y -= y;
		this.z -= z;
		return this;
	}
	
	public Vec3i subtractX(int x) {
		this.x -= x;
		return this;
	}
	
	public Vec3i subtractY(int y) {
		this.y -= y;
		return this;
	}
	
	public Vec3i subtractZ(int z) {
		this.z -= z;
		return this;
	}
	
	public Vec3i multiply(Vec3i vec) {
		this.x *= vec.x;
		this.y *= vec.y;
		this.z *= vec.z;
		return this;
	}
	
	public Vec3i multiply(int x, int y, int z) {
		this.x *= x;
		this.y *= y;
		this.z *= z;
		return this;
	}
	
	public Vec3i multiplyX(int x) {
		this.x *= x;
		return this;
	}
	
	public Vec3i multiplyY(int y) {
		this.y *= y;
		return this;
	}
	
	public Vec3i multiplyZ(int z) {
		this.z *= z;
		return this;
	}
	
	public Vec3i divide(Vec3i vec) {
		this.x /= vec.x;
		this.y /= vec.y;
		this.z /= vec.z;
		return this;
	}
	
	public Vec3i divide(int x, int y, int z) {
		this.x /= x;
		this.y /= y;
		this.z /= z;
		return this;
	}
	
	public Vec3i divideX(int x) {
		this.x /= x;
		return this;
	}
	
	public Vec3i divideY(int y) {
		this.y /= y;
		return this;
	}
	
	public Vec3i divideZ(int z) {
		this.z /= z;
		return this;
	}
	
	public Vec3i set(Vec3i vec) {
		this.x = vec.x;
		this.y = vec.y;
		this.z = vec.z;
		return this;
	}
	
	public Vec3i set(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		return this;
	}
	
	public Vec3i setX(int x) {
		this.x = x;
		return this;
	}
	
	public Vec3i setY(int y) {
		this.y = y;
		return this;
	}
	
	public Vec3i setZ(int z) {
		this.z = z;
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
	
	public Vec3i inverse() {
		return new Vec3i(-x, -y, -z);
	}
	
	public int difference(Vec3i vec) {
		return Math.abs(x - vec.x) + Math.abs(y - vec.y) + Math.abs(z - vec.z);
	}
	
	public boolean isZero() {
		return (x == 0 && y == 0 && z == 0) ? true : false;
	}
	
	@Override
	public Vec3i copy() {
		return new Vec3i(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vec3i) {
			if (((Vec3i) obj).x == x && ((Vec3i) obj).y == y && ((Vec3i) obj).z == z) {
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
		return result;
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ")";
	}
}
