package psn.dbshow.ssi.povo.po;

import java.io.Serializable;
import java.util.Date;

public class QueryTable implements Serializable {

    private static final long serialVersionUID = -7776155519779414076L;

    private Long id;

    private String name;

    private Boolean active;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
}
