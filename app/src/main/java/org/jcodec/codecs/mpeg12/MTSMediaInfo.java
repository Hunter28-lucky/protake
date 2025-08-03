package org.jcodec.codecs.mpeg12;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.jcodec.codecs.mpeg12.MPSMediaInfo;
import org.jcodec.common.io.FileChannelWrapper;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.containers.mps.MTSUtils;
import org.jcodec.containers.mps.psi.PMTSection;

/* loaded from: classes2.dex */
public class MTSMediaInfo {
    public static MTSMediaInfo extract(SeekableByteChannel seekableByteChannel) {
        return null;
    }

    public static void main1(String[] strArr) throws IOException {
        Iterator<MPSMediaInfo.MPEGTrackMetadata> it = new MTSMediaInfo().getMediaInfo(new File(strArr[0])).iterator();
        while (it.hasNext()) {
            System.out.println(it.next().codec);
        }
    }

    public List<MPSMediaInfo.MPEGTrackMetadata> getAudioTracks() {
        return null;
    }

    public List<MPSMediaInfo.MPEGTrackMetadata> getMediaInfo(File file) throws Throwable {
        FileChannelWrapper fileChannelWrapper;
        final ArrayList arrayList = new ArrayList();
        final HashMap map = new HashMap();
        final ArrayList arrayList2 = new ArrayList();
        try {
            fileChannelWrapper = NIOUtils.readableChannel(file);
        } catch (Throwable th) {
            th = th;
            fileChannelWrapper = null;
        }
        try {
            new MTSUtils.TSReader(false) { // from class: org.jcodec.codecs.mpeg12.MTSMediaInfo.1
                private ByteBuffer pmtBuffer;
                private boolean pmtDone;
                private int pmtPid = -1;

                @Override // org.jcodec.containers.mps.MTSUtils.TSReader
                public boolean onPkt(int i, boolean z, ByteBuffer byteBuffer, long j, boolean z2, ByteBuffer byteBuffer2) {
                    if (i == 0) {
                        this.pmtPid = MTSUtils.parsePAT(byteBuffer);
                    } else if (i == this.pmtPid && !this.pmtDone) {
                        ByteBuffer byteBuffer3 = this.pmtBuffer;
                        if (byteBuffer3 == null) {
                            this.pmtBuffer = ByteBuffer.allocate(((byteBuffer.duplicate().getInt() >> 8) & 1023) + 3);
                        } else if (byteBuffer3.hasRemaining()) {
                            ByteBuffer byteBuffer4 = this.pmtBuffer;
                            NIOUtils.writeL(byteBuffer4, byteBuffer, Math.min(byteBuffer4.remaining(), byteBuffer.remaining()));
                        }
                        if (!this.pmtBuffer.hasRemaining()) {
                            this.pmtBuffer.flip();
                            PMTSection pmt = MTSUtils.parsePMT(this.pmtBuffer);
                            arrayList.add(pmt);
                            for (PMTSection.PMTStream pMTStream : pmt.getStreams()) {
                                if (!map.containsKey(Integer.valueOf(pMTStream.getPid()))) {
                                    map.put(Integer.valueOf(pMTStream.getPid()), new MPSMediaInfo());
                                }
                            }
                            this.pmtDone = pmt.getSectionNumber() == pmt.getLastSectionNumber();
                            this.pmtBuffer = null;
                        }
                    } else if (map.containsKey(Integer.valueOf(i))) {
                        try {
                            ((MPSMediaInfo) map.get(Integer.valueOf(i))).analyseBuffer(byteBuffer, j);
                        } catch (MPSMediaInfo.MediaInfoDone unused) {
                            arrayList2.addAll(((MPSMediaInfo) map.get(Integer.valueOf(i))).getInfos());
                            map.remove(Integer.valueOf(i));
                            if (map.size() == 0) {
                                return false;
                            }
                        }
                    }
                    return true;
                }
            }.readTsFile(fileChannelWrapper);
            NIOUtils.closeQuietly(fileChannelWrapper);
            return arrayList2;
        } catch (Throwable th2) {
            th = th2;
            NIOUtils.closeQuietly(fileChannelWrapper);
            throw th;
        }
    }

    public MPSMediaInfo.MPEGTrackMetadata getVideoTrack() {
        return null;
    }
}
