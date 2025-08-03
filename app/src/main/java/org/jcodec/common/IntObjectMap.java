package org.jcodec.common;

import java.lang.reflect.Array;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class IntObjectMap<T> {
    private static final int GROW_BY = 128;
    private int _size;
    private Object[] storage = new Object[128];

    public void clear() {
        int i = 0;
        while (true) {
            Object[] objArr = this.storage;
            if (i >= objArr.length) {
                this._size = 0;
                return;
            } else {
                objArr[i] = null;
                i++;
            }
        }
    }

    public T get(int i) {
        Object[] objArr = this.storage;
        if (i >= objArr.length) {
            return null;
        }
        return (T) objArr[i];
    }

    public int[] keys() {
        int[] iArr = new int[this._size];
        int i = 0;
        int i2 = 0;
        while (true) {
            Object[] objArr = this.storage;
            if (i >= objArr.length) {
                return iArr;
            }
            if (objArr[i] != null) {
                iArr[i2] = i;
                i2++;
            }
            i++;
        }
    }

    public void put(int i, T t) {
        Object[] objArr = this.storage;
        if (objArr.length <= i) {
            Object[] objArr2 = new Object[i + 128];
            System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
            this.storage = objArr2;
        }
        Object[] objArr3 = this.storage;
        if (objArr3[i] == null) {
            this._size++;
        }
        objArr3[i] = t;
    }

    public void remove(int i) {
        Object[] objArr = this.storage;
        if (objArr[i] != null) {
            this._size--;
        }
        objArr[i] = null;
    }

    public int size() {
        return this._size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T[] values(T[] tArr) {
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance(Platform.arrayComponentType(tArr), this._size));
        int i = 0;
        int i2 = 0;
        while (true) {
            Object[] objArr = this.storage;
            if (i >= objArr.length) {
                return tArr2;
            }
            Object obj = objArr[i];
            if (obj != null) {
                tArr2[i2] = obj;
                i2++;
            }
            i++;
        }
    }
}
