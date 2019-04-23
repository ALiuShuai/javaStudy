package com.someTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

// 一个文件中,单词出现的最多次数.
public class WordMaxForFile {
	// 读文件,并加载到字符串中
	public static String loadFile(String path) {
		try {
			Reader in = new FileReader(path);
			BufferedReader br = new BufferedReader(in);

			String line = null;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}
			br.close();
			return sb.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String[] parseWards(String str) {
		String[] words = str.split("[^a-zA-Z]+");
		return words;
	}

	private static Map<String, Integer> countWords(String[] words) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			if (map.containsKey(word)) {
				Integer n = map.get(word);
				map.put(word, ++n);
			} else {
				map.put(word, 1);
			}
		}
		return map;
	}

	private static Integer getMaxValue(Map<String, Integer> map) {
		Collection<Integer> values = map.values();
		return Collections.max(values);
	}

	private static List<String> getKeyByValue(Map<String, Integer> map, Integer value) {
		List<String> list = new ArrayList<String>();
		for (Entry<String, Integer> e : map.entrySet()) {
			Integer value2 = e.getValue();
			if (value == value2) {
				list.add(e.getKey());
			}
		}
		return list;
	}

	public static void main(String[] args) {
		String str = loadFile("E:\\1.txt");
		String[] words = parseWards(str);

		Map<String, Integer> map = countWords(words);

		Integer max = getMaxValue(map);
		System.out.print("单词出现的次数为:" + max + "次:");

		List<String> key = getKeyByValue(map, max);
		System.out.println(key);
	}
}