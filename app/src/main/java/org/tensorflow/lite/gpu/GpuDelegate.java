package org.tensorflow.lite.gpu;

import java.io.Closeable;
import org.tensorflow.lite.annotations.UsedByReflection;

@UsedByReflection
/* loaded from: classes2.dex */
public class GpuDelegate implements Closeable {
    private long delegateHandle;

    public static final class Options {
        public boolean precisionLossAllowed = true;
        public boolean quantizedModelsAllowed = true;
        public int inferencePreference = 0;
        public String serializationDir = null;
        public String modelToken = null;
    }

    static {
        System.loadLibrary("tensorflowlite_gpu_jni");
    }

    public GpuDelegate(Options options) {
        this.delegateHandle = createDelegate(options.precisionLossAllowed, options.quantizedModelsAllowed, options.inferencePreference, options.serializationDir, options.modelToken);
    }

    private static native long createDelegate(boolean z, boolean z2, int i, String str, String str2);

    private static native void deleteDelegate(long j);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        long j = this.delegateHandle;
        if (j != 0) {
            deleteDelegate(j);
            this.delegateHandle = 0L;
        }
    }

    @UsedByReflection
    public GpuDelegate() {
        this(new Options());
    }
}
