package psn.dbshow.ssi.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import psn.dbshow.ssi.povo.po.QueryTable;
import psn.dbshow.ssi.povo.vo.QueryColumnVO;
import psn.dbshow.ssi.povo.vo.QueryTableVO;
import psn.dbshow.ssi.service.TableService;
import psn.dbshow.ssi.util.Pager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public class TableAction extends ActionSupport {

    private static final long serialVersionUID = -4987706912623663235L;

    private static final Logger logger = LoggerFactory.getLogger(TableAction.class);

    @Autowired
    private TableService tableService;

    public void addQuery() {
        String tableName = getTableName();
        QueryTable queryTable = new QueryTable();
        queryTable.setActive(true);
        queryTable.setName(tableName);
        tableService.save(queryTable);
    }

    public void removeQuery() {
        String tableName = getTableName();
        tableService.remove(tableName);
    }

    public String tables() {
        HttpServletRequest request = ServletActionContext.getRequest();
        Integer start = (Integer) request.getAttribute("start");
        Integer size = (Integer) request.getAttribute("size");
        Pager pager = new Pager();
        if (start != null) pager.setPageNumber(start);
        if (size != null) pager.setPageSize(size);
        List<QueryTableVO> queryTableVOs = tableService.findTables(pager);
        request.setAttribute("tables", queryTableVOs);
        request.setAttribute("size", (queryTableVOs != null) ? queryTableVOs.size() : 0);
        return SUCCESS;
    }

    private String getTableName() {
        HttpServletRequest request = ServletActionContext.getRequest();
        Map params = request.getParameterMap();
        return ((String[]) params.get("table_name"))[0];
    }

}
