package com.lrm.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogApi {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/log")
    public String log(){
        String name = "test";
        String test = "name";
        logger.info("info ---- log");
        logger.warn("warn ---- log");
        logger.error("error ---- log");
        logger.debug("debug ---- log");
        logger.trace("debug ---- log");

        logger.info("name : {}, test : {}", name, test);

        return "testLog";
    }
}
