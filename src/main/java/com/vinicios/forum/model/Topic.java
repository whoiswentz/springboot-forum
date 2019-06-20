package com.vinicios.forum.model;

import com.vinicios.forum.enums.StatusTopic;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Topic {

    private Long id;
    private final String title;
    private final String message;
    private final LocalDateTime createdAt = LocalDateTime.now();
    private StatusTopic status = StatusTopic.NOT_ANSWERED;
    private User autor;
    private Course curso;
    private List<Answer> respostas = new ArrayList<>();

    public Topic(String title, String message, Course curso) {
        this.title = title;
        this.message = message;
        this.curso = curso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topic topic = (Topic) o;
        return Objects.equals(id, topic.id) &&
                Objects.equals(title, topic.title) &&
                Objects.equals(message, topic.message) &&
                Objects.equals(createdAt, topic.createdAt) &&
                Objects.equals(status, topic.status) &&
                Objects.equals(autor, topic.autor) &&
                Objects.equals(curso, topic.curso) &&
                Objects.equals(respostas, topic.respostas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, message, createdAt, status, autor, curso, respostas);
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

    public StatusTopic getStatus() {
        return status;
    }

    public User getAutor() {
        return autor;
    }

    public Course getCurso() {
        return curso;
    }

    public List<Answer> getRespostas() {
        return respostas;
    }
}
