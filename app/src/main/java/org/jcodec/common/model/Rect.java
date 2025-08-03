package org.jcodec.common.model;

/* loaded from: classes2.dex */
public class Rect {
    private int height;
    private int width;
    private int x;
    private int y;

    public Rect(int i, int i2, int i3, int i4) {
        this.x = i;
        this.y = i2;
        this.width = i3;
        this.height = i4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Rect rect = (Rect) obj;
        return this.height == rect.height && this.width == rect.width && this.x == rect.x && this.y == rect.y;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int hashCode() {
        return ((((((this.height + 31) * 31) + this.width) * 31) + this.x) * 31) + this.y;
    }

    public String toString() {
        return "Rect [x=" + this.x + ", y=" + this.y + ", width=" + this.width + ", height=" + this.height + "]";
    }
}
