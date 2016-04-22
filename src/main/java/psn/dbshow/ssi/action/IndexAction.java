package psn.dbshow.ssi.action;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {

    private static final long serialVersionUID = 7758532352137325820L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String index(){
        return SUCCESS;
    }

}
