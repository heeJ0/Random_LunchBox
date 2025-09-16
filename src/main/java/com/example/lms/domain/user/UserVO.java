package com.example.lms.domain.user;

import com.example.lms.util.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@NoArgsConstructor // 얘는 내가 선택한 멤버만 인자로 넣어도 됨
//@AllArgsConstructor // -> 얘는 멤버를 전부 인자값으로 받아야 함
@Getter
@Entity // -> 이 class가 하나의 객체라는 것을 알려주는 Annotation
@Table(name="student")
public class UserVO extends Timestamp { // -> UserDTO, 순수 객체만 담기 때문에 Setter(X)
//    userCode int primary key,
//    grade char(1) not null,
//            `name` varchar(20) not null,
//    id varchar(20) not null,
//    pw varchar(20) not null,
//    address varchar(100) not null,
//    mobile varchar(13) not null,
//    gender char(1) not null,
//    birth date not null,
//    major varchar(20) not null

    @Id // <- PK 지정
    private int usercode;

    @Column(name ="grade", nullable = false)
    private char grade;

    @Column(name="gender", nullable = false)
    private char gender;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="id", nullable = false)
    private String id;

    @Column(name="pw", nullable = false)
    private String pw;

    @Column(name="address", nullable = false)
    private String address;

    @Column(name="mobile", nullable = false)
    private String mobile;

    @Column(name="major", nullable = false)
    private String major;

    @Column(name="birth", nullable = false)
    private Date birth;

    public void updateUser(UserRequestDTO dto){
        this.pw = dto.getPw();
        this.address = dto.getAddress();
        this.mobile = dto.getMobile();
    }

    public UserVO(UserRequestDTO dto){
        this.usercode = dto.getUsercode();
        this.grade = dto.getGrade();
        this.name = dto.getName();
        this.id = dto.getId();
        this.pw = dto.getPw();
        this.address = dto.getAddress();
        this.mobile = dto.getMobile();
        this.gender = dto.getGender();
        this.birth = dto.getBirth();
        this.major = dto.getMajor();
    }
    public void update(UserRequestDTO userRequestDto){
        this.name = userRequestDto.getName();
    }

}
