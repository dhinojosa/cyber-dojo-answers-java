package com.evolutionnext.cyberdojo.anagrams;

import org.assertj.core.util.Lists;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AnagramsTest {

    @Test
    public void testEmptyString() throws Exception {
        assertThat(Anagrams.shuffle("")).isEqualTo(Lists.newArrayList(""));
    }

    @Test
    public void testOneLetterString() throws Exception {
       assertThat(Anagrams.shuffle("a")).isEqualTo(Lists.newArrayList("a"));
    }

    @Test
    public void testTwoLetterString() throws Exception {
        assertThat(Anagrams.shuffle("ab")).isEqualTo(Lists.newArrayList("ab", "ba"));
    }

    @Test
    public void testThreeLetterString() throws Exception {
        assertThat(Anagrams.shuffle("abc")).isEqualTo(Lists.newArrayList("abc", "acb", "bac",
                                                                                "bca", "cab", "cba"));
    }

    @Test
    public void testFourLetterString() throws Exception {
        assertThat(Anagrams.shuffle("abcd")).isEqualTo(Lists.newArrayList(
                "abcd", "abdc", "acbd", "acdb", "adbc", "adcb",
                "bacd", "badc", "bcad", "bcda", "bdac", "bdca",
                "cabd", "cadb", "cbad", "cbda", "cdab", "cdba",
                "dabc", "dacb", "dbac", "dbca", "dcab", "dcba"));
    }

    @Test
    public void testSizeOfFiveLetterString() throws Exception {
        assertThat(Anagrams.shuffle("abcde")).hasSize(120);
    }

    @Test
    public void testSizeOfSixLetterString() throws Exception {
        assertThat(Anagrams.shuffle("abcdef")).hasSize(720);
    }
}
