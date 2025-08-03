package org.tensorflow.lite.support.label;

import java.util.Objects;
import org.tensorflow.lite.annotations.UsedByReflection;

@UsedByReflection
/* loaded from: classes2.dex */
public final class Category {
    private final String displayName;
    private final int index;
    private final String label;
    private final float score;

    @UsedByReflection
    public Category(String str, float f) {
        this(str, "", f, -1);
    }

    @UsedByReflection
    public static Category create(String str, String str2, float f, int i) {
        return new Category(str, str2, f, i);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Category)) {
            return false;
        }
        Category category = (Category) obj;
        return category.getLabel().equals(this.label) && category.getDisplayName().equals(this.displayName) && Math.abs(category.getScore() - this.score) < 1.0E-6f && category.getIndex() == this.index;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public int getIndex() {
        return this.index;
    }

    public String getLabel() {
        return this.label;
    }

    public float getScore() {
        return this.score;
    }

    public int hashCode() {
        return Objects.hash(this.label, this.displayName, Float.valueOf(this.score), Integer.valueOf(this.index));
    }

    public String toString() {
        return "<Category \"" + this.label + "\" (displayName=" + this.displayName + " score=" + this.score + " index=" + this.index + ")>";
    }

    private Category(String str, String str2, float f, int i) {
        this.label = str;
        this.displayName = str2;
        this.score = f;
        this.index = i;
    }

    @UsedByReflection
    public static Category create(String str, String str2, float f) {
        return new Category(str, str2, f, -1);
    }
}
