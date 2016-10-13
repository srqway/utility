package idv.hsiehpinghan.codecutility.utility;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class Base64Utility {
	public static byte[] decode(String string) {
		Decoder decoder = Base64.getDecoder();
		return decoder.decode(string);
	}

	public static String encode(byte[] bytes) {
		Encoder encoder = Base64.getEncoder();
		return encoder.encodeToString(bytes);
	}
}
