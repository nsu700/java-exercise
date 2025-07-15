package com.kdkd.test_postcomments.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.kdkd.test_postcomments.dto.GeneralDto;

@Controller
public interface GeneralController {
  @GetMapping("/general")
  List<GeneralDto> getAll();
}
