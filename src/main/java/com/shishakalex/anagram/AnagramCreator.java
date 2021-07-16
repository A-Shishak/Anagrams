package com.shishakalex.anagram;

public class AnagramCreator {
    private static final String SPACE_DELIMETER = " ";

    public String makeAnagram(String sentence){
        validateSentence(sentence);

        String[] words = sentence.split(SPACE_DELIMETER);
        String[] reversedWords = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            reversedWords[i] = reverseWord(words[i]);
        }

        return concatReversedWords(reversedWords);
    }

    private void validateSentence(String sentence){
        if (sentence == null){
            throw new IllegalArgumentException("Sentence is null");
        }
        if (sentence.isEmpty()){
            throw new IllegalArgumentException("Sentence is empty");
        }
        if (sentence.trim().isEmpty()){
            throw new IllegalArgumentException("Sentence contains only whitespaces/tabs");
        }
    }

    private String reverseWord(String word){
        char[] symbols = word.toCharArray();

        int rightPointer = symbols.length - 1;
        int leftPointer = 0;
        while (leftPointer < rightPointer){
            if (!Character.isAlphabetic(symbols[leftPointer])) {
                leftPointer++;
            }
            else if(!Character.isAlphabetic(symbols[rightPointer])) {
                rightPointer--;
            }
            else{
                swap(symbols, leftPointer, rightPointer);
                leftPointer++;
                rightPointer--;
            }
        }
        return new String(symbols);
    }

    private void swap(char[] symbols, int leftPointer, int rightPointer){
        char tmp = symbols[leftPointer];
        symbols[leftPointer] = symbols[rightPointer];
        symbols[rightPointer] = tmp;
    }

    private String concatReversedWords(String[] words){
        return String.join(SPACE_DELIMETER, words);
    }
}
