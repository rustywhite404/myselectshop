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
public class Writer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nation;

    private int age;

    @Builder.Default
    @OneToMany(mappedBy = "writer")
    private List<Book> book = new ArrayList<>();

}
