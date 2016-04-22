package psn.dbshow.ssi.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import psn.dbshow.ssi.Constants;
import psn.dbshow.ssi.povo.po.User;
import psn.dbshow.ssi.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;

public class LoginAction extends ActionSupport {

    private static final Logger logger = LoggerFactory.getLogger(LoginAction.class);

    @Autowired
    private UserService userService;

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void check() throws IOException {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            logger.info("登录参数错误, 用户名或者密码为空, 用户名为=[" + username + "], 密码=[" + password + "]");
            return;
        }
        HttpServletResponse response = ServletActionContext.getResponse();
        HttpServletRequest request = ServletActionContext.getRequest();
        Writer writer = response.getWriter();
        User user = userService.login(username, password);
        if (user != null) {
            request.getSession().setAttribute(Constants.LOGIN_SESSION_KEY, user);
        }
        writer.write((user != null) ? "success" : "ticket-error");
        writer.flush();
    }

    public String login() {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            logger.info("登录参数错误, 用户名或者密码为空, 用户名为=[" + username + "], 密码=[" + password + "]");
            return LOGIN;
        }
        HttpServletRequest request = ServletActionContext.getRequest();
        User user = (User) request.getSession().getAttribute(Constants.LOGIN_SESSION_KEY);
        if (user == null) {
            logger.info("当前用户session已过期, 将进行重新登录.");
            user = userService.login(username, password);
            logger.info("用户[" + username + "]于[" + new Date() + "]登录系统" + ((user == null) ? "成功" : "失败"));
            if (user == null) {

            }
        }
        return (user != null) ? SUCCESS : LOGIN;
    }

    public String logout(){
        HttpServletRequest request = ServletActionContext.getRequest();
        User user = (User) request.getSession().getAttribute(Constants.LOGIN_SESSION_KEY);
        if(user != null) {
            request.removeAttribute(Constants.LOGIN_SESSION_KEY);
        }
        request.getSession().invalidate();
        return SUCCESS;
    }

}
