package com.example.primenumberservice.unittests;

import static org.junit.jupiter.api.Assertions.*;

import com.example.primenumberservice.PrimeNumber;
import com.example.primenumberservice.PrimeNumberService;
import com.example.primenumberservice.algorithms.Algorithm;
import com.example.primenumberservice.algorithms.SOEPrimeNumberGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;

class PrimeNumberServiceTest {


  @ParameterizedTest
  @EnumSource(Algorithm.class)
  void serviceShouldReturnListOfPrimes(Algorithm algorithm){
    PrimeNumberService primeNumberService = new PrimeNumberService();
    PrimeNumber primes = primeNumberService.getPrimes(10, algorithm);
    PrimeNumber expected = new PrimeNumber(10, new Integer[]{2,3,5,7});
    assertEquals(expected,primes);
  }

  @ParameterizedTest
  @ValueSource(ints = {20_0000_000})
  void shouldReturnPrimesForLargeLimits(int limit){
    PrimeNumberService primeNumberService = new PrimeNumberService();
    PrimeNumber primes = primeNumberService.getPrimes(limit, Algorithm.DEFAULT);
    Integer[] primesArray  = primes.primes();

    assertEquals(199999991, primesArray[primesArray.length-1]);
  }

}