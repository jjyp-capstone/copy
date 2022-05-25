package com.dongjoon.study.controller;


import com.dongjoon.study.domain.posts.Posts;
import com.dongjoon.study.domain.posts.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class BaseController {
    private final PostsRepository postsRepository;

    @GetMapping("/search")
    public String search(@RequestParam(value = "keyword")String keyword, Model model){
        List<Posts> postsList = postsRepository.postsearch(keyword);
        model.addAttribute("result", postsList);

        return "search_page";
    };


    @GetMapping("/searchall")
    public String searchAll(Model model){

        return "index";
    }

    @GetMapping("/searchkw")
    public String searchName(@RequestParam("kw") String kw, Model model){
        model.addAttribute("kw", postsRepository.postsearch(kw));


        return "search_result";
    }

    @GetMapping("/viewall")
    public String viewAll(Model model){
        model.addAttribute("list",postsRepository.postall());

        //return "demo_show";
        return "chart01"; //예시 워드 클라우드뷰
    }

    @GetMapping("/home") //home 화면
    public String home(Model model){
        model.addAttribute("list",postsRepository.postall());

        //return "demo_show";
        return "home"; 
 
    }

    @GetMapping("/keyword") //IPC 키워드 화면
    public String keyword(Model model){
        model.addAttribute("list",postsRepository.postall());
        return "keyword"; 
 
    }

    @GetMapping("/keyword_detail") //키워드 관련 기사, 유툽화면 
    public String keyword_detail(Model model){
        model.addAttribute("list",postsRepository.postall());
        return "keyword_detail"; 
 
    }

    @GetMapping("/A_section") //A_section
    public String A_section(Model model){
        model.addAttribute("list",postsRepository.postall());
        return "A_section"; 
 
    }

    @GetMapping("/B_section") //B_section
    public String B_section(Model model){
        model.addAttribute("list",postsRepository.postall());
        return "B_section"; 
 
    }

    @GetMapping("/C_section") //C_section
    public String C_section(Model model){
        model.addAttribute("list",postsRepository.postall());
        return "C_section"; 
 
    }

    @GetMapping("/D_section") //D_section
    public String D_section(Model model){
        model.addAttribute("list",postsRepository.postall());
        return "D_section"; 
 
    }

    @GetMapping("/E_section") //E_section
    public String E_section(Model model){
        model.addAttribute("list",postsRepository.postall());
        return "E_section"; 
 
    }

    @GetMapping("/F_section") //F_section
    public String F_section(Model model){
        model.addAttribute("list",postsRepository.postall());
        return "F_section"; 
 
    }

    @GetMapping("/G_section") //G_section
    public String G_section(Model model){
        model.addAttribute("list",postsRepository.postall());
        return "G_section"; 
 
    }

    @GetMapping("/H_section") //H_section
    public String H_section(Model model){
        model.addAttribute("list",postsRepository.postall());
        return "H_section"; 
 
    }

    @GetMapping("/Y_section") //Y_section
    public String Y_section(Model model){
        //model.addAttribute("list",postsRepository.postall());
        return "Y_section"; 
 
    }

}
 