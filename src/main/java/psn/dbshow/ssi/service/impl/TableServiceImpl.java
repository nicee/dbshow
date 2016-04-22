package psn.dbshow.ssi.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import psn.dbshow.ssi.Constants;
import psn.dbshow.ssi.dao.TableDAO;
import psn.dbshow.ssi.povo.po.QueryTable;
import psn.dbshow.ssi.povo.vo.MenuVO;
import psn.dbshow.ssi.povo.vo.QueryColumnVO;
import psn.dbshow.ssi.povo.vo.QueryTableVO;
import psn.dbshow.ssi.service.MenuService;
import psn.dbshow.ssi.service.TableService;
import psn.dbshow.ssi.util.Pager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TableServiceImpl implements TableService {

    private static final Logger logger = LoggerFactory.getLogger(TableServiceImpl.class);

    @Autowired
    private TableDAO tableDAO;

    @Autowired
    private MenuService menuService;

    @Autowired
    private Mapper dozerMapper;

    public void save(QueryTable queryTable) {
        if (queryTable == null) {
            logger.info("新增查询表信息不能为空");
        } else {
            QueryTable old = tableDAO.selectByName(queryTable.getName());
            if (null != old) {
                tableDAO.active(old.getId());
            } else {
                tableDAO.insertOne(queryTable);
            }
            MenuVO menuVO = new MenuVO();
            menuVO.setName(queryTable.getName());
            menuVO.setpId(Constants.DATA_QUERY_ID);
            menuVO.setUrl("/data/query.do?table_name=".concat(queryTable.getName()));
            menuService.save(menuVO);
        }
    }

    public void remove(String tableName) {
        if (StringUtils.isNotBlank(tableName) && tableDAO.removeOne(tableName) == 1) {
            menuService.removeChild(Constants.DATA_QUERY_ID, tableName);
        }
    }

    public List<String> findTableNames() {
        String[] allTableNames = getTables();
        List<String> tableNames = new ArrayList<String>();
        Collections.addAll(tableNames, allTableNames);
        return tableNames;
    }

    public List<QueryTableVO> findTables(Pager pager) {
        String[] allTableNames = getTables();
        List<String> tableNames = new ArrayList<String>();

        List<QueryTableVO> queryTableVOs = tableDAO.selectQueryTables(pager);
        //添加已经选择的表
        for (QueryTableVO table : queryTableVOs) {
            tableNames.add(table.getName());
        }
        //添加未选择的表
        for (String tableName : allTableNames) {
            if (!tableNames.contains(tableName)) {
                QueryTableVO tmp = new QueryTableVO();
                tmp.setName(tableName);
                tmp.setActive(false);
                tmp.setIncluded(false);
                queryTableVOs.add(tmp);
            }
        }
        return queryTableVOs;
    }

    private String[] getTables() {
        String[] allTableNames = tableDAO.selectTables();
        if (null == allTableNames || allTableNames.length == 0) {
            logger.info("系统中找不到可用的表, 请检查'dbshow'数据库中");
            return null;
        }
        return allTableNames;
    }

}
