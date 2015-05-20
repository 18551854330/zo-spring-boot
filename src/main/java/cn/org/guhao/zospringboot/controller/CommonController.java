package cn.org.guhao.zospringboot.controller;


import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommonController {

	Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@RequestMapping("/")
    String index() {
        return "index";
    }
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	String checkLogin(){
		boolean hasLogged = SecurityUtils.getSubject().isAuthenticated();
		if(hasLogged){
			return "index";
		}
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	String login(@RequestParam("username") String username,@RequestParam("password") String password){
		/**
		 * 实质上登陆的验证的逻辑不是在这里做的,login请求是authc类型（即FormAuthenticationFilter）
		 * 这其中包含了验证登录和跳转到需要登陆之前的页面，也可以不使用authc类型，那么将要在这里作如下代码
		 * 并且使用WebUtils.redirectToSavedRequest(request, response, fallbackUrl)跳转至前一个画面
		 * 既然FormAuthenticationFilter中实现好了，何不直接利用呢
		 * 注:login和其他请求使用的过滤器配置在ShiroConfiguration.java中
		 */
		/*
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try{
			SecurityUtils.getSubject().login(token);
		} catch (UnknownAccountException e ) { 
			logger.error("用户不存在", e);
			return "login";
		} catch (IncorrectCredentialsException e ) {
			logger.error("密码错误", e);
			return "login";
		} catch (LockedAccountException e ) {
			logger.error("账户已锁定", e);
			return "login";
		} catch (ExcessiveAttemptsException e ) {
			logger.error("尝试次数过多", e);
			return "login";
		} catch (AuthenticationException e) {
			logger.error("认证失败！", e);
			return "login";
        }
        return "/example/list";
        */
		return "/";
	}
	
	@RequestMapping("/403")  
    public String unauthorizedRole(){  
        return "/403";  
    }  
	
	
	@RequestMapping("logout")
	String logout(){
		SecurityUtils.getSubject().logout();
		return "index";
	}
	
}
