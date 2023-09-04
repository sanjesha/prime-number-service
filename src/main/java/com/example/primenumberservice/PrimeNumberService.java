package com.example.primenumberservice;


import com.example.primenumberservice.algorithms.Algorithm;
import com.example.primenumberservice.algorithms.PrimeNumberGenerator;
import com.example.primenumberservice.algorithms.PrimeNumberGeneratorFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListSet;
import org.springframework.stereotype.Component;

@Component
public class PrimeNumberService {

  private final int MAX_LIMIT_FOR_DEFAULT_ALGO = 100000;
  public PrimeNumber getPrimes(int maxPrime, Algorithm algorithm) {
    if(maxPrime > MAX_LIMIT_FOR_DEFAULT_ALGO){
      algorithm = Algorithm.SIEVEOFERATOSTHENESE;
    }

    PrimeNumberGenerator primeNumberGenerator =
        PrimeNumberGeneratorFactory.getPrimeNumberGenerator(algorithm);

    Integer[] primes = primeNumberGenerator.getPrimesTill(maxPrime);
    return new PrimeNumber(maxPrime, primes);
  }
}
