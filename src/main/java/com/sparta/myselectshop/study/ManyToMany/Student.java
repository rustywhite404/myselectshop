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
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int grade;

    @Builder.Default
    @ManyToMany
    @JoinTable(name="student_subject", joinColumns = @JoinColumn(name = "student_id"),inverseJoinColumns = @JoinColumn(name="subject_id"))
    private List<Subject> subject = new ArrayList<>();


    public void addSubjectList(Subject subjects){
        this.subject.add(subjects);
        subjects.getStudents().add(this);
    }
}
