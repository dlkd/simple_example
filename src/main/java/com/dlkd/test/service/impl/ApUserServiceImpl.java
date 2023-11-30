package com.dlkd.test.service.impl;/**
 * author: 孙维良
 * time:20:40
 */

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.dlkd.test.dto.LoginDto;
import com.dlkd.test.mapper.ApUserMapper;
import com.dlkd.test.pojo.ApUser;
import com.dlkd.test.response.AppHttpCodeEnum;
import com.dlkd.test.response.ResponseResult;
import com.dlkd.test.service.ApUserService;
import com.dlkd.test.util.AppJwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : LoginServiceImpl  //类名
 * @Description :   //描述
 * @Author : 孤 //作者
 * @Date: 2023/11/12  20:40 //日期
 */
@Service
@Transactional
@Slf4j
public class ApUserServiceImpl extends ServiceImpl<ApUserMapper, ApUser> implements ApUserService {

    /**
     * 登录接口
     *
     * @param loginDto
     * @return
     */
    @Override
    public ResponseResult login(LoginDto loginDto) {
        if (StringUtils.isNotBlank(loginDto.getPhone()) && StringUtils.isNotBlank(loginDto.getPassword())) {
            // 1.比对数据库中的手机号是否存在
            ApUser dbUser = getOne(Wrappers.<ApUser>lambdaQuery().eq(ApUser::getPhone, loginDto.getPhone()));
            if (dbUser == null) {
                return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST, "手机号不存在！");
            }
            //2.比对加密后的密码是否正确
            String inPassword = loginDto.getPassword();
            String salt = dbUser.getSalt();

            String password = DigestUtils.md5DigestAsHex((inPassword + salt).getBytes());
            if (!password.equals(dbUser.getPassword())) {
                return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_PASSWORD_ERROR);
            }

            //3.返回结果 jwt
            String token = AppJwtUtil.getToken(dbUser.getId().longValue());
            Map<String, Object> map = new HashMap<>();
            map.put("token", token);
            dbUser.setPassword("");
            dbUser.setSalt("");
            map.put("user", dbUser);

            return ResponseResult.okResult(map);
        } else {
            //游客登录
            Map<String, Object> map = new HashMap<>();
            map.put("token", AppJwtUtil.getToken(0L));
            return ResponseResult.okResult(map);
        }
    }
}
