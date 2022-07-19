package com.example.springboot.Service;

import com.example.springboot.Bean.TestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class DemoService {
    private HashMap<String, TestBean> map = new HashMap<>();
    @Autowired
    private TestBean testBean;


    public String getData(String id) {
        TestBean test = map.get(id);
        if (test == null) {
            return "";
        }
        return test.name;
    }

    public void updateData(String id, String name) {
        testBean.id = id;
        testBean.name = name;
        map.put(id, testBean);
    }
}
