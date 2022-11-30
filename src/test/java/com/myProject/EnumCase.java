package com.myProject;

import com.myProject.javaBase.enumcase.CaleWay;
import com.myProject.javaBase.enumcase.FactoryEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnumCase {

    @Test
    public void test1() {
        CaleWay bbc = FactoryEnum.getServiceByType("bbc");
        assert bbc != null;
        System.out.println(bbc.caleMargin());
    }
}
