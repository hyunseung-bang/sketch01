package com.sketch01.core.domain.attachments.dto;

import com.sketch01.core.domain.attachments.code.enums.DirectoryCreationRule;
import com.sketch01.core.domain.attachments.entity.AttachFilePolicy;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
import java.util.stream.Collectors;

public class AttachFilePolicyDto {

    @Jacksonized
    @Builder
    @Getter
    @ToString
    public static class Item {

        /** 첨부파일정책 ID */
        private Long policyId;

        /** 첨부파일정책명 */
        private String policyName;

        /** 첨부가능확장자 */
        private String attachableExtension;

        /** 첨부불가확정자 */
        private String unAttachableExtension;

        /** 첨부가능파일크기 */
        private Long attachableFileSize;

        /** 첨부디렉토리명 */
        private String directoryName;

        /** 첨부가능파일수 */
        private Integer attachableFileCount;

        /** 첨부디렉토리생성규칙 */
        private DirectoryCreationRule directoryCreationRule;

        /** 참조테이블명 */
        private String referenceTable;

    }

    public static Item of(AttachFilePolicy attachFilePolicy) {
        if( attachFilePolicy == null ) {
            return null;
        }

        return Item.builder()
                .policyId             (attachFilePolicy.getPolicyId())
                .policyName           (attachFilePolicy.getPolicyName())
                .attachableExtension  (attachFilePolicy.getAttachableExtension())
                .unAttachableExtension(attachFilePolicy.getUnAttachableExtension())
                .attachableFileSize   (attachFilePolicy.getAttachableFileSize())
                .directoryName        (attachFilePolicy.getDirectoryName())
                .attachableFileCount  (attachFilePolicy.getAttachableFileCount())
                .directoryCreationRule(attachFilePolicy.getDirectoryCreationRule())
                .referenceTable       (attachFilePolicy.getReferenceTable())
                .build();
    }

    public static List<Item> of(List<AttachFilePolicy> attachFilePolicyList) {
        if( attachFilePolicyList == null ) {
            return null;
        }

        return attachFilePolicyList.stream().map(AttachFilePolicyDto::of).collect(Collectors.toList());
    }
}























