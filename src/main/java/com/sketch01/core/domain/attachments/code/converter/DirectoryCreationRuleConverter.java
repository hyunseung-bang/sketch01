package com.sketch01.core.domain.attachments.code.converter;

import com.sketch01.core.domain.attachments.code.enums.DirectoryCreationRule;
import com.sketch01.core.global.converter.enums.AbstractEnumConverter;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class DirectoryCreationRuleConverter extends AbstractEnumConverter<DirectoryCreationRule> {

    public DirectoryCreationRuleConverter() {
        super(DirectoryCreationRule.class, "디렉토리생성규칙", true);
    }
}
