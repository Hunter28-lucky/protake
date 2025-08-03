package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.model.Rational;

/* loaded from: classes2.dex */
public class GenericPictureEssenceDescriptor extends FileDescriptor {
    private byte activeFormatDescriptor;
    private byte alphaTransparency;
    private Rational aspectRatio;
    private UL codingEquations;
    private UL colorPrimaries;
    private int displayF2Offset;
    private int displayHeight;
    private int displayWidth;
    private int displayXOffset;
    private int displayYOffset;
    private byte fieldDominance;
    private LayoutType frameLayout;
    private int imageAlignmentOffset;
    private int imageEndOffset;
    private int imageStartOffset;
    private UL pictureEssenceCoding;
    private int sampledHeight;
    private int sampledWidth;
    private int sampledXOffset;
    private int sampledYOffset;
    private byte signalStandard;
    private int storedF2Offset;
    private int storedHeight;
    private int storedWidth;
    private UL transferCharacteristic;
    private int[] videoLineMap;

    public enum LayoutType {
        FullFrame,
        SeparateFields,
        OneField,
        MixedFields,
        SegmentedFrame
    }

    public GenericPictureEssenceDescriptor(UL ul) {
        super(ul);
    }

    public byte getActiveFormatDescriptor() {
        return this.activeFormatDescriptor;
    }

    public byte getAlphaTransparency() {
        return this.alphaTransparency;
    }

    public Rational getAspectRatio() {
        return this.aspectRatio;
    }

    public UL getCodingEquations() {
        return this.codingEquations;
    }

    public UL getColorPrimaries() {
        return this.colorPrimaries;
    }

    public int getDisplayF2Offset() {
        return this.displayF2Offset;
    }

    public int getDisplayHeight() {
        return this.displayHeight;
    }

    public int getDisplayWidth() {
        return this.displayWidth;
    }

    public int getDisplayXOffset() {
        return this.displayXOffset;
    }

    public int getDisplayYOffset() {
        return this.displayYOffset;
    }

    public byte getFieldDominance() {
        return this.fieldDominance;
    }

    public LayoutType getFrameLayout() {
        return this.frameLayout;
    }

    public int getImageAlignmentOffset() {
        return this.imageAlignmentOffset;
    }

    public int getImageEndOffset() {
        return this.imageEndOffset;
    }

    public int getImageStartOffset() {
        return this.imageStartOffset;
    }

    public UL getPictureEssenceCoding() {
        return this.pictureEssenceCoding;
    }

    public int getSampledHeight() {
        return this.sampledHeight;
    }

    public int getSampledWidth() {
        return this.sampledWidth;
    }

    public int getSampledXOffset() {
        return this.sampledXOffset;
    }

    public int getSampledYOffset() {
        return this.sampledYOffset;
    }

    public byte getSignalStandard() {
        return this.signalStandard;
    }

    public int getStoredF2Offset() {
        return this.storedF2Offset;
    }

    public int getStoredHeight() {
        return this.storedHeight;
    }

    public int getStoredWidth() {
        return this.storedWidth;
    }

    public UL getTransferCharacteristic() {
        return this.transferCharacteristic;
    }

    public int[] getVideoLineMap() {
        return this.videoLineMap;
    }

    @Override // org.jcodec.containers.mxf.model.FileDescriptor, org.jcodec.containers.mxf.model.GenericDescriptor, org.jcodec.containers.mxf.model.MXFInterchangeObject
    public void read(Map<Integer, ByteBuffer> map) {
        super.read(map);
        Iterator<Map.Entry<Integer, ByteBuffer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, ByteBuffer> next = it.next();
            ByteBuffer value = next.getValue();
            switch (next.getKey().intValue()) {
                case 12801:
                    this.pictureEssenceCoding = UL.read(value);
                    break;
                case 12802:
                    this.storedHeight = value.getInt();
                    break;
                case 12803:
                    this.storedWidth = value.getInt();
                    break;
                case 12804:
                    this.sampledHeight = value.getInt();
                    break;
                case 12805:
                    this.sampledWidth = value.getInt();
                    break;
                case 12806:
                    this.sampledXOffset = value.getInt();
                    break;
                case 12807:
                    this.sampledYOffset = value.getInt();
                    break;
                case 12808:
                    this.displayHeight = value.getInt();
                    break;
                case 12809:
                    this.displayWidth = value.getInt();
                    break;
                case 12810:
                    this.displayXOffset = value.getInt();
                    break;
                case 12811:
                    this.displayYOffset = value.getInt();
                    break;
                case 12812:
                    this.frameLayout = LayoutType.values()[value.get()];
                    break;
                case 12813:
                    this.videoLineMap = MXFMetadata.readInt32Batch(value);
                    break;
                case 12814:
                    this.aspectRatio = new Rational(value.getInt(), value.getInt());
                    break;
                case 12815:
                    this.alphaTransparency = value.get();
                    break;
                case 12816:
                    this.transferCharacteristic = UL.read(value);
                    break;
                case 12817:
                    this.imageAlignmentOffset = value.getInt();
                    break;
                case 12818:
                    this.fieldDominance = value.get();
                    break;
                case 12819:
                    this.imageStartOffset = value.getInt();
                    break;
                case 12820:
                    this.imageEndOffset = value.getInt();
                    break;
                case 12821:
                    this.signalStandard = value.get();
                    break;
                case 12822:
                    this.storedF2Offset = value.getInt();
                    break;
                case 12823:
                    this.displayF2Offset = value.getInt();
                    break;
                case 12824:
                    this.activeFormatDescriptor = value.get();
                    break;
                case 12825:
                    this.colorPrimaries = UL.read(value);
                    break;
                case 12826:
                    this.codingEquations = UL.read(value);
                    break;
                default:
                    Logger.warn(String.format("Unknown tag [ " + this.ul + "]: %04x", next.getKey()));
                    continue;
            }
            it.remove();
        }
    }
}
