package com.dongjoon.study.controller;


import com.dongjoon.study.domain.posts.Posts;
import com.dongjoon.study.domain.posts.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Controller
public class BaseController {

    private final PostsRepository postsRepository;

    @GetMapping("/searchall")
    public List<Posts> searchAll(){
        return postsRepository.findAll();
    }

    @GetMapping("/searchname")
    public List<Posts> searchName(@RequestParam(value = "kw")String kw){

        return postsRepository.postsearch(kw);
    }

    @GetMapping("/viewall")
    public String viewAll(Model model){
        model.addAttribute("list",postsRepository.findAll());

        return "demo_show";
    }
}
