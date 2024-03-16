package com.example;

import com.example.entity.Note;
import com.example.repository.NoteRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    private final NoteRepository noteRepository;

    @Autowired
    public Main(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @PostConstruct
    public void init() {
        Note note1 = new Note();
        note1.setTitle("Замітка 1");
        note1.setContext("Це перша замітка");
        noteRepository.save(note1);

        Note note2 = new Note();
        note2.setTitle("Замітка 2");
        note2.setContext("Це друга замітка");
        noteRepository.save(note2);
    }
}
