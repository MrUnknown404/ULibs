package main.java.ulibs.engine.gl;

import org.lwjgl.opengl.GL46;

import main.java.ulibs.utils.Console;
import main.java.ulibs.utils.Console.WarningType;

public class VertexArray extends QuadData {
	protected int vao, vbo, ibo, tbo;
	protected int count;
	
	protected boolean wasSetup = false;
	
	/** Sets up everything to be ready for rendering
	 * <br>
	 * Must be called before using! */
	public void setup() {
		count = indices.length;
		
		if (!wasSetup) {
			wasSetup = true;
			vao = GL46.glGenVertexArrays();
			vbo = GL46.glGenBuffers();
			tbo = GL46.glGenBuffers();
			ibo = GL46.glGenBuffers();
		}
		
		GL46.glBindVertexArray(vao);
		
		GL46.glBindBuffer(GL46.GL_ARRAY_BUFFER, vbo);
		GL46.glBufferData(GL46.GL_ARRAY_BUFFER, BufferUtils.createFloatBuffer(vertices), GL46.GL_DYNAMIC_DRAW);
		GL46.glVertexAttribPointer(Shader.VERTEX_ATTRIB, 3, GL46.GL_FLOAT, false, 0, 0);
		GL46.glEnableVertexAttribArray(Shader.VERTEX_ATTRIB);
		
		GL46.glBindBuffer(GL46.GL_ARRAY_BUFFER, tbo);
		GL46.glBufferData(GL46.GL_ARRAY_BUFFER, BufferUtils.createFloatBuffer(tcs), GL46.GL_DYNAMIC_DRAW);
		GL46.glVertexAttribPointer(Shader.TCOORD_ATTRIB, 2, GL46.GL_FLOAT, false, 0, 0);
		GL46.glEnableVertexAttribArray(Shader.TCOORD_ATTRIB);
		
		GL46.glBindBuffer(GL46.GL_ELEMENT_ARRAY_BUFFER, ibo);
		GL46.glBufferData(GL46.GL_ELEMENT_ARRAY_BUFFER, BufferUtils.createIntBuffer(indices), GL46.GL_DYNAMIC_DRAW);
		
		GL46.glBindBuffer(GL46.GL_ELEMENT_ARRAY_BUFFER, 0);
		GL46.glBindBuffer(GL46.GL_ARRAY_BUFFER, 0);
		GL46.glBindVertexArray(0);
	}
	
	public void bind() {
		if (!wasSetup) {
			Console.print(WarningType.FatalError, "VertexArray was not setup!", true);
		}
		
		GL46.glBindVertexArray(vao);
		GL46.glBindBuffer(GL46.GL_ELEMENT_ARRAY_BUFFER, ibo);
	}
	
	public void unbind() {
		GL46.glBindVertexArray(0);
		GL46.glBindBuffer(GL46.GL_ELEMENT_ARRAY_BUFFER, 0);
	}
	
	public void draw() {
		GL46.glDrawElements(GL46.GL_TRIANGLES, count, GL46.GL_UNSIGNED_INT, 0);
	}
	
	@Override
	public void reset() {
		super.reset();
		wasSetup = false;
		vao = 0;
		vbo = 0;
		ibo = 0;
		tbo = 0;
		count = 0;
	}
}
