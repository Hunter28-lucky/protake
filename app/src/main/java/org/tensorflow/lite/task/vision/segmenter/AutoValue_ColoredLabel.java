package org.tensorflow.lite.task.vision.segmenter;

/* loaded from: classes2.dex */
final class AutoValue_ColoredLabel extends ColoredLabel {
    private final int argb;
    private final String displayName;
    private final String label;

    public AutoValue_ColoredLabel(String str, String str2, int i) {
        if (str == null) {
            throw new NullPointerException("Null label");
        }
        this.label = str;
        if (str2 == null) {
            throw new NullPointerException("Null displayName");
        }
        this.displayName = str2;
        this.argb = i;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ColoredLabel)) {
            return false;
        }
        ColoredLabel coloredLabel = (ColoredLabel) obj;
        return this.label.equals(coloredLabel.getlabel()) && this.displayName.equals(coloredLabel.getDisplayName()) && this.argb == coloredLabel.getArgb();
    }

    @Override // org.tensorflow.lite.task.vision.segmenter.ColoredLabel
    public int getArgb() {
        return this.argb;
    }

    @Override // org.tensorflow.lite.task.vision.segmenter.ColoredLabel
    public String getDisplayName() {
        return this.displayName;
    }

    @Override // org.tensorflow.lite.task.vision.segmenter.ColoredLabel
    public String getlabel() {
        return this.label;
    }

    public int hashCode() {
        return ((((this.label.hashCode() ^ 1000003) * 1000003) ^ this.displayName.hashCode()) * 1000003) ^ this.argb;
    }

    public String toString() {
        return "ColoredLabel{label=" + this.label + ", displayName=" + this.displayName + ", argb=" + this.argb + "}";
    }
}
