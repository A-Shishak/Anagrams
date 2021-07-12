package com.shishakalex.anagram;


import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class AnagramCreatorTest {
    private static  AnagramCreator anagramCreator;

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

    @BeforeClass
    public static void makeAnagramCreator(){
        anagramCreator = new AnagramCreator();
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void makeAnagramTakesNullShouldThrowIllegalArgumentException() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Sentence is null");

        anagramCreator.makeAnagram(TEST_NULL_STRING);
    }

    @Test
    public void makeAnagramTakesEmptyStringShouldThrowIllegalArgumentException(){
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Sentence is empty");

        anagramCreator.makeAnagram(TEST_EMPTY_STRING);
    }

    @Test
    public void makeAnagramTakesSpacesTabsStringShouldThrowIllegalArgumentException(){
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Sentence contains only whitespaces/tabs");

        anagramCreator.makeAnagram(TEST_BLANK_STRING);

    }

    @Test
    public void makeAnagramTakesThreeWordsShouldCorrectlyReverse(){
        assertEquals("e!?dcba ji*h ponm@lk",
                anagramCreator.makeAnagram(TEST_WORD_STRING_WITH_THREE_WORDS_DIFFERENT_SYMBOLS));
    }

    @Test
    public void makeAnagramTakesThreeWordsOnlyNonLetterSymbolShouldCorrectlyReverse(){
        assertEquals(TEST_WORD_STRING_WITH_THREE_WORDS_ONLY_NON_LETTER_SYMBOLS,
                anagramCreator.makeAnagram(TEST_WORD_STRING_WITH_THREE_WORDS_ONLY_NON_LETTER_SYMBOLS));
    }

    @Test
    public void makeAnagramTakesThreeWordsOnlyLetterSymbolShouldCorrectlyReverse(){
        assertEquals("gfedcba jih ponmlk",
                anagramCreator.makeAnagram(TEST_WORD_STRING_WITH_THREE_WORDS_ONLY_LETTER_SYMBOLS));
    }

    @Test
    public void makeAnagramTakesOneWordDifferentLetterSymbolUpperLowerCasesShouldCorrectlyReverse(){
        assertEquals("GfEdcbAa",
                anagramCreator.makeAnagram(TEST_WORD_STRING_WITH_ONE_WORD_AND_DIFFERENT_LETTER_SYMBOLS_UPPER_AND_LOWER_CASES));
    }

    @Test
    public void makeAnagramTakesOneWordDifferentNonLetterSymbolShouldCorrectlyReverse(){
        assertEquals("c!№b?a",
                anagramCreator.makeAnagram(TEST_WORD_STRING_WITH_ONE_WORD_AND_DIFFERENT_NON_LETTER_SYMBOLS));
    }

    @Test
    public void makeAnagramTakesOneWordDifferentLetterSymbolShouldCorrectlyReverse(){
        assertEquals("gfedcba",
                anagramCreator.makeAnagram(TEST_WORD_STRING_WITH_ONE_WORD_AND_DIFFERENT_LETTER_SYMBOLS));
    }

    @Test
    public void makeAnagramTakesOneWordSameNonLetterSymbolShouldCorrectlyReverse(){
        assertEquals(TEST_WORD_STRING_WITH_ONE_WORD_AND_SAME_NON_LETTER_SYMBOLS,
                anagramCreator.makeAnagram(TEST_WORD_STRING_WITH_ONE_WORD_AND_SAME_NON_LETTER_SYMBOLS));
    }

    @Test
    public void makeAnagramTakesOneWordOneNonLetterSymbolShouldCorrectlyReverse(){
        assertEquals("ssa?aa",
                anagramCreator.makeAnagram(TEST_WORD_STRING_WITH_ONE_WORD_AND_ONE_NON_LETTER_SYMBOLS));
    }

    @Test
    public void makeAnagramTakesOneWordOneLetterSymbolShouldCorrectlyReverse(){
        assertEquals(TEST_WORD_STRING_WITH_ONE_WORD_AND_ONE_LETTER_SYMBOLS,
                anagramCreator.makeAnagram(TEST_WORD_STRING_WITH_ONE_WORD_AND_ONE_LETTER_SYMBOLS));
    }

    @Test
    public void makeAnagramTakesOneWordSameLetterSymbolShouldCorrectlyReverse(){
        assertEquals(TEST_WORD_STRING_WITH_ONE_WORD_AND_SAME_LETTER_SYMBOLS,
                anagramCreator.makeAnagram(TEST_WORD_STRING_WITH_ONE_WORD_AND_SAME_LETTER_SYMBOLS));
    }

    @Test
    public void makeAnagramTakesDigitsShouldStaySamePositions(){
        assertEquals(TEST_DIGIT_STRING, anagramCreator.makeAnagram(TEST_DIGIT_STRING));
    }

    @Test
    public void makeAnagramTakesStringShouldReverseIt(){
        assertEquals("cba gfed",
                anagramCreator.makeAnagram(TEST_WORD_STRING_WITH_NO_NON_LETTER_SYMBOLS));
    }

    @Test
    public void makeAnagramTakesStringWithNonLetterSymbolsShouldReverseIt(){
        assertEquals("d1cba hgf!e",
                anagramCreator.makeAnagram(TEST_WORD_STRING_WITH_NON_LETTER_SYMBOLS));
    }
}
