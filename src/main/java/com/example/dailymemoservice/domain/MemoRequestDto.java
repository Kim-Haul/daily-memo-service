package com.example.dailymemoservice.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // 멤버 변수를 private 로 선언하면 해당 녀석을 생성하고 가져올 때 문제가 생기기 때문에, Getter 필요 .
@RequiredArgsConstructor
public class MemoRequestDto {
    // RequestDto 는 필요한 정보를 물고 다니는 녀석
    private final String username;
    private final String contents;
}
