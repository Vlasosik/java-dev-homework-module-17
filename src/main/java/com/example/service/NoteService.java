package com.example.service;

import com.example.dto.NoteDTO;
import com.example.entity.Note;
import com.example.exception.NoteNotFoundException;
import com.example.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.mapper.NoteMapper.mapToDto;

@Component
public class NoteService {
    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    public NoteDTO add(Note note) {
        noteRepository.save(note);
        return mapToDto(note);
    }

    public void deleteById(Long id) throws NoteNotFoundException {
        if (noteRepository.existsById(id)) {
            noteRepository.deleteById(id);
        } else {
            throw new NoteNotFoundException(id);
        }
    }

    public void update(Note note) throws NoteNotFoundException {
        try {
            noteRepository.save(note);
        } catch (Exception e) {
            throw new NoteNotFoundException();
        }
    }

    public NoteDTO getById(Long id) throws NoteNotFoundException {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));
        return mapToDto(note);
    }
}
