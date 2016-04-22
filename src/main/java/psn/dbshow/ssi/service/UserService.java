package psn.dbshow.ssi.service;

import psn.dbshow.ssi.povo.po.User;

/**
 * @author: nicee
 * @since: 2016/3/22
 */
public interface UserService {

    boolean register(User user);

    User login(String username, String password);

}
