package org.gfg.Spring_Minor.mapper;


import lombok.experimental.UtilityClass;
import org.gfg.Spring_Minor.dto.AddBookRequest;
import org.gfg.Spring_Minor.model.Author;

@UtilityClass
public class AuthorMapper {

    public Author mapToAuthor(AddBookRequest addBookRequest) {
        return Author.builder()
                .name(addBookRequest.getAuthorName())
                .email(addBookRequest.getAuthorEmail())
                .build();
    }
}
