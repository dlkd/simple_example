package com.dlkd.test.service.impl;

import com.dlkd.test.pojo.Employee;
import com.dlkd.test.mapper.EmployeeMapper;
import com.dlkd.test.service.EmployeeServiceI;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.Arrays;

/**
 * @Package com.dlkd.test.service.impl;
 * @ClassName EmployeeServiceImpl
 * @Author 孙老师
 * @Description EmployeeServiceImpl ServiceImpl实现类
 * @Date 2023-11-29
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeServiceI {

    /**
    *   按查询分页查询
    */
    @Override
    public IPage<Employee> findByPage(int pageNum, int pageSize,Employee employee) {

        //验证
        if(pageNum<1)
            pageNum=1;
        if(pageSize<1)
            pageSize=10;
        if(ObjectUtil.isEmpty(employee))
            employee = new Employee();

        // 查询条件
        LambdaQueryWrapper<Employee> wrapper = getEmployeeQueryWrapper(employee);
        IPage<Employee> page = new Page<>(pageNum, pageSize);
        page = this.page(page, wrapper);
        return page;
    }

    /**
    *   查询条件
    */
     private LambdaQueryWrapper<Employee> getEmployeeQueryWrapper(Employee employee) {
        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
        //
        wrapper.like(ObjectUtil.isNotEmpty(employee.getEmpName()),Employee::getEmpName, employee.getEmpName());
        //
        wrapper.eq(ObjectUtil.isNotEmpty(employee.getDeptName()),Employee::getDeptName, employee.getDeptName());
        //
        wrapper.eq(ObjectUtil.isNotEmpty(employee.getEmpDegreeName()),Employee::getEmpDegreeName, employee.getEmpDegreeName());
        wrapper.orderByDesc(Employee::getId);
        return wrapper;
    }

    @Override
    public void delById(Serializable attrId) {
        String str = (String) attrId;
        if(str.contains(",")){
            this.removeByIds(Arrays.asList(str.split(",")));
        }else{
            this.removeById(attrId);
        }
    }
}
