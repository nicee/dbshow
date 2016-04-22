package psn.dbshow.ssi.dao;

import org.apache.ibatis.annotations.Param;
import psn.dbshow.ssi.povo.po.User;

public interface UserDAO {

    int insertUser(User user);

    User findByName(@Param("name") String name);

}
