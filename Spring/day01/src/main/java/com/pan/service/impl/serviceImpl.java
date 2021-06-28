package com.pan.service.impl;

import com.pan.service.service;

public class serviceImpl implements service {
    private int num;

    public void setNum(int num) {
        this.num = num;
    }

    public void save() {
        System.out.println("aaaaaa");
        System.out.println(num);
    }
}
