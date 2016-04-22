package psn.dbshow.ssi.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import psn.dbshow.ssi.dao.QueryDAO;
import psn.dbshow.ssi.service.ColumnService;
import psn.dbshow.ssi.service.QueryService;
import psn.dbshow.ssi.util.Pager;

import java.util.List;
import java.util.Map;

@Service
public class QueryServiceImpl implements QueryService {

    @Autowired
    private QueryDAO queryDAO;

    @Autowired
    private ColumnService columnService;

    public List<Map<String, Object>> queryOnPage(String tableName, Pager pager) {
        if (StringUtils.isBlank(tableName)) {
            return null;
        }
        List<String> columns = columnService.findColumnNames(tableName);
        if (CollectionUtils.isEmpty(columns)) {
            return null;
        }
        StringBuffer buffer = new StringBuffer();
        for (String col : columns) {
            buffer.append("`").append(col).append("`,");
        }
        int cur = buffer.lastIndexOf(",");
        return queryDAO.query(buffer.toString().substring(0, cur), tableName,
                pager.getStartNumber(), pager.getEndNumber());
    }

}
