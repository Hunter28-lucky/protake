package okio;

import defpackage.C3921;
import defpackage.C4184;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: HashingSource.kt */
/* loaded from: classes2.dex */
public final class HashingSource extends ForwardingSource {
    public static final Companion Companion = new Companion(null);
    private final Mac mac;
    private final MessageDigest messageDigest;

    /* compiled from: HashingSource.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(C4184 c4184) {
            this();
        }

        public final HashingSource hmacSha1(Source source, ByteString byteString) {
            C3921.m12667(source, "source");
            C3921.m12667(byteString, "key");
            return new HashingSource(source, byteString, "HmacSHA1");
        }

        public final HashingSource hmacSha256(Source source, ByteString byteString) {
            C3921.m12667(source, "source");
            C3921.m12667(byteString, "key");
            return new HashingSource(source, byteString, "HmacSHA256");
        }

        public final HashingSource hmacSha512(Source source, ByteString byteString) {
            C3921.m12667(source, "source");
            C3921.m12667(byteString, "key");
            return new HashingSource(source, byteString, "HmacSHA512");
        }

        public final HashingSource md5(Source source) {
            C3921.m12667(source, "source");
            return new HashingSource(source, "MD5");
        }

        public final HashingSource sha1(Source source) {
            C3921.m12667(source, "source");
            return new HashingSource(source, "SHA-1");
        }

        public final HashingSource sha256(Source source) {
            C3921.m12667(source, "source");
            return new HashingSource(source, "SHA-256");
        }

        public final HashingSource sha512(Source source) {
            C3921.m12667(source, "source");
            return new HashingSource(source, "SHA-512");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSource(Source source, String str) {
        super(source);
        C3921.m12667(source, "source");
        C3921.m12667(str, "algorithm");
        this.messageDigest = MessageDigest.getInstance(str);
        this.mac = null;
    }

    public static final HashingSource hmacSha1(Source source, ByteString byteString) {
        return Companion.hmacSha1(source, byteString);
    }

    public static final HashingSource hmacSha256(Source source, ByteString byteString) {
        return Companion.hmacSha256(source, byteString);
    }

    public static final HashingSource hmacSha512(Source source, ByteString byteString) {
        return Companion.hmacSha512(source, byteString);
    }

    public static final HashingSource md5(Source source) {
        return Companion.md5(source);
    }

    public static final HashingSource sha1(Source source) {
        return Companion.sha1(source);
    }

    public static final HashingSource sha256(Source source) {
        return Companion.sha256(source);
    }

    public static final HashingSource sha512(Source source) {
        return Companion.sha512(source);
    }

    /* renamed from: -deprecated_hash, reason: not valid java name */
    public final ByteString m7877deprecated_hash() {
        return hash();
    }

    public final ByteString hash() throws IllegalStateException {
        byte[] bArrDoFinal;
        MessageDigest messageDigest = this.messageDigest;
        if (messageDigest != null) {
            bArrDoFinal = messageDigest.digest();
        } else {
            Mac mac = this.mac;
            if (mac == null) {
                C3921.m12675();
            }
            bArrDoFinal = mac.doFinal();
        }
        C3921.m12663(bArrDoFinal, "result");
        return new ByteString(bArrDoFinal);
    }

    @Override // okio.ForwardingSource, okio.Source
    public long read(Buffer buffer, long j) throws IllegalStateException, IOException {
        C3921.m12667(buffer, "sink");
        long j2 = super.read(buffer, j);
        if (j2 != -1) {
            long size = buffer.size() - j2;
            long size2 = buffer.size();
            Segment segment = buffer.head;
            if (segment == null) {
                C3921.m12675();
            }
            while (size2 > size) {
                segment = segment.prev;
                if (segment == null) {
                    C3921.m12675();
                }
                size2 -= segment.limit - segment.pos;
            }
            while (size2 < buffer.size()) {
                int i = (int) ((segment.pos + size) - size2);
                MessageDigest messageDigest = this.messageDigest;
                if (messageDigest != null) {
                    messageDigest.update(segment.data, i, segment.limit - i);
                } else {
                    Mac mac = this.mac;
                    if (mac == null) {
                        C3921.m12675();
                    }
                    mac.update(segment.data, i, segment.limit - i);
                }
                size2 += segment.limit - segment.pos;
                segment = segment.next;
                if (segment == null) {
                    C3921.m12675();
                }
                size = size2;
            }
        }
        return j2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSource(Source source, ByteString byteString, String str) throws NoSuchAlgorithmException, InvalidKeyException {
        super(source);
        C3921.m12667(source, "source");
        C3921.m12667(byteString, "key");
        C3921.m12667(str, "algorithm");
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            this.mac = mac;
            this.messageDigest = null;
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }
}
