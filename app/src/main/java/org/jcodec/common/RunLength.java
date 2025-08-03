package org.jcodec.common;

import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteBuffer;
import org.jcodec.common.io.NIOUtils;

/* loaded from: classes2.dex */
public abstract class RunLength {
    public IntArrayList counts = IntArrayList.createIntArrayList();

    public static class Integer extends RunLength {
        private static final int MIN_VALUE = Integer.MIN_VALUE;
        private int count = 0;
        private int lastValue = Integer.MIN_VALUE;
        private IntArrayList values = IntArrayList.createIntArrayList();

        public static Integer parse(ByteBuffer byteBuffer) {
            Integer integer = new Integer();
            int i = byteBuffer.getInt();
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = (byteBuffer.get() & ExifInterface.MARKER) + 1;
                int i4 = byteBuffer.getInt();
                integer.counts.add(i3);
                integer.values.add(i4);
            }
            return integer;
        }

        public void add(int i) {
            int i2 = this.lastValue;
            if (i2 == Integer.MIN_VALUE || i2 != i) {
                if (i2 != Integer.MIN_VALUE) {
                    this.values.add(i2);
                    this.counts.add(this.count);
                    this.count = 0;
                }
                this.lastValue = i;
            }
            this.count++;
        }

        @Override // org.jcodec.common.RunLength
        public void finish() {
            int i = this.lastValue;
            if (i != Integer.MIN_VALUE) {
                this.values.add(i);
                this.counts.add(this.count);
                this.lastValue = Integer.MIN_VALUE;
                this.count = 0;
            }
        }

        public int[] flattern() {
            int[] counts = getCounts();
            int i = 0;
            for (int i2 : counts) {
                i += i2;
            }
            int[] values = getValues();
            int[] iArr = new int[i];
            int i3 = 0;
            for (int i4 = 0; i4 < counts.length; i4++) {
                int i5 = 0;
                while (i5 < counts[i4]) {
                    iArr[i3] = values[i4];
                    i5++;
                    i3++;
                }
            }
            return iArr;
        }

        public int[] getValues() {
            finish();
            return this.values.toArray();
        }

        @Override // org.jcodec.common.RunLength
        public int recSize() {
            return 5;
        }

        public void serialize(ByteBuffer byteBuffer) {
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            int[] counts = getCounts();
            int[] values = getValues();
            NIOUtils.skip(byteBuffer, 4);
            int i = 0;
            int i2 = 0;
            while (i < counts.length) {
                int i3 = counts[i];
                while (i3 >= 256) {
                    byteBuffer.put((byte) -1);
                    byteBuffer.putInt(values[i]);
                    i2++;
                    i3 += InputDeviceCompat.SOURCE_ANY;
                }
                byteBuffer.put((byte) (i3 - 1));
                byteBuffer.putInt(values[i]);
                i++;
                i2++;
            }
            byteBufferDuplicate.putInt(i2);
        }
    }

    public static class Long extends RunLength {
        private static final long MIN_VALUE = Long.MIN_VALUE;
        private int count = 0;
        private long lastValue = Long.MIN_VALUE;
        private LongArrayList values = LongArrayList.createLongArrayList();

        public static Long parse(ByteBuffer byteBuffer) {
            Long r0 = new Long();
            int i = byteBuffer.getInt();
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = (byteBuffer.get() & ExifInterface.MARKER) + 1;
                long j = byteBuffer.getLong();
                r0.counts.add(i3);
                r0.values.add(j);
            }
            return r0;
        }

        public void add(long j) {
            long j2 = this.lastValue;
            if (j2 == Long.MIN_VALUE || j2 != j) {
                if (j2 != Long.MIN_VALUE) {
                    this.values.add(j2);
                    this.counts.add(this.count);
                    this.count = 0;
                }
                this.lastValue = j;
            }
            this.count++;
        }

        @Override // org.jcodec.common.RunLength
        public void finish() {
            long j = this.lastValue;
            if (j != Long.MIN_VALUE) {
                this.values.add(j);
                this.counts.add(this.count);
                this.lastValue = Long.MIN_VALUE;
                this.count = 0;
            }
        }

        public long[] flattern() {
            int[] counts = getCounts();
            int i = 0;
            for (int i2 : counts) {
                i += i2;
            }
            long[] values = getValues();
            long[] jArr = new long[i];
            int i3 = 0;
            for (int i4 = 0; i4 < counts.length; i4++) {
                int i5 = 0;
                while (i5 < counts[i4]) {
                    jArr[i3] = values[i4];
                    i5++;
                    i3++;
                }
            }
            return jArr;
        }

        @Override // org.jcodec.common.RunLength
        public int[] getCounts() {
            finish();
            return this.counts.toArray();
        }

        public long[] getValues() {
            finish();
            return this.values.toArray();
        }

        @Override // org.jcodec.common.RunLength
        public int recSize() {
            return 9;
        }

        public void serialize(ByteBuffer byteBuffer) {
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            int[] counts = getCounts();
            long[] values = getValues();
            NIOUtils.skip(byteBuffer, 4);
            int i = 0;
            int i2 = 0;
            while (i < counts.length) {
                int i3 = counts[i];
                while (i3 >= 256) {
                    byteBuffer.put((byte) -1);
                    byteBuffer.putLong(values[i]);
                    i2++;
                    i3 += InputDeviceCompat.SOURCE_ANY;
                }
                byteBuffer.put((byte) (i3 - 1));
                byteBuffer.putLong(values[i]);
                i++;
                i2++;
            }
            byteBufferDuplicate.putInt(i2);
        }
    }

    public int estimateSize() {
        int[] counts = getCounts();
        int i = 0;
        int i2 = 0;
        while (i < counts.length) {
            for (int i3 = counts[i]; i3 >= 256; i3 += InputDeviceCompat.SOURCE_ANY) {
                i2++;
            }
            i++;
            i2++;
        }
        return (i2 * recSize()) + 4;
    }

    public abstract void finish();

    public int[] getCounts() {
        finish();
        return this.counts.toArray();
    }

    public abstract int recSize();
}
