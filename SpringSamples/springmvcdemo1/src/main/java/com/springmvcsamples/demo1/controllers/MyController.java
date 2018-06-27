package com.springmvcsamples.demo1.controllers;

import com.springmvcsamples.demo1.Demo1Application;
import com.springmvcsamples.demo1.models.Sum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyController {
    @RequestMapping("/")
    @ResponseBody
    public String hello()
    {
        return "Hello!";
    }

    @GetMapping("/sum")
    public String greetingForm(Model model) {
        model.addAttribute("sum", new Sum());
        return "sum";
    }

    @PostMapping("/result")
    public String greetingSubmit(@ModelAttribute Sum sum) {
        sum.setSum(sum.getFirst()+sum.getSecond());
        return "result";
    }
}
