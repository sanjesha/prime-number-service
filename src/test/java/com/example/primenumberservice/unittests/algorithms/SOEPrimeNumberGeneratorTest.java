package com.example.primenumberservice.unittests.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import com.example.primenumberservice.algorithms.SOEPrimeNumberGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SOEPrimeNumberGeneratorTest {

  @ParameterizedTest
  @ValueSource(ints = {-10, -1, 0, 1})
  void shouldReturnEmptyArrayForNumbersLessThanOne(int limit){
    SOEPrimeNumberGenerator png = new SOEPrimeNumberGenerator();
    Integer[] primes = png.getPrimesTill(limit);
    assertArrayEquals(new Integer[]{}, primes);
  }

  @Test
  void shouldReturnPrimes(){
    int limit = 10;
    SOEPrimeNumberGenerator png = new SOEPrimeNumberGenerator();
    Integer[] primes = png.getPrimesTill(limit);
    assertArrayEquals(new Integer[]{2,3,5,7}, primes);
  }

  @ParameterizedTest
  @ValueSource(ints = {20_0000_000})
  void shouldReturnPrimesForLargeLimits(int limit){
      SOEPrimeNumberGenerator png = new SOEPrimeNumberGenerator();
      Integer[] primes = png.getPrimesTill(limit);
      assertEquals(199999991, primes[primes.length-1]);
  }



}