package org.jcodec.containers.mps.psi;

import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.containers.mps.MPSUtils;
import org.jcodec.containers.mps.MTSStreamType;

/* loaded from: classes2.dex */
public class PMTSection extends PSISection {
    private int pcrPid;
    private PMTStream[] streams;
    private Tag[] tags;

    public static class PMTStream {
        private List<MPSUtils.MPEGMediaDescriptor> descriptors;
        private int pid;
        private MTSStreamType streamType;
        private int streamTypeTag;

        public PMTStream(int i, int i2, List<MPSUtils.MPEGMediaDescriptor> list) {
            this.streamTypeTag = i;
            this.pid = i2;
            this.descriptors = list;
            this.streamType = MTSStreamType.fromTag(i);
        }

        public List<MPSUtils.MPEGMediaDescriptor> getDesctiptors() {
            return this.descriptors;
        }

        public int getPid() {
            return this.pid;
        }

        public MTSStreamType getStreamType() {
            return this.streamType;
        }

        public int getStreamTypeTag() {
            return this.streamTypeTag;
        }
    }

    public static class Tag {
        private ByteBuffer content;
        private int tag;

        public Tag(int i, ByteBuffer byteBuffer) {
            this.tag = i;
            this.content = byteBuffer;
        }

        public ByteBuffer getContent() {
            return this.content;
        }

        public int getTag() {
            return this.tag;
        }
    }

    public PMTSection(PSISection pSISection, int i, Tag[] tagArr, PMTStream[] pMTStreamArr) {
        super(pSISection.tableId, pSISection.specificId, pSISection.versionNumber, pSISection.currentNextIndicator, pSISection.sectionNumber, pSISection.lastSectionNumber);
        this.pcrPid = i;
        this.tags = tagArr;
        this.streams = pMTStreamArr;
    }

    public static PMTSection parsePMT(ByteBuffer byteBuffer) {
        PSISection psi = PSISection.parsePSI(byteBuffer);
        int i = byteBuffer.getShort() & 65535 & 8191;
        List<Tag> tags = parseTags(NIOUtils.read(byteBuffer, byteBuffer.getShort() & 65535 & 4095));
        ArrayList arrayList = new ArrayList();
        while (byteBuffer.remaining() > 4) {
            arrayList.add(new PMTStream(byteBuffer.get() & ExifInterface.MARKER, byteBuffer.getShort() & 65535 & 8191, MPSUtils.parseDescriptors(NIOUtils.read(byteBuffer, byteBuffer.getShort() & 65535 & 4095))));
        }
        return new PMTSection(psi, i, (Tag[]) tags.toArray(new Tag[0]), (PMTStream[]) arrayList.toArray(new PMTStream[0]));
    }

    public static List<Tag> parseTags(ByteBuffer byteBuffer) {
        ArrayList arrayList = new ArrayList();
        while (byteBuffer.hasRemaining()) {
            arrayList.add(new Tag(byteBuffer.get(), NIOUtils.read(byteBuffer, byteBuffer.get())));
        }
        return arrayList;
    }

    public int getPcrPid() {
        return this.pcrPid;
    }

    public PMTStream[] getStreams() {
        return this.streams;
    }

    public Tag[] getTags() {
        return this.tags;
    }
}
