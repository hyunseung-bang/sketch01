package com.sketch01.core.domain.attachments.entity;

import com.sketch01.core.domain.attachments.code.enums.DirectoryCreationRule;
import com.sketch01.core.domain.attachments.dto.AttachFilePolicyDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ATTACH_FILE_POLICY")
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class AttachFilePolicy {

    /** 첨부파일정책명 */
    @Id
    @Column(name = "ATTACH_FILE_POLICY_ID", length = 10, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long policyId;

    @Column(name = "ATTACH_FILE_POLICY_NAME", length = 20, nullable = false)
    private String policyName;

    /** 첨부가능확장자 */
    @Column(name = "ATTACHABLE_EXTENSION", length = 40, nullable = false)
    private String attachableExtension;

    /** 첨부불가확정자 */
    @Column(name = "UN_ATTACHABLE_ATTACHMENT", length = 40, nullable = false)
    private String unAttachableExtension;

    /** 첨부가능파일크기 */
    @Column(name = "ATTACHABLE_FILE_SIZE", length = 10, nullable = false)
    private Long attachableFileSize;

    /** 첨부디렉토리명 */
    @Column(name = "DIRECTORY_NAME", length = 20, nullable = false)
    private String directoryName;

    /** 첨부가능파일수 */
    @Column(name = "ATTACHABLE_FILE_COUNT", length = 10, nullable = false)
    private Integer attachableFileCount;

    /** 첨부디렉토리생성규칙 */
    @Column(name = "DIRECTORY_CREATION_RULE", length = 10, nullable = false)
    private DirectoryCreationRule directoryCreationRule;

    /** 참조테이블명 */
    @Column(name = "REFERENCE_TABLE", length = 10, nullable = true)
    private String referenceTable;

    public static AttachFilePolicy of(AttachFilePolicyDto.Item saveDataItem) {
        return AttachFilePolicy.builder()
                .policyName           (saveDataItem.getPolicyName())
                .attachableExtension  (saveDataItem.getAttachableExtension())
                .unAttachableExtension(saveDataItem.getUnAttachableExtension())
                .attachableFileSize   (saveDataItem.getAttachableFileSize())
                .directoryName        (saveDataItem.getDirectoryName())
                .attachableFileCount  (saveDataItem.getAttachableFileCount())
                .directoryCreationRule(saveDataItem.getDirectoryCreationRule())
                .referenceTable       (saveDataItem.getReferenceTable())
                .build();
    }
}
