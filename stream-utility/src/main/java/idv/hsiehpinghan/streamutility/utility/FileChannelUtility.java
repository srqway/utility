package idv.hsiehpinghan.streamutility.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelUtility {
	private static final int SIZE = 1024;

	public static void copyFile(File inputFile, File outputFile) throws IOException {
		try (FileInputStream inputStream = new FileInputStream(inputFile);
				FileOutputStream outputStream = new FileOutputStream(outputFile);) {
			FileChannel inputChannel = inputStream.getChannel();
			FileChannel outputChannel = outputStream.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(SIZE);
			while (true) {
				buffer.clear();
				int length = inputChannel.read(buffer);
				if (length <= 0) {
					break;
				}
				buffer.flip();
				outputChannel.write(buffer);
			}
		}
	}

}
