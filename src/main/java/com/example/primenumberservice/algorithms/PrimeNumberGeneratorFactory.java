package com.example.primenumberservice.algorithms;

public class PrimeNumberGeneratorFactory {

  public static PrimeNumberGenerator getPrimeNumberGenerator(Algorithm algorithm) {
    switch(algorithm){
      case DEFAULT: return new DefaultPrimeNumberGenerator();
      case SIEVEOFERATOSTHENESE: return new SOEPrimeNumberGenerator();
      default : return new DefaultPrimeNumberGenerator();
    }
  }
}
