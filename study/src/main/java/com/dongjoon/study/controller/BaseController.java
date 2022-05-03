package com.dongjoon.study.controller;


import com.dongjoon.study.domain.posts.Posts;
import com.dongjoon.study.domain.posts.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
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
}
 