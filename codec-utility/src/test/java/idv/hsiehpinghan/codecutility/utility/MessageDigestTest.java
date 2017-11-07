package idv.hsiehpinghan.codecutility.utility;

import java.security.MessageDigest;

import org.testng.annotations.Test;

public class MessageDigestTest {
	private final String[] ALGORITHMS = new String[] { "MD2", "MD5", "SHA1", "SHA-256", "SHA-384", "SHA-512" };
	private final byte[] SALT = "salt".getBytes();
	private final String MESSAGE = "訊息測試";

	@Test
	public void test() throws Exception {
		for (String algorithm : ALGORITHMS) {
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			messageDigest.reset();
			messageDigest.update(SALT);
			byte[] messageBytes = MESSAGE.getBytes();
			byte[] encryptedMessage = messageDigest.digest(messageBytes);
			System.err.println(
					String.format("algorithm(%s) -> encryptedMessage(%s)", algorithm, new String(encryptedMessage)));
		}
	}

}
