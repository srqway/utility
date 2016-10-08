package idv.hsiehpinghan.streamutility.utility;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileChannelUtilityTest {
	private final String FILE_PATH = "/tmp/FileChannelUtilityTest_writeByteBuffers";
	private final Charset CHAR_SET = Charset.forName("utf-8");
	private final int ID = 33333;
	private final String NAME_BYTE_BUFFER = "nameByteBuffer";
	private ByteBuffer idByteBuffer;
	private ByteBuffer nameByteBuffer;
	private ByteBuffer[] byteBuffers;

	@BeforeClass
	public void beforeClass() throws UnsupportedEncodingException {
		idByteBuffer = ByteBuffer.wrap(ByteBuffer.allocate(Integer.BYTES).putInt(ID).array());
		nameByteBuffer = ByteBuffer.wrap(NAME_BYTE_BUFFER.getBytes(CHAR_SET));
		byteBuffers = new ByteBuffer[] { idByteBuffer, nameByteBuffer };
	}

	@Test
	public void copyFile() throws Exception {
		String inputPath = "/etc/passwd";
		String outputPath = "/tmp/FileChannelUtilityTest_copyFile";
		File inputFile = new File(inputPath);
		File outputFile = new File(outputPath);
		FileChannelUtility.copyFile(inputFile, outputFile);
	}

	@Test
	public void writeByteBuffers() throws Exception {
		File outputFile = new File(FILE_PATH);
		FileChannelUtility.writeByteBuffers(byteBuffers, outputFile);
	}

	@Test(dependsOnMethods = { "writeByteBuffers" })
	public void readByteBuffers() throws Exception {
		File inputFile = new File(FILE_PATH);
		ByteBuffer idByteBuffer = ByteBuffer.allocate(Integer.BYTES);
		ByteBuffer nameByteBuffer = ByteBuffer.allocate(NAME_BYTE_BUFFER.getBytes(CHAR_SET).length);
		ByteBuffer[] byteBuffers = new ByteBuffer[] { idByteBuffer, nameByteBuffer };
		FileChannelUtility.readByteBuffers(byteBuffers, inputFile);
		idByteBuffer.flip();
		this.idByteBuffer.flip();
		Assert.assertEquals(idByteBuffer.getInt(), this.idByteBuffer.getInt());
		nameByteBuffer.flip();
		this.nameByteBuffer.flip();
		Assert.assertEquals(new String(nameByteBuffer.array(), CHAR_SET),
				new String(this.nameByteBuffer.array(), CHAR_SET));
	}
}
