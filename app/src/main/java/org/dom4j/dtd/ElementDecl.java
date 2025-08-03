package org.dom4j.dtd;

import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;

/* loaded from: classes2.dex */
public class ElementDecl implements Decl {
    private String model;
    private String name;

    public ElementDecl(String str, String str2) {
        this.name = str;
        this.model = str2;
    }

    public String toString() {
        return "<!ELEMENT " + this.name + MyUTIL.white_space + this.model + ">";
    }
}
