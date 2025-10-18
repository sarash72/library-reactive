package com.example.library.mapper;


import com.example.library.dto.BookDTO;
import com.example.library.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
    public interface BookMapper {

        BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

        // تبدیل Entity → DTO
        BookDTO toDTO(Book book);

        // تبدیل DTO → Entity
        Book toEntity(BookDTO dto);
}
