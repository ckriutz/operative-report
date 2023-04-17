package com.operativereport.web.Controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
    @RequestMapping(value = "/")
    public String index(@RequestParam(name="id", required=false, defaultValue="0") String name, Model model) { 
        return "index";
    }
}