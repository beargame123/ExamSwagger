package com.example.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Api(tags = {"API 정보를 제공하는 Controller"})
@RestController
@RequestMapping("/api")
public class ApiController extends WebMvcConfigurationSupport {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/plus/{x}")
    public int plus(
                        @ApiParam(value = "x값" , defaultValue = "20")
                        @PathVariable int x,

                        @ApiParam(value = "y값", defaultValue = "5")
                        @RequestParam int y){
        return x+y;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui/**").addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
    }
}
