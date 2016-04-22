package psn.dbshow.ssi.service;

import psn.dbshow.ssi.povo.po.QueryTable;
import psn.dbshow.ssi.povo.vo.QueryColumnVO;
import psn.dbshow.ssi.povo.vo.QueryTableVO;
import psn.dbshow.ssi.util.Pager;

import java.util.List;

public interface TableService {

    void save(QueryTable queryTable);

    void remove(String tableName);

    //查询可用的表名列表
    List<String> findTableNames();

    //查询可用配置的表
    List<QueryTableVO> findTables(Pager pager);

}
