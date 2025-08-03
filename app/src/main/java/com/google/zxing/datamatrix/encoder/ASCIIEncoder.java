package com.google.zxing.datamatrix.encoder;

/* loaded from: classes2.dex */
final class ASCIIEncoder implements Encoder {
    private static char encodeASCIIDigits(char c, char c2) {
        if (HighLevelEncoder.isDigit(c) && HighLevelEncoder.isDigit(c2)) {
            return (char) (((c - '0') * 10) + (c2 - '0') + 130);
        }
        throw new IllegalArgumentException("not digits: " + c + c2);
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void encode(EncoderContext encoderContext) {
        if (HighLevelEncoder.determineConsecutiveDigitCount(encoderContext.getMessage(), encoderContext.pos) >= 2) {
            encoderContext.writeCodeword(encodeASCIIDigits(encoderContext.getMessage().charAt(encoderContext.pos), encoderContext.getMessage().charAt(encoderContext.pos + 1)));
            encoderContext.pos += 2;
            return;
        }
        char currentChar = encoderContext.getCurrentChar();
        int iLookAheadTest = HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode());
        if (iLookAheadTest == getEncodingMode()) {
            if (!HighLevelEncoder.isExtendedASCII(currentChar)) {
                encoderContext.writeCodeword((char) (currentChar + 1));
                encoderContext.pos++;
                return;
            } else {
                encoderContext.writeCodeword(HighLevelEncoder.UPPER_SHIFT);
                encoderContext.writeCodeword((char) ((currentChar - 128) + 1));
                encoderContext.pos++;
                return;
            }
        }
        if (iLookAheadTest == 1) {
            encoderContext.writeCodeword(HighLevelEncoder.LATCH_TO_C40);
            encoderContext.signalEncoderChange(1);
            return;
        }
        if (iLookAheadTest == 2) {
            encoderContext.writeCodeword(HighLevelEncoder.LATCH_TO_TEXT);
            encoderContext.signalEncoderChange(2);
            return;
        }
        if (iLookAheadTest == 3) {
            encoderContext.writeCodeword(HighLevelEncoder.LATCH_TO_ANSIX12);
            encoderContext.signalEncoderChange(3);
        } else if (iLookAheadTest == 4) {
            encoderContext.writeCodeword(HighLevelEncoder.LATCH_TO_EDIFACT);
            encoderContext.signalEncoderChange(4);
        } else if (iLookAheadTest == 5) {
            encoderContext.writeCodeword(HighLevelEncoder.LATCH_TO_BASE256);
            encoderContext.signalEncoderChange(5);
        } else {
            throw new IllegalStateException("Illegal mode: " + iLookAheadTest);
        }
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        return 0;
    }
}
