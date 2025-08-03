package org.jcodec.containers.mkv.boxes;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.jcodec.common.UsedViaReflection;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.containers.mkv.MKVType;
import org.jcodec.containers.mkv.util.EbmlUtil;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public abstract class EbmlBase {
    public int dataLen = 0;
    public long dataOffset;
    public byte[] id;
    public long offset;
    public EbmlMaster parent;
    public MKVType type;
    public int typeSizeLength;

    @UsedViaReflection
    public EbmlBase(byte[] bArr) {
        this.id = bArr;
    }

    public boolean equalId(byte[] bArr) {
        return Platform.arrayEqualsByte(this.id, bArr);
    }

    public abstract ByteBuffer getData();

    public long mux(SeekableByteChannel seekableByteChannel) throws IOException {
        return seekableByteChannel.write(getData());
    }

    public long size() {
        int i = this.dataLen;
        return i + EbmlUtil.ebmlLength(i) + this.id.length;
    }
}
