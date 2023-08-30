package com.sanha.b_pj._progressive_be.controller;

import com.sanha.b_pj._progressive_be.domain.posts.Posts;
import com.sanha.b_pj._progressive_be.domain.posts.PostsRepository;
import com.sanha.b_pj._progressive_be.service.post.PostsServiceImpl;
import com.sanha.b_pj._progressive_be.web.dto.PostResponseDto;
import com.sanha.b_pj._progressive_be.web.dto.PostsSaveRequestDto;
import com.sanha.b_pj._progressive_be.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/v1")
public class RegisterController {

     private final PostsRepository postsRepository;
     private final PostsServiceImpl postsService;

     @GetMapping(value = "/posts")
     public List<Posts> helloWorld(@RequestParam String startDate, @RequestParam String endDate) {
          List<Posts> all = postsRepository.findAll();
          ArrayList<Posts> selected = new ArrayList<>();
          LocalDate start = LocalDate.parse(startDate+"-01",DateTimeFormatter.ISO_DATE);
          LocalDate end = LocalDate.parse(endDate+"-01",DateTimeFormatter.ISO_DATE);

          for (Posts posts : all) {
               List<LocalDate> startDates = Arrays.asList(
                       posts.getPlanStartDate(), posts.getDesignStartDate(),
                       posts.getDevelopmentStartDate(), posts.getOpenStartDate());

               LocalDate minDate = startDates.stream().min(Comparator.nullsLast(Comparator.naturalOrder())).get();

               List<LocalDate> endDates = Arrays.asList(
                       posts.getPlanEndDate(), posts.getDesignEndDate(),
                       posts.getDevelopmentEndDate(), posts.getOpenEndDate());

               LocalDate maxDate = endDates.stream().max(Comparator.nullsFirst(Comparator.naturalOrder())).get();
               if(start.isBefore(minDate)&& end.isAfter(maxDate)){
                    selected.add(posts);
               }

          }


          return selected;
     }

     @GetMapping("/posts/{id}")
     public PostResponseDto findById(@PathVariable Long id) {
          return postsService.findById(id);
     }

     @PostMapping("/posts")
     public Long save(@RequestBody PostsSaveRequestDto requestDto) {
          return postsService.save(requestDto);
     }

     @PutMapping("/posts/{id}")
     public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
          return postsService.update(id, requestDto);
     }

     @DeleteMapping("/posts/{id}")
     public void delete(@PathVariable Long id) {
          postsService.delete(id);
     }
}
