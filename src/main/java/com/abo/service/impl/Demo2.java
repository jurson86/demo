package com.abo.service.impl;

import com.abo.service.IDemo2;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/31.
 */
@Service
public class Demo2 implements IDemo2 {

    @Override
    public void test2() {
        System.out.print("2222222222222");
    }
}
