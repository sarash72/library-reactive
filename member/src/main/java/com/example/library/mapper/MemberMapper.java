package com.example.library.mapper;


import com.example.library.dto.MemberDTO;
import com.example.library.model.Member;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
    public interface MemberMapper {

        MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

        // تبدیل Entity → DTO
        MemberDTO toDTO(Member book);

        // تبدیل DTO → Entity
        Member toEntity(MemberDTO dto);
}
