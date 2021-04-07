package main.java.ulibs.ucrypt;

//@param <T> Used for {@link ICryptable#fromString(String)} to allow returning self instead of parent

public interface ICryptable<T extends ICryptable<T>> {
	/** Used to convert self into a byte array for {@link UCrypt#encode(long, ICryptable)}
	 * @return A byte array to be encoded
	 */
	public byte[] toBytes();
	
	/** Used to create a new instance of self for {@link UCrypt#decode(long, String, Class)}
	 * @param string The decoded string used to create a instance of self
	 * @return A new instance of self
	 */
	public T fromString(String string);
}
