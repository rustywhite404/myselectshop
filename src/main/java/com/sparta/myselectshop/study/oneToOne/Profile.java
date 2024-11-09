package com.sparta.myselectshop.study.oneToOne;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="profile")
public class Profile implements Serializable {
    @Id
    @Column(name="visitor_id")
    private String visitor_id;

    @Column
    private String visitor_name;

    @Column
    private String email;

    @Column
    private int point;

    //더 자주 사용되는 쪽이 관계의 주인이 되는 게 좋으므로
    // Profile 대신 Visitor를 관계의 주인으로 둔다.
    // Profile은 주인이 아닌 쪽이므로, mappedBy를 사용하여
    // 해당 필드가 주인 엔티티의 어느 필드와 매핑되어 있는지 나타낸다.
    @OneToOne(mappedBy = "profile")
    private Visitor visitor;
}
