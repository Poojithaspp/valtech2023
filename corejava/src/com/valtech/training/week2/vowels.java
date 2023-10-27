package com.valtech.training.week2;

public class vowels {
	public static String[] breakintowords(String sentence) {
		String[] words = sentence.split(" ");
		return words;

	}

	public static int countVowels(String word) {
		int vowelCount = 0;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				vowelCount++;
			}
		}
		return vowelCount;
	}

	public static String sort(String sentence) {
		String[] words = breakintowords(sentence);
		int[] vowelCount = new int[words.length];
		int len = words.length;
		for (int i = 0; i < len; i++) {
			vowelCount[i] = countVowels(words[i]);
		}
		for (int i = 0; i < words.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < words.length; j++) {
				if (vowelCount[j] < vowelCount[minIndex]) {
					minIndex = j;
				}
			}

			int temp = vowelCount[i];
			vowelCount[i] = vowelCount[minIndex];
			vowelCount[minIndex] = temp;

			String tempWord = words[i];
			words[i] = words[minIndex];
			words[minIndex] = tempWord;
		}

		String sortedSentence = String.join(" ", words);
		return sortedSentence;
	}

	public static void main(String[] args) {
		String sentence = "Hello how are you doing";
		System.out.println(sort(sentence));
	}
}
