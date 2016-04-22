package psn.dbshow.ssi.povo.vo;

import java.io.Serializable;
import java.util.List;

public class DataQueryVO implements Serializable {

    private static final long serialVersionUID = 8059818832035514615L;

    private String tableName;

    private List<String> columns;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }
    
}
