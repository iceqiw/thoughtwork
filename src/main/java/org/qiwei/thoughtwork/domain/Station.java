package org.qiwei.thoughtwork.domain;


/**
 * @author qiwei
 * @description 车站类
 * @date 2018/9/15 20:17
 */
public class Station {

    /**
     * 站名称
     */
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
