package psn.dbshow.ssi.action;

import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import psn.dbshow.ssi.povo.vo.QueryColumnVO;
import psn.dbshow.ssi.service.ColumnService;
import psn.dbshow.ssi.service.TableService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public class ColumnAction extends ActionSupport {

    @Autowired
    private TableService tableService;

    @Autowired
    private ColumnService columnService;

    public String config() {
        HttpServletRequest request = ServletActionContext.getRequest();
        List<String> tableNames = tableService.findTableNames();
        request.setAttribute("tables", tableNames);
        request.setAttribute("size", (tableNames != null) ? tableNames.size() : 0);
        return SUCCESS;
    }

    public String columns() {
        String tableName = getTableName();
        List<QueryColumnVO> columns = columnService.findColumns(tableName);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("table", tableName);
        request.setAttribute("columns", columns);
        request.setAttribute("size", (columns == null) ? 0 : columns.size());
        return SUCCESS;
    }

    public void update() {
        HttpServletRequest request = ServletActionContext.getRequest();
        Map params = request.getParameterMap();
        String tableName = ((String[]) params.get("table"))[0];
        String cols = ((String[]) params.get("cols"))[0];
        List<QueryColumnVO> columnVOs = JSONObject.parseArray(cols, QueryColumnVO.class);
        columnService.saveOrUpdate(tableName, columnVOs);
    }

    private String getTableName() {
        HttpServletRequest request = ServletActionContext.getRequest();
        Map params = request.getParameterMap();
        return ((String[]) params.get("table_name"))[0];
    }

}
