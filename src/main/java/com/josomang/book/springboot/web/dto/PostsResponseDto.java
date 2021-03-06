package com.josomang.book.springboot.web.dto;

import com.josomang.book.springboot.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private LocalDateTime modifiedDate;
    private String author;

    public PostsResponseDto(Posts entity){
        this.id = entity.getId();
        this.title =  entity.getTitle();

        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }

}
