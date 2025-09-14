# Backend (Spring Boot + Spring AI)

## Features

- REST API for chat and document upload
- Uses Spring AI for LLM-based chat
- In-memory H2 database for storing documents and chats

## Setup

1. Install Java 17+
2. Build: `./mvnw clean install`
3. Run: `./mvnw spring-boot:run`

## Endpoints

- `POST /api/documents` — Upload documents
- `POST /api/chat` — Send chat messages and get responses