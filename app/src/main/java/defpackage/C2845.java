package defpackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import defpackage.InterfaceC3129;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* compiled from: HttpUrlFetcher.java */
/* renamed from: Ϡ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2845 implements InterfaceC3129<InputStream> {

    /* renamed from: ֈ, reason: contains not printable characters */
    @VisibleForTesting
    public static final InterfaceC2847 f10325 = new C2846();

    /* renamed from: ԫ, reason: contains not printable characters */
    public final C4207 f10326;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int f10327;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC2847 f10328;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public HttpURLConnection f10329;

    /* renamed from: ԯ, reason: contains not printable characters */
    public InputStream f10330;

    /* renamed from: ՠ, reason: contains not printable characters */
    public volatile boolean f10331;

    /* compiled from: HttpUrlFetcher.java */
    /* renamed from: Ϡ$Ϳ, reason: contains not printable characters */
    public static class C2846 implements InterfaceC2847 {
        @Override // defpackage.C2845.InterfaceC2847
        /* renamed from: Ϳ, reason: contains not printable characters */
        public HttpURLConnection mo10189(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* compiled from: HttpUrlFetcher.java */
    /* renamed from: Ϡ$Ԩ, reason: contains not printable characters */
    public interface InterfaceC2847 {
        /* renamed from: Ϳ */
        HttpURLConnection mo10189(URL url) throws IOException;
    }

    public C2845(C4207 c4207, int i) {
        this(c4207, i, f10325);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static boolean m10185(int i) {
        return i / 100 == 2;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static boolean m10186(int i) {
        return i / 100 == 3;
    }

    @Override // defpackage.InterfaceC3129
    public void cancel() {
        this.f10331 = true;
    }

    @Override // defpackage.InterfaceC3129
    @NonNull
    /* renamed from: Ϳ */
    public Class<InputStream> mo7075() {
        return InputStream.class;
    }

    @Override // defpackage.InterfaceC3129
    /* renamed from: Ԩ */
    public void mo7076() throws IOException {
        InputStream inputStream = this.f10330;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f10329;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f10329 = null;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final InputStream m10187(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f10330 = C3754.m12029(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            this.f10330 = httpURLConnection.getInputStream();
        }
        return this.f10330;
    }

    @Override // defpackage.InterfaceC3129
    @NonNull
    /* renamed from: Ԫ */
    public DataSource mo7077() {
        return DataSource.REMOTE;
    }

    @Override // defpackage.InterfaceC3129
    /* renamed from: ԫ */
    public void mo7078(@NonNull Priority priority, @NonNull InterfaceC3129.InterfaceC3130<? super InputStream> interfaceC3130) {
        StringBuilder sb;
        long jM14630 = C4904.m14630();
        try {
            try {
                interfaceC3130.mo4919(m10188(this.f10326.m13288(), 0, null, this.f10326.m13285()));
            } catch (IOException e2) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Failed to load data for url", e2);
                }
                interfaceC3130.mo4918(e2);
                if (!Log.isLoggable("HttpUrlFetcher", 2)) {
                    return;
                } else {
                    sb = new StringBuilder();
                }
            }
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(C4904.m14629(jM14630));
                Log.v("HttpUrlFetcher", sb.toString());
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + C4904.m14629(jM14630));
            }
            throw th;
        }
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final InputStream m10188(URL url, int i, URL url2, Map<String, String> map) throws IOException {
        if (i >= 5) {
            throw new HttpException("Too many (> 5) redirects!");
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new HttpException("In re-direct loop");
                }
            } catch (URISyntaxException unused) {
            }
        }
        this.f10329 = this.f10328.mo10189(url);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.f10329.addRequestProperty(entry.getKey(), entry.getValue());
        }
        this.f10329.setConnectTimeout(this.f10327);
        this.f10329.setReadTimeout(this.f10327);
        this.f10329.setUseCaches(false);
        this.f10329.setDoInput(true);
        this.f10329.setInstanceFollowRedirects(false);
        this.f10329.connect();
        this.f10330 = this.f10329.getInputStream();
        if (this.f10331) {
            return null;
        }
        int responseCode = this.f10329.getResponseCode();
        if (m10185(responseCode)) {
            return m10187(this.f10329);
        }
        if (!m10186(responseCode)) {
            if (responseCode == -1) {
                throw new HttpException(responseCode);
            }
            throw new HttpException(this.f10329.getResponseMessage(), responseCode);
        }
        String headerField = this.f10329.getHeaderField(HttpHeaders.HEAD_KEY_LOCATION);
        if (TextUtils.isEmpty(headerField)) {
            throw new HttpException("Received empty or null redirect url");
        }
        URL url3 = new URL(url, headerField);
        mo7076();
        return m10188(url3, i + 1, url, map);
    }

    @VisibleForTesting
    public C2845(C4207 c4207, int i, InterfaceC2847 interfaceC2847) {
        this.f10326 = c4207;
        this.f10327 = i;
        this.f10328 = interfaceC2847;
    }
}
