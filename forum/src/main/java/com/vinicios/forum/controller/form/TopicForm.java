package com.vinicios.forum.controller.form;

import com.vinicios.forum.model.Course;
import com.vinicios.forum.model.Topic;
import com.vinicios.forum.repository.CourseRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TopicForm {

    @NotNull
    @NotEmpty
    @Length(min = 5)
    private final String title;

    @NotNull
    @NotEmpty
    @Length(min = 5)
    private final String message;

    @NotNull
    @NotEmpty
    @Length(min = 5)
    private final String courseName;

    public TopicForm(String title, String message, String course) {
        this.title = title;
        this.message = message;
        this.courseName = course;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getCourseName() {
        return courseName;
    }

    public Topic convert(CourseRepository repository) {
        Course course = repository.findByName(courseName);
        return new Topic(title, message, course);
    }
}
