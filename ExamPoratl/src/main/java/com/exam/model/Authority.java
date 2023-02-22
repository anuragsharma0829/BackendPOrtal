package com.exam.model;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {

    private String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}



//YE authority ko implemet USerDatils me jo grand Authority method he uska implemtntsion he isme ham ye dete he ki user ko role konsa he usko kya dikhana he
