package com.vinicios.forum.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @ManyToOne
    private Topic topic;

    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    private User author;

    private Boolean solution = false;

    public Answer(Long id, String message, Topic topic, User author) {
        this.id = id;
        this.message = message;
        this.topic = topic;
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer awnser = (Answer) o;
        return Objects.equals(id, awnser.id) &&
                Objects.equals(message, awnser.message) &&
                Objects.equals(topic, awnser.topic) &&
                Objects.equals(createdAt, awnser.createdAt) &&
                Objects.equals(author, awnser.author) &&
                Objects.equals(solution, awnser.solution);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, topic, createdAt, author, solution);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Boolean getSolution() {
        return solution;
    }

    public void setSolution(Boolean solution) {
        this.solution = solution;
    }
}
