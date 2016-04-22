package psn.dbshow.ssi.dao;

import org.apache.ibatis.annotations.Param;
import psn.dbshow.ssi.povo.po.QueryColumn;
import psn.dbshow.ssi.povo.vo.QueryColumnVO;

import java.util.List;

public interface ColumnDAO {

    /**
     * 查询表查询列字段信息
     *
     * @param tableName 表名称
     * @return 列字段查询信息
     */
    List<QueryColumnVO> selectQueryColumns(@Param("tableName") String tableName);

    /**
     * @param tableName 表名称
     * @return 表的列字段数组
     */
    String[] selectColumns(@Param("tableName") String tableName);

    /**
     * 新增查询配置
     *
     * @param queryColumn 配置信息
     * @return 受影响行数
     */
    int addQuery(QueryColumn queryColumn);


    /**
     * 更新查询配置
     *
     * @param colNames 配置信息
     * @return 受影响行数
     */
    int updateQuery(QueryColumn colNames);

    /**
     * 批量移除配置信息
     *
     * @param tableName 表名称
     * @param colNames  列名称列表
     * @return 受影响行数
     */
    int batchNotActive(@Param("tableName") String tableName, @Param("colNames") List<String> colNames);


}
