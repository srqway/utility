package idv.hsiehpinghan.streamutility.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

	public static void writeByteBuffers(ByteBuffer[] byteBuffers, File outputFile)
			throws FileNotFoundException, IOException {
		try (FileOutputStream outputStream = new FileOutputStream(outputFile);) {
			FileChannel outputChannel = outputStream.getChannel();
			outputChannel.write(byteBuffers);
		}
	}

	public static void readByteBuffers(ByteBuffer[] byteBuffers, File inputFile)
			throws FileNotFoundException, IOException {
		try (FileInputStream inputStream = new FileInputStream(inputFile);) {
			FileChannel inputChannel = inputStream.getChannel();
			inputChannel.read(byteBuffers);
		}
	}
}
