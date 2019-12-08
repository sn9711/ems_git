package com.sn.controller;

import com.sn.entity.Emp;
import com.sn.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by sn on 2019/12/8.
 */
@RestController
@RequestMapping("emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    @RequestMapping("showAll")
    public Map showAll(Integer page, Integer rows) {
        Map map = empService.showAll(page, rows);
        return map;
    }

    @RequestMapping("edit")
    public void edit(String oper, String[] id, Emp emp) {
        if (oper.equals("add")) {
            empService.add(emp);
        } else if (oper.equals("edit")) {
            empService.update(emp);
        } else {
            empService.del(Arrays.asList(id));
        }
    }

}
