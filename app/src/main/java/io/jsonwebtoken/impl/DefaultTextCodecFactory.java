package io.jsonwebtoken.impl;

@Deprecated
/* loaded from: classes2.dex */
public class DefaultTextCodecFactory implements TextCodecFactory {
    public String getSystemProperty(String str) {
        return System.getProperty(str);
    }

    @Override // io.jsonwebtoken.impl.TextCodecFactory
    public TextCodec getTextCodec() {
        return isAndroid() ? new AndroidBase64Codec() : new Base64Codec();
    }

    public boolean isAndroid() {
        String systemProperty = getSystemProperty("java.vm.name");
        if (systemProperty != null) {
            return systemProperty.toLowerCase().contains("dalvik");
        }
        String systemProperty2 = getSystemProperty("java.vm.vendor");
        if (systemProperty2 != null) {
            return systemProperty2.toLowerCase().contains("android");
        }
        return false;
    }
}
