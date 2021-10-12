package com.sketch01.core.global.converter.enums;

import javax.persistence.AttributeConverter;
import javax.validation.ValidationException;
import java.util.EnumSet;

import static org.apache.commons.lang3.StringUtils.isBlank;

public abstract class AbstractEnumConverter<E extends Enum<E> & EnumCode> implements AttributeConverter<E, String> {

    private final Class<E> enumClass;
    private final String codeName;
    private final boolean nonNull;

    public AbstractEnumConverter(Class<E> enumClass, String enumName, boolean nonNull) {
        this.enumClass = enumClass;
        this.codeName = enumName;
        this.nonNull  = nonNull;
    }

    @Override
    public String convertToDatabaseColumn(E attribute) {

        if( nonNull && attribute == null ) {
            throw new ValidationException(String.format("[%s] 정보는 필수 항목입니다.", codeName));
        }

        return attribute.code();
    }

    @Override
    public E convertToEntityAttribute(String code) {

        if( nonNull && isBlank(code) ) {
            throw new ValidationException(String.format("[%s] 정보는 필수 항목입니다.", codeName));
        }

        if (isBlank(code)) {
            return null;
        }

        return EnumSet.allOf(enumClass).stream()
                .filter(x -> x.code().equals(code))
                .findFirst()
                .orElseThrow(() -> new ValidationException(String.format("[%s] 코드에 [%s] 코드값이 존재하지 않습니다.", codeName, code)));
    }
}
