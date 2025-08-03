package org.jcodec.audio;

import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jcodec.audio.Audio;

/* loaded from: classes2.dex */
public class FilterGraph implements AudioFilter {
    private FilterSocket[] sockets;

    public static class Factory {
        private List<FilterSocket> sockets = new ArrayList();

        public Factory(AudioFilter audioFilter) {
            if (audioFilter.getDelay() == 0) {
                this.sockets.add(FilterSocket.createFilterSocket(new AudioFilter[]{audioFilter}));
            } else {
                this.sockets.add(FilterSocket.createFilterSocket(new Audio.DummyFilter[]{new Audio.DummyFilter(audioFilter.getNInputs())}));
                addLevel(new AudioFilter[]{audioFilter});
            }
        }

        public Factory addLevel(AudioFilter[] audioFilterArr) {
            FilterSocket filterSocketCreateFilterSocket = FilterSocket.createFilterSocket(audioFilterArr);
            filterSocketCreateFilterSocket.allocateBuffers(4096);
            this.sockets.add(filterSocketCreateFilterSocket);
            return this;
        }

        public Factory addLevelSpan(AudioFilter audioFilter) {
            int totalOutputs = this.sockets.get(r0.size() - 1).getTotalOutputs();
            if (totalOutputs % audioFilter.getNInputs() == 0) {
                return addLevels(audioFilter, totalOutputs / audioFilter.getNInputs());
            }
            throw new IllegalArgumentException("Can't fill " + totalOutputs + " with multiple of " + audioFilter.getNInputs());
        }

        public Factory addLevels(AudioFilter audioFilter, int i) {
            AudioFilter[] audioFilterArr = new AudioFilter[i];
            Arrays.fill(audioFilterArr, audioFilter);
            return addLevel(audioFilterArr);
        }

        public FilterGraph create() {
            return new FilterGraph((FilterSocket[]) this.sockets.toArray(new FilterSocket[0]));
        }
    }

    public static Factory addLevel(AudioFilter audioFilter) {
        return new Factory(audioFilter);
    }

    @Override // org.jcodec.audio.AudioFilter
    public void filter(FloatBuffer[] floatBufferArr, long[] jArr, FloatBuffer[] floatBufferArr2) {
        this.sockets[0].setBuffers(floatBufferArr, jArr);
        int i = 0;
        while (true) {
            FilterSocket[] filterSocketArr = this.sockets;
            if (i >= filterSocketArr.length) {
                return;
            }
            FloatBuffer[] buffers = i < filterSocketArr.length + (-1) ? filterSocketArr[i + 1].getBuffers() : floatBufferArr2;
            this.sockets[i].filter(buffers);
            if (i > 0) {
                this.sockets[i].rotate();
            }
            if (i < this.sockets.length - 1) {
                for (FloatBuffer floatBuffer : buffers) {
                    floatBuffer.flip();
                }
            }
            i++;
        }
    }

    @Override // org.jcodec.audio.AudioFilter
    public int getDelay() {
        return this.sockets[0].getFilters()[0].getDelay();
    }

    @Override // org.jcodec.audio.AudioFilter
    public int getNInputs() {
        return this.sockets[0].getTotalInputs();
    }

    @Override // org.jcodec.audio.AudioFilter
    public int getNOutputs() {
        return this.sockets[r0.length - 1].getTotalOutputs();
    }

    private FilterGraph(FilterSocket[] filterSocketArr) {
        this.sockets = filterSocketArr;
    }
}
