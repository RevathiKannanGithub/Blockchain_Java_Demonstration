import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class SHA256 implements Serializable {
	
	// Instantiated serialVersionUID from abstract class Serializable
	private static final long serialVersionUID = 1L;
	// SHA256 messagedigest
	static MessageDigest digest;
	String hash;
	
	// Calculate SHA256 of a Serializable object
	public static String getHash(Object o) throws IOException, NoSuchAlgorithmException {
		digest = MessageDigest.getInstance("SHA-256");
		// Convert object to byte array
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
		objectOutputStream.writeObject(o);
		objectOutputStream.flush();
		byte[] data = byteArrayOutputStream.toByteArray();
		// Hash the byte array and convert to hex
		return bytesToHex(digest.digest(data));
	}
	
	// Calculate SHA256 of a string
	public static String getHash(String s) throws NoSuchAlgorithmException {
		digest = MessageDigest.getInstance("SHA-256");
		// Hash byte array representation of string and convert to hex
		return bytesToHex(digest.digest(s.getBytes(StandardCharsets.UTF_8)));
	}
	
	// Convert byte[] to hex string
	private static String bytesToHex(byte[] hash) {
	    StringBuffer hexString = new StringBuffer();
	    for (int i = 0; i < hash.length; i++) {
	    // Convert 4 bit nibble to hex string
	    String hex = Integer.toHexString(0xff & hash[i]);
	    if(hex.length() == 1) hexString.append('0');
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
}
