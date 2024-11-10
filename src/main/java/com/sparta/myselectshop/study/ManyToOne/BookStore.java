package com.sparta.myselectshop.study.ManyToOne;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookStore {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String master;
    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "bookStore")
    private List<Book> bookList = new ArrayList<>();

}
