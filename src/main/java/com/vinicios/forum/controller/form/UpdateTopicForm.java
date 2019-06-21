package com.vinicios.forum.controller.form;

import com.vinicios.forum.model.Topic;
import com.vinicios.forum.repository.TopicRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UpdateTopicForm {

    @NotNull
    @NotEmpty
    @Length(min = 5)
    private final String title;

    @NotNull
    @NotEmpty
    @Length(min = 5)
    private final String message;

    public UpdateTopicForm(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public Topic update(Long id, TopicRepository repository) {
        Topic topic = repository.getOne(id);
        topic.setTitle(title);
        topic.setMessage(message);
        return topic;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }
}
