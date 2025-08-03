package io.jsonwebtoken.impl.io;

import defpackage.C4905;
import io.jsonwebtoken.io.Serializer;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Classes;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public class RuntimeClasspathSerializerLocator implements InstanceLocator<Serializer> {
    private static final AtomicReference<Serializer<Object>> SERIALIZER = new AtomicReference<>();

    public boolean compareAndSet(Serializer<Object> serializer) {
        return C4905.m14631(SERIALIZER, null, serializer);
    }

    public boolean isAvailable(String str) {
        return Classes.isAvailable(str);
    }

    public Serializer<Object> locate() {
        if (isAvailable("com.fasterxml.jackson.databind.ObjectMapper")) {
            return (Serializer) Classes.newInstance("io.jsonwebtoken.io.JacksonSerializer");
        }
        if (isAvailable("org.json.JSONObject")) {
            return (Serializer) Classes.newInstance("io.jsonwebtoken.io.OrgJsonSerializer");
        }
        throw new IllegalStateException("Unable to discover any JSON Serializer implementations on the classpath.");
    }

    @Override // io.jsonwebtoken.impl.io.InstanceLocator
    /* renamed from: getInstance, reason: merged with bridge method [inline-methods] */
    public Serializer getInstance2() {
        AtomicReference<Serializer<Object>> atomicReference = SERIALIZER;
        Serializer<Object> serializerLocate = atomicReference.get();
        if (serializerLocate == null) {
            serializerLocate = locate();
            Assert.state(serializerLocate != null, "locate() cannot return null.");
            if (!compareAndSet(serializerLocate)) {
                serializerLocate = atomicReference.get();
            }
        }
        Assert.state(serializerLocate != null, "serializer cannot be null.");
        return serializerLocate;
    }
}
