package com.blink.academy.film.support.stream.ts.google.Core.Descriptor;

import com.blink.academy.film.support.stream.ts.google.API.BitOutputStream;
import com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_AC3Audio;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;

/* loaded from: classes.dex */
public class AC3_AudioImpl implements DC_AC3Audio {
    public byte[] additional_info;
    public int asvcflags;
    public int bit_rate_code;
    public int bsid;
    public int bsmod;
    public int full_svc;
    public int langcod;
    public int langcod2;
    public int mainid;
    public int num_channels;
    public int sample_rate_code;
    public int surround_mode;
    public char[] text;
    public int text_code;
    public int textlen;

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_AC3Audio
    public byte[] getAdditionalInfo() {
        return this.additional_info;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_AC3Audio
    public int getAsvcFlags() {
        return this.asvcflags;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_AC3Audio
    public int getBitRateCode() {
        return this.bit_rate_code;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_AC3Audio
    public int getBsid() {
        return this.bsid;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_AC3Audio
    public int getBsmod() {
        return this.bsmod;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_AC3Audio
    public int getFullSvc() {
        return this.full_svc;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_AC3Audio
    public int getLangCod() {
        return this.langcod;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_AC3Audio
    public int getLangCod2() {
        return this.langcod2;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_AC3Audio
    public int getMainId() {
        return this.mainid;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorContent
    public String getNameString() {
        return "AC3_Audio";
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_AC3Audio
    public int getNumChannels() {
        return this.num_channels;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_AC3Audio
    public int getSampleRateCode() {
        return this.sample_rate_code;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation
    public int getSizeInBytes() {
        return (this.num_channels == 0 ? 5 : 4) + 1 + 1 + this.textlen + this.additional_info.length;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_AC3Audio
    public int getSurroundMode() {
        return this.surround_mode;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_AC3Audio
    public char[] getText() {
        return this.text;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_AC3Audio
    public int getTextCode() {
        return this.text_code;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_AC3Audio
    public int getTextLen() {
        return this.textlen;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_AC3Audio
    public void setAdditionalInfo(byte[] bArr) {
        this.additional_info = bArr;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_AC3Audio
    public void setAsvcFlags(int i) {
        this.asvcflags = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_AC3Audio
    public void setBitRateCode(int i) {
        this.bit_rate_code = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_AC3Audio
    public void setBsid(int i) {
        this.bsid = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_AC3Audio
    public void setBsmod(int i) {
        this.bsmod = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_AC3Audio
    public void setFullSvc(int i) {
        this.full_svc = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_AC3Audio
    public void setLangCod(int i) {
        this.langcod = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_AC3Audio
    public void setLangCod2(int i) {
        this.langcod2 = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_AC3Audio
    public void setMainId(int i) {
        this.mainid = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_AC3Audio
    public void setNumChannels(int i) {
        this.num_channels = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_AC3Audio
    public void setSampleRateCode(int i) {
        this.sample_rate_code = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_AC3Audio
    public void setSurroundMode(int i) {
        this.surround_mode = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_AC3Audio
    public void setText(char[] cArr) {
        this.text = cArr;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_AC3Audio
    public void setTextCode(int i) {
        this.text_code = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_AC3Audio
    public void setTextLen(int i) {
        this.textlen = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation
    public byte[] toByteArray() {
        BitOutputStream bitOutputStream = new BitOutputStream(getSizeInBytes() * 8);
        bitOutputStream.writeFromLSB(this.sample_rate_code, 3);
        bitOutputStream.writeFromLSB(this.bsid, 5);
        bitOutputStream.writeFromLSB(this.bit_rate_code, 6);
        bitOutputStream.writeFromLSB(this.surround_mode, 2);
        bitOutputStream.writeFromLSB(this.bsmod, 3);
        bitOutputStream.writeFromLSB(this.num_channels, 4);
        bitOutputStream.writeFromLSB(this.full_svc, 1);
        bitOutputStream.writeFromLSB(this.langcod, 8);
        if (this.num_channels == 0) {
            bitOutputStream.writeFromLSB(this.langcod2, 8);
        }
        int i = 0;
        if (this.bsmod < 2) {
            bitOutputStream.writeFromLSB(this.mainid, 3);
            bitOutputStream.writeFromLSB(0, 5);
        } else {
            bitOutputStream.writeFromLSB(this.asvcflags, 8);
        }
        bitOutputStream.writeFromLSB(this.textlen, 7);
        bitOutputStream.writeFromLSB(this.text_code, 1);
        if (this.text_code != 1) {
            while (true) {
                char[] cArr = this.text;
                if (i >= cArr.length) {
                    break;
                }
                bitOutputStream.write(cArr[i]);
                i++;
            }
        } else {
            while (true) {
                char[] cArr2 = this.text;
                if (i >= cArr2.length) {
                    break;
                }
                bitOutputStream.write((byte) cArr2[i]);
                i++;
            }
        }
        byte[] bArr = this.additional_info;
        if (bArr != null) {
            bitOutputStream.write(bArr);
        }
        return bitOutputStream.toByteArray();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.XMLRepresentation
    public String toXMLString(int i) {
        return ((((((((((((((new String() + MyUTIL.whiteSpaceStr(i) + "<sample_rate_code>" + this.sample_rate_code + "</sample_rate_code>\n") + MyUTIL.whiteSpaceStr(i) + "<bsid>" + this.bsid + "</bsid>\n") + MyUTIL.whiteSpaceStr(i) + "<bit_rate_code>" + this.bit_rate_code + "</bit_rate_code>\n") + MyUTIL.whiteSpaceStr(i) + "<surround_mode>" + this.surround_mode + "</surround_mode>\n") + MyUTIL.whiteSpaceStr(i) + "<bsmod>" + this.bsmod + "</bsmod>\n") + MyUTIL.whiteSpaceStr(i) + "<num_channels>" + this.num_channels + "</num_channels>\n") + MyUTIL.whiteSpaceStr(i) + "<full_svc>" + this.full_svc + "</full_svc>\n") + MyUTIL.whiteSpaceStr(i) + "<langcod>" + this.langcod + "</langcod>\n") + MyUTIL.whiteSpaceStr(i) + "<langcod2>" + this.langcod2 + "</langcod2>\n") + MyUTIL.whiteSpaceStr(i) + "<mainid>" + this.mainid + "</mainid>\n") + MyUTIL.whiteSpaceStr(i) + "<asvcflags>" + this.asvcflags + "</asvcflags>\n") + MyUTIL.whiteSpaceStr(i) + "<textlen>" + this.textlen + "</textlen>\n") + MyUTIL.whiteSpaceStr(i) + "<text_code>" + this.text_code + "</text_code>\n") + MyUTIL.whiteSpaceStr(i) + "<text>" + new String(this.text) + "</text>\n") + MyUTIL.whiteSpaceStr(i) + "<textlen>" + this.textlen + "</textlen>\n";
    }
}
