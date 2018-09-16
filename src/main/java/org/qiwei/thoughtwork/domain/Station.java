package org.qiwei.thoughtwork.domain;


/**
*@description 
*  
* @author   qiwei
* @date     2018/9/15 20:17
*/
public class Station {

    private String name;


    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
