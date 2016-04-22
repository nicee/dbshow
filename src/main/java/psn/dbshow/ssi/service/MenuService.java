package psn.dbshow.ssi.service;

import psn.dbshow.ssi.povo.vo.MenuVO;

import java.util.List;

public interface MenuService {

    void save(MenuVO menuVO);

    List<MenuVO> getRootMenus();

    List<MenuVO> getChildMenus(String parentId);

    boolean removeChild(String pId, String name);

}
