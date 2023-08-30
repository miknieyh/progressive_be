package com.sanha.b_pj._progressive_be.service.post;

import com.sanha.b_pj._progressive_be.domain.posts.Posts;
import com.sanha.b_pj._progressive_be.domain.posts.PostsRepository;
import com.sanha.b_pj._progressive_be.web.dto.PostResponseDto;
import com.sanha.b_pj._progressive_be.web.dto.PostsSaveRequestDto;
import com.sanha.b_pj._progressive_be.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class PostsServiceImpl implements PostService{

    private final PostsRepository postsRepository;

    @Override
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
    @Override
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 내용이 없습니다. id="+id));
        posts.update(
                requestDto.getNum(),requestDto.getProject(),requestDto.getItem(),requestDto.getJiraLink(),
                requestDto.getDepartment(), requestDto.getProductOwner(), requestDto.getProductManager(), requestDto.getProgress(),
                requestDto.getPlanStartDate(),requestDto.getPlanEndDate(),requestDto.getDesignStartDate(),requestDto.getDesignEndDate(),
                requestDto.getDevelopmentStartDate(),requestDto.getDevelopmentEndDate(),requestDto.getOpenStartDate(),requestDto.getOpenEndDate());
        return id;
    }
    @Override
    public PostResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 내용이 없습니다. id="+id));
        return new PostResponseDto(entity);
    }

    @Override
    public void delete(Long id) {
        Posts post = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 내용이 없습니다. id="+id));
        postsRepository.delete(post);
    }
}
