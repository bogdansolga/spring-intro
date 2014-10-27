package com.tpg.spring.intro.service;

import flexjson.JSONDeserializer;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@SuppressWarnings("unused, unchecked")
public class JSONSerializer {

    public String serialize(Object object, boolean prettyPrint) {
        validate(object);

        return getSerializer(prettyPrint).serialize(object);
    }

    public <T extends Serializable> T deSerialize(String serializedObject, Class<T> objectClass) {
        return (T) new JSONDeserializer<>().deserialize(serializedObject, objectClass);
    }

    private flexjson.JSONSerializer getSerializer(boolean jsonPrettyPrint) {
        return new flexjson.JSONSerializer()
                .exclude("*.class")
                .include("*")
                .prettyPrint(jsonPrettyPrint);
    }

    private void validate(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("Why da' fuck do you serialize a null!?");
        }

        if (object instanceof String) {
            throw new IllegalArgumentException("Why da' fuck do you serialize a string!?");
        }
    }
}
