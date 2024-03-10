package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ArticleServiceTest {
    @Autowired
    ArticleService articleService;

    @DisplayName("전체 목록 검색")
    @Test
    void index() {
        // 1. 예상 데이터
        Article a = new Article(1L, "가가가가", "1111");
        Article b = new Article(2L, "나나나나", "2222");
        Article c = new Article(3L, "다다다다", "3333");
        Article d = new Article(4L,"당신의 인생 영화는?","댓글 고");
        Article e = new Article(5L,"당신의 소울 푸드는?","댓글 고고");
        Article f = new Article(6L,"당신의 취미는?","댓글 고고고");
        List<Article> expected = new ArrayList<>(Arrays.asList(a, b, c,d,e,f));
        // 2. 실제 데이터 획득하기
        List<Article> articles = articleService.index();
        // 3. 예쌍 데이터와 실제 데이터 비교해 검증하기
        assertEquals(expected.toString() , articles.toString(),"결과가 다름");
        

    }

    @Test
    void show_성공_존재하는_id_입력() {
        // 1. 예상 데이터
        Long id = 1L;
        Article expected = new Article(1L, "가가가", "111");
        // 2. 실제 데이터
        Article article = articleService.show(id);
        // 3. 비교 및 검증
        assertEquals(expected.toString(),article.toString());
    }
    @Test
    void show_실패_존재하지_않는_id_입력() {
        // 1. 예상 데이터
        Long id = 10L;
        Article expected = null;
        // 2. 실제 데이터
        Article article = articleService.show(id);
        // 3.비교 및 검증
        assertEquals(expected,article);
    }

    @Transactional
    @Test
    void create_성공_title과_content만_있는_dto_입력() {
        // 1. 예상 데이터
        String title = "입력 성공";
        String content = "1234";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(7L, title, content);
        // 2. 실제 데이터
        Article article = articleService.create(dto);
        // 3. 비교 및 검증
        assertEquals(expected.toString(),article.toString());
        
    }
    @Transactional
    @Test
    void create_실패_id가_포함된_dto_입력() {
        // 1. 예상 데이터
        Long id = 7L;
        String title = "입력 성공";
        String content = "1234";
        ArticleForm dto = new ArticleForm(id,title,content);
        Article expected = null;
        // 2. 실제 데이터
        Article article = articleService.create(dto);
        // 3.비교 및 검증
        assertEquals(expected,article);
    }

    @Transactional
    @Test
    void update_성공_존재하는_id와_title_content가_있는_dto_입력() {
        // 1 .예상 데이터
        Long id = 1L;
        String title = "변경 할게";
        String content = "변경 완료";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = new Article(id, title, content);
        // 2. 실제 데이터
        Article article = articleService.update(id,dto);
        // 3. 비교 및 검증
        assertEquals(expected.toString(),article.toString());
    }
    @Transactional
    @Test
    void update_성공_존재하는_id와_title만_있는_dto_입력() {
        // 1. 예상 데이터
        Long id = 1L;
        String title = "변경 할게요";
        ArticleForm dto = new ArticleForm(id,title,null);
        Article expected = new Article(id, title, "1111");
        // 2. 실제 데이터
        Article article = articleService.update(id,dto);
        // 3. 비교 및 검증
        assertEquals(expected.toString(),article.toString());
    }
    @Transactional
    @Test
    void update_실패_존자하지_않는_id의_dto_입력() {
        // 1. 예상 데이터
        Long id = 10L;
        String title = "변경";
        String content = "완료";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = null;
        // 2. 실제 데이터
        Article article = articleService.update(id,dto);
        // 3. 비교 및 검증
        assertEquals(expected,article);
        
    }

    @Transactional
    @Test
    void delete_성공_존재하는_id_입력() {
        // 1. 예상 데이터
        Long id = 1L;
        Article expected =new Article(id,"가가가가","1111");
        // 2. 실제 데이터
        Article article = articleService.delete(id);
        // 3. 비교 및 검증
        assertEquals(expected.toString(),article.toString());
    }

    @Transactional
    @Test
    void delete_실패_존재하는_않는_id_입력() {
        // 1. 예상 데이터
        Long id = 10L;
        Article expected = null;
        // 2. 실제 데이터
        Article article = articleService.delete(id);
        // 3. 비교 및 검증
        assertEquals(expected,article);
    }
}