package com.evolutionnext.cyberdojo.fibonaccisequence;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FibonacciSequenceTest {


    //f(n) -> 0 -> if n = 0
    //     -> 1 -> if n = 1
    //     -> F(n-1) + F(n - 2) if n > 1

    @Test
    public void testZero() {
        assertThat(Fibonacci.apply(0)).isEqualTo(0);
    }

    @Test
    public void testOne() {
        assertThat(Fibonacci.apply(1)).isEqualTo(1);
    }

    @Test
    public void testTwo() {
        assertThat(Fibonacci.apply(2)).isEqualTo(Fibonacci.apply(1) + Fibonacci.apply(0));
    }

    @Test
    public void test34() {
        assertThat(Fibonacci.apply(34)).isEqualTo(5702887);
    }
}
