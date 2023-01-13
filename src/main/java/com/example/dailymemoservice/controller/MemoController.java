package com.example.dailymemoservice.controller;

import com.example.dailymemoservice.domain.Memo;
import com.example.dailymemoservice.domain.MemoRepository;
import com.example.dailymemoservice.domain.MemoRequestDto;
import com.example.dailymemoservice.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor // 어라? 근데 나 저 필요한 애들을 못 받을 수도 있을 것 같은데 ? final 로 선언된 녀석들이 있으면, 생성할 때 꼭 같이 넣어줄게.
@RestController
public class MemoController {
    // 이 녀석들이 꼭 필요해 ! final !
    private final MemoRepository memoRepository; // 나머지(CRD) 를 위해
    private final MemoService memoService; // 업데이트(U)를 위해

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        // 클라이언트에서 요~렇게 데이터를 말아서 보내면 @RequestBody 어노테이션이 Body 라는 녀석 안에 들어있는 것을 알아서 넣어줌 .
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    @GetMapping("/api/memos")
    public List<Memo> getMemos() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime yesterday = LocalDateTime.now().minusDays(1);
        return memoRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(yesterday, now);
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        memoRepository.deleteById(id);
        return id;
    }

    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        return memoService.update(id, requestDto);
    }
}
