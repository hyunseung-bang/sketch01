package com.sketch01.api.attachfile.data;

import com.sketch01.core.domain.attachments.dto.AttachFilePolicyDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class AttachFilePolicySaveData {

    private AttachFilePolicyDto.Item item;

}
