package com.example.primenumberservice.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SOEPrimeNumberGenerator implements PrimeNumberGenerator {

  @Override
  public Integer[] getPrimesTill(int maxPrime) {
    if(maxPrime<2){
      return new Integer[]{};
    }

    boolean[] isPrime = new boolean[maxPrime+1];
    Arrays.fill(isPrime, true);

    for(int i=2; i<= Math.sqrt(maxPrime); i++){
      if(isPrime[i]==true){
        int j = i*i;
        while(j<maxPrime+1){
          isPrime[j] = false;
          j = j+i;
        }
      }
    }

    List<Integer> primes = new ArrayList<>();
    for (int i = 2; i < maxPrime+1; i++) {
      if(isPrime[i]){
        primes.add(i);
      }
    }

    return primes.toArray(Integer[]::new);

  }
}
