package psn.dbshow.ssi.povo.vo;

import java.io.Serializable;

public class QueryColumnVO implements Serializable {

    private static final long serialVersionUID = 1358237151063143786L;

    private Integer id;

    private String columnName;

    private String labelName;

    private Boolean active;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
    
}
