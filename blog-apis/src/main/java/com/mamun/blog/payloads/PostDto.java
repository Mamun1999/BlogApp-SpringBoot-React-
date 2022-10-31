package com.mamun.blog.payloads;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {
    
    private Integer postId;

    private String title;

    private String content;

    private String imagaName;

    private Date addedDate;

    private CategoryDto category;

    private UserDto user;
}
