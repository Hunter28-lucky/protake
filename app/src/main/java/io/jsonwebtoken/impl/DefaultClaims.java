package io.jsonwebtoken.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.RequiredTypeException;
import java.util.Date;
import java.util.Map;

/* loaded from: classes2.dex */
public class DefaultClaims extends JwtMap implements Claims {
    public DefaultClaims() {
    }

    private <T> T castClaimValue(Object obj, Class<T> cls) {
        if (obj instanceof Integer) {
            int iIntValue = ((Integer) obj).intValue();
            if (cls == Long.class) {
                obj = Long.valueOf(iIntValue);
            } else if (cls == Short.class && -32768 <= iIntValue && iIntValue <= 32767) {
                obj = Short.valueOf((short) iIntValue);
            } else if (cls == Byte.class && -128 <= iIntValue && iIntValue <= 127) {
                obj = Byte.valueOf((byte) iIntValue);
            }
        }
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        throw new RequiredTypeException("Expected value to be of type: " + cls + ", but was " + obj.getClass());
    }

    private static boolean isSpecDate(String str) {
        return Claims.EXPIRATION.equals(str) || Claims.ISSUED_AT.equals(str) || Claims.NOT_BEFORE.equals(str);
    }

    @Override // io.jsonwebtoken.Claims
    public <T> T get(String str, Class<T> cls) {
        Object specDate = get(str);
        if (specDate == null) {
            return null;
        }
        if (Date.class.equals(cls)) {
            specDate = isSpecDate(str) ? JwtMap.toSpecDate(specDate, str) : JwtMap.toDate(specDate, str);
        }
        return (T) castClaimValue(specDate, cls);
    }

    @Override // io.jsonwebtoken.Claims
    public String getAudience() {
        return getString(Claims.AUDIENCE);
    }

    @Override // io.jsonwebtoken.Claims
    public Date getExpiration() {
        return (Date) get(Claims.EXPIRATION, Date.class);
    }

    @Override // io.jsonwebtoken.Claims
    public String getId() {
        return getString(Claims.ID);
    }

    @Override // io.jsonwebtoken.Claims
    public Date getIssuedAt() {
        return (Date) get(Claims.ISSUED_AT, Date.class);
    }

    @Override // io.jsonwebtoken.Claims
    public String getIssuer() {
        return getString(Claims.ISSUER);
    }

    @Override // io.jsonwebtoken.Claims
    public Date getNotBefore() {
        return (Date) get(Claims.NOT_BEFORE, Date.class);
    }

    @Override // io.jsonwebtoken.Claims
    public String getSubject() {
        return getString(Claims.SUBJECT);
    }

    public DefaultClaims(Map<String, Object> map) {
        super(map);
    }

    @Override // io.jsonwebtoken.impl.JwtMap, java.util.Map
    public Object put(String str, Object obj) {
        return ((obj instanceof Date) && isSpecDate(str)) ? setDateAsSeconds(str, (Date) obj) : super.put(str, obj);
    }

    @Override // io.jsonwebtoken.ClaimsMutator
    public Claims setAudience(String str) {
        setValue(Claims.AUDIENCE, str);
        return this;
    }

    @Override // io.jsonwebtoken.ClaimsMutator
    public Claims setExpiration(Date date) {
        setDateAsSeconds(Claims.EXPIRATION, date);
        return this;
    }

    @Override // io.jsonwebtoken.ClaimsMutator
    public Claims setId(String str) {
        setValue(Claims.ID, str);
        return this;
    }

    @Override // io.jsonwebtoken.ClaimsMutator
    public Claims setIssuedAt(Date date) {
        setDateAsSeconds(Claims.ISSUED_AT, date);
        return this;
    }

    @Override // io.jsonwebtoken.ClaimsMutator
    public Claims setIssuer(String str) {
        setValue(Claims.ISSUER, str);
        return this;
    }

    @Override // io.jsonwebtoken.ClaimsMutator
    public Claims setNotBefore(Date date) {
        setDateAsSeconds(Claims.NOT_BEFORE, date);
        return this;
    }

    @Override // io.jsonwebtoken.ClaimsMutator
    public Claims setSubject(String str) {
        setValue(Claims.SUBJECT, str);
        return this;
    }
}
