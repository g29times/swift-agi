package com.mootal.agi.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
/**
 * . _________         .__   _____   __
 * ./   _____/__  _  __|__|_/ ____\_/  |_
 * .\_____  \ \ \/ \/ /|  |\   __\ \   __\
 * ./        \ \     / |  | |  |    |  |
 * /_______  /  \/\_/  |__| |__|    |__|
 * .       \/
 * <p>
 * <a href="www.google.com">google</a>
 *
 * @author li tong
 * @description:
 * @date 2025/02/25 15:21
 * @see Object
 * @since 1.0
 */
@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final List<Content> contents = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    @GetMapping
    public List<Content> getAllContents() {
        return contents;
    }

    @GetMapping("/{id}")
    public Content getContent(@PathVariable Long id) {
        return contents.stream()
                .filter(content -> content.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Content not found"));
    }

    @PostMapping
    public Content createContent(@RequestBody Content content) {
        content.setId(counter.incrementAndGet());
        contents.add(content);
        return content;
    }

    @PutMapping("/{id}")
    public Content updateContent(@PathVariable Long id, @RequestBody Content updatedContent) {
        Content content = getContent(id);
        content.setTitle(updatedContent.getTitle());
        content.setBody(updatedContent.getBody());
        return content;
    }

    @DeleteMapping("/{id}")
    public void deleteContent(@PathVariable Long id) {
        contents.removeIf(content -> content.getId().equals(id));
    }

    // 内部类用于表示内容
    private static class Content {
        private Long id;
        private String title;
        private String body;

        // getters and setters
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }
        public String getBody() { return body; }
        public void setBody(String body) { this.body = body; }
    }
}
