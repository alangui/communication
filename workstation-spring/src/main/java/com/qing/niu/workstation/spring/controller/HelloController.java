package com.qing.niu.workstation.spring.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/8/6
 * @ProjectName communication
 * @Version 1.0.0
 */
@RestController
@Api(value = "HelloController|一个用来测试swagger注解的控制器")
public class HelloController {

    @ApiOperation(value = "hello world",notes = "hw")
    @RequestMapping(value = "/hello/user",method = RequestMethod.GET)
    public String hello() {
        System.out.println("hello world!!!");
        return "hello world !!!!!!";
    }
}
