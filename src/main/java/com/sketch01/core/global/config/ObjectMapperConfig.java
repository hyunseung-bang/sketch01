package com.sketch01.core.global.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sketch01.core.global.converter.enums.EnumCode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.io.IOException;

@Configuration
public class ObjectMapperConfig {

    @Bean
    @Primary
    public ObjectMapper objectMapper() {

        ObjectMapper objectMapper = new ObjectMapper();

        SimpleModule module = new SimpleModule();

        module.setDeserializerModifier(new BeanDeserializerModifier() {

            @Override
            public JsonDeserializer<Enum<? extends EnumCode>> modifyEnumDeserializer(DeserializationConfig config, final JavaType type, BeanDescription beanDesc, final JsonDeserializer<?> deserializer) {

                return new JsonDeserializer<Enum<? extends EnumCode>>() {

                    @Override
                    @SuppressWarnings({"unchecked", "rawtypes"})
                    public Enum<? extends EnumCode> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {

                        JsonNode jsonNode = p.getCodec().readTree(p);

                        String text = jsonNode.asText();

                        Class<? extends Enum> rawClass = (Class<Enum<?>>) type.getRawClass();

                        return Enum.valueOf(rawClass, text);
                    }
                };
            }
        });

        objectMapper.registerModule(module);

        return objectMapper;
    }

}
