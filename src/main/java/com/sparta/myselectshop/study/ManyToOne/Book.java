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

    @ManyToOne
    @JoinColumn(name="writer_id")
    private Writer writer;

}
