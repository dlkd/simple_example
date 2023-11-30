package com.dlkd.test.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dlkd.test.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.dlkd.test.pojo.Employee;
import com.dlkd.test.service.EmployeeServiceI;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

/**
 * @Package com.dlkd.test.controller;
 * @ClassName EmployeeController
 * @Author 孙老师
 * @Description  前端控制器
 * @Date 2023-11-29
 */
@RestController
@RequestMapping("/test/employee")
@Api(tags = "员工接口")
public class EmployeeController {

    /**
     * 业务层
     */
    @Resource
    private EmployeeServiceI employeeService;

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @param employee
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("分页查询")
    public ResponseResult findByPage(@ApiParam("当前页") int pageNum, @ApiParam("页大小") int pageSize, Employee employee){
        IPage page = employeeService.findByPage(pageNum,pageSize,employee);
        return ResponseResult.okResult(page);
    }

    /**
     * 按主键查询
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("按主键查询")
    public ResponseResult getById(@ApiParam("序号") @PathVariable Serializable id){
        return ResponseResult.okResult(employeeService.getById(id));
    }

    /**
     * 增加
     * @param employee
     * @return
     */
    @PostMapping
    @ApiOperation("增加")
    public ResponseResult add(@RequestBody Employee employee){
        employeeService.save(employee);
        return ResponseResult.okResult(200,"success");
    }

    /**
     * 修改
     * @param employee
     * @return
     */
    @PutMapping
    @ApiOperation("修改")
    public ResponseResult edit(@RequestBody Employee employee){
        employeeService.updateById(employee);
        return ResponseResult.okResult(200,"success");
    }

    /**
     * 按主键删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation("按主键删除")
    public ResponseResult removeById(@ApiParam("序号") @PathVariable Serializable id){
        employeeService.delById(id);
        return ResponseResult.okResult(200,"success");
    }

    /**
     * 查询所有部门
     * @return
     */
    @GetMapping("getDept")
    @ApiOperation("查询部门")
    public ResponseResult getDeptName(){
        List<Employee> employeeList = employeeService.list(Wrappers.<Employee>lambdaQuery().select(Employee::getDeptName));
        List<String> deptNameList = employeeList.stream().map(Employee::getDeptName).distinct().collect(Collectors.toList());
        return ResponseResult.okResult(deptNameList);
    }

    /**
     * 导出excel
     * @return
     */
    @GetMapping("export")
    @ApiOperation("导出excel")
    public ResponseResult exportExcel(){
        return ResponseResult.okResult(employeeService.list());
    }
}
