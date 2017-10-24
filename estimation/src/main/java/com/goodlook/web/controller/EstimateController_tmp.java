package com.goodlook.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 26.08.2017.
 */

@Controller
@RequestMapping("/public")
public class EstimateController_tmp {

    @GetMapping
    public ModelAndView getHomePage() {

        Map<String,String> params = new HashMap<String, String>();
        params.put("messages", "hello from spring");
        params.put("messages2", "hello from spring2");
        return new ModelAndView("public/homepage", params);
    }

}
