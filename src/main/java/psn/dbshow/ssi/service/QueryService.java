package psn.dbshow.ssi.service;

import psn.dbshow.ssi.util.Pager;

import java.util.List;
import java.util.Map;

public interface QueryService {

    List<Map<String, Object>> queryOnPage(String tableName, Pager pager);

}
