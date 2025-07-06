package com.kd.test.test_calculator.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.kd.test.test_calculator.controller.CalController;
import com.kd.test.test_calculator.model.Ops;
import com.kd.test.test_calculator.service.CalService;

@RestController
public class CalControllerImpl implements CalController{
  @Autowired
  private CalService calService;

  @Override
  public double minus(double i1,double i2) {
    return calService.minus(i1, i2);
  }

  @Override
  public double mul(double i1, double i2) {
    return calService.mul(i1, i2);
  }

  @Override
  public double add(double i1, double i2) {
    return calService.add(i1, i2);
  }

  @Override
  public double div(double i1, double i2) {
    return calService.div(i1, i2);
  }

  @Override
  public double operation(double i1, double i2, Ops operation) {
    double ret;
    switch (operation) {
        case Ops.add -> ret = this.add(i1, i2);
        case Ops.div -> ret = this.div(i1, i2);
        case Ops.mul -> ret = this.mul(i1, i2);
        case Ops.minus -> ret = this.minus(i1, i2);
        default -> throw new AssertionError();
    }
    return ret;
  }
}
