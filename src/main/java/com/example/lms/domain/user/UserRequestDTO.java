package com.example.lms.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@NoArgsConstructor
@Getter
public class UserRequestDTO { // -> DTO 로 값을 받고, 검증 완료되면 VO 변환해서 실제 사용한다

    private int usercode;
    private char grade;
    private char gender;
    private String name;
    private String id;
    private String pw;
    private String address;
    private String mobile;
    private String major;
    private Date birth;

}
