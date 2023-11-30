package com.dlkd.test.dto;/**
 * author: 孙维良
 * time:20:34
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName : LoginDto  //类名
 * @Description :   //描述
 * @Author : 孤 //作者
 * @Date: 2023/11/12  20:34 //日期
 */
@Data
public class LoginDto {

    /*
      *手机号
     */
    @ApiModelProperty(value = "手机号",required = true)
    private String phone;

    /*
    密码
     */
    @ApiModelProperty(value = "密码",required = true)
    private String password;
}
