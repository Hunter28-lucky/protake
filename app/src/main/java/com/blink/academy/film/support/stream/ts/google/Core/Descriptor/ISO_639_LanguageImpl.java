package com.blink.academy.film.support.stream.ts.google.Core.Descriptor;

import com.blink.academy.film.support.stream.ts.google.API.BitOutputStream;
import com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_ISO639Language;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import java.util.List;
import java.util.Vector;

/* loaded from: classes.dex */
public class ISO_639_LanguageImpl implements DC_ISO639Language {
    public List<Integer> ISO_639_language_codes = new Vector();
    public List<Integer> audio_types = new Vector();

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_ISO639Language
    public boolean addLanguage(int i, int i2) {
        this.ISO_639_language_codes.add(new Integer(i));
        this.audio_types.add(new Integer(i2));
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_ISO639Language
    public boolean addLanguageAt(int i, int i2, int i3) {
        if (i < 0 || i > this.ISO_639_language_codes.size()) {
            return false;
        }
        this.ISO_639_language_codes.add(i, new Integer(i2));
        this.audio_types.add(i, new Integer(i3));
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_ISO639Language
    public int getAudioTypeAt(int i) {
        if (i < 0 || i >= this.audio_types.size()) {
            return -1;
        }
        return this.audio_types.get(i).intValue();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_ISO639Language
    public int getLanguageCodeAt(int i) {
        if (i < 0 || i >= this.ISO_639_language_codes.size()) {
            return -1;
        }
        return this.ISO_639_language_codes.get(i).intValue();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_ISO639Language
    public int getLanguagesDefined() {
        return this.ISO_639_language_codes.size();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorContent
    public String getNameString() {
        return "ISO639_Language";
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation
    public int getSizeInBytes() {
        return this.ISO_639_language_codes.size() * 4;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_ISO639Language
    public boolean setLanguageAt(int i, int i2, int i3) {
        if (i < 0 || i >= this.ISO_639_language_codes.size()) {
            return false;
        }
        this.ISO_639_language_codes.set(i, new Integer(i2));
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation
    public byte[] toByteArray() {
        if (getLanguagesDefined() == 0) {
            return null;
        }
        BitOutputStream bitOutputStream = new BitOutputStream(getSizeInBytes() * 8);
        for (int i = 0; i < getLanguagesDefined(); i++) {
            bitOutputStream.writeFromLSB(getLanguageCodeAt(i), 24);
            bitOutputStream.writeFromLSB(getAudioTypeAt(i), 8);
        }
        return bitOutputStream.toByteArray();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.XMLRepresentation
    public String toXMLString(int i) {
        String str = new String();
        for (int i2 = 0; i2 < getLanguagesDefined(); i2++) {
            int languageCodeAt = getLanguageCodeAt(i2);
            str = (str + MyUTIL.whiteSpaceStr(i) + "<ISO_639_language_code>" + String.valueOf((char) ((16711680 & languageCodeAt) >> 16)) + String.valueOf((char) ((65280 & languageCodeAt) >> 8)) + String.valueOf((char) (languageCodeAt & 255)) + "</ISO_639_language_code>\n") + MyUTIL.whiteSpaceStr(i + 2) + "<audio_type>" + getAudioTypeAt(i2) + "</audio_type>\n";
        }
        return str;
    }
}
