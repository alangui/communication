package com.qing.niu.workstation.springmvc.finishbyhand;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/3/12 19:42
 * @ProjectName communication
 * @Version 1.0.0
 */
public class FreemarkerView {

    private Map<String,Object> map = new HashMap();

    private String ftl;

    public FreemarkerView(String ftl){
        this.ftl = ftl;
    }

    public void setModel(String key, Object value){
        map.put(key,value);
    }

    public String getFtl() {
        return ftl;
    }

    public void setFtl(String ftl) {
        this.ftl = ftl;
    }
}
