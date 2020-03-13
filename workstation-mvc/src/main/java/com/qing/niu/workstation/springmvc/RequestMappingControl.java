package com.qing.niu.workstation.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/3/12 13:15
 * @ProjectName communication
 * @Version 1.0.0
 */
@Controller
public class RequestMappingControl {

    @RequestMapping("/rm.do")
    public ModelAndView hello(){
        ModelAndView modelAndView = new ModelAndView("userView");
        modelAndView.addObject("name","request mapping");
        return modelAndView;
    }
}
