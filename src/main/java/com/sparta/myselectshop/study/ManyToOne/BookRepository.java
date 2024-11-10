package com.sparta.myselectshop.study.ManyToOne;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    // BookStore의 ID로 책들을 조회하는 메서드
    List<Book> findByBookStoreId(Long bookStoreId);
}
