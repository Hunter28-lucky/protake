package com.blink.academy.film.support.stream.ts.google.Core.Descriptor;

import com.blink.academy.film.support.stream.ts.google.API.BitOutputStream;
import com.blink.academy.film.support.stream.ts.google.API.Descriptor.Descriptor;
import com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorContent;
import com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorTag;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;

/* loaded from: classes.dex */
public class DescriptorImpl implements Descriptor {
    public DescriptorContent descriptor_content;
    public DescriptorTag descriptor_tag;

    public DescriptorImpl(DescriptorTag descriptorTag) {
        this.descriptor_tag = descriptorTag;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.Descriptor
    public DescriptorContent getContent() {
        return this.descriptor_content;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.Descriptor
    public int getDescriptorLength() {
        DescriptorContent descriptorContent = this.descriptor_content;
        if (descriptorContent == null) {
            return 0;
        }
        return descriptorContent.getSizeInBytes();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.Descriptor
    public DescriptorTag getDescriptorTag() {
        return this.descriptor_tag;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation
    public int getSizeInBytes() {
        return getDescriptorLength() + 2;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.Descriptor
    public void setContent(DescriptorContent descriptorContent) {
        this.descriptor_content = descriptorContent;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation
    public byte[] toByteArray() {
        BitOutputStream bitOutputStream = new BitOutputStream(getSizeInBytes() * 8);
        bitOutputStream.writeFromLSB(this.descriptor_tag.getValue(), 8);
        bitOutputStream.writeFromLSB(getDescriptorLength(), 8);
        DescriptorContent descriptorContent = this.descriptor_content;
        if (descriptorContent != null) {
            bitOutputStream.write(descriptorContent.toByteArray());
        }
        return bitOutputStream.toByteArray();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.XMLRepresentation
    public String toXMLString(int i) {
        String str;
        String str2 = new String();
        if (this.descriptor_content == null) {
            str = str2 + MyUTIL.whiteSpaceStr(i) + "<Descriptor>\n";
        } else {
            str = str2 + MyUTIL.whiteSpaceStr(i) + "<" + this.descriptor_content.getNameString() + "_Descriptor>\n";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        int i2 = i + 2;
        sb.append(MyUTIL.whiteSpaceStr(i2));
        sb.append("<descriptor_tag>");
        sb.append(this.descriptor_tag);
        sb.append("</descriptor_tag>\n");
        String string = sb.toString();
        if (this.descriptor_content != null) {
            string = string + this.descriptor_content.toXMLString(i2);
        }
        if (this.descriptor_content == null) {
            return string + MyUTIL.whiteSpaceStr(i) + "<Descriptor>\n";
        }
        return string + MyUTIL.whiteSpaceStr(i) + "<" + this.descriptor_content.getNameString() + "_Descriptor>\n";
    }
}
