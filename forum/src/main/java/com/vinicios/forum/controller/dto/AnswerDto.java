package com.vinicios.forum.controller.dto;

import com.vinicios.forum.model.Answer;

import java.time.LocalDateTime;

public class AnswerDto {

    private final Long id;
    private final String message;
    private final LocalDateTime createdAt;
    private final String author;

    public AnswerDto(Answer answer) {
        this.id = answer.getId();
        this.message = answer.getMessage();
        this.createdAt = answer.getCreatedAt();
        this.author = answer.getAuthor().getName();
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getAuthor() {
        return author;
    }
}
