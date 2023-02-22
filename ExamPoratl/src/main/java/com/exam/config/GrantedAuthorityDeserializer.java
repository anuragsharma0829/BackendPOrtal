package com.exam.config;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

public class GrantedAuthorityDeserializer extends JsonDeserializer<GrantedAuthority> {


        @Override
        public GrantedAuthority deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
                return new SimpleGrantedAuthority(jsonParser.getText());
        }
}