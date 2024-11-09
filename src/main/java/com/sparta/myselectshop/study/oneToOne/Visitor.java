package com.sparta.myselectshop.study.oneToOne;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="visitor")
public class Visitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String role;

    @Column
    private String password;

    //더 자주 사용되는 쪽이 관계의 주인이 되는 게 좋으므로 Visitor를 관계의 주인으로 둔다.
    //관계의 주인은 @JoinColumn을 사용하여 외래키를 명시적으로 매핑함.
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name="fk_visitor_id", referencedColumnName = "visitor_id")
    //@JoinColumn(name = "visitor_id", referencedColumnName = "visitor_id")// 외래 키를 visitor_id로 설정
    private Profile profile;
}
