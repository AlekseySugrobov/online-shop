package ru.winzdoor.OnlineShopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
    @RequestMapping(value={"/", "/home", "/index"})
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("greeting", "welcome to spring web mvc");
        return mv;
    }

    @RequestMapping(value = "/test_request")
    public ModelAndView test_request(@RequestParam(value = "greeting", required = false) String greeting){
        return getModelAndView(greeting);
    }

    @RequestMapping(value = "/test_path/{greeting}")
    public ModelAndView test_path(@PathVariable(value = "greeting")String greeting){
        return getModelAndView(greeting);
    }

    private ModelAndView getModelAndView(String greeting) {
        if(greeting == null){
            greeting = "'greeting' is null";
        }
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("greeting", greeting);
        return mv;
    }
}
