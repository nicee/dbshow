package psn.dbshow.ssi.service.impl;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import psn.dbshow.ssi.dao.ColumnDAO;
import psn.dbshow.ssi.povo.po.QueryColumn;
import psn.dbshow.ssi.povo.vo.QueryColumnVO;
import psn.dbshow.ssi.service.ColumnService;

import java.util.*;

@Service
public class ColumnServiceImpl implements ColumnService {

    private static final Logger logger = LoggerFactory.getLogger(ColumnServiceImpl.class);

    @Autowired
    private ColumnDAO columnDAO;

    @Autowired
    private Mapper dozerMapper;

    public List<String> findColumnNames(String tableName) {
        List<QueryColumnVO> queryColumnVOs = columnDAO.selectQueryColumns(tableName);
        if (CollectionUtils.isEmpty(queryColumnVOs)) {
            return null;
        }
        List<String> columns = new ArrayList<String>();
        for (QueryColumnVO column : queryColumnVOs) {
            if (column.getActive()) {
                columns.add(column.getColumnName());
            }
        }
        return columns;
    }

    public Map<String, String> findLabelNames(String tableName) {
        List<QueryColumnVO> queryColumnVOs = columnDAO.selectQueryColumns(tableName);
        if (CollectionUtils.isEmpty(queryColumnVOs)) {
            return null;
        }
        Map<String, String> relations = new HashMap<String, String>();
        for (QueryColumnVO column : queryColumnVOs) {
            if (column.getActive()) {
                relations.put(column.getColumnName(), column.getLabelName());
            }
        }
        return relations;
    }

    public List<QueryColumnVO> findColumns(String tableName) {
        String[] columns = columnDAO.selectColumns(tableName);
        if (null == columns || columns.length == 0) {
            logger.info("系统中找不到表'" + tableName + "', 请检查'dbshow'数据库中");
            return null;
        }

        List<String> columnNames = new ArrayList<String>();
        //获取已选择列项
        List<QueryColumnVO> queryColumnVOs = columnDAO.selectQueryColumns(tableName);
        if (queryColumnVOs != null) {
            for (QueryColumnVO columnVO : queryColumnVOs) {
                columnNames.add(columnVO.getColumnName());
            }
        }
        //操作未选择的列项
        for (String column : columns) {
            if (!columnNames.contains(column)) {
                QueryColumnVO tmp = new QueryColumnVO();
                tmp.setLabelName(column);
                tmp.setColumnName(column);
                tmp.setActive(false);
                queryColumnVOs.add(tmp);
            }
        }
        return queryColumnVOs;
    }

    public boolean saveOrUpdate(String tableName, List<QueryColumnVO> columnVOs) {
        if (tableName == null) return false;
        String[] columns = columnDAO.selectColumns(tableName);
        if (columns == null || columns.length == 0) return false;
        List<String> colNames = new ArrayList<String>();
        Collections.addAll(colNames, columns);
        List<QueryColumn> updateObj = new ArrayList<QueryColumn>();
        boolean result = true;
        for (QueryColumnVO columnVO : columnVOs) {
            String colName = columnVO.getColumnName();
            colNames.remove(colName);
            QueryColumn queryColumn = dozerMapper.map(columnVO, QueryColumn.class);
            queryColumn.setTableName(tableName);
            if (columnVO.getId() == null) {
                //新增查询字段
                result = columnDAO.addQuery(queryColumn) == 1;
            } else {
                //更新之前查询的字段
                queryColumn.setActive(true);
                updateObj.add(queryColumn);
            }
        }
        if (result && !updateObj.isEmpty()) {
            for (QueryColumn toUpdate : updateObj) {
                result = columnDAO.updateQuery(toUpdate) == 1;
            }
        }
        if (result && !colNames.isEmpty()) {
            //激活查询字段
            result = columnDAO.batchNotActive(tableName, colNames) == colNames.size();
        }
        return result;
    }

}
