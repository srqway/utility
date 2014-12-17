import idv.hsiehpinghan.datatypeutility.utility.ByteUtility;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;


public class Test {
	public static void main(String[] args) {
	
		byte[] b1 = {'a','b','c'};
		byte[] b2 = {'1','2','3'};
		byte[] b3 = {'A','B','C'};
		
//		ArrayUtils.addAll(b1, b2, b3);
//		getbytes(b1, b2);
	}
	
	public static byte[] getbytes(byte[]... bs) {
		for(int i = 0, size = bs.length; i < size; ++i) {
			for(byte b : bs[i]) {
				System.err.println(b);
			}
			
		}
		return null;
	}
}
