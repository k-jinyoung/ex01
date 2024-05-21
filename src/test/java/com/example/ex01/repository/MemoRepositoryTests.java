package com.example.ex01.repository;

import com.example.ex01.entity.Memo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemoRepositoryTests {

    @Autowired
    MemoRepository memoRepository;

    @Test
    public void testClass() {
        System.out.println(memoRepository.getClass().getName());
    }

    @Test
    @DisplayName("등록 작업")
    public void testInsertDummies() {
        IntStream.rangeClosed(1,100).forEach(i -> {
            Memo memo = Memo.builder().memoText("Sample..." + i).build();
            memoRepository.save(memo);
        });
    }

    @Test
    @DisplayName("조회 작업")
    public void testSelect() {
        //데이터베이스에 존재하는 mno (mno가 100번인 것을 조회하겠다)
        Long mno = 100L;

        Optional<Memo> result = memoRepository.findById(mno);

        System.out.println("====================================");

        if (result.isPresent()) {
            Memo memo = result.get();
            System.out.println(memo);
        }
    }

    @Test
    @DisplayName("수정 작업")
    public void testUpdate() {
        Memo memo = Memo.builder().mno(1L).memoText("Update Text").build();

        System.out.println(memoRepository.save(memo));
    }

    @Test
    @DisplayName("삭제 작업")
    public void testDelete() {

        Long mno = 100L;

        memoRepository.deleteById(mno);
    }
}
