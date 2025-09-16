package com.example.lms.util;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 나(부모)를 상속받은 자식 클래스에게 멤버변수들을 -> 컬럼으로 부여함
@EntityListeners(AuditingEntityListener.class)
// ㄴ> "실시간으로 엔터티의 변화 상황을 지켜봄(감시)" -> 테이블 변화를 캐치하고 반영
public class Timestamp {

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

}