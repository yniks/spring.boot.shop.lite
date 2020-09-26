package com.commerce.shop.buy.phone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.commerce.shop.buy.phone.Schemas.Item;
import com.commerce.shop.buy.phone.repositories.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
  private static final Logger log = LoggerFactory.getLogger(App.class);
  private Gson gson = new GsonBuilder().create();

  public static void main(String[] args) {
    SpringApplication.run(App.class);
  }

  private String readFile(String name) throws FileNotFoundException {
    String data = "";
    try {
      File myObj = new File(name);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine())
        data += myReader.nextLine();
      myReader.close();
    } catch (FileNotFoundException e) {
      log.error("File could not be read! :: " + name);
      throw e;
    }
    return data;
  }

  @Bean
  public CommandLineRunner demo(ItemRepository repository) {

    return (args) -> {
      log.info("Current Directory::" + System.getProperty("user.dir"));
      try {
        String json = readFile("data.json");
        log.info("JSON read successfully");
        Item[] items = gson.fromJson(json, Item[].class);
        log.info("JSON parsed successfully");
        for (Item i : items) {
          repository.save(i);
          log.info("Entity Saved :: " + i.toString());
        }
      } catch (FileNotFoundException e) {
        log.info("Could not load data from JSON file.");
        log.info(" Use '/phone/admin/add' route to update repository.");
      }
    };
  }
}