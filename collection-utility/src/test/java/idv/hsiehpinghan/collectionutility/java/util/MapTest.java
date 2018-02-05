package idv.hsiehpinghan.collectionutility.java.util;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MapTest {

	@Test
	public void computeIfAbsent() {
		Map<String, String> map = new HashMap<>();
		Stream.of("aaa", "bbb", "ccc").forEach(str -> map.computeIfAbsent(str, String::new));
		Assert.assertEquals(map.toString(), "{aaa=aaa, ccc=ccc, bbb=bbb}");
	}

	@Test
	public void forEach() {
		Map<String, String> map = Stream.of("aaa", "bbb", "ccc")
				.collect(Collectors.toMap(s -> "key : " + s, s -> "value : " + s));
		map.forEach((k, v) -> {
			System.err.println(String.format("%s / %s", k, v));
		});
	}

}
