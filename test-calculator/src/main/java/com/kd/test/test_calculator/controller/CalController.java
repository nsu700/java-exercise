package com.kd.test.test_calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kd.test.test_calculator.model.Ops;

public interface CalController {
  @GetMapping(value = "/minus/{i1}/{i2}")
  double minus(@PathVariable double i1,@PathVariable double i2);

  @GetMapping(value = "/mul/{i1}/{i2}")
  double mul(@PathVariable double i1,@PathVariable double i2);

  @GetMapping(value = "/div/{i1}/{i2}")
  double div(@PathVariable double i1,@PathVariable double i2);

  @GetMapping(value = "/add/{i1}/{i2}")
  double add(@PathVariable double i1,@PathVariable double i2);

  @GetMapping("/operation/{i1}/{i2}/{operation}")
  double operation(@PathVariable double i1, @PathVariable double i2, @PathVariable Ops operation);
}
