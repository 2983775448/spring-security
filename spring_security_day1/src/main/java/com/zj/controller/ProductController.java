package com.zj.controller;

import com.zj.security.MyUserDetailService;
import com.zj.service.ProductService;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class ProductController {

//    @Resource
//    private ProductService productService;

    @RequestMapping("/index")
    public String toIndex(){
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

//    @RequestMapping("/login")
//    public Object login(User user){
//
//        return null;
//    }

}
