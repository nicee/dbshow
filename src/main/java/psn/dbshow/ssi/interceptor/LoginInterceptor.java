package psn.dbshow.ssi.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;
import psn.dbshow.ssi.Constants;
import psn.dbshow.ssi.povo.po.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        //获取当前登录的url
        HttpServletRequest request = ServletActionContext.getRequest();
        String url = request.getRequestURL().toString();
        if (url.equals("/auth/check.do") || url.equals("/auth/login.do")) {
            return invocation.invoke();
        }

        //设置响应的配置
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires", 0);

        User user = (User) request.getSession().getAttribute(Constants.LOGIN_SESSION_KEY);
        return (user == null) ? "login" : invocation.invoke();
    }

}
