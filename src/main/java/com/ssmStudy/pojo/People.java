package com.ssmStudy.pojo;

/**
 * used for spring test
 */
public class People {
    private Rice rice;
    public  People(){};
    public People(Rice rice) {
        this.rice = rice;
    }

    public Rice getRice() {
        return rice;
    }

    public void setRice(Rice rice) {
        this.rice = rice;
    }

    public void eat(){
        rice.showName();
    }
}
