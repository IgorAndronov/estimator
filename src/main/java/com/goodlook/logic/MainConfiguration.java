package com.goodlook.logic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Created by admin on 26.08.2017.
 */


@SpringBootApplication(scanBasePackages ="com.goodlook" )
@EntityScan(basePackages = "com.goodlook.dao")
public class MainConfiguration {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainConfiguration.class, args);
    }
}
