package main.java.ulibs.engine.gl;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import main.java.ulibs.utils.ICopyable;
import main.java.ulibs.utils.math.Vec2i;

public class QuadData implements ICopyable<QuadData> {
	public static final float[] DEFAULT_TCS = new float[] { 0, 1, 0, 0, 1, 0, 1, 1 };
	public static final int[] DEFAULT_INDICES = new int[] { 0, 1, 2, 2, 3, 0 };
	
	protected float[] vertices = new float[0], tcs = new float[0];
	protected int[] indices = new int[0];
	protected int size;
	
	public QuadData() {
		this(new float[0], new int[0], new float[0], 0);
	}
	
	protected QuadData(float[] vertices, int[] indices, float[] tcs, int size) {
		this.vertices = vertices;
		this.indices = indices;
		this.tcs = tcs;
		this.size = size;
	}
	
	private QuadData(QuadData data) {
		this(data.vertices, data.indices, data.tcs, data.size);
	}
	
	public void reset() {
		vertices = new float[0];
		tcs = new float[0];
		indices = new int[0];
		size = 0;
	}
	
	public <T extends QuadData> T addAll(QuadData data) {
		return addAll(data.vertices, data.indices, data.tcs);
	}
	
	public <T extends QuadData> T addAll(float[] vertices, int[] indices, float[] tcs) {
		return addVerticesAndSafeIndices(vertices, indices).addTcs(tcs);
	}
	
	public <T extends QuadData> T addVerticesWithDefaults(float[] vertices) {
		return addDefaultIndices().addDefaultTcs().addVertices(vertices);
	}
	
	public <T extends QuadData> T addVerticesAndSafeIndices(float[] vertices, int[] indices) {
		return addIndices(indices).addVertices(vertices);
	}
	
	public <T extends QuadData> T addDefaultTcs() {
		return addTcs(DEFAULT_TCS);
	}
	
	public <T extends QuadData> T addDefaultIndices() {
		return addIndices(DEFAULT_INDICES);
	}
	
	public void setAll(QuadData data) {
		this.vertices = data.vertices;
		this.tcs = data.tcs;
		this.indices = data.indices;
	}
	
	public void setVertices(float[] vertices) {
		this.vertices = vertices;
	}
	
	public void setTcs(float[] tcs) {
		this.tcs = tcs;
	}
	
	public void setIndices(int[] indices) {
		this.indices = indices;
	}
	
	protected float[] combine(float[] v1, float[] v2) {
		FloatBuffer buf = FloatBuffer.wrap(new float[v1.length + v2.length]);
		buf.put(v1);
		buf.put(v2);
		buf.flip();
		
		return buf.array();
	}
	
	protected int[] combine(int[] v1, int[] v2) {
		IntBuffer buf = IntBuffer.wrap(new int[v1.length + v2.length]);
		buf.put(v1);
		buf.put(v2);
		buf.flip();
		
		return buf.array();
	}
	
	@SuppressWarnings("unchecked")
	private <T extends QuadData> T addVertices(float[] vertices) {
		this.vertices = combine(this.vertices, vertices);
		size++;
		return (T) this;
	}
	
	@SuppressWarnings("unchecked")
	private <T extends QuadData> T addTcs(float[] tcs) {
		this.tcs = combine(this.tcs, tcs);
		return (T) this;
	}
	
	@SuppressWarnings("unchecked")
	private <T extends QuadData> T addIndices(int[] indices) {
		int[] ids = indices.clone();
		for (int i = 0; i < ids.length; i++) {
			ids[i] = ids[i] + size * 4;
		}
		
		this.indices = combine(this.indices, ids);
		return (T) this;
	}
	
	public static float[] createVertex(float x, float y, ZConstant z, float w, float h) {
		return new float[] { x, y, z.z, x, y + h, z.z, x + w, y + h, z.z, x + w, y, z.z };
	}
	
	public static float[] createVertex(Vec2i pos, ZConstant z, Vec2i size) {
		return new float[] { pos.getX(), pos.getY(), z.z, pos.getX(), pos.getY() + size.getY(), z.z, pos.getX() + size.getX(), pos.getY() + size.getY(), z.z,
				pos.getX() + size.getX(), pos.getY(), z.z };
	}
	
	public float[] getVertices() {
		return vertices;
	}
	
	public int[] getIndices() {
		return indices;
	}
	
	public float[] getTcs() {
		return tcs;
	}
	
	@Override
	public QuadData copy() {
		return new QuadData(this);
	}
}
