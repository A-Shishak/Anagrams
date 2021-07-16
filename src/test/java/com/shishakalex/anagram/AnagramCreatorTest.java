package com.shishakalex.anagram;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnagramCreatorTest {
    private final AnagramCreator anagramCreator = new AnagramCreator();

    private static final String TEST_NULL_STRING = null;
    private static final String TEST_EMPTY_STRING = "";
    private static final String TEST_BLANK_STRING = "            ";

    private static final String TEST_DIGIT_STRING = "12345 678 1234567890";

    private static final String TEST_WORD_STRING_WITH_NO_NON_LETTER_SYMBOLS = "abc defg";
    private static final String TEST_WORD_STRING_WITH_NON_LETTER_SYMBOLS = "a1bcd efg!h";
    private static final String TEST_WORD_STRING_WITH_ONE_WORD_AND_ONE_NON_LETTER_SYMBOLS = "aaa?ss";
    private static final String TEST_WORD_STRING_WITH_ONE_WORD_AND_ONE_LETTER_SYMBOLS = "!@##A*(?";
    private static final String TEST_WORD_STRING_WITH_ONE_WORD_AND_SAME_LETTER_SYMBOLS = "aaaaaa!a";
    private static final String TEST_WORD_STRING_WITH_ONE_WORD_AND_SAME_NON_LETTER_SYMBOLS = "aaa$$a$a$$aa";
    private static final String TEST_WORD_STRING_WITH_ONE_WORD_AND_DIFFERENT_LETTER_SYMBOLS = "abcdefg";
    private static final String TEST_WORD_STRING_WITH_ONE_WORD_AND_DIFFERENT_NON_LETTER_SYMBOLS = "a!№b?c";
    private static final String TEST_WORD_STRING_WITH_ONE_WORD_AND_DIFFERENT_LETTER_SYMBOLS_UPPER_AND_LOWER_CASES = "aAbcdEfG";
    private static final String TEST_WORD_STRING_WITH_THREE_WORDS_ONLY_LETTER_SYMBOLS = "abcdefg hij klmnop";
    private static final String TEST_WORD_STRING_WITH_THREE_WORDS_ONLY_NON_LETTER_SYMBOLS = "!@# &^% (*";
    private static final String TEST_WORD_STRING_WITH_THREE_WORDS_DIFFERENT_SYMBOLS = "a!?bcde hi*j klmn@op";

    @Test
    void makeAnagramTakesNullShouldThrowIllegalArgumentException() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> anagramCreator.makeAnagram(TEST_NULL_STRING),
                "Must throw IllegalArgumentException on null string");

        assertEquals("Sentence is null", thrown.getMessage());
    }

    @Test
    void makeAnagramTakesEmptyStringShouldThrowIllegalArgumentException(){
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> anagramCreator.makeAnagram(TEST_EMPTY_STRING),
                "Must throw IllegalArgumentException on empty string");

        assertEquals("Sentence is empty", thrown.getMessage());
    }

    @Test
    void makeAnagramTakesSpacesTabsStringShouldThrowIllegalArgumentException(){
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> anagramCreator.makeAnagram(TEST_BLANK_STRING),
                "Must throw IllegalArgumentException on spaced/tabbed string");

        assertEquals("Sentence contains only whitespaces/tabs", thrown.getMessage());
    }

    @Test
    void makeAnagramTakesThreeWordsShouldCorrectlyReverse(){
        assertThat("e!?dcba ji*h ponm@lk",
                is(anagramCreator.makeAnagram(TEST_WORD_STRING_WITH_THREE_WORDS_DIFFERENT_SYMBOLS)));
        }

    @Test
    void makeAnagramTakesThreeWordsOnlyNonLetterSymbolShouldCorrectlyReverse(){
        assertThat(TEST_WORD_STRING_WITH_THREE_WORDS_ONLY_NON_LETTER_SYMBOLS,
                is(anagramCreator.makeAnagram(TEST_WORD_STRING_WITH_THREE_WORDS_ONLY_NON_LETTER_SYMBOLS)));
        }

    @Test
    void makeAnagramTakesThreeWordsOnlyLetterSymbolShouldCorrectlyReverse(){
        assertThat("gfedcba jih ponmlk",
                is(anagramCreator.makeAnagram(TEST_WORD_STRING_WITH_THREE_WORDS_ONLY_LETTER_SYMBOLS)));
    }

    @Test
    void makeAnagramTakesOneWordDifferentLetterSymbolUpperLowerCasesShouldCorrectlyReverse(){
        assertThat("GfEdcbAa",
                is(anagramCreator.makeAnagram(TEST_WORD_STRING_WITH_ONE_WORD_AND_DIFFERENT_LETTER_SYMBOLS_UPPER_AND_LOWER_CASES)));
    }

    @Test
    void makeAnagramTakesOneWordDifferentNonLetterSymbolShouldCorrectlyReverse(){
        assertThat("c!№b?a",
                is(anagramCreator.makeAnagram(TEST_WORD_STRING_WITH_ONE_WORD_AND_DIFFERENT_NON_LETTER_SYMBOLS)));
        }

    @Test
    void makeAnagramTakesOneWordDifferentLetterSymbolShouldCorrectlyReverse(){
        assertThat("gfedcba",
                is(anagramCreator.makeAnagram(TEST_WORD_STRING_WITH_ONE_WORD_AND_DIFFERENT_LETTER_SYMBOLS)));
    }

    @Test
    void makeAnagramTakesOneWordSameNonLetterSymbolShouldCorrectlyReverse(){
        assertThat(TEST_WORD_STRING_WITH_ONE_WORD_AND_SAME_NON_LETTER_SYMBOLS,
                is(anagramCreator.makeAnagram(TEST_WORD_STRING_WITH_ONE_WORD_AND_SAME_NON_LETTER_SYMBOLS)));
        }

    @Test
    void makeAnagramTakesOneWordOneNonLetterSymbolShouldCorrectlyReverse(){
        assertThat("ssa?aa",
                is(anagramCreator.makeAnagram(TEST_WORD_STRING_WITH_ONE_WORD_AND_ONE_NON_LETTER_SYMBOLS)));
        }

    @Test
    void makeAnagramTakesOneWordOneLetterSymbolShouldCorrectlyReverse(){
        assertThat(TEST_WORD_STRING_WITH_ONE_WORD_AND_ONE_LETTER_SYMBOLS,
                is(anagramCreator.makeAnagram(TEST_WORD_STRING_WITH_ONE_WORD_AND_ONE_LETTER_SYMBOLS)));
        }

    @Test
    void makeAnagramTakesOneWordSameLetterSymbolShouldCorrectlyReverse(){
        assertThat(TEST_WORD_STRING_WITH_ONE_WORD_AND_SAME_LETTER_SYMBOLS,
                is(anagramCreator.makeAnagram(TEST_WORD_STRING_WITH_ONE_WORD_AND_SAME_LETTER_SYMBOLS)));
        }

    @Test
    void makeAnagramTakesDigitsShouldStaySamePositions(){
        assertThat(TEST_DIGIT_STRING,
                is(anagramCreator.makeAnagram(TEST_DIGIT_STRING)));
        }

    @Test
    void makeAnagramTakesStringShouldReverseIt(){
        assertThat("cba gfed",
                is(anagramCreator.makeAnagram(TEST_WORD_STRING_WITH_NO_NON_LETTER_SYMBOLS)));
        }

    @Test
    void makeAnagramTakesStringWithNonLetterSymbolsShouldReverseIt(){
        assertThat("d1cba hgf!e",
                is(anagramCreator.makeAnagram(TEST_WORD_STRING_WITH_NON_LETTER_SYMBOLS)));
        }
}
