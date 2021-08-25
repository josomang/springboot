package com.josomang.book.springboot.service.posts;

import com.josomang.book.springboot.domain.posts.Posts;
import com.josomang.book.springboot.domain.posts.PostsRepository;
import com.josomang.book.springboot.web.dto.PostsResponseDto;
import com.josomang.book.springboot.web.dto.PostsSaveRequestsDto;
import com.josomang.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestsDto requestsDto){
        return postsRepository.save(requestsDto.toEntity()).getId();

    }
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        posts.update(requestDto.getTitle(),requestDto.getContent());
        return id;

    }
    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        return new PostsResponseDto(entity);
    }
}
