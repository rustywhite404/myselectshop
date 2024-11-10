package com.sparta.myselectshop.study.ManyToOne;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookStoreRepository extends JpaRepository<BookStore,Long> {
}
