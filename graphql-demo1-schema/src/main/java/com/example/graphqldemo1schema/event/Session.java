package com.example.graphqldemo1schema.event;

public record Session(
        Integer id,
        String title,
        String description
) {
}
