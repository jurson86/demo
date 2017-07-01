package com.abo.service.impl;

import com.abo.service.IDemo1;
import com.abo.service.IDemo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/31.
 */
@Service
public class Demo implements IDemo1 {

    @Autowired
    private IDemo2 demo2;

    public void setDemo2(IDemo2 demo2) {
        this.demo2 = demo2;
    }

    @Override
    public void myTest() {
        System.out.println("111111111111111");
        demo2.test2();
    }
}
