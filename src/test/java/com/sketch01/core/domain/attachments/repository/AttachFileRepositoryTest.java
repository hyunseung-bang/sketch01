package com.sketch01.core.domain.attachments.repository;

import com.sketch01.core.domain.attachments.entity.AttachFile;
import com.sketch01.core.domain.attachments.entity.AttachFileGroup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AttachFileRepositoryTest {

    @Autowired
    AttachFileGroupRepository attachFileGroupRepository;

    @Autowired
    AttachFileRepository attachFileRepository;

    @Test
    void save_testData() {

        AttachFileGroup attachFileGroup = AttachFileGroup.builder().build();

        AttachFile attachFile1 = AttachFile.builder()
                .attachFileName("1")
                .originalFileName("1")
                .directoryPath("1")
                .webAccessPath("1")
                .attachFileGroup(attachFileGroup)
                .build();

        AttachFile attachFile2 = AttachFile.builder()
                .attachFileName("2")
                .originalFileName("2")
                .directoryPath("2")
                .webAccessPath("2")
                .attachFileGroup(attachFileGroup)
                .build();

        attachFileGroup.addAttachFile(attachFile1);
        attachFileGroup.addAttachFile(attachFile2);

        attachFileGroupRepository.save(attachFileGroup);

    }

    @Test
    @DisplayName("T2_조인컬럼으로조회")
    void test2() {
        List<AttachFile> attachFileList = attachFileRepository.findAllByAttachFileGroup_AttachFileGroupIdOrderByAttachFileIdAsc(30L);
        for(AttachFile attachFile : attachFileList) {
            System.out.println("[AttachFile]                  : " + attachFile);
            System.out.println("[AttachFile][AttachFileGroup] : " + attachFile.getAttachFileGroup());
            System.out.println("[AttachFile][AttachFileGroup][AttachFilePolicy] : " + attachFile.getAttachFileGroup().getAttachFilePolicy());
        }

    }


}