package org.tensorflow.lite.task.vision.detector;

import java.util.ArrayList;
import java.util.List;
import org.tensorflow.lite.task.core.annotations.UsedByReflection;

@UsedByReflection
/* loaded from: classes2.dex */
public class ObjectDetector$ObjectDetectorOptions {
    private final String displayNamesLocale;
    private final boolean isScoreThresholdSet;
    private final List<String> labelAllowList;
    private final List<String> labelDenyList;
    private final int maxResults;
    private final int numThreads;
    private final float scoreThreshold;

    @UsedByReflection
    public String getDisplayNamesLocale() {
        return this.displayNamesLocale;
    }

    @UsedByReflection
    public boolean getIsScoreThresholdSet() {
        return this.isScoreThresholdSet;
    }

    @UsedByReflection
    public List<String> getLabelAllowList() {
        return new ArrayList(this.labelAllowList);
    }

    @UsedByReflection
    public List<String> getLabelDenyList() {
        return new ArrayList(this.labelDenyList);
    }

    @UsedByReflection
    public int getMaxResults() {
        return this.maxResults;
    }

    @UsedByReflection
    public int getNumThreads() {
        return this.numThreads;
    }

    @UsedByReflection
    public float getScoreThreshold() {
        return this.scoreThreshold;
    }
}
