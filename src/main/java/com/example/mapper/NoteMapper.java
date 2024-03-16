package com.example.mapper;

import com.example.dto.NoteDTO;
import com.example.entity.Note;

public class NoteMapper {
    private NoteMapper() {
    }

    public static NoteDTO mapToDto(Note note){
        NoteDTO noteDTO = new NoteDTO();
        noteDTO.setId(note.getId());
        noteDTO.setTitle(note.getTitle());
        noteDTO.setContext(note.getContext());
        return noteDTO;
    }
    public static Note mapToEntity(NoteDTO noteDTO){
        Note note = new Note();
        note.setId(noteDTO.getId());
        note.setTitle(noteDTO.getTitle());
        note.setContext(noteDTO.getContext());
        return note;
    }
}
