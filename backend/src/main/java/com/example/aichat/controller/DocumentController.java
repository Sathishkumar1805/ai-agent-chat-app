package com.example.aichat.controller;

import com.example.aichat.model.Document;
import com.example.aichat.service.DocumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {
    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping
    public ResponseEntity<Document> uploadDocument(@RequestParam String name, @RequestBody String content) {
        Document doc = documentService.saveDocument(name, content);
        return ResponseEntity.ok(doc);
    }
}
