package com.example.ex3.web;

import com.example.ex3.web.dto.SampleDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/sample")
@Log4j2
public class SampleController {

    @GetMapping("/ex1")
    public void ex1() {
        log.info("ex1-----------------------");
    }

    @GetMapping({"/ex2", "/ex22","/ex226", "/ex227", "/ex228", "/exLink"})
    public void exModel(Model model) {
        List<SampleDto> list2 = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            SampleDto dto = SampleDto.builder()
                    .sno((long) i)
                    .first("First.." + i)
                    .last("Last.." + i)
                    .regTime(LocalDateTime.now())
                    .build();
            list2.add(dto);
        }

        List<SampleDto> list = IntStream.rangeClosed(1,20).asLongStream()
                .mapToObj(i -> {
                   SampleDto dto = SampleDto.builder()
                           .sno(i)
                           .first("First.."+i)
                           .last("Last.."+i)
                           .regTime(LocalDateTime.now())
                           .build();
                   return dto;
                }).collect(Collectors.toList());
        model.addAttribute("list", list);
    }

    @GetMapping({"/exInline"})
    public String exInline(RedirectAttributes redirectAttributes) {
        SampleDto dto = SampleDto.builder()
                .sno(100L)
                .first("First..100")
                .last("Last..100")
                .regTime(LocalDateTime.now())
                .build();
        redirectAttributes.addFlashAttribute("result", "sucess");
        redirectAttributes.addFlashAttribute("dto", dto);
        return "redirect:/sample/ex3";
    }

    @GetMapping("/ex3")
    public void ex3() {
        log.info("ex3");
    }

}