package com.example.dailymemoservice.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter // 멤버 변수가 private 로 선언되어 있기 때문에 Getter 가 꼭 필요. 타임 스탬프를 작성할 때는 이 3가지 어노테이션 꼭 확인.
@MappedSuperclass // 상속했을 때, 컬럼으로 인식하게 합니다.
@EntityListeners(AuditingEntityListener.class) // 생성/수정 시간을 자동으로 반영하도록 설정
public class Timestamped {

    // abstract : 직접 구현이 안되고, 상속으로만 쓸 수 있다.
    // 즉, 빵을 못만드는 빵틀의 개념.

    @CreatedDate // 생성일자임을 나타냅니다.
    private LocalDateTime createdAt;

    @LastModifiedDate // 마지막 수정일자임을 나타냅니다.
    private LocalDateTime modifiedAt;
}
