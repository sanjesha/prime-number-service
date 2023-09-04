package com.example.primenumberservice;

import com.example.primenumberservice.algorithms.Algorithm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.enums.ParameterStyle;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PrimeNumberController {

  private PrimeNumberService primeNumberService;

  public PrimeNumberController(PrimeNumberService primeNumberService){
    this.primeNumberService = primeNumberService;
  }


  @Operation(summary = "Generate Prime Numbers", description = "Get Prime Numbers till a given limit using one of the available algorithms")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "successful operation"),
      @ApiResponse(responseCode = "400", description = "Invalid limit value", content = @Content),
      @ApiResponse(responseCode = "400", description = "Invalid algorithm", content = @Content) })
  @GetMapping(value = "/primes/{limit}",
      produces ={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  public PrimeNumber primes(
      @Parameter(name="limit", in= ParameterIn.PATH,
          schema = @Schema(type = "integer", minimum = "0", maximum = "10000000"))
      @PathVariable(required = true)  int limit,
      @Parameter(name = "algorithm", in = ParameterIn.QUERY,
          schema = @Schema(type = "string", defaultValue = "DEFAULT",
          allowableValues = { "DEFAULT", "SIEVEOFERATOSTHENESE" }))
      @RequestParam(required = false, defaultValue = "DEFAULT") Algorithm algorithm,
      HttpServletResponse response) {

    String oneYearInSeconds = "31536000";
    response.setHeader("Cache-Control", "max-age="+oneYearInSeconds);

    return primeNumberService.getPrimes(limit, algorithm);

  }



}