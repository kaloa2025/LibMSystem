package com.example.LibMSystem.dto;

import com.example.LibMSystem.model.Author;
import com.example.LibMSystem.model.Book;
import com.example.LibMSystem.model.BookType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BookRequest {
    @NotBlank(message = "BookTitle must be unique")
    private String bookName;

    @NotBlank(message = "BookNo must be unique")
    private String bookNo;

    @NotBlank(message = "AuthorName must be unique")
    private String authorName;

    @NotBlank(message = "AuthorEmail must be unique")
    private String authorEmail;

    @NotNull
    private BookType bookType;

    @Positive
    private int securityAmount;

    public Author toAuthor()
    {
        return Author.builder()
                .authorEmail(this.authorEmail)
                .authorName(this.authorName)
                .build();
    }

    public Book toBook()
    {
        return Book.builder()
                .bookNo(this.bookNo)
                .title(this.bookName)
                .securityAmount(this.securityAmount)
                .bookType(this.bookType)
                .build();
    }
}
