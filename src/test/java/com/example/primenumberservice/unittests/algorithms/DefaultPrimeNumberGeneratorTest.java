package com.example.primenumberservice.unittests.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import com.example.primenumberservice.algorithms.DefaultPrimeNumberGenerator;
import com.example.primenumberservice.algorithms.SOEPrimeNumberGenerator;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DefaultPrimeNumberGeneratorTest {


  @ParameterizedTest
  @ValueSource(ints = {-1, 0, 1})
  void shouldReturnEmptyArrayForNumbersLessThanOne(int limit){
    DefaultPrimeNumberGenerator png = new DefaultPrimeNumberGenerator();
    Integer[] primes = png.getPrimesTill(limit);
    assertArrayEquals(new Integer[]{}, primes);
  }

  @ParameterizedTest
  @ValueSource(ints = {100000})
  void shouldReturnPrimesForLargeLimits(int limit){
    DefaultPrimeNumberGenerator png = new DefaultPrimeNumberGenerator();
    Integer[] primes = png.getPrimesTill(limit);
    assertEquals(99991, primes[primes.length-1]);
  }

  @Test
  void shouldReturnPrimes(){
    int limit = 10;
    SOEPrimeNumberGenerator png = new SOEPrimeNumberGenerator();
    Integer[] primes = png.getPrimesTill(limit);
    assertArrayEquals(new Integer[]{2,3,5,7}, primes);
  }
}