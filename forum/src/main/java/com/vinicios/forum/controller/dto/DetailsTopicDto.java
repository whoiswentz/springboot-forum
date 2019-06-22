package com.vinicios.forum.controller.dto;

import com.vinicios.forum.enums.StatusTopic;
import com.vinicios.forum.model.Topic;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DetailsTopicDto {

    private final Long id;
    private final String title;
    private final String message;
    private final String author;
    private final StatusTopic statusTopic;
    private final List<AnswerDto> answers;
    private final LocalDateTime createdAt;

    public DetailsTopicDto(Topic topic) {
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.author = topic.getAuthor().getName();
        this.statusTopic = topic.getStatus();
        this.answers = new ArrayList<>();
        this.answers.addAll(topic.getAnswers()
                .stream()
                .map(AnswerDto::new)
                .collect(Collectors.toList()));
        this.createdAt = topic.getCreatedAt();
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

    public String getAuthor() {
        return author;
    }

    public StatusTopic getStatusTopic() {
        return statusTopic;
    }

    public List<AnswerDto> getAnswers() {
        return answers;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
