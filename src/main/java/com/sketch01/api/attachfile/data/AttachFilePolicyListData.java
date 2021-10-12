package com.sketch01.api.attachfile.data;

import com.sketch01.core.domain.attachments.dto.AttachFilePolicyDto;

import java.util.List;


public class AttachFilePolicyListData {

    private List<AttachFilePolicyDto.Item> itemList;

    public List<AttachFilePolicyDto.Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<AttachFilePolicyDto.Item> itemList) {
        this.itemList = itemList;
    }
}
