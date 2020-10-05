package main.java.ulibs.utils;

public class Pair<L, R> {
	private L left;
	private R right;
	
	public Pair(L left, R right) {
		this.left = left;
		this.right = right;
	}
	
	public Pair<L, R> setL(L left) {
		this.left = left;
		return this;
	}
	
	public Pair<L, R> setR(R right) {
		this.right = right;
		return this;
	}
	
	public Pair<L, R> setLeft(L left) {
		this.left = left;
		return this;
	}
	
	public Pair<L, R> setRight(R right) {
		this.right = right;
		return this;
	}
	
	public L getL() {
		return left;
	}
	
	public R getR() {
		return right;
	}
	
	public L getLeft() {
		return left;
	}
	
	public R getRight() {
		return right;
	}
	
	@Override
	public String toString() {
		return "(" + left + ", " + right + ")";
	}
}
