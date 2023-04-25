import java.util.*;


public class Main {
	public static void main(String[] args) {
		String[] words = new String[]{"mama", "papa", "it was me", "yes", "no", "abba"};
		findDuplicate(words);
	}


	public static void findDuplicate(String[] words) {

		List<String> resultList = new ArrayList<>();

		for (String word : words) {

			char[] chars = word.toCharArray();

			Map<Character, Integer> charsMap = new HashMap<>();

			boolean isRightWord = true;

			for (Character character : chars) {
				if (charsMap.containsKey(character)) {
					Integer value = charsMap.get(character) + 1;
					charsMap.put(character, value);
				} else {
					charsMap.put(character, 1);
				}
			}

			for (Character key : charsMap.keySet()) {
				if (charsMap.get(key) % 2 != 0) {
					isRightWord = false;
				}
			}

			if (isRightWord) {
				resultList.add(word);
			}
		}

		Set<Character> charsSet = new HashSet<>();

		resultList.forEach(word ->
				word.chars().forEach(charValue -> charsSet.add((char) charValue))
		);

		System.out.println(resultList);
		System.out.println(charsSet);
	}
}
