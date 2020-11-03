package com.ssmStudy.pojo;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * used for spring test,用于熟悉控制反转、依赖注入
 */
public class People {
    private Rice rice;
    private Rice[] riceArr;
    private List<String> list;
    private Map<String,String> map;
    private Set<String> set;
    private List<Rice> listForBean;
    private Map<String,Rice> mapForBean;
    private Set<Rice> setForBean;
    private Map<String,String> mapPro;

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
        System.out.println(list.size());
        rice.showName();
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Rice[] getRiceArr() {
        return riceArr;
    }

    public void setRiceArr(Rice[] riceArr) {
        this.riceArr = riceArr;
    }

    public List<Rice> getListForBean() {
        return listForBean;
    }

    public void setListForBean(List<Rice> listForBean) {
        this.listForBean = listForBean;
    }

    public Map<String, Rice> getMapForBean() {
        return mapForBean;
    }

    public void setMapForBean(Map<String, Rice> mapForBean) {
        this.mapForBean = mapForBean;
    }

    public Set<Rice> getSetForBean() {
        return setForBean;
    }

    public void setSetForBean(Set<Rice> setForBean) {
        this.setForBean = setForBean;
    }

    public Map<String, String> getMapPro() {
        return mapPro;
    }

    public void setMapPro(Map<String, String> mapPro) {
        this.mapPro = mapPro;
    }
}
