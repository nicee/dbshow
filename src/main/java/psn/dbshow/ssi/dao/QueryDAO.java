package psn.dbshow.ssi.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface QueryDAO {

    /**
     * 分页查询数据
     *
     * @param columns   查询列
     * @param tableName 表名称
     * @param start     起始位置
     * @param size      页大小
     * @return 数据Map组
     */
    List<Map<String, Object>> query(@Param("columns") String columns, @Param("tableName") String tableName,
                                    @Param("start") Integer start, @Param("size") Integer size);

}
