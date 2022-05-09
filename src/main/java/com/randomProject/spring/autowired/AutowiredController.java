package com.randomProject.spring.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ZhangYijing
 * @Description
 * @Date 2022/5/9
 */
@RestController
@RequestMapping("/autowired")
public class AutowiredController {

    @Autowired
    @Qualifier("ZhangYijing")
    AutowiredInterface autowiredInterface;

    @Autowired
    List<AutowiredInterface> autowiredInterfaceList;

    @RequestMapping("/input")
    public String input() {
        autowiredInterface.say();
        return "Hello";
    }

    @RequestMapping("/input2")
    public String input2() {
        for (AutowiredInterface anInterface : autowiredInterfaceList) {
            anInterface.say();
        }
        return "Hello2";
    }
}