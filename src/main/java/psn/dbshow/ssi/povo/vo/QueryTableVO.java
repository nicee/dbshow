package psn.dbshow.ssi.povo.vo;

import java.io.Serializable;

public class QueryTableVO implements Serializable {

    private static final long serialVersionUID = -5003815511560317520L;

    private Long id;

    private String name;

    private Boolean active;

    private Boolean included = true;

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

    public Boolean getIncluded() {
        return included;
    }

    public void setIncluded(Boolean included) {
        this.included = included;
    }

}
