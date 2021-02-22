package main.java.ulibs.utils.math;

import main.java.ulibs.utils.ICopyable;

@SuppressWarnings("javadoc")
public class Vec4d implements ICopyable<Vec4d> {
	protected double x, y, z, w;
	
	public Vec4d() {
		x = 0;
		y = 0;
		z = 0;
		w = 0;
	}
	
	public Vec4d(double x, double y, double z, double w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	public Vec4d(double xyzw) {
		this.x = xyzw;
		this.y = xyzw;
		this.z = xyzw;
		this.w = xyzw;
	}
	
	public Vec4d(Vec4i vec) {
		this(vec.getX(), vec.getY(), vec.getZ(), vec.getW());
	}
	
	public Vec4d(Vec4f vec) {
		this(vec.getX(), vec.getY(), vec.getZ(), vec.getW());
	}
	
	public Vec4d(Vec4d vec) {
		this(vec.getX(), vec.getY(), vec.getZ(), vec.getW());
	}
	
	public Vec4d add(Vec4d vec) {
		this.x += vec.x;
		this.y += vec.y;
		this.z += vec.z;
		this.w += vec.w;
		return this;
	}
	
	public Vec4d add(double x, double y, double z, double w) {
		this.x += x;
		this.y += y;
		this.z += z;
		this.w += w;
		return this;
	}
	
	public Vec4d addX(double x) {
		this.x += x;
		return this;
	}
	
	public Vec4d addY(double y) {
		this.y += y;
		return this;
	}
	
	public Vec4d addZ(double z) {
		this.z += z;
		return this;
	}
	
	public Vec4d addW(double w) {
		this.w += w;
		return this;
	}
	
	public Vec4d subtract(Vec4d vec) {
		this.x -= vec.x;
		this.y -= vec.y;
		this.z -= vec.z;
		this.w -= vec.w;
		return this;
	}
	
	public Vec4d subtract(double x, double y, double z, double w) {
		this.x -= x;
		this.y -= y;
		this.z -= z;
		this.w -= w;
		return this;
	}
	
	public Vec4d subtractX(double x) {
		this.x -= x;
		return this;
	}
	
	public Vec4d subtractY(double y) {
		this.y -= y;
		return this;
	}
	
	public Vec4d subtractZ(double z) {
		this.z -= z;
		return this;
	}
	
	public Vec4d subtractW(double w) {
		this.w -= w;
		return this;
	}
	
	public Vec4d multiply(Vec4d vec) {
		this.x *= vec.x;
		this.y *= vec.y;
		this.z *= vec.z;
		this.w *= vec.w;
		return this;
	}
	
	public Vec4d multiply(double x, double y, double z, double w) {
		this.x *= x;
		this.y *= y;
		this.z *= z;
		this.w *= w;
		return this;
	}
	
	public Vec4d multiplyX(double x) {
		this.x *= x;
		return this;
	}
	
	public Vec4d multiplyY(double y) {
		this.y *= y;
		return this;
	}
	
	public Vec4d multiplyZ(double z) {
		this.z *= z;
		return this;
	}
	
	public Vec4d multiplyW(double w) {
		this.w *= w;
		return this;
	}
	
	public Vec4d divide(Vec4d vec) {
		this.x /= vec.x;
		this.y /= vec.y;
		this.z /= vec.z;
		this.w /= vec.w;
		return this;
	}
	
	public Vec4d divide(double x, double y, double z, double w) {
		this.x /= x;
		this.y /= y;
		this.z /= z;
		this.w /= w;
		return this;
	}
	
	public Vec4d divideX(double x) {
		this.x /= x;
		return this;
	}
	
	public Vec4d divideY(double y) {
		this.y /= y;
		return this;
	}
	
	public Vec4d divideZ(double z) {
		this.z /= z;
		return this;
	}
	
	public Vec4d divideW(double w) {
		this.w /= w;
		return this;
	}
	
	public Vec4d set(Vec4d vec) {
		this.x = vec.x;
		this.y = vec.y;
		this.z = vec.z;
		this.w = vec.w;
		return this;
	}
	
	public Vec4d set(double x, double y, double z, double w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
		return this;
	}
	
	public Vec4d setX(double x) {
		this.x = x;
		return this;
	}
	
	public Vec4d setY(double y) {
		this.y = y;
		return this;
	}
	
	public Vec4d setZ(double z) {
		this.z = z;
		return this;
	}
	
	public Vec4d setW(double w) {
		this.w = w;
		return this;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getZ() {
		return z;
	}
	
	public double getW() {
		return w;
	}
	
	public Vec4d inverse() {
		return new Vec4d(-x, -y, -z, -w);
	}
	
	public double difference(Vec4d vec) {
		return Math.abs(x - vec.x) + Math.abs(y - vec.y) + Math.abs(z - vec.z) + Math.abs(w - vec.w);
	}
	
	public boolean isZero() {
		return (x == 0 && y == 0 && z == 0 && w == 0) ? true : false;
	}
	
	@Override
	public Vec4d copy() {
		return new Vec4d(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vec4d) {
			if (((Vec4d) obj).x == x && ((Vec4d) obj).y == y && ((Vec4d) obj).z == z && ((Vec4d) obj).w == w) {
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
		temp = Double.doubleToLongBits(z);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(w);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ", " + w + ")";
	}
}
