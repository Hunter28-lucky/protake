package org.jcodec.codecs.h264.io.model;

import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class RefPicMarking {
    private Instruction[] instructions;

    public enum InstrType {
        REMOVE_SHORT,
        REMOVE_LONG,
        CONVERT_INTO_LONG,
        TRUNK_LONG,
        CLEAR,
        MARK_LONG
    }

    public static class Instruction {
        private int arg1;
        private int arg2;
        private InstrType type;

        public Instruction(InstrType instrType, int i, int i2) {
            this.type = instrType;
            this.arg1 = i;
            this.arg2 = i2;
        }

        public int getArg1() {
            return this.arg1;
        }

        public int getArg2() {
            return this.arg2;
        }

        public InstrType getType() {
            return this.type;
        }
    }

    public RefPicMarking(Instruction[] instructionArr) {
        this.instructions = instructionArr;
    }

    public Instruction[] getInstructions() {
        return this.instructions;
    }

    public String toString() {
        return Platform.toJSON(this);
    }
}
