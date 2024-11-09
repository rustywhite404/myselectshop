package com.sparta.myselectshop;

import com.sparta.myselectshop.study.ManyToOne.Book;
import com.sparta.myselectshop.study.ManyToOne.BookRepository;
import com.sparta.myselectshop.study.ManyToOne.Writer;
import com.sparta.myselectshop.study.ManyToOne.WriterRepository;
import com.sparta.myselectshop.study.oneToOne.Profile;
import com.sparta.myselectshop.study.oneToOne.ProfileRepository;
import com.sparta.myselectshop.study.oneToOne.Visitor;
import com.sparta.myselectshop.study.oneToOne.VisitorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@SpringBootTest
class MyselectshopApplicationTests {

    @Autowired
    VisitorRepository visitorRepository;

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    WriterRepository writerRepository;

    @Test
    @Rollback(value = false)
    void test1(){

        Profile profile = Profile.builder()
                .visitor_name("zian1")
                .email("abc1@naver.com")
                .visitor_id("rustywhite4041")
                .point(100).build();

        Visitor visitor = Visitor.builder()
                .password("1234")
                .role("USER")
                .profile(profile).build();

        visitorRepository.save(visitor);

    }

    @Test
    @Rollback(value = false)
    void test2(){

        visitorRepository.deleteById(1L);

    }

    @Test
    @Rollback(value = false)
    void test3(){

        Writer writer1 = Writer.builder()
                .age(40)
                .name("조앤롤링")
                .nation("England")
                .build();

        Writer writer2 = Writer.builder()
                .age(45)
                .name("한강")
                .nation("Korea")
                .build();

        List<Book> bookList = new ArrayList<>();

        Book book1 = Book.builder()
                .price(15000)
                .subject("해리포터와 마법사의 돌")
                .writer(writer1)
                .sell(194)
                .build();

        Book book2 = Book.builder()
                .price(16000)
                .subject("해리포터와 비밀의 방")
                .writer(writer1)
                .sell(203)
                .build();

        Book book3 = Book.builder()
                .price(18000)
                .subject("채식주의자")
                .writer(writer2)
                .sell(301)
                .build();

        Book book4 = Book.builder()
                .price(17500)
                .subject("소년이 온다")
                .writer(writer2)
                .sell(400)
                .build();

        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);

        writerRepository.save(writer1);
        writerRepository.save(writer2);
        bookRepository.saveAll(bookList);
    }

}
