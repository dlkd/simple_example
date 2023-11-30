package com.dlkd.test.controller;

import com.dlkd.test.dto.LoginDto;
import com.dlkd.test.dto.UserInfoDto;
import com.dlkd.test.pojo.ApUser;
import com.dlkd.test.response.ResponseResult;
import com.dlkd.test.service.ApUserService;
import com.dlkd.test.util.AppJwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwsHeader;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/v1/login")
@Api(value = "app用户登录",tags = "app用户登录")
public class ApUserController {

    @Autowired
    private ApUserService apUserService;

    @PostMapping("/login_auth")
    @ApiOperation(value = "登录")
    public ResponseResult login(@RequestBody LoginDto loginDto) {
        return apUserService.login(loginDto);
    }

    @GetMapping("/getInfo")
    @ApiOperation(value = "获取信息")
    public ResponseResult getInfo(String token) {
        //获取用户信息
        Jws<Claims> jws = AppJwtUtil.getJws(token);
        Claims claims = jws.getBody();
        Object id = claims.get("id");

        ApUser apUser = apUserService.getById(id.toString());
        UserInfoDto dto = new UserInfoDto();
        if (apUser == null){
            dto.setId(0L);
            dto.setName("游客");
        }else {
            dto.setId(Long.valueOf(apUser.getId()));
            dto.setName(apUser.getName());

        }
        dto.setAvatar(null);
        dto.setIntroduction(null);
        String[] roles = {"admin-token","admin","editor"};
        dto.setRoles(roles);

        return ResponseResult.okResult(dto);
    }

    @GetMapping("/logout")
    @ApiOperation(value = "退出")
    public ResponseResult logout(HttpSession session) {
        session.removeAttribute("Admin-Token");
        return ResponseResult.okResult(200,"退出成功！");
    }

}
