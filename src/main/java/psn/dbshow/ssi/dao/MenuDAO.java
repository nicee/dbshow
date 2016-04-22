package psn.dbshow.ssi.dao;


import org.apache.ibatis.annotations.Param;
import psn.dbshow.ssi.povo.po.Menu;
import psn.dbshow.ssi.povo.vo.MenuVO;

import java.util.List;

public interface MenuDAO {

    int insert(Menu menu);

    boolean exist(@Param("name") String name);

    List<MenuVO> selectMenus(@Param("parentId") String parentId);

    int deleteChild(@Param("pId") String pId, @Param("name") String name);

}
