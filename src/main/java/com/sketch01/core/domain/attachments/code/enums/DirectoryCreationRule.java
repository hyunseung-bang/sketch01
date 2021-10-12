package com.sketch01.core.domain.attachments.code.enums;

import com.sketch01.core.global.converter.enums.EnumCode;
import com.sketch01.core.libs.CaseBuilder;
import com.sketch01.core.libs.DateUtils;

import java.io.File;
import java.util.Arrays;

import static org.apache.commons.lang3.StringUtils.joinWith;

public enum DirectoryCreationRule implements EnumCode {

    YEAR ("01", "년별생성"),
    MONTH("02", "월별생성"),
    DAY  ("03", "일별생성"),
    NONE ("04", "사용안함");

    private final String code;
    private final String desc;

    DirectoryCreationRule(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String desc() {
        return desc;
    }

    public String path() {
        return new CaseBuilder<String>()
                .whenthen(this.compareTo(DirectoryCreationRule.YEAR) , DateUtils.currentYear())
                .whenthen(this.compareTo(DirectoryCreationRule.MONTH), joinWith(File.separator, DateUtils.currentYear(), DateUtils.currentMonth()))
                .whenthen(this.compareTo(DirectoryCreationRule.DAY)  , joinWith(File.separator, DateUtils.currentYear(), DateUtils.currentMonth(), DateUtils.currentDay()))
                .whenthen(this.compareTo(DirectoryCreationRule.NONE) , DateUtils.currentYear())
                .end();
    }

    public static DirectoryCreationRule of(String code) {
        return Arrays.stream(DirectoryCreationRule.values())
                .filter(x -> x.code().equals(code))
                .findFirst()
                .orElse(null);
    }
}
