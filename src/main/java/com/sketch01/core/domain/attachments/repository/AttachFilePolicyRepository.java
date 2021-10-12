package com.sketch01.core.domain.attachments.repository;

import com.sketch01.core.domain.attachments.entity.AttachFilePolicy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttachFilePolicyRepository extends JpaRepository<AttachFilePolicy, String> {

    List<AttachFilePolicy> findTop300ByOrderByPolicyNameAsc();

    List<AttachFilePolicy> findAllByOrderByPolicyNameAsc();

}
