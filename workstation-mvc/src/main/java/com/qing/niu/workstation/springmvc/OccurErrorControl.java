package com.qing.niu.workstation.springmvc;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/3/12 13:00
 * @ProjectName communication
 * @Version 1.0.0
 */
public class OccurErrorControl implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OccurErrorControl handleRequest");
        throw new RuntimeException("occur error");
    }
}
