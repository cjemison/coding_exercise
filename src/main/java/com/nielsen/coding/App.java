package com.nielsen.coding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

  public static void main(String[] args) {
    final SpringApplication springApplication = new SpringApplication(App.class);
    springApplication.run(args);
  }
}
