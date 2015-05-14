package cn.org.guhao.zospringboot.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommonController {

	Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@RequestMapping("/")
    String index() {
        return "index";
    }
	
	@RequestMapping("/login")
	String login(@RequestParam("username") String username,@RequestParam("password") String password){
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try{
			SecurityUtils.getSubject().login(token);
		} catch ( UnknownAccountException e ) { 
			logger.error("用户不存在");
		} catch ( IncorrectCredentialsException e ) {
			logger.error("密码错误");
		} catch (LockedAccountException e ) {
			logger.error("账户已锁定");
		} catch (ExcessiveAttemptsException e ) {
			logger.error("尝试次数过多");
		} catch (AuthenticationException e) {
			logger.error("认证失败！");
            return null;
        }
		return "index";
	}
	
}
