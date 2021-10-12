package com.sketch01.api.attachfile.service;

import com.sketch01.api.attachfile.data.AttachFilePolicyListData;
import com.sketch01.api.attachfile.data.AttachFilePolicySaveData;
import com.sketch01.core.domain.attachments.AttachFileCoreService;
import com.sketch01.core.domain.attachments.dto.AttachFilePolicyDto;
import com.sketch01.core.domain.attachments.entity.AttachFilePolicy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttachFileService {

    private final AttachFileCoreService attachFileCoreService;

    @Transactional
    public AttachFilePolicySaveData savePolicy(AttachFilePolicySaveData attachFilePolicySaveData) {

        AttachFilePolicyDto.Item saveDataItem = attachFilePolicySaveData.getItem();

        AttachFilePolicy attachFilePolicy = AttachFilePolicy.of(saveDataItem);

        attachFileCoreService.savePolicy(attachFilePolicy);

        AttachFilePolicyDto.Item item = AttachFilePolicyDto.of(attachFilePolicy);

        attachFilePolicySaveData.setItem(item);

        return attachFilePolicySaveData;
    }

    @Transactional(readOnly = true)
    public AttachFilePolicyListData selectList() {

        List<AttachFilePolicy> attachFilePolicyList = attachFileCoreService.findAllByAttachFilePolicy();

        List<AttachFilePolicyDto.Item> itemList = AttachFilePolicyDto.of(attachFilePolicyList);

        AttachFilePolicyListData attachFilePolicyListData = new AttachFilePolicyListData();

        attachFilePolicyListData.setItemList(itemList);

        return attachFilePolicyListData;
    }


}
