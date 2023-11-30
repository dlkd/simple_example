package com.dlkd.test.dto;/**
 * author: 孙维良
 * time:11:26
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName : UserInfoDto  //类名
 * @Description :   //描述
 * @Author : 孤 //作者
 * @Date: 2023/11/30  11:26 //日期
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto {

    private Long id;
    private String name;
    private String avatar;
    private String introduction;
    private Object[] roles;
}
