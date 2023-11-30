package com.dlkd.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dlkd.test.dto.LoginDto;
import com.dlkd.test.pojo.ApUser;
import com.dlkd.test.response.ResponseResult;


/**
 * author: 孙维良
 * time:20:39
 */
public interface ApUserService extends IService<ApUser> {

    /**
     * 登录接口
     *
     * @param loginDto
     * @return
     */
    public ResponseResult login(LoginDto loginDto);
}
