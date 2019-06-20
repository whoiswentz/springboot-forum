package com.vinicios.forum.controller;

import com.vinicios.forum.controller.dto.TopicDTO;
import com.vinicios.forum.model.Course;
import com.vinicios.forum.model.Topic;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicsController {

    @RequestMapping("/topics")
    public List<TopicDTO> list() {
        Topic topic = new Topic("Doubt", "Doubt with sping",
                new Course("Spring", "Programming"));
        return TopicDTO.convert(Arrays.asList(topic, topic, topic));
    }
}
