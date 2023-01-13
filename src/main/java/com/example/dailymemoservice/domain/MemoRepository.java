package com.example.dailymemoservice.domain;

import java.time.LocalDateTime;
import java.util.List;

public interface MemoRepository {
    // JpaRepository 에 미리 작성된 여러코드들(findAll, delete, findById, save)을 갖다 쓸꺼다.
    // List<Memo> findAllByOrderByModifiedAtDesc(); 에서 수정 일자가 24시 전인 것들만 다시 필터링.

    List<Memo> findAllByModifiedAtBetweenOrderByModifiedAtDesc(LocalDateTime start, LocalDateTime end);
}
