package com.jiea.monkey.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.jiea.monkey.domain.vo.Rtn;
import com.jiea.monkey.shiro.ShiroUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    private Producer producer;

    @GetMapping("tologin")
    public String tologin() {
        return "login";
    }

    @GetMapping("captcha")
    public void captcha(HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        //保存到shiro session
        ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
    }

    @ResponseBody
    @PostMapping("login")
    public Rtn login(String username, String password, String captcha) {
        String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
        if (!captcha.equalsIgnoreCase(kaptcha)) {
            return Rtn.error("验证码不正确");
        }

        try {
            Subject subject = ShiroUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
        } catch (UnknownAccountException e) {
            return Rtn.error(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return Rtn.error("账号或密码不正确");
        } catch (LockedAccountException e) {
            return Rtn.error("账号已被锁定，请联系管理员");
        } catch (AuthenticationException e) {
            return Rtn.error("账户验证失败");
        }

        return Rtn.ok();
    }
}
