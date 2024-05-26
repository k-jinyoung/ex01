package com.example.ex01.controller;


import com.example.ex01.dto.SampleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/ex01")
    public void ex01() {

        System.out.println("ex01..................");
    }

    @GetMapping("/ex02")
    public void exModel(Model model) {
        System.out.println("ex02.................");

        SampleDTO dto = SampleDTO.builder()
                .regTime(LocalDateTime.now())
                .build();

        List<SampleDTO> list = IntStream.rangeClosed(1,20)
                .asLongStream()
                .mapToObj(i -> dto.toBuilder()
                        .sno(i)
                        .first("first..."+i)
                        .last("last..."+i)
                        .build()
        ).collect(Collectors.toList());

        System.out.println(list);

        model.addAttribute("list", list);
    }

    @GetMapping({"/exLayout1", "/exLayout2", "exTemplate", "/exSidebar"})
    public void exLayout1() {
        System.out.println("exLayout................");
    }
}
