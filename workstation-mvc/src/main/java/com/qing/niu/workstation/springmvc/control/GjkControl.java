package com.qing.niu.workstation.springmvc.control;


import com.qing.niu.workstation.springmvc.finishbyhand.FreemarkerView;
import com.qing.niu.workstation.springmvc.finishbyhand.MvcMapping;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/3/12 19:40
 * @ProjectName communication
 * @Version 1.0.0
 */
@Controller
public class GjkControl {

    @MvcMapping("/open.do")
    public FreemarkerView openPage(String name){
        FreemarkerView freeMarkerView = new FreemarkerView("opeb.ftl");
        freeMarkerView.setModel("name",name);
        return freeMarkerView;
    }

    @MvcMapping("/hello.do")
    public FreemarkerView hello(String name, BlogDoc blogDoc,
                                HttpServletRequest request,
                                HttpServletResponse response){
        FreemarkerView freeMarkerView = new FreemarkerView("opeb.ftl");
        freeMarkerView.setModel("name",name);
        return freeMarkerView;
    }
}
