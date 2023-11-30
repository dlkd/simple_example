package com.dlkd.test.service;

import com.dlkd.test.pojo.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.io.Serializable;

/**
 * @Package com.dlkd.test.service;
 * @ClassName EmployeeServiceI
 * @Author 孙老师
 * @Description EmployeeServiceI ServiceImpl实现类
 * @Date 2023-11-29
 */
public interface EmployeeServiceI extends IService<Employee> {

    /**
    *   按查询分页查询
    */
    IPage<Employee> findByPage(int pageNum, int pageSize,Employee employee);

    /**
    *   根据主键删除
    */
    void delById(Serializable attrId);
}
