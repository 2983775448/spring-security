package com.zj.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ProductController {

    @RequestMapping("/index")
    public String toIndex(ModelMap modelMap){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails){
            UserDetails user = (UserDetails)principal;
            modelMap.put("username",user.getUsername());
        }
        return "index";
    }

    @RequestMapping("/productAdd")
    public String productAdd(){
        return "product/productAdd";
    }

    @RequestMapping("/productDel")
    public String productDel(){
        return "product/productDel";
    }

    @RequestMapping("/productList")
    public String productList(){
        return "product/productList";
    }

    @RequestMapping("/productUpdate")
    public String productUpdate(){
        return "product/productUpdate";
    }

    @RequestMapping("/error")
    public String toError(){
        return "error";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }


}
