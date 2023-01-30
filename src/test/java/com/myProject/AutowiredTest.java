package com.myProject;

import com.myProject.springboot.annotation.autowired.AutowiredInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutowiredTest {

    @Autowired
    @Qualifier("ZhangYijing")
    AutowiredInterface autowiredInterface;

    @Autowired
    List<AutowiredInterface> autowiredInterfaceList;

    @Test
    public void input() {
        autowiredInterface.say();
    }

    @Test
    public void input2() {
        for (AutowiredInterface anInterface : autowiredInterfaceList) {
            anInterface.say();
        }
    }

}
