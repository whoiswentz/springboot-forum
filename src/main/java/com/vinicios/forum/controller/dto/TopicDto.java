package com.vinicios.forum.controller.dto;

import com.vinicios.forum.model.Topic;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

public class TopicDto {

    private Long id;
    private String title;
    private String message;
    private LocalDateTime createdAt;

    public TopicDto(Topic topic) {
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.createdAt = topic.getCreatedAt();
    }

    public static Page<TopicDto> convert(Page<Topic> topics) {
        return topics.map(TopicDto::new);
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
