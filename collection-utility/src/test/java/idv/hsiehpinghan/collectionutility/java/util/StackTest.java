package idv.hsiehpinghan.collectionutility.java.util;

import java.util.Stack;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StackTest {
	private final int SIZE = 3;

	@Test
	public void cloneTest() {
		Stack<String> stack = generateStack();
		@SuppressWarnings("unchecked")
		Stack<String> cloneStack = (Stack<String>) stack.clone();
		stack.pop();
		Assert.assertEquals(cloneStack.size(), SIZE);
	}

	private Stack<String> generateStack() {
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < SIZE; ++i) {
			stack.push("string_" + i);
		}
		return stack;
	}
}
