package com.dlkd.test.pojo;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Package com.dlkd.test.pojo;
 * @ClassName Employee
 * @Author 孙老师
 * @Description Employee 实体类
 * @Date 2023-11-29
 */
@ApiModel(value="Employee对象", description="")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String empName;

    private String sex;

    private Integer age;

    private String deptName;

    private String empDegreeName;


}
