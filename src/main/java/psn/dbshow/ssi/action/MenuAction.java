package psn.dbshow.ssi.action;

import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import psn.dbshow.ssi.Constants;
import psn.dbshow.ssi.povo.vo.MenuVO;
import psn.dbshow.ssi.service.MenuService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MenuAction extends ActionSupport {

    private static final Logger logger = LoggerFactory.getLogger(MenuAction.class);

    @Autowired
    private MenuService menuService;

    private String parentId;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String childMenus() throws IOException {
        List<MenuVO> children = menuService.getChildMenus(parentId);
        if (!CollectionUtils.isEmpty(children)) {

            HttpServletResponse response = ServletActionContext.getResponse();
            response.setContentType("text/html;charset=utf-8");
        }
        return SUCCESS;
    }

    public void menus() throws IOException {
        HttpServletResponse response = ServletActionContext.getResponse();
        List<MenuVO> menus = menuService.getRootMenus();
        if (!CollectionUtils.isEmpty(menus)) {
            HttpServletRequest request = ServletActionContext.getRequest();
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(JSONObject.toJSONString(menus));
        } else {
            response.getWriter().write("[]");
        }
    }

}
