package com.pan.dao.Impl;

import com.pan.dao.BookDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Properties;

public class bookDaoImpl implements BookDao {

    private ArrayList al;
    private Properties properties;
    private int[] arr;
    private HashSet hs;
    private HashMap hm ;

    public void setAl(ArrayList al) {
        this.al = al;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public void setHs(HashSet hs) {
        this.hs = hs;
    }

    public void setHm(HashMap hm) {
        this.hm = hm;
    }

    public bookDaoImpl(ArrayList al, Properties properties, int[] arr, HashSet hs, HashMap hm) {
        this.al = al;
        this.properties = properties;
        this.arr = arr;
        this.hs = hs;
        this.hm = hm;
    }

    public void save() {
        System.out.println("book dao running...");
        System.out.println("ArrayList:"+al);
        System.out.println("Properties:"+properties);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("HashSet:"+hs);
        System.out.println("HashMap:"+hm);
    }
}
