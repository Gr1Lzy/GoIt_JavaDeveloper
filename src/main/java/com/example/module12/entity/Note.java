package com.example.module12.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Note {
    private long id;
    private String title;
    private String content;
}
