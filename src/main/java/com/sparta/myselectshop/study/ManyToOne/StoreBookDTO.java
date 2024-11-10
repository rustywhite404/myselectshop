package com.sparta.myselectshop.study.ManyToOne;

import lombok.Getter;

@Getter
public class StoreBookDTO {
    private String subject;
    private String name;
    private String master;

    public StoreBookDTO(String subject, String name, String master){
        this.subject = subject;
        this.name = name;
        this.master = master;
    }
}
