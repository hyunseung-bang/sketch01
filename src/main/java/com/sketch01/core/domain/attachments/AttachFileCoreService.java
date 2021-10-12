package com.sketch01.core.domain.attachments;

import com.sketch01.core.domain.attachments.entity.AttachFilePolicy;
import com.sketch01.core.domain.attachments.repository.AttachFilePolicyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttachFileCoreService {

    private final AttachFilePolicyRepository attachFilePolicyRepository;

    public void saveAttachFilePolicy(AttachFilePolicy attachFilePolicy) {
        attachFilePolicyRepository.save(attachFilePolicy);
    }

    public List<AttachFilePolicy> findAllByAttachFilePolicy() {
        return attachFilePolicyRepository.findAllByOrderByPolicyNameAsc();
    }

    public void savePolicy(AttachFilePolicy attachFilePolicy) {
        attachFilePolicyRepository.save(attachFilePolicy);
    }
}
