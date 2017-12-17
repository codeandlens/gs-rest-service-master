package com.itg.game.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
 
@Controller
public class WebController {
	
    @GetMapping(value="/")
    public String homepage(){
        return "index";
    }
    
    @GetMapping(value="/is-activate")
    public String pageIsActivate(){
        return "is-activate";
    }
    
    @GetMapping(value="/search-node")
    public String pageSearchNode(){
        return "search-node";
    }
    
}