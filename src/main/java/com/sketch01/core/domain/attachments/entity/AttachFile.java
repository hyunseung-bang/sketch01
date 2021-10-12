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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ATTACH_FILE")
@Builder
@Getter
@ToString(exclude = "attachFileGroup")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class AttachFile {

    @Id
    @Column(name = "ATTACH_FILE_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long attachFileId;

    @Column(name = "ATTACH_FILE_NAME", length = 20, nullable = false)
    private String attachFileName;

    @Column(name = "ORIGINAL_FILE_NAME", length = 60, nullable = false)
    private String originalFileName;

    @Column(name = "DIRECTORY_PATH", length = 40, nullable = false)
    private String directoryPath;

    @Column(name = "WEB_ACCESS_PATH", length = 40, nullable = false)
    private String webAccessPath;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ATTACH_FILE_GROUP_ID", nullable = false)
    private AttachFileGroup attachFileGroup;

}
