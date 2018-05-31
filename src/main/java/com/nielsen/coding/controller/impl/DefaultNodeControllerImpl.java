package com.nielsen.coding.controller.impl;

import com.nielsen.coding.controller.NodeController;
import com.nielsen.coding.service.RequestService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DefaultNodeControllerImpl implements NodeController {

  @Autowired
  private RequestService requestService;

  @Override
  @RequestMapping(value = "/v1/perm/{numberOfSteps}", method = RequestMethod.GET)
  public ResponseEntity<?> handle(@PathVariable("numberOfSteps") final Integer numberOfSteps) {
    return ResponseEntity.ok(requestService.getPermutions(numberOfSteps));
  }
}
