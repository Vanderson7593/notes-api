package com.telema.notes.dtos.note;

import jakarta.validation.constraints.NotBlank;
import org.mapstruct.BeanMapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

public record CreateUpdateNoteRequest(
        @NotBlank
        String title,
        @NotBlank
        String content
) {
}
