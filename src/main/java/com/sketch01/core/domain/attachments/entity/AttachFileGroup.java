package com.sketch01.core.domain.attachments.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ATTACH_FILE_GROUP")
@Builder
@Getter
@ToString(exclude = "attachFileList")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class AttachFileGroup {

    /** 첨부파일그룹아이디 */
    @Id
    @Column(name = "ATTACH_FILE_GROUP_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long attachFileGroupId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ATTACH_FILE_POLICY_ID", nullable = false)
    private AttachFilePolicy attachFilePolicy;

    /** 첨부파일목록 */
    @Builder.Default
    @OneToMany(mappedBy = "attachFileGroup", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AttachFile> attachFileList = new ArrayList<>();

    public void addAttachFile(AttachFile attachFile) {
        this.attachFileList.add(attachFile);
    }

}
