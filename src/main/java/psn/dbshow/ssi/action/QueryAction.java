package psn.dbshow.ssi.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import psn.dbshow.ssi.service.ColumnService;
import psn.dbshow.ssi.service.QueryService;
import psn.dbshow.ssi.util.Pager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public class QueryAction extends ActionSupport {

    @Autowired
    private QueryService queryService;

    @Autowired
    private ColumnService columnService;

    public String query() {
        HttpServletRequest request = ServletActionContext.getRequest();
        Pager pager = getPager(request);
        String tableName = getTableName(request);
        Map<String, String> labels = columnService.findLabelNames(tableName);
        request.setAttribute("size", (labels != null) ? labels.size() : 0);
        if(labels != null){
            request.setAttribute("labels", labels);
            List<Map<String, Object>> datas = queryService.queryOnPage(tableName, pager);
            request.setAttribute("datas", datas);
        }
        return SUCCESS;
    }

    private String getTableName(HttpServletRequest request) {
        Map<String, String[]> params = request.getParameterMap();
        String[] tableNames = params.get("table_name");
        return (tableNames != null && tableNames.length > 0) ? tableNames[0] : null;
    }

    private Pager getPager(HttpServletRequest request) {
        Map<String, String[]> params = request.getParameterMap();
        Pager pager = new Pager();
        String[] start = params.get("start");
        String[] size = params.get("size");
        if (start != null && StringUtils.isNotBlank(start[0])) {
            pager.setPageNumber(Integer.parseInt(start[0]));
        }
        if (size != null && StringUtils.isNotBlank(size[0])) {
            pager.setPageNumber(Integer.parseInt(size[0]));
        }
        return pager;
    }

}
