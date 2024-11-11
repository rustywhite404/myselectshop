//package com.sparta.myselectshop;
//
//import com.sparta.myselectshop.study.ManyToMany.Student;
//import com.sparta.myselectshop.study.ManyToMany.StudentRepository;
//import com.sparta.myselectshop.study.ManyToMany.Subject;
//import com.sparta.myselectshop.study.ManyToMany.SubjectRepository;
//import com.sparta.myselectshop.study.ManyToOne.*;
//import com.sparta.myselectshop.study.oneToOne.Profile;
//import com.sparta.myselectshop.study.oneToOne.ProfileRepository;
//import com.sparta.myselectshop.study.oneToOne.Visitor;
//import com.sparta.myselectshop.study.oneToOne.VisitorRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Transactional
//@SpringBootTest
//class MyselectshopApplicationTests {
//
//    @Autowired
//    VisitorRepository visitorRepository;
//
//    @Autowired
//    ProfileRepository profileRepository;
//
//    @Autowired
//    BookRepository bookRepository;
//
//    @Autowired
//    WriterRepository writerRepository;
//
//    @Autowired
//    StudentRepository studentRepository;
//
//    @Autowired
//    SubjectRepository subjectRepository;
//
//    @Autowired
//    BookStoreRepository bookStoreRepository;
//
//    @Test
//    @Rollback(value = false)
//    void test1(){
//
//        Profile profile = Profile.builder()
//                .visitor_name("zian1")
//                .email("abc1@naver.com")
//                .visitor_id("rustywhite4041")
//                .point(100).build();
//
//        Visitor visitor = Visitor.builder()
//                .password("1234")
//                .role("USER")
//                .profile(profile).build();
//
//        visitorRepository.save(visitor);
//
//    }
//
//    @Test
//    @Rollback(value = false)
//    void test2(){
//
//        visitorRepository.deleteById(1L);
//
//    }
//
//    @Test
//    @Rollback(value = false)
//    void test3(){
//
//        Writer writer1 = Writer.builder()
//                .age(40)
//                .name("조앤롤링")
//                .nation("England")
//                .build();
//
//        Writer writer2 = Writer.builder()
//                .age(45)
//                .name("한강")
//                .nation("Korea")
//                .build();
//
//        List<Book> bookList = new ArrayList<>();
//
//        Book book1 = Book.builder()
//                .price(15000)
//                .subject("해리포터와 마법사의 돌")
//                .writer(writer1)
//                .sell(194)
//                .build();
//
//        Book book2 = Book.builder()
//                .price(16000)
//                .subject("해리포터와 비밀의 방")
//                .writer(writer1)
//                .sell(203)
//                .build();
//
//        Book book3 = Book.builder()
//                .price(18000)
//                .subject("채식주의자")
//                .writer(writer2)
//                .sell(301)
//                .build();
//
//        Book book4 = Book.builder()
//                .price(17500)
//                .subject("소년이 온다")
//                .writer(writer2)
//                .sell(400)
//                .build();
//
//        bookList.add(book1);
//        bookList.add(book2);
//        bookList.add(book3);
//        bookList.add(book4);
//
//        writerRepository.save(writer1);
//        writerRepository.save(writer2);
//        bookRepository.saveAll(bookList);
//    }
//
//    @Test
//    @Rollback(value = false)
//    void test4() {
//        Student student1 = Student.builder().name("김철수").grade(2).build();
//        Student student2 = Student.builder().name("이민정").grade(3).build();
//
//        Subject subject1 = Subject.builder().subjectName("물리1").teacher("조현식").build();
//        Subject subject2 = Subject.builder().subjectName("화학").teacher("서윤진").build();
//        Subject subject3 = Subject.builder().subjectName("국어").teacher("이정수").build();
//
//        student1.addSubjectList(subject1);
//        student1.addSubjectList(subject2);
//        student1.addSubjectList(subject3);
//
//        student2.addSubjectList(subject2);
//        student2.addSubjectList(subject3);
//        // Repository에 저장
//        studentRepository.saveAll(List.of(student1, student2));
//        subjectRepository.saveAll(List.of(subject1, subject2, subject3));
//    }
//
//    @Test
//    @Rollback(value = false)
//    void test5() {
//        Writer writer1 = Writer.builder()
//                .age(39)
//                .name("테드 창")
//                .nation("Taiwan")
//                .build();
//
//        List<Book> bookList = new ArrayList<>();
//        //BookStore store = BookStore.builder().master("김사장").name("동네책방").build();
//
//        Book book1 = Book.builder()
//                .price(27000)
//                .subject("컨택트")
//                .writer(writer1)
//                .bookStore(bookStoreRepository.findById(1L).orElseThrow(()->new IllegalArgumentException("해당 서점이 존재하지 않습니다.")))
//                .sell(95)
//                .build();
//
//        bookList.add(book1);
////        writerRepository.save(writer1);
////        bookStoreRepository.save(store);
//        bookRepository.saveAll(bookList);
//    }
//
//    @Test
//    @Rollback(value = false)
//    void test6() {
//        BookStore bookStore = bookStoreRepository.findById(1L).orElseThrow(NullPointerException::new);
//        System.out.println("서점명:"+bookStore.getName());
//        System.out.println("이 서점에서 판매중인 책:");
//
//        for(Book book:bookStore.getBookList()){
//            System.out.println("- "+book.getSubject());
//        }
//    }
//
//    @Test
//    @Rollback(value = false)
//    void test7() {
//        List<Book> books = bookRepository.findByBookStoreId(1L);
//        List<StoreBookDTO> bookList = books.stream().map(book -> new StoreBookDTO(book.getSubject(),book.getBookStore().getName(),book.getBookStore().getMaster())).collect(Collectors.toList());
//        for (StoreBookDTO book : bookList) {
//            System.out.println("책 제목:"+book.getSubject());
//            System.out.println("서점명:"+book.getName());
//            System.out.println("서점 주인:"+book.getMaster());
//        }
//    }
//
//}
