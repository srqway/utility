package idv.hsiehpinghan.threadutility.utility;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolUtility {
	/**
	 * Submit runnables with fixed thread pool.
	 * 
	 * @param fixedThreadAmount
	 * @param runnables
	 * @return
	 */
	public static Map<Runnable, Future<Boolean>> submitWithFixedThreadPool(
			int fixedThreadAmount, Collection<Runnable> runnables) {
		Map<Runnable, Future<Boolean>> result = new HashMap<Runnable, Future<Boolean>>(
				runnables.size());
		ExecutorService service = Executors
				.newFixedThreadPool(fixedThreadAmount);
		for (Runnable runnable : runnables) {
			Future<Boolean> future = service.submit(runnable, Boolean.TRUE);
			result.put(runnable, future);
		}
		service.shutdown();
		return result;
	}

	/**
	 * Submit runnables with cached thread pool.
	 * 
	 * @param runnables
	 * @return
	 */
	public static Map<Runnable, Future<Boolean>> submitWithCachedThreadPool(
			Collection<Runnable> runnables) {
		Map<Runnable, Future<Boolean>> result = new HashMap<Runnable, Future<Boolean>>(
				runnables.size());
		ExecutorService service = Executors.newCachedThreadPool();
		for (Runnable runnable : runnables) {
			Future<Boolean> future = service.submit(runnable, Boolean.TRUE);
			result.put(runnable, future);
		}
		service.shutdown();
		return result;
	}
}
