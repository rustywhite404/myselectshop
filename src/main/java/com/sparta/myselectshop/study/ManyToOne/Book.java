package com.sparta.myselectshop.study.ManyToOne;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String subject;

    @Column(nullable = false)
    int sell;

    @Column(nullable = false)
    int price;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name="writer_id")
    private Writer writer;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="bookstore_id")
    private BookStore bookStore;
}
