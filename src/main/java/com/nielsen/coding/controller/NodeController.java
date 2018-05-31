package com.nielsen.coding.controller;

import org.springframework.http.ResponseEntity;

public interface NodeController {

  ResponseEntity<?> handle(final Integer numberOfSteps);
}
