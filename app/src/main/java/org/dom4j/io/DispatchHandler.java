package org.dom4j.io;

import java.util.ArrayList;
import java.util.HashMap;
import org.dom4j.Element;
import org.dom4j.ElementHandler;
import org.dom4j.ElementPath;

/* loaded from: classes2.dex */
class DispatchHandler implements ElementHandler {
    private ElementHandler defaultHandler;
    private boolean atRoot = true;
    private String path = "/";
    private ArrayList<String> pathStack = new ArrayList<>();
    private ArrayList<ElementHandler> handlerStack = new ArrayList<>();
    private HashMap<String, ElementHandler> handlers = new HashMap<>();

    @Override // org.dom4j.ElementHandler
    public void onEnd(ElementPath elementPath) {
        ElementHandler elementHandler;
        HashMap<String, ElementHandler> map = this.handlers;
        if (map != null && map.containsKey(this.path)) {
            ElementHandler elementHandler2 = this.handlers.get(this.path);
            ArrayList<ElementHandler> arrayList = this.handlerStack;
            arrayList.remove(arrayList.size() - 1);
            elementHandler2.onEnd(elementPath);
        } else if (this.handlerStack.isEmpty() && (elementHandler = this.defaultHandler) != null) {
            elementHandler.onEnd(elementPath);
        }
        ArrayList<String> arrayList2 = this.pathStack;
        this.path = arrayList2.remove(arrayList2.size() - 1);
        if (this.pathStack.size() == 0) {
            this.atRoot = true;
        }
    }

    @Override // org.dom4j.ElementHandler
    public void onStart(ElementPath elementPath) {
        ElementHandler elementHandler;
        Element current = elementPath.getCurrent();
        this.pathStack.add(this.path);
        if (this.atRoot) {
            this.path += current.getName();
            this.atRoot = false;
        } else {
            this.path += "/" + current.getName();
        }
        HashMap<String, ElementHandler> map = this.handlers;
        if (map != null && map.containsKey(this.path)) {
            ElementHandler elementHandler2 = this.handlers.get(this.path);
            this.handlerStack.add(elementHandler2);
            elementHandler2.onStart(elementPath);
        } else {
            if (!this.handlerStack.isEmpty() || (elementHandler = this.defaultHandler) == null) {
                return;
            }
            elementHandler.onStart(elementPath);
        }
    }
}
