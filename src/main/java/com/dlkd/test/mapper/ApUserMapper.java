package com.dlkd.test.mapper;/**
 * author: 孙维良
 * time:20:38
 */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dlkd.test.pojo.ApUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName : LoginMapper  //类名
 * @Description :   //描述
 * @Author : 孤 //作者
 * @Date: 2023/11/12  20:38 //日期
 */
@Mapper
public interface ApUserMapper extends BaseMapper<ApUser> {

}
