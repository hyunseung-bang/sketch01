package com.sketch01.core.domain.attachments.repository;

import com.sketch01.core.domain.attachments.entity.AttachFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttachFileRepository extends JpaRepository<AttachFile, Long> {

    List<AttachFile> findAllByAttachFileGroup_AttachFileGroupIdOrderByAttachFileIdAsc(Long attachGroupId);
}
