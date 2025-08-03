package org.dom4j.io;

import org.dom4j.Element;
import org.dom4j.ElementPath;

/* loaded from: classes2.dex */
class ElementStack implements ElementPath {
    private DispatchHandler handler;
    public int lastElementIndex;
    public Element[] stack;

    public ElementStack() {
        this(50);
    }

    public void clear() {
        this.lastElementIndex = -1;
    }

    @Override // org.dom4j.ElementPath
    public Element getCurrent() {
        return peekElement();
    }

    public Element peekElement() {
        int i = this.lastElementIndex;
        if (i < 0) {
            return null;
        }
        return this.stack[i];
    }

    public Element popElement() {
        int i = this.lastElementIndex;
        if (i < 0) {
            return null;
        }
        Element[] elementArr = this.stack;
        this.lastElementIndex = i - 1;
        return elementArr[i];
    }

    public void pushElement(Element element) {
        int length = this.stack.length;
        int i = this.lastElementIndex + 1;
        this.lastElementIndex = i;
        if (i >= length) {
            reallocate(length * 2);
        }
        this.stack[this.lastElementIndex] = element;
    }

    public void reallocate(int i) {
        Element[] elementArr = this.stack;
        Element[] elementArr2 = new Element[i];
        this.stack = elementArr2;
        System.arraycopy(elementArr, 0, elementArr2, 0, elementArr.length);
    }

    public void setDispatchHandler(DispatchHandler dispatchHandler) {
        this.handler = dispatchHandler;
    }

    public ElementStack(int i) {
        this.lastElementIndex = -1;
        this.handler = null;
        this.stack = new Element[i];
    }
}
