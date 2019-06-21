package com.vinicios.forum.controller;

import com.vinicios.forum.controller.dto.DetailsTopicDto;
import com.vinicios.forum.controller.dto.TopicDto;
import com.vinicios.forum.controller.form.TopicForm;
import com.vinicios.forum.controller.form.UpdateTopicForm;
import com.vinicios.forum.model.Topic;
import com.vinicios.forum.repository.CourseRepository;
import com.vinicios.forum.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topics")
public class TopicsController {

    private final TopicRepository topicRepository;
    private final CourseRepository courseRepository;

    /**
     * Spring Team advise: Always prefer constructor Autowired
     * With constructor Autowired we can build immutable classes
     *
     * @param topicRepository
     * @param courseRepository
     */
    @Autowired
    public TopicsController(TopicRepository topicRepository, CourseRepository courseRepository) {
        this.topicRepository = topicRepository;
        this.courseRepository = courseRepository;
    }

    /**
     * Get all courses if no parameters are passed
     * filter the couses by name if parameter was passed
     *
     * @param courseName
     * @return List
     */
    @GetMapping
    public List<TopicDto> list(String courseName) {
        if (courseName == null) {
            List<Topic> topics = topicRepository.findAll();
            return TopicDto.convert(topics);
        }
        List<Topic> topics = topicRepository.findByCourseName(courseName);
        return TopicDto.convert(topics);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TopicDto> register(@RequestBody @Valid TopicForm form, UriComponentsBuilder uriComponentsBuilder) {
        final Topic topic = form.convert(courseRepository);
        topicRepository.save(topic);
        URI uri = uriComponentsBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicDto(topic));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailsTopicDto> detail(@PathVariable Long id) {
        Optional<Topic> topic = topicRepository.findById(id);

        if (!topic.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new DetailsTopicDto(topic.get()));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicDto> update(@PathVariable Long id, @RequestBody @Valid UpdateTopicForm form) {
        Optional<Topic> topic = topicRepository.findById(id);

        if (!topic.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Topic updatedTopic = form.update(id, topicRepository);
        return ResponseEntity.ok(new TopicDto(updatedTopic));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicDto> delete(@PathVariable Long id) {
        Optional<Topic> topic = topicRepository.findById(id);

        if (!topic.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Topic topicToDelete = topicRepository.getOne(id);
        topicRepository.deleteById(topicToDelete.getId());
        return ResponseEntity.ok(new TopicDto(topicToDelete));
    }
}
