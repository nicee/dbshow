package psn.dbshow.ssi.dao;

import org.apache.ibatis.annotations.Param;
import psn.dbshow.ssi.povo.po.QueryTable;
import psn.dbshow.ssi.povo.vo.QueryColumnVO;
import psn.dbshow.ssi.povo.vo.QueryTableVO;
import psn.dbshow.ssi.util.Pager;

import java.util.List;

public interface TableDAO {

    /**
     * 新增一个数据查询配置信息
     *
     * @param queryTable 数据查询信息
     * @return 影响行数
     */
    int insertOne(QueryTable queryTable);

    /**
     * 移除对表的查询配置
     *
     * @param tableName 表名称
     * @return 影响行数
     */
    int removeOne(@Param("tableName") String tableName);

    /**
     * 激活表的查询配置
     *
     * @param id 主键ID
     * @return 影响行数
     */
    int active(Long id);

    /**
     * 查询一个表查询配置
     *
     * @param tableName 表名称
     * @return 表查询配置信息
     */
    QueryTable selectByName(@Param("tableName") String tableName);

//    int updateOne(@Param("tableName") String tableName);

    /**
     * 查询用于配置数据查询的表信息
     *
     * @param pager 分页参数
     * @return 配置数据查询的表信息
     */
    List<QueryTableVO> selectQueryTables(@Param("pager") Pager pager);

    //通过数据库默认表操作用户创建的表

    /**
     * 查找数据库中所有用于数据查询的表
     *
     * @return 表名称数组
     */
    String[] selectTables();

}
