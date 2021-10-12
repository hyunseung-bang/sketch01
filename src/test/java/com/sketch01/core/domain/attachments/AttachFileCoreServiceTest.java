package com.sketch01.core.domain.attachments;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AttachFileCoreServiceTest {

    @Autowired
    AttachFileCoreService attachFileCoreService;

    @Test
    void test01() {
        attachFileCoreService.findAllByAttachFilePolicy();

    }
}