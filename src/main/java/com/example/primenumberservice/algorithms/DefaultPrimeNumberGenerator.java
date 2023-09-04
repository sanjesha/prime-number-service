package com.example.primenumberservice.algorithms;

import java.util.concurrent.ConcurrentSkipListSet;

public class DefaultPrimeNumberGenerator implements PrimeNumberGenerator {

  private final ConcurrentSkipListSet<Integer> sortedPrimes = new ConcurrentSkipListSet<>();
  private int maxLimitCalculated   = 0;

  @Override
  public Integer[] getPrimesTill(int maxPrime) {
    int firstPrime = 2;
    if(sortedPrimes.isEmpty())
      sortedPrimes.add(firstPrime);

    if(maxLimitCalculated >= maxPrime)
      return sortedPrimes.headSet(maxPrime,true).toArray(Integer[]::new);

    int currentMax = Math.max(maxLimitCalculated, sortedPrimes.last());
    for (int i = currentMax+1; i <= maxPrime; i++) {
      if(isPrime(i)){
        sortedPrimes.add(i);
      }
    }

    maxLimitCalculated = maxPrime;


    Integer[] primes = sortedPrimes.headSet(maxPrime,true).toArray(Integer[]::new);
    return primes;

  }

  private boolean isPrime(long number) {
    for (int i: sortedPrimes) {

      if(number % i == 0)
        return false;

     // if(number == i)   //if another thread has concurrently added this prime
      //  return true;

    }

    return true;
  }
}
