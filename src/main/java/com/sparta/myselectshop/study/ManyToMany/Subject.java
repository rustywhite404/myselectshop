package com.sparta.myselectshop.study.ManyToMany;


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
public class Subject {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subjectName;
    private String teacher;

    @Builder.Default
    @ManyToMany(mappedBy = "subject")
    private List<Student> students = new ArrayList<>();

    public void addStudentList(Student student){
        this.students.add(student);
        student.getSubject().add(this);
    }
}
