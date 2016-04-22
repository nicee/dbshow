package psn.dbshow.ssi.util;

import java.io.Serializable;

public class Pager implements Serializable {

    public static final Integer MAX_PAGE_SIZE = Integer.MAX_VALUE;

    private static final long serialVersionUID = 5745127873935595742L;

    private Integer pageNumber = 1;

    private Integer pageSize = 20;

    private Integer totalCount = 0;

    private Integer pageCount = 0;

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        if (pageNumber < 1) {
            pageNumber = 1;
        }
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize < 1) {
            pageSize = 1;
        } else if (pageSize > MAX_PAGE_SIZE) {
            pageSize = MAX_PAGE_SIZE;
        }
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
        if (pageSize == 0) {
            pageCount = 0;
        } else {
            pageCount = (totalCount + pageSize - 1) / pageSize;
        }
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getStartNumber() {
        if (pageNumber < 2) {
            return 0;
        }
        return (this.pageNumber - 1) * this.pageSize;
    }

    public Integer getEndNumber() {
        return this.pageSize;
    }

}
