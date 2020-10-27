package com.ssmStudy.pojo;

/**
 * used for spring test
 */
public class People {
    EggRice eggRice;

    public EggRice getEggRice() {
        return eggRice;
    }

    public void setEggRice(EggRice eggRice) {
        this.eggRice = eggRice;
    }
    public void eat(){
        eggRice.showName();
    }
}
