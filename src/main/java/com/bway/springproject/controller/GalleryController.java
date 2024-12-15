package com.bway.springproject.controller;

import com.bway.springproject.repository.ProductRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;

@Controller
public class GalleryController {

    @Autowired
    private ProductRepository prodRepo;

    @GetMapping("/gallery")
    public String getGallery(Model model, HttpSession session){

        if(session.getAttribute("validUser") == null){
            return "LoginForm";
        }

        String[] imgNames=new File("src\\main\\resources\\static\\login\\image").list();
        model.addAttribute("imgList",imgNames);

        return "GalleryForm";
    }
    @GetMapping("/productImage")
    public String productGallery(Model model){

        model.addAttribute("pList",prodRepo.findAll());
        return "ProductGallery";
    }
}
