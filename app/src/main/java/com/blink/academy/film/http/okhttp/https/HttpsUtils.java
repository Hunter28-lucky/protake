package com.blink.academy.film.http.okhttp.https;

import defpackage.C4638;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public class HttpsUtils {

    public static class SSLParams {
        public SSLSocketFactory sSLSocketFactory;
        public X509TrustManager trustManager;
    }

    /* renamed from: com.blink.academy.film.http.okhttp.https.HttpsUtils$Ԩ, reason: contains not printable characters */
    public static class C0393 implements X509TrustManager {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public X509TrustManager f954;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public X509TrustManager f955;

        public C0393(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyStoreException {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            this.f954 = HttpsUtils.chooseTrustManager(trustManagerFactory.getTrustManagers());
            this.f955 = x509TrustManager;
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            try {
                this.f954.checkServerTrusted(x509CertificateArr, str);
            } catch (CertificateException unused) {
                this.f955.checkServerTrusted(x509CertificateArr, str);
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    /* renamed from: com.blink.academy.film.http.okhttp.https.HttpsUtils$Ԫ, reason: contains not printable characters */
    public static class C0394 implements X509TrustManager {
        public C0394() {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static X509TrustManager chooseTrustManager(TrustManager[] trustManagerArr) {
        for (TrustManager trustManager : trustManagerArr) {
            if (trustManager instanceof X509TrustManager) {
                return (X509TrustManager) trustManager;
            }
        }
        return null;
    }

    public static SSLParams getSslSocketFactory(InputStream inputStream, String str, InputStream[] inputStreamArr) throws UnrecoverableKeyException, NoSuchAlgorithmException, IOException, CertificateException, KeyManagementException {
        SSLParams sSLParams = new SSLParams();
        try {
            KeyManager[] keyManagerArrPrepareKeyManager = prepareKeyManager(inputStream, str);
            TrustManager[] trustManagerArrPrepareTrustManager = prepareTrustManager(inputStreamArr);
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            X509TrustManager c0393 = trustManagerArrPrepareTrustManager != null ? new C0393(chooseTrustManager(trustManagerArrPrepareTrustManager)) : new C0394();
            sSLContext.init(keyManagerArrPrepareKeyManager, new TrustManager[]{c0393}, null);
            sSLParams.sSLSocketFactory = sSLContext.getSocketFactory();
            sSLParams.trustManager = c0393;
            return sSLParams;
        } catch (KeyManagementException e2) {
            throw new AssertionError(e2);
        } catch (KeyStoreException e3) {
            throw new AssertionError(e3);
        } catch (NoSuchAlgorithmException e4) {
            throw new AssertionError(e4);
        }
    }

    private static KeyManager[] prepareKeyManager(InputStream inputStream, String str) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException {
        if (inputStream != null && str != null) {
            try {
                KeyStore keyStore = KeyStore.getInstance("BKS");
                keyStore.load(inputStream, str.toCharArray());
                KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                keyManagerFactory.init(keyStore, str.toCharArray());
                return keyManagerFactory.getKeyManagers();
            } catch (Exception e2) {
                C4638.m14100(e2);
            }
        }
        return null;
    }

    private static TrustManager[] prepareTrustManager(InputStream... inputStreamArr) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException {
        if (inputStreamArr != null && inputStreamArr.length > 0) {
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                keyStore.load(null);
                int length = inputStreamArr.length;
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    InputStream inputStream = inputStreamArr[i];
                    int i3 = i2 + 1;
                    keyStore.setCertificateEntry(Integer.toString(i2), certificateFactory.generateCertificate(inputStream));
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                            C4638.m14100(e2);
                        }
                    }
                    i++;
                    i2 = i3;
                }
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init(keyStore);
                return trustManagerFactory.getTrustManagers();
            } catch (Exception e3) {
                C4638.m14100(e3);
            }
        }
        return null;
    }
}
