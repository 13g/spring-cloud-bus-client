package com.mycompany.myapp.web;

import com.mycompany.myapp.config.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/content")
public class ContentController {
    @Autowired
    private ApplicationProperties properties;

    @GetMapping
    public ResponseEntity content() {
        return ResponseEntity.ok(properties.getContact());
    }
}
