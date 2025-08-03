package io.jsonwebtoken.impl.io;

import defpackage.C4905;
import io.jsonwebtoken.io.Deserializer;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Classes;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public class RuntimeClasspathDeserializerLocator<T> implements InstanceLocator<Deserializer<T>> {
    private static final AtomicReference<Deserializer> DESERIALIZER = new AtomicReference<>();

    public boolean compareAndSet(Deserializer<T> deserializer) {
        return C4905.m14631(DESERIALIZER, null, deserializer);
    }

    public boolean isAvailable(String str) {
        return Classes.isAvailable(str);
    }

    public Deserializer<T> locate() {
        if (isAvailable("com.fasterxml.jackson.databind.ObjectMapper")) {
            return (Deserializer) Classes.newInstance("io.jsonwebtoken.io.JacksonDeserializer");
        }
        if (isAvailable("org.json.JSONObject")) {
            return (Deserializer) Classes.newInstance("io.jsonwebtoken.io.OrgJsonDeserializer");
        }
        throw new IllegalStateException("Unable to discover any JSON Deserializer implementations on the classpath.");
    }

    @Override // io.jsonwebtoken.impl.io.InstanceLocator
    public Deserializer<T> getInstance() {
        AtomicReference<Deserializer> atomicReference = DESERIALIZER;
        Deserializer deserializerLocate = atomicReference.get();
        if (deserializerLocate == null) {
            deserializerLocate = locate();
            Assert.state(deserializerLocate != null, "locate() cannot return null.");
            if (!compareAndSet(deserializerLocate)) {
                deserializerLocate = atomicReference.get();
            }
        }
        Assert.state(deserializerLocate != null, "deserializer cannot be null.");
        return deserializerLocate;
    }
}
