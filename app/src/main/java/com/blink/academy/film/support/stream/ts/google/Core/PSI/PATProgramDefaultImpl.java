package com.blink.academy.film.support.stream.ts.google.Core.PSI;

import com.blink.academy.film.support.stream.ts.google.API.BitOutputStream;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.blink.academy.film.support.stream.ts.google.API.PSI.PATProgram;

/* loaded from: classes.dex */
public class PATProgramDefaultImpl implements PATProgram {
    public int pid;
    public int program_number;

    public PATProgramDefaultImpl(int i, int i2) {
        this.program_number = i;
        this.pid = i2;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSI.PATProgram
    public int getPID() {
        return this.pid;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSI.PATProgram
    public int getProgramNumber() {
        return this.program_number;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation
    public int getSizeInBytes() {
        return 4;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSI.PATProgram
    public void setPID(int i) {
        this.pid = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSI.PATProgram
    public void setProgramNumber(int i) {
        this.program_number = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation
    public byte[] toByteArray() {
        BitOutputStream bitOutputStream = new BitOutputStream(32);
        bitOutputStream.writeFromLSB(this.program_number, 16);
        bitOutputStream.writeFromLSB((byte) 0, 3);
        bitOutputStream.writeFromLSB(this.pid, 13);
        return bitOutputStream.toByteArray();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.XMLRepresentation
    public String toXMLString(int i) {
        String str;
        String str2 = new String() + MyUTIL.whiteSpaceStr(i) + "<PATProgram>\n";
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        int i2 = i + 2;
        sb.append(MyUTIL.whiteSpaceStr(i2));
        sb.append("<program_number>");
        sb.append(this.program_number);
        sb.append("</program_number>\n");
        String string = sb.toString();
        if (this.program_number == 0) {
            str = string + MyUTIL.whiteSpaceStr(i2) + "<network_PID>" + this.pid + "</network_PID>\n";
        } else {
            str = string + MyUTIL.whiteSpaceStr(i2) + "<program_map_PID>" + this.pid + "</program_map_PID>\n";
        }
        return str + MyUTIL.whiteSpaceStr(i) + "</PATProgram>\n";
    }
}
