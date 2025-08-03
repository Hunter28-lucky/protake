package com.blink.academy.film.support.stream.ts.google.CRC32;

import androidx.exifinterface.media.ExifInterface;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.zip.Checksum;

/* loaded from: classes.dex */
public abstract class AbstractChecksum implements Checksum {
    public static final String BASE16 = "base16";
    public static final String BASE32 = "base32";
    public static final String BASE64 = "base64";
    public static final String BIN = "bin";
    public static final String BUBBLEBABBLE = "bubblebabble";
    public static final int BUFFERSIZE = 8192;
    public static final String DEC = "dec";
    public static final String HEX = "hex";
    public static final String HEX_UPPERCASE = "hexup";
    public static final String OCT = "oct";
    public long value = 0;
    public long length = 0;
    public String separator = "\t";
    public String filename = null;
    public String encoding = "";
    public String timestampFormat = null;
    public Format timestampFormatter = null;
    public long timestamp = 0;
    public int group = 0;
    public char groupChar = ' ';
    public String name = null;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AbstractChecksum) {
            return Arrays.equals(getByteArray(), ((AbstractChecksum) obj).getByteArray());
        }
        return false;
    }

    public byte[] getByteArray() {
        return new byte[]{(byte) (this.value & 255)};
    }

    public String getEncoding() {
        return this.encoding;
    }

    public String getFilename() {
        return this.filename;
    }

    public int getGroup() {
        return this.group;
    }

    public char getGroupChar() {
        return this.groupChar;
    }

    public long getLength() {
        return this.length;
    }

    public String getName() {
        return this.name;
    }

    public String getSeparator() {
        return this.separator;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getTimestampFormat() {
        return this.timestampFormat;
    }

    public String getTimestampFormatted() {
        if (this.timestampFormatter == null) {
            this.timestampFormatter = new SimpleDateFormat(this.timestampFormat);
        }
        return this.timestampFormatter.format(new Date(this.timestamp));
    }

    @Override // java.util.zip.Checksum
    public long getValue() {
        return this.value;
    }

    public int hashCode() {
        int i = 0;
        for (byte b : getByteArray()) {
            i = ((i << 8) + b) % 8388593;
        }
        return i;
    }

    public boolean isGroupWanted() {
        return this.group > 0;
    }

    public boolean isTimestampWanted() {
        return this.timestampFormat != null;
    }

    public long readFile(String str) throws IOException {
        return readFile(str, true);
    }

    @Override // java.util.zip.Checksum
    public void reset() {
        this.value = 0L;
        this.length = 0L;
    }

    public void setFilename(String str) {
        this.filename = str;
    }

    public void setGroup(int i) {
        this.group = i;
    }

    public void setGroupChar(char c) {
        this.groupChar = c;
    }

    public void setGrouping(int i, char c) {
        setGroup(i);
        setGroupChar(c);
    }

    public void setHex(boolean z) {
        this.encoding = z ? HEX : "";
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSeparator(String str) {
        this.separator = str;
    }

    public void setTimestamp(String str) {
        this.timestamp = new File(str).lastModified();
    }

    public void setTimestampFormat(String str) {
        this.timestampFormat = str;
    }

    public void setUpperCase(boolean z) {
        this.encoding = z ? HEX_UPPERCASE : HEX;
    }

    @Override // java.util.zip.Checksum
    public void update(int i) {
        this.length++;
    }

    public long readFile(String str, boolean z) throws Throwable {
        FileInputStream fileInputStream;
        this.filename = str;
        if (isTimestampWanted()) {
            setTimestamp(str);
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(fileInputStream);
                if (z) {
                    try {
                        reset();
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                }
                long j = this.length;
                byte[] bArr = new byte[8192];
                while (true) {
                    int i = bufferedInputStream2.read(bArr);
                    if (i <= -1) {
                        bufferedInputStream2.close();
                        fileInputStream.close();
                        return this.length - j;
                    }
                    update(bArr, 0, i);
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public void update(byte b) {
        update(b & ExifInterface.MARKER);
    }

    @Override // java.util.zip.Checksum
    public void update(byte[] bArr, int i, int i2) {
        for (int i3 = i; i3 < i2 + i; i3++) {
            update(bArr[i3]);
        }
    }

    @Override // java.util.zip.Checksum
    public void update(byte[] bArr) {
        update(bArr, 0, bArr.length);
    }
}
