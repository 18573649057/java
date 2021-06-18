package com.pan.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pan.bean.Company;
import com.pan.controller.Impl.CompanyServiceImpl;

import java.io.IOException;
import java.util.List;

public class CompanyTest {
    public static void main(String[] args) throws IOException {
        CompanyServiceImpl service = new CompanyServiceImpl();
        List<Company> all = service.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(all);
        System.out.println(s);
    }


}
