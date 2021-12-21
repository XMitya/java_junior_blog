package ru.ifmo.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private Long id;
    private Long authorId;
    private LocalDateTime createdAt;
    private String title;
    private String content;
}
