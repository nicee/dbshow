package psn.dbshow.ssi.action;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import psn.dbshow.ssi.povo.po.User;
import psn.dbshow.ssi.service.UserService;

public class UserAction extends ActionSupport {

    private static final long serialVersionUID = 7022977921401693051L;

    @Autowired
    private UserService userService;

    private String username;

    private String password;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

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

    public String register() {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new IllegalArgumentException("缺少参数，检查用户名和密码");
        }
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        return userService.register(user) ? "success" : "login";
    }

    public String login() {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new IllegalArgumentException("缺少参数，检查用户名和密码");
        }
        return userService.login(username, password) != null ? "success" : "login";
    }

}
