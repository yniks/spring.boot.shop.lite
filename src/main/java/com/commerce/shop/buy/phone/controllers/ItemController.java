package com.commerce.shop.buy.phone.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.commerce.shop.buy.phone.repositories.*;
import com.commerce.shop.buy.phone.Schemas.*;

@RestController
@RequestMapping("/phones")
public class ItemController {
    private static final Logger log = LoggerFactory.getLogger(ItemController.class);
    private final ItemRepository repo;
    ItemController(ItemRepository repo)
    {
        log.info("RestController Initiated::");
        this.repo=repo;
    }
    @GetMapping("/get")
    Item[] get( Item alike)
    {
        log.info("GET @ '/' :: "+alike.toString());
        return  repo.get(alike);
    }
    @PostMapping("/admin/add")
    String set( @RequestBody Item alike)
    {
        log.info("SET @ '/' :: "+alike.toString());
        return  "{\"upc\":\""+repo.save(alike).getUpc()+"\"}";
    }
}
