package com.sn.service;

import com.sn.entity.Emp;

import java.util.List;
import java.util.Map;

/**
 * Created by sn on 2019/12/8.
 */
public interface EmpService {

    Map showAll(Integer page, Integer rows);

    void add(Emp emp);

    void update(Emp emp);

    void del(List<String> ids);
}
