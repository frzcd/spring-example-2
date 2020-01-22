package ru.frzcd.spring02.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@PropertySource("classpath:application.properties")
@Configuration
@ComponentScan(basePackages = "ru.otus.spring02")
public class ApplicationConfig {

}