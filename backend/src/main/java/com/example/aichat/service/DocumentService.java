package com.example.aichat.service;

import com.example.aichat.model.Document;
import com.example.aichat.repository.DocumentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DocumentService {
    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Transactional
    public Document saveDocument(String name, String content) {
        Document doc = new Document();
        doc.setName(name);
        doc.setContent(content);
        return documentRepository.save(doc);
    }
}
