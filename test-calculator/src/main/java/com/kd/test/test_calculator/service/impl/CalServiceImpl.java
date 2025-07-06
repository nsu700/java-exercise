package com.kd.test.test_calculator.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.kd.test.test_calculator.service.CalService;

@Service
public class CalServiceImpl implements CalService{
  @Override
  public double add(double i1, double i2){
    return BigDecimal.valueOf(i1).add(BigDecimal.valueOf(i2)).doubleValue();
  }

  @Override
  public double minus(double i1, double i2) {
    return BigDecimal.valueOf(i1).subtract(BigDecimal.valueOf(i2)).doubleValue();
  }
    
  @Override
  public double div(double i1, double i2) {
    return BigDecimal.valueOf(1).divide(BigDecimal.valueOf(i2)).doubleValue();
  }

  @Override
  public double mul(double i1, double i2) {
    return BigDecimal.valueOf(i1).multiply(BigDecimal.valueOf(i2)).doubleValue();
  }
}
