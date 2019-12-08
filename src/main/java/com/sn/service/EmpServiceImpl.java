package com.sn.service;

import com.sn.dao.EmpDao;
import com.sn.entity.Emp;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by sn on 2019/12/8.
 */
@Service
@Transactional
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map showAll(Integer page, Integer rows) {
        HashMap hashMap = new HashMap();
        List<Emp> emps = empDao.selectByRowBounds(new Emp(), new RowBounds(page * rows - rows, page * rows));
        int count = empDao.selectCount(new Emp());
        int pages = count % rows == 0 ? count / rows : count / rows + 1;
        hashMap.put("page", page);
        hashMap.put("records", count);
        hashMap.put("total", pages);
        hashMap.put("rows", emps);
        return hashMap;
    }

    @Override
    public void add(Emp emp) {
        String s = UUID.randomUUID().toString();
        emp.setId(s);
        empDao.insert(emp);
    }

    @Override
    public void update(Emp emp) {
        emp.setAge(null).setBir(null);
        empDao.updateByPrimaryKeySelective(emp);
    }

    @Override
    public void del(List<String> ids) {
        empDao.deleteByIdList(ids);
    }
}
