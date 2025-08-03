package io.jsonwebtoken.io;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Strings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* loaded from: classes2.dex */
public class OrgJsonDeserializer implements Deserializer<Object> {
    private Object convertIfNecessary(Object obj) {
        if (JSONObject.NULL.equals(obj)) {
            return null;
        }
        return obj instanceof JSONArray ? toList((JSONArray) obj) : obj instanceof JSONObject ? toMap((JSONObject) obj) : obj;
    }

    private Object parse(String str) throws JSONException {
        JSONTokener jSONTokener = new JSONTokener(str);
        char cNextClean = jSONTokener.nextClean();
        jSONTokener.back();
        return cNextClean == '{' ? toMap(new JSONObject(jSONTokener)) : cNextClean == '[' ? toList(new JSONArray(jSONTokener)) : convertIfNecessary(jSONTokener.nextValue());
    }

    private List<Object> toList(JSONArray jSONArray) {
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            arrayList.add(convertIfNecessary(jSONArray.get(i)));
        }
        return arrayList;
    }

    private Map<String, Object> toMap(JSONObject jSONObject) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            linkedHashMap.put(next, convertIfNecessary(jSONObject.get(next)));
        }
        return linkedHashMap;
    }

    @Override // io.jsonwebtoken.io.Deserializer
    public Object deserialize(byte[] bArr) throws DeserializationException {
        Assert.notNull(bArr, "JSON byte array cannot be null");
        if (bArr.length == 0) {
            throw new DeserializationException("Invalid JSON: zero length byte array.");
        }
        try {
            return parse(new String(bArr, Strings.UTF_8));
        } catch (Exception e2) {
            throw new DeserializationException("Invalid JSON: " + e2.getMessage(), e2);
        }
    }
}
