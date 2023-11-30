package com.dlkd.test.interceptor;/**
 * author: 孙维良
 * time:23:02
 */

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.dlkd.test.response.AppHttpCodeEnum;
import com.dlkd.test.response.ResponseResult;
import com.dlkd.test.util.AppJwtUtil;
import io.jsonwebtoken.Claims;
import net.minidev.json.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import springfox.documentation.service.ResponseMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName : LoginInterceptor  //类名
 * @Description :   //描述
 * @Author : 孤 //作者
 * @Date: 2023/11/29  23:02 //日期
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("執行了攔截器...");
        //统一拦截（查询当前session是否存在user）(这里user会在每次登陆成功后，写入session)
        String token = request.getHeader("token");

        if (StringUtils.isBlank(token)) {
            ResponseResult result = ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
            String json = JSONUtil.toJsonStr(result);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter out = null;
            try {
                out = response.getWriter();
                out.append(json);
                System.out.println("全局拦截器 返回数据: "+json);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (out != null) {
                    out.close();
                }
            }
            return false;
        }

        //3.判断token是否有效
        try {
            Claims claimsBody = AppJwtUtil.getClaimsBody(token);
            int eff = AppJwtUtil.verifyToken(claimsBody);
            if (eff == 1 || eff == 2) {
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }

        //如果设置为false时，被请求时，拦截器执行到此处将不会继续操作
        //如果设置为true时，请求将会继续执行后面的操作

        return true;
    }

}
