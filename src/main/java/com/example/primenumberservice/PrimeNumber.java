package com.example.primenumberservice;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import org.json.JSONObject;

public record PrimeNumber(int limit, Integer[] primes) {

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PrimeNumber that = (PrimeNumber) o;
    return limit == that.limit && Arrays.equals(primes, that.primes);
  }


}
