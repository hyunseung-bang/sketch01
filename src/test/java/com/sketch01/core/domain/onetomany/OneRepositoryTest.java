package com.sketch01.core.domain.onetomany;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OneRepositoryTest {

    @Autowired
    OneRepository oneRepository;

    @Autowired
    ManyRepository manyRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("테스트데이타등록")
    void test1() {

        List<Many> manyList = new ArrayList<>();

        One one = new One(null, "name", manyList);

        manyList.add(new Many(null, "manyName1", one));
        manyList.add(new Many(null, "manyName2", one));
        manyList.add(new Many(null, "manyName3", one));

        oneRepository.save(one);
    }

    @Test
    @DisplayName("조회테스트")
    @Transactional
    void test2() {

        One one = oneRepository.findById(3L).orElse(null);

        List<Many> manyList = one.getManyList();

        System.out.println("[ONE][MANY][SIZE] : " + manyList.size());

        System.out.println("[ONE] : " + one.toString());
        for( Many many : manyList ) {
            System.out.println("[ONE][MANY] : " + many.toString());
        }
        manyRepository.findById(5L);
    }


    @Test
    @DisplayName("자식한건삭제")
    @Transactional
    void test3() {
        One one = oneRepository.findById(3L).orElse(null);
        List<Many> manyList = one.getManyList();
        manyList.remove(1);
        oneRepository.saveAndFlush(one);
    }


    @Test
    @DisplayName("부모삭제시 자식도 같이 삭제")
    @Transactional
    void test4() {
        // orphanRemoval = true 또는
        // cascade = CascadeType.REMOVE 인 경우에 부모 삭제시 자식도 같이 삭제됨
        One one = oneRepository.findById(3L).orElse(null);
        oneRepository.delete(one);
        entityManager.flush();
    }

    @Test
    @DisplayName("자식신규등록")
    @Transactional
    void test5() {
        One one = oneRepository.findById(3L).orElse(null);
        //one.update("edit");
        List<Many> manyList = one.getManyList();
        manyList.get(0).update("수정");
        manyList.remove(1);
        manyList.add(new Many(null, "name add1", one));
        manyList.add(new Many(null, "name add2", one));
        oneRepository.save(one);
        entityManager.flush();
    }

    @Test
    @DisplayName("자식수정")
    @Transactional
    void test6() {
        One one = oneRepository.findById(3L).orElse(null);
        List<Many> manyList = one.getManyList();
        manyList.get(0).update("수정");
        oneRepository.saveAndFlush(one);
    }

    @Test
    @DisplayName("자식한건삭제_한건수정")
    @Transactional
    void test7() {
        One one = oneRepository.findById(3L).orElse(null);
        List<Many> manyList = one.getManyList();
        manyList.get(0).update("xxxx");
        manyList.remove(1);
        oneRepository.saveAndFlush(one);
    }

}