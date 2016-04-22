package psn.dbshow.ssi.service;

import psn.dbshow.ssi.povo.vo.DataQueryVO;
import psn.dbshow.ssi.util.Pager;

import java.util.List;

public interface DataQueryService {

    /**
     * 从数据中查找数据
     *
     * @param queryVO
     * @param pager
     * @return
     */
    List<Object> findDatas(DataQueryVO queryVO, Pager pager);

}
