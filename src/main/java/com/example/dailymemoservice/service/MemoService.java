package com.example.dailymemoservice.service;

import com.example.dailymemoservice.domain.Memo;
import com.example.dailymemoservice.domain.MemoRepository;
import com.example.dailymemoservice.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MemoService {
    private final MemoRepository memoRepository;

    @Transactional // 이 업데이트는 DB 에 반영이 되어야함을 알려주는 어노테이션
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        memo.update(requestDto);
        return memo.getId();
    }
}
