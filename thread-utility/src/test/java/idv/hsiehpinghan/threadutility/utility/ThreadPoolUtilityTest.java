package idv.hsiehpinghan.threadutility.utility;

import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Future;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ThreadPoolUtilityTest {

	@Test
	public void submitWithFixedThreadPool() throws Exception {
		int runnableAmout = 10;
		int fixedThreadAmount = 5;
		Set<Runnable> runnables = generateRunnables(runnableAmout);
		Map<Runnable, Future<Boolean>> result = ThreadPoolUtility
				.submitWithFixedThreadPool(fixedThreadAmount, runnables);
		assertIsDone(result, false);
		Thread.sleep(10000);
		assertIsDone(result, true);
	}

	@Test
	public void submitWithCachedThreadPool() throws Exception {
		int runnableAmout = 10;
		Set<Runnable> runnables = generateRunnables(runnableAmout);
		Map<Runnable, Future<Boolean>> result = ThreadPoolUtility
				.submitWithCachedThreadPool(runnables);
		assertIsDone(result, false);
		Thread.sleep(10000);
		assertIsDone(result, true);
	}

	private void assertIsDone(Map<Runnable, Future<Boolean>> result,
			boolean isDone) {
		for (Entry<Runnable, Future<Boolean>> ent : result.entrySet()) {
			Assert.assertEquals(isDone, ent.getValue().isDone());
		}
	}

	private Set<Runnable> generateRunnables(int runnableAmout) {
		Set<Runnable> runnables = new HashSet<Runnable>(runnableAmout);
		for (int i = 0; i < runnableAmout; ++i) {
			Runnable runnable = new Runnable() {
				public void run() {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// Deal with stop process.
					}
				}
			};
			runnables.add(runnable);
		}
		return runnables;
	}
}
