package defpackage;

import android.os.Environment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/* compiled from: BuildProperties.java */
/* renamed from: ȉ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2514 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static C2514 f9328;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Properties f9329;

    public C2514() throws IOException {
        Properties properties = new Properties();
        this.f9329 = properties;
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static C2514 m9301() {
        if (f9328 == null) {
            f9328 = new C2514();
        }
        return f9328;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String m9302(String str) throws IOException {
        String str2 = "";
        try {
            Process processStart = new ProcessBuilder("/system/bin/getprop", str).redirectErrorStream(true).start();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processStart.getInputStream()));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                str2 = line;
            }
            processStart.destroy();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return str2;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public String m9303(String str, String str2) {
        return this.f9329.getProperty(str, str2);
    }
}
