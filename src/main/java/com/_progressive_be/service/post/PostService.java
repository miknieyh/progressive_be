package com.sanha.b_pj._progressive_be.service.post;

import com.sanha.b_pj._progressive_be.web.dto.PostResponseDto;
import com.sanha.b_pj._progressive_be.web.dto.PostsSaveRequestDto;
import com.sanha.b_pj._progressive_be.web.dto.PostsUpdateRequestDto;

public interface PostService {

     Long save(PostsSaveRequestDto requestDto);

     Long update(Long id, PostsUpdateRequestDto requestDto);

     PostResponseDto findById(Long id);

     void delete(Long id);
}
