package psn.dbshow.ssi.service;

import psn.dbshow.ssi.povo.vo.QueryColumnVO;

import java.util.List;
import java.util.Map;

public interface ColumnService {

    //查询某表查询列的名称集合
    List<String> findColumnNames(String tableName);

    //查询某彪查询列的Label名称集合
    Map<String, String> findLabelNames(String tableName);

    //查询某表查询列的配置
    List<QueryColumnVO> findColumns(String tableName);

    //修改表查询列的配置
    boolean saveOrUpdate(String tableName, List<QueryColumnVO> columnVOs);

}
