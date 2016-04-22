package psn.dbshow.ssi.service.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import psn.dbshow.ssi.Constants;
import psn.dbshow.ssi.dao.MenuDAO;
import psn.dbshow.ssi.povo.po.Menu;
import psn.dbshow.ssi.povo.vo.MenuVO;
import psn.dbshow.ssi.service.MenuService;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDAO menuDAO;

    @Autowired
    private Mapper dozerMapper;

    public void save(MenuVO menuVO) {
        Menu menu = dozerMapper.map(menuVO, Menu.class);
        menu.setSortNum(Constants.DEFAULT_SORT);
        if(!menuDAO.exist(menu.getName())){
            menuDAO.insert(menu);
        }
    }

    public List<MenuVO> getRootMenus() {
        return menuDAO.selectMenus(null);
    }

    public List<MenuVO> getChildMenus(String parentId) {
        return menuDAO.selectMenus(parentId);
    }

    public boolean removeChild(String pId, String name) {
        return menuDAO.deleteChild(pId, name) == 1;
    }

}
