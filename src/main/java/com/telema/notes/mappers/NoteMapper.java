package com.telema.notes.mappers;

import com.telema.notes.dtos.note.CreateUpdateNoteRequest;
import com.telema.notes.entities.Note;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface NoteMapper {
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "id", ignore = true)
    void updateNotePartial(
            CreateUpdateNoteRequest createUpdateNoteRequest,
            @MappingTarget Note note
    );
}