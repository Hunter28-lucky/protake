package org.jcodec.audio;

import java.nio.FloatBuffer;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class FilterSocket {
    private FloatBuffer[] buffers;
    private int[] delays;
    private AudioFilter[] filters;
    private long[] positions;
    private int totalInputs;
    private int totalOutputs;

    private FilterSocket() {
    }

    public static FilterSocket createFilterSocket(AudioFilter[] audioFilterArr) {
        FilterSocket filterSocket = new FilterSocket();
        filterSocket.totalInputs = 0;
        filterSocket.totalOutputs = 0;
        for (int i = 0; i < audioFilterArr.length; i++) {
            filterSocket.totalInputs += audioFilterArr[i].getNInputs();
            filterSocket.totalOutputs += audioFilterArr[i].getNOutputs();
        }
        int i2 = filterSocket.totalInputs;
        filterSocket.buffers = new FloatBuffer[i2];
        filterSocket.positions = new long[i2];
        filterSocket.delays = new int[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < audioFilterArr.length; i4++) {
            int i5 = 0;
            while (i5 < audioFilterArr[i4].getNInputs()) {
                filterSocket.delays[i3] = audioFilterArr[i4].getDelay();
                i5++;
                i3++;
            }
        }
        filterSocket.filters = audioFilterArr;
        return filterSocket;
    }

    public static FilterSocket createFilterSocket2(AudioFilter audioFilter, FloatBuffer[] floatBufferArr, long[] jArr) {
        FilterSocket filterSocket = new FilterSocket();
        filterSocket.filters = new AudioFilter[]{audioFilter};
        filterSocket.buffers = floatBufferArr;
        filterSocket.positions = jArr;
        filterSocket.delays = new int[]{audioFilter.getDelay()};
        filterSocket.totalInputs = audioFilter.getNInputs();
        filterSocket.totalOutputs = audioFilter.getNOutputs();
        return filterSocket;
    }

    public void allocateBuffers(int i) {
        for (int i2 = 0; i2 < this.totalInputs; i2++) {
            this.buffers[i2] = FloatBuffer.allocate((this.delays[i2] * 2) + i);
            this.buffers[i2].position(this.delays[i2]);
        }
    }

    public void filter(FloatBuffer[] floatBufferArr) {
        if (floatBufferArr.length != this.totalOutputs) {
            throw new IllegalArgumentException("Can not output to provided filter socket inputs != outputs (" + floatBufferArr.length + "!=" + this.totalOutputs + ")");
        }
        int i = 0;
        int nInputs = 0;
        int nOutputs = 0;
        while (true) {
            AudioFilter[] audioFilterArr = this.filters;
            if (i >= audioFilterArr.length) {
                return;
            }
            AudioFilter audioFilter = audioFilterArr[i];
            audioFilter.filter((FloatBuffer[]) Platform.copyOfRangeO(this.buffers, nInputs, audioFilter.getNInputs() + nInputs), Platform.copyOfRangeL(this.positions, nInputs, this.filters[i].getNInputs() + nInputs), (FloatBuffer[]) Platform.copyOfRangeO(floatBufferArr, nOutputs, this.filters[i].getNOutputs() + nOutputs));
            nInputs += this.filters[i].getNInputs();
            nOutputs += this.filters[i].getNOutputs();
            i++;
        }
    }

    public FloatBuffer[] getBuffers() {
        return this.buffers;
    }

    public AudioFilter[] getFilters() {
        return this.filters;
    }

    public long[] getPositions() {
        return this.positions;
    }

    public int getTotalInputs() {
        return this.totalInputs;
    }

    public int getTotalOutputs() {
        return this.totalOutputs;
    }

    public void rotate() {
        int i = 0;
        while (true) {
            if (i >= this.buffers.length) {
                return;
            }
            long[] jArr = this.positions;
            jArr[i] = jArr[i] + r1[i].position();
            Audio.rotate(this.buffers[i]);
            i++;
        }
    }

    public void setBuffers(FloatBuffer[] floatBufferArr, long[] jArr) {
        int length = floatBufferArr.length;
        int i = this.totalInputs;
        if (length != i) {
            throw new IllegalArgumentException("Number of input buffers provided is less then the number of filter inputs.");
        }
        if (jArr.length != i) {
            throw new IllegalArgumentException("Number of input buffer positions provided is less then the number of filter inputs.");
        }
        this.buffers = floatBufferArr;
        this.positions = jArr;
    }
}
