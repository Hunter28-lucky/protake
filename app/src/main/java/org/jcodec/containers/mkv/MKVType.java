package org.jcodec.containers.mkv;

import androidx.exifinterface.media.ExifInterface;
import com.blink.academy.film.support.stream.ts.TsConstants;
import com.umeng.analytics.pro.cb;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jcodec.containers.mkv.boxes.EbmlBase;
import org.jcodec.containers.mkv.boxes.EbmlBin;
import org.jcodec.containers.mkv.boxes.EbmlDate;
import org.jcodec.containers.mkv.boxes.EbmlFloat;
import org.jcodec.containers.mkv.boxes.EbmlMaster;
import org.jcodec.containers.mkv.boxes.EbmlSint;
import org.jcodec.containers.mkv.boxes.EbmlString;
import org.jcodec.containers.mkv.boxes.EbmlUint;
import org.jcodec.containers.mkv.boxes.EbmlVoid;
import org.jcodec.containers.mkv.boxes.MkvBlock;
import org.jcodec.containers.mkv.boxes.MkvSegment;
import org.jcodec.containers.mkv.util.EbmlUtil;
import org.jcodec.containers.mxf.model.BER;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public final class MKVType {
    public static final MKVType AlphaMode;
    public static final MKVType AspectRatioType;
    public static final MKVType AttachedFile;
    public static final MKVType AttachmentLink;
    public static final MKVType Attachments;
    public static final MKVType Audio;
    public static final MKVType BitDepth;
    public static final MKVType Block;
    public static final MKVType BlockAddID;
    public static final MKVType BlockAdditional;
    public static final MKVType BlockAdditions;
    public static final MKVType BlockDuration;
    public static final MKVType BlockGroup;
    public static final MKVType BlockMore;
    public static final MKVType Channels;
    public static final MKVType ChapCountry;
    public static final MKVType ChapLanguage;
    public static final MKVType ChapProcess;
    public static final MKVType ChapProcessCodecID;
    public static final MKVType ChapProcessCommand;
    public static final MKVType ChapProcessData;
    public static final MKVType ChapProcessPrivate;
    public static final MKVType ChapProcessTime;
    public static final MKVType ChapString;
    public static final MKVType ChapterAtom;
    public static final MKVType ChapterDisplay;
    public static final MKVType ChapterFlagEnabled;
    public static final MKVType ChapterFlagHidden;
    public static final MKVType ChapterPhysicalEquiv;
    public static final MKVType ChapterSegmentEditionUID;
    public static final MKVType ChapterSegmentUID;
    public static final MKVType ChapterStringUID;
    public static final MKVType ChapterTimeEnd;
    public static final MKVType ChapterTimeStart;
    public static final MKVType ChapterTrack;
    public static final MKVType ChapterTrackNumber;
    public static final MKVType ChapterTranslate;
    public static final MKVType ChapterTranslateCodec;
    public static final MKVType ChapterTranslateEditionUID;
    public static final MKVType ChapterTranslateID;
    public static final MKVType ChapterUID;
    public static final MKVType Chapters;
    public static final MKVType Cluster;
    public static final MKVType CodecDecodeAll;
    public static final MKVType CodecID;
    public static final MKVType CodecName;
    public static final MKVType CodecPrivate;
    public static final MKVType CodecState;
    public static final MKVType ColourSpace;
    public static final MKVType ContentCompAlgo;
    public static final MKVType ContentCompSettings;
    public static final MKVType ContentCompression;
    public static final MKVType ContentEncAlgo;
    public static final MKVType ContentEncKeyID;
    public static final MKVType ContentEncoding;
    public static final MKVType ContentEncodingOrder;
    public static final MKVType ContentEncodingScope;
    public static final MKVType ContentEncodingType;
    public static final MKVType ContentEncodings;
    public static final MKVType ContentEncryption;
    public static final MKVType ContentSigAlgo;
    public static final MKVType ContentSigHashAlgo;
    public static final MKVType ContentSigKeyID;
    public static final MKVType ContentSignature;
    public static final MKVType CueBlockNumber;
    public static final MKVType CueClusterPosition;
    public static final MKVType CueCodecState;
    public static final MKVType CueDuration;
    public static final MKVType CuePoint;
    public static final MKVType CueRefTime;
    public static final MKVType CueReference;
    public static final MKVType CueRelativePosition;
    public static final MKVType CueTime;
    public static final MKVType CueTrack;
    public static final MKVType CueTrackPositions;
    public static final MKVType Cues;
    public static final MKVType DateUTC;
    public static final MKVType DefaultDuration;
    public static final MKVType DisplayHeight;
    public static final MKVType DisplayUnit;
    public static final MKVType DisplayWidth;
    public static final MKVType DocType;
    public static final MKVType DocTypeReadVersion;
    public static final MKVType DocTypeVersion;
    public static final MKVType Duration;
    public static final MKVType EBML;
    public static final MKVType EBMLMaxIDLength;
    public static final MKVType EBMLMaxSizeLength;
    public static final MKVType EBMLReadVersion;
    public static final MKVType EBMLVersion;
    public static final MKVType EditionEntry;
    public static final MKVType EditionFlagDefault;
    public static final MKVType EditionFlagHidden;
    public static final MKVType EditionFlagOrdered;
    public static final MKVType EditionUID;
    public static final MKVType FileData;
    public static final MKVType FileDescription;
    public static final MKVType FileMimeType;
    public static final MKVType FileName;
    public static final MKVType FileUID;
    public static final MKVType FlagDefault;
    public static final MKVType FlagEnabled;
    public static final MKVType FlagForced;
    public static final MKVType FlagInterlaced;
    public static final MKVType FlagLacing;
    public static final MKVType Info;
    public static final MKVType LaceNumber;
    public static final MKVType Language;
    public static final MKVType MaxBlockAdditionID;
    public static final MKVType MaxCache;
    public static final MKVType MinCache;
    public static final MKVType MuxingApp;
    public static final MKVType Name;
    public static final MKVType NextFilenam;
    public static final MKVType NextUID;
    public static final MKVType OutputSamplingFrequency;
    public static final MKVType PixelCropBottom;
    public static final MKVType PixelCropLeft;
    public static final MKVType PixelCropRight;
    public static final MKVType PixelCropTop;
    public static final MKVType PixelHeight;
    public static final MKVType PixelWidth;
    public static final MKVType Position;
    public static final MKVType PrevFilename;
    public static final MKVType PrevSize;
    public static final MKVType PrevUID;
    public static final MKVType ReferenceBlock;
    public static final MKVType ReferencePriority;
    public static final MKVType SamplingFrequency;
    public static final MKVType Seek;
    public static final MKVType SeekHead;
    public static final MKVType SeekID;
    public static final MKVType SeekPosition;
    public static final MKVType Segment;
    public static final MKVType SegmentFamily;
    public static final MKVType SegmentFilename;
    public static final MKVType SegmentUID;
    public static final MKVType SilentTrackNumber;
    public static final MKVType SilentTracks;
    public static final MKVType SimpleBlock;
    public static final MKVType SimpleTag;
    public static final MKVType Slices;
    public static final MKVType StereoMode;
    public static final MKVType Tag;
    public static final MKVType TagAttachmentUID;
    public static final MKVType TagBinary;
    public static final MKVType TagChapterUID;
    public static final MKVType TagDefault;
    public static final MKVType TagEditionUID;
    public static final MKVType TagLanguage;
    public static final MKVType TagName;
    public static final MKVType TagString;
    public static final MKVType TagTrackUID;
    public static final MKVType Tags;
    public static final MKVType TargetType;
    public static final MKVType TargetTypeValue;
    public static final MKVType Targets;
    public static final MKVType TimeSlice;
    public static final MKVType Timecode;
    public static final MKVType TimecodeScale;
    public static final MKVType Title;
    public static final MKVType TrackCombinePlanes;
    public static final MKVType TrackEntry;
    public static final MKVType TrackJoinBlocks;
    public static final MKVType TrackJoinUID;
    public static final MKVType TrackNumber;
    public static final MKVType TrackOperation;
    public static final MKVType TrackOverlay;
    public static final MKVType TrackPlane;
    public static final MKVType TrackPlaneType;
    public static final MKVType TrackPlaneUID;
    public static final MKVType TrackTranslate;
    public static final MKVType TrackTranslateCodec;
    public static final MKVType TrackTranslateEditionUID;
    public static final MKVType TrackTranslateTrackID;
    public static final MKVType TrackType;
    public static final MKVType TrackUID;
    public static final MKVType Tracks;
    public static final MKVType Video;
    public static final MKVType WritingApp;
    public static final Map<MKVType, Set<MKVType>> children;
    public static MKVType[] firstLevelHeaders;
    private String _name;
    public final Class<? extends EbmlBase> clazz;
    public final byte[] id;
    private static final List<MKVType> _values = new ArrayList();
    public static final MKVType Void = new MKVType("Void", new byte[]{-20}, EbmlVoid.class);
    public static final MKVType CRC32 = new MKVType("CRC32", new byte[]{-65}, EbmlBin.class);

    static {
        MKVType mKVType = new MKVType("EBML", new byte[]{26, 69, -33, -93}, EbmlMaster.class);
        EBML = mKVType;
        MKVType mKVType2 = new MKVType("EBMLVersion", new byte[]{66, -122}, EbmlUint.class);
        EBMLVersion = mKVType2;
        MKVType mKVType3 = new MKVType("EBMLReadVersion", new byte[]{66, -9}, EbmlUint.class);
        EBMLReadVersion = mKVType3;
        MKVType mKVType4 = new MKVType("EBMLMaxIDLength", new byte[]{66, -14}, EbmlUint.class);
        EBMLMaxIDLength = mKVType4;
        MKVType mKVType5 = new MKVType("EBMLMaxSizeLength", new byte[]{66, -13}, EbmlUint.class);
        EBMLMaxSizeLength = mKVType5;
        MKVType mKVType6 = new MKVType("DocType", new byte[]{66, -126}, EbmlString.class);
        DocType = mKVType6;
        MKVType mKVType7 = new MKVType("DocTypeVersion", new byte[]{66, -121}, EbmlUint.class);
        DocTypeVersion = mKVType7;
        MKVType mKVType8 = new MKVType("DocTypeReadVersion", new byte[]{66, -123}, EbmlUint.class);
        DocTypeReadVersion = mKVType8;
        MKVType mKVType9 = new MKVType("Segment", MkvSegment.SEGMENT_ID, MkvSegment.class);
        Segment = mKVType9;
        MKVType mKVType10 = new MKVType("SeekHead", new byte[]{17, 77, -101, 116}, EbmlMaster.class);
        SeekHead = mKVType10;
        MKVType mKVType11 = new MKVType("Seek", new byte[]{77, -69}, EbmlMaster.class);
        Seek = mKVType11;
        MKVType mKVType12 = new MKVType("SeekID", new byte[]{83, -85}, EbmlBin.class);
        SeekID = mKVType12;
        MKVType mKVType13 = new MKVType("SeekPosition", new byte[]{83, -84}, EbmlUint.class);
        SeekPosition = mKVType13;
        MKVType mKVType14 = new MKVType("Info", new byte[]{21, 73, -87, 102}, EbmlMaster.class);
        Info = mKVType14;
        MKVType mKVType15 = new MKVType("SegmentUID", new byte[]{115, -92}, EbmlBin.class);
        SegmentUID = mKVType15;
        MKVType mKVType16 = new MKVType("SegmentFilename", new byte[]{115, -124}, EbmlString.class);
        SegmentFilename = mKVType16;
        MKVType mKVType17 = new MKVType("PrevUID", new byte[]{60, -71, 35}, EbmlBin.class);
        PrevUID = mKVType17;
        MKVType mKVType18 = new MKVType("PrevFilename", new byte[]{60, -125, -85}, EbmlString.class);
        PrevFilename = mKVType18;
        MKVType mKVType19 = new MKVType("NextUID", new byte[]{62, -71, 35}, EbmlBin.class);
        NextUID = mKVType19;
        MKVType mKVType20 = new MKVType("NextFilenam", new byte[]{62, -125, -69}, EbmlString.class);
        NextFilenam = mKVType20;
        MKVType mKVType21 = new MKVType("SegmentFamily", new byte[]{68, 68}, EbmlBin.class);
        SegmentFamily = mKVType21;
        MKVType mKVType22 = new MKVType("ChapterTranslate", new byte[]{105, TsConstants.ACESType_h265}, EbmlMaster.class);
        ChapterTranslate = mKVType22;
        MKVType mKVType23 = new MKVType("ChapterTranslateEditionUID", new byte[]{105, -4}, EbmlUint.class);
        ChapterTranslateEditionUID = mKVType23;
        MKVType mKVType24 = new MKVType("ChapterTranslateCodec", new byte[]{105, -65}, EbmlUint.class);
        ChapterTranslateCodec = mKVType24;
        MKVType mKVType25 = new MKVType("ChapterTranslateID", new byte[]{105, -91}, EbmlBin.class);
        ChapterTranslateID = mKVType25;
        MKVType mKVType26 = new MKVType("TimecodeScale", new byte[]{ExifInterface.START_CODE, -41, -79}, EbmlUint.class);
        TimecodeScale = mKVType26;
        MKVType mKVType27 = new MKVType("Duration", new byte[]{68, -119}, EbmlFloat.class);
        Duration = mKVType27;
        MKVType mKVType28 = new MKVType("DateUTC", new byte[]{68, 97}, EbmlDate.class);
        DateUTC = mKVType28;
        MKVType mKVType29 = new MKVType("Title", new byte[]{123, -87}, EbmlString.class);
        Title = mKVType29;
        MKVType mKVType30 = new MKVType("MuxingApp", new byte[]{77, BER.ASN_LONG_LEN}, EbmlString.class);
        MuxingApp = mKVType30;
        MKVType mKVType31 = new MKVType("WritingApp", new byte[]{87, 65}, EbmlString.class);
        WritingApp = mKVType31;
        MKVType mKVType32 = new MKVType("Cluster", EbmlMaster.CLUSTER_ID, EbmlMaster.class);
        Cluster = mKVType32;
        MKVType mKVType33 = new MKVType("Timecode", new byte[]{-25}, EbmlUint.class);
        Timecode = mKVType33;
        MKVType mKVType34 = new MKVType("SilentTracks", new byte[]{88, 84}, EbmlMaster.class);
        SilentTracks = mKVType34;
        MKVType mKVType35 = new MKVType("SilentTrackNumber", new byte[]{88, -41}, EbmlUint.class);
        SilentTrackNumber = mKVType35;
        MKVType mKVType36 = new MKVType("Position", new byte[]{-89}, EbmlUint.class);
        Position = mKVType36;
        MKVType mKVType37 = new MKVType("PrevSize", new byte[]{-85}, EbmlUint.class);
        PrevSize = mKVType37;
        MKVType mKVType38 = new MKVType("SimpleBlock", MkvBlock.SIMPLEBLOCK_ID, MkvBlock.class);
        SimpleBlock = mKVType38;
        MKVType mKVType39 = new MKVType("BlockGroup", new byte[]{-96}, EbmlMaster.class);
        BlockGroup = mKVType39;
        MKVType mKVType40 = new MKVType("Block", MkvBlock.BLOCK_ID, MkvBlock.class);
        Block = mKVType40;
        MKVType mKVType41 = new MKVType("BlockAdditions", new byte[]{117, -95}, EbmlMaster.class);
        BlockAdditions = mKVType41;
        MKVType mKVType42 = new MKVType("BlockMore", new byte[]{-90}, EbmlMaster.class);
        BlockMore = mKVType42;
        MKVType mKVType43 = new MKVType("BlockAddID", new byte[]{-18}, EbmlUint.class);
        BlockAddID = mKVType43;
        MKVType mKVType44 = new MKVType("BlockAdditional", new byte[]{-91}, EbmlBin.class);
        BlockAdditional = mKVType44;
        MKVType mKVType45 = new MKVType("BlockDuration", new byte[]{-101}, EbmlUint.class);
        BlockDuration = mKVType45;
        MKVType mKVType46 = new MKVType("ReferencePriority", new byte[]{-6}, EbmlUint.class);
        ReferencePriority = mKVType46;
        MKVType mKVType47 = new MKVType("ReferenceBlock", new byte[]{-5}, EbmlSint.class);
        ReferenceBlock = mKVType47;
        MKVType mKVType48 = new MKVType("CodecState", new byte[]{-92}, EbmlBin.class);
        CodecState = mKVType48;
        MKVType mKVType49 = new MKVType("Slices", new byte[]{-114}, EbmlMaster.class);
        Slices = mKVType49;
        MKVType mKVType50 = new MKVType("TimeSlice", new byte[]{-24}, EbmlMaster.class);
        TimeSlice = mKVType50;
        MKVType mKVType51 = new MKVType("LaceNumber", new byte[]{-52}, EbmlUint.class);
        LaceNumber = mKVType51;
        MKVType mKVType52 = new MKVType("Tracks", new byte[]{22, 84, -82, 107}, EbmlMaster.class);
        Tracks = mKVType52;
        MKVType mKVType53 = new MKVType("TrackEntry", new byte[]{-82}, EbmlMaster.class);
        TrackEntry = mKVType53;
        MKVType mKVType54 = new MKVType("TrackNumber", new byte[]{-41}, EbmlUint.class);
        TrackNumber = mKVType54;
        MKVType mKVType55 = new MKVType("TrackUID", new byte[]{115, -59}, EbmlUint.class);
        TrackUID = mKVType55;
        MKVType mKVType56 = new MKVType("TrackType", new byte[]{-125}, EbmlUint.class);
        TrackType = mKVType56;
        FlagEnabled = new MKVType("FlagEnabled", new byte[]{-71}, EbmlUint.class);
        MKVType mKVType57 = new MKVType("FlagDefault", new byte[]{-120}, EbmlUint.class);
        FlagDefault = mKVType57;
        MKVType mKVType58 = new MKVType("FlagForced", new byte[]{85, -86}, EbmlUint.class);
        FlagForced = mKVType58;
        MKVType mKVType59 = new MKVType("FlagLacing", new byte[]{-100}, EbmlUint.class);
        FlagLacing = mKVType59;
        MKVType mKVType60 = new MKVType("MinCache", new byte[]{109, -25}, EbmlUint.class);
        MinCache = mKVType60;
        MKVType mKVType61 = new MKVType("MaxCache", new byte[]{109, -8}, EbmlUint.class);
        MaxCache = mKVType61;
        MKVType mKVType62 = new MKVType("DefaultDuration", new byte[]{35, -29, -125}, EbmlUint.class);
        DefaultDuration = mKVType62;
        MKVType mKVType63 = new MKVType("MaxBlockAdditionID", new byte[]{85, -18}, EbmlUint.class);
        MaxBlockAdditionID = mKVType63;
        MKVType mKVType64 = new MKVType("Name", new byte[]{83, 110}, EbmlString.class);
        Name = mKVType64;
        MKVType mKVType65 = new MKVType("Language", new byte[]{34, -75, -100}, EbmlString.class);
        Language = mKVType65;
        MKVType mKVType66 = new MKVType("CodecID", new byte[]{-122}, EbmlString.class);
        CodecID = mKVType66;
        MKVType mKVType67 = new MKVType("CodecPrivate", new byte[]{99, -94}, EbmlBin.class);
        CodecPrivate = mKVType67;
        MKVType mKVType68 = new MKVType("CodecName", new byte[]{37, -122, -120}, EbmlString.class);
        CodecName = mKVType68;
        MKVType mKVType69 = new MKVType("AttachmentLink", new byte[]{116, 70}, EbmlUint.class);
        AttachmentLink = mKVType69;
        MKVType mKVType70 = new MKVType("CodecDecodeAll", new byte[]{-86}, EbmlUint.class);
        CodecDecodeAll = mKVType70;
        MKVType mKVType71 = new MKVType("TrackOverlay", new byte[]{111, -85}, EbmlUint.class);
        TrackOverlay = mKVType71;
        MKVType mKVType72 = new MKVType("TrackTranslate", new byte[]{102, TsConstants.ACESType_h265}, EbmlMaster.class);
        TrackTranslate = mKVType72;
        MKVType mKVType73 = new MKVType("TrackTranslateEditionUID", new byte[]{102, -4}, EbmlUint.class);
        TrackTranslateEditionUID = mKVType73;
        MKVType mKVType74 = new MKVType("TrackTranslateCodec", new byte[]{102, -65}, EbmlUint.class);
        TrackTranslateCodec = mKVType74;
        MKVType mKVType75 = new MKVType("TrackTranslateTrackID", new byte[]{102, -91}, EbmlBin.class);
        TrackTranslateTrackID = mKVType75;
        MKVType mKVType76 = new MKVType("Video", new byte[]{-32}, EbmlMaster.class);
        Video = mKVType76;
        MKVType mKVType77 = new MKVType("FlagInterlaced", new byte[]{-102}, EbmlUint.class);
        FlagInterlaced = mKVType77;
        MKVType mKVType78 = new MKVType("StereoMode", new byte[]{83, -72}, EbmlUint.class);
        StereoMode = mKVType78;
        MKVType mKVType79 = new MKVType("AlphaMode", new byte[]{83, -64}, EbmlUint.class);
        AlphaMode = mKVType79;
        MKVType mKVType80 = new MKVType("PixelWidth", new byte[]{-80}, EbmlUint.class);
        PixelWidth = mKVType80;
        MKVType mKVType81 = new MKVType("PixelHeight", new byte[]{-70}, EbmlUint.class);
        PixelHeight = mKVType81;
        MKVType mKVType82 = new MKVType("PixelCropBottom", new byte[]{84, -86}, EbmlUint.class);
        PixelCropBottom = mKVType82;
        MKVType mKVType83 = new MKVType("PixelCropTop", new byte[]{84, -69}, EbmlUint.class);
        PixelCropTop = mKVType83;
        MKVType mKVType84 = new MKVType("PixelCropLeft", new byte[]{84, -52}, EbmlUint.class);
        PixelCropLeft = mKVType84;
        MKVType mKVType85 = new MKVType("PixelCropRight", new byte[]{84, -35}, EbmlUint.class);
        PixelCropRight = mKVType85;
        MKVType mKVType86 = new MKVType("DisplayWidth", new byte[]{84, -80}, EbmlUint.class);
        DisplayWidth = mKVType86;
        MKVType mKVType87 = new MKVType("DisplayHeight", new byte[]{84, -70}, EbmlUint.class);
        DisplayHeight = mKVType87;
        MKVType mKVType88 = new MKVType("DisplayUnit", new byte[]{84, -78}, EbmlUint.class);
        DisplayUnit = mKVType88;
        MKVType mKVType89 = new MKVType("AspectRatioType", new byte[]{84, -77}, EbmlUint.class);
        AspectRatioType = mKVType89;
        MKVType mKVType90 = new MKVType("ColourSpace", new byte[]{46, -75, TsConstants.ACESType_h265}, EbmlBin.class);
        ColourSpace = mKVType90;
        MKVType mKVType91 = new MKVType("Audio", new byte[]{ExifInterface.MARKER_APP1}, EbmlMaster.class);
        Audio = mKVType91;
        MKVType mKVType92 = new MKVType("SamplingFrequency", new byte[]{-75}, EbmlFloat.class);
        SamplingFrequency = mKVType92;
        MKVType mKVType93 = new MKVType("OutputSamplingFrequency", new byte[]{120, -75}, EbmlFloat.class);
        OutputSamplingFrequency = mKVType93;
        MKVType mKVType94 = new MKVType("Channels", new byte[]{-97}, EbmlUint.class);
        Channels = mKVType94;
        MKVType mKVType95 = new MKVType("BitDepth", new byte[]{98, 100}, EbmlUint.class);
        BitDepth = mKVType95;
        MKVType mKVType96 = new MKVType("TrackOperation", new byte[]{-30}, EbmlMaster.class);
        TrackOperation = mKVType96;
        MKVType mKVType97 = new MKVType("TrackCombinePlanes", new byte[]{-29}, EbmlMaster.class);
        TrackCombinePlanes = mKVType97;
        MKVType mKVType98 = new MKVType("TrackPlane", new byte[]{-28}, EbmlMaster.class);
        TrackPlane = mKVType98;
        MKVType mKVType99 = new MKVType("TrackPlaneUID", new byte[]{-27}, EbmlUint.class);
        TrackPlaneUID = mKVType99;
        MKVType mKVType100 = new MKVType("TrackPlaneType", new byte[]{-26}, EbmlUint.class);
        TrackPlaneType = mKVType100;
        MKVType mKVType101 = new MKVType("TrackJoinBlocks", new byte[]{-23}, EbmlMaster.class);
        TrackJoinBlocks = mKVType101;
        MKVType mKVType102 = new MKVType("TrackJoinUID", new byte[]{-19}, EbmlUint.class);
        TrackJoinUID = mKVType102;
        MKVType mKVType103 = new MKVType("ContentEncodings", new byte[]{109, BER.ASN_LONG_LEN}, EbmlMaster.class);
        ContentEncodings = mKVType103;
        MKVType mKVType104 = new MKVType("ContentEncoding", new byte[]{98, TsConstants.ACESType_data}, EbmlMaster.class);
        ContentEncoding = mKVType104;
        MKVType mKVType105 = new MKVType("ContentEncodingOrder", new byte[]{80, 49}, EbmlUint.class);
        ContentEncodingOrder = mKVType105;
        MKVType mKVType106 = new MKVType("ContentEncodingScope", new byte[]{80, 50}, EbmlUint.class);
        ContentEncodingScope = mKVType106;
        MKVType mKVType107 = new MKVType("ContentEncodingType", new byte[]{80, 51}, EbmlUint.class);
        ContentEncodingType = mKVType107;
        MKVType mKVType108 = new MKVType("ContentCompression", new byte[]{80, 52}, EbmlMaster.class);
        ContentCompression = mKVType108;
        MKVType mKVType109 = new MKVType("ContentCompAlgo", new byte[]{66, 84}, EbmlUint.class);
        ContentCompAlgo = mKVType109;
        MKVType mKVType110 = new MKVType("ContentCompSettings", new byte[]{66, 85}, EbmlBin.class);
        ContentCompSettings = mKVType110;
        MKVType mKVType111 = new MKVType("ContentEncryption", new byte[]{80, 53}, EbmlMaster.class);
        ContentEncryption = mKVType111;
        MKVType mKVType112 = new MKVType("ContentEncAlgo", new byte[]{71, ExifInterface.MARKER_APP1}, EbmlUint.class);
        ContentEncAlgo = mKVType112;
        MKVType mKVType113 = new MKVType("ContentEncKeyID", new byte[]{71, -30}, EbmlBin.class);
        ContentEncKeyID = mKVType113;
        MKVType mKVType114 = new MKVType("ContentSignature", new byte[]{71, -29}, EbmlBin.class);
        ContentSignature = mKVType114;
        MKVType mKVType115 = new MKVType("ContentSigKeyID", new byte[]{71, -28}, EbmlBin.class);
        ContentSigKeyID = mKVType115;
        MKVType mKVType116 = new MKVType("ContentSigAlgo", new byte[]{71, -27}, EbmlUint.class);
        ContentSigAlgo = mKVType116;
        MKVType mKVType117 = new MKVType("ContentSigHashAlgo", new byte[]{71, -26}, EbmlUint.class);
        ContentSigHashAlgo = mKVType117;
        MKVType mKVType118 = new MKVType("Cues", new byte[]{28, 83, -69, 107}, EbmlMaster.class);
        Cues = mKVType118;
        MKVType mKVType119 = new MKVType("CuePoint", new byte[]{-69}, EbmlMaster.class);
        CuePoint = mKVType119;
        MKVType mKVType120 = new MKVType("CueTime", new byte[]{-77}, EbmlUint.class);
        CueTime = mKVType120;
        MKVType mKVType121 = new MKVType("CueTrackPositions", new byte[]{-73}, EbmlMaster.class);
        CueTrackPositions = mKVType121;
        MKVType mKVType122 = new MKVType("CueTrack", new byte[]{-9}, EbmlUint.class);
        CueTrack = mKVType122;
        MKVType mKVType123 = new MKVType("CueClusterPosition", new byte[]{-15}, EbmlUint.class);
        CueClusterPosition = mKVType123;
        MKVType mKVType124 = new MKVType("CueRelativePosition", new byte[]{-16}, EbmlUint.class);
        CueRelativePosition = mKVType124;
        MKVType mKVType125 = new MKVType("CueDuration", new byte[]{-78}, EbmlUint.class);
        CueDuration = mKVType125;
        MKVType mKVType126 = new MKVType("CueBlockNumber", new byte[]{83, 120}, EbmlUint.class);
        CueBlockNumber = mKVType126;
        MKVType mKVType127 = new MKVType("CueCodecState", new byte[]{-22}, EbmlUint.class);
        CueCodecState = mKVType127;
        MKVType mKVType128 = new MKVType("CueReference", new byte[]{-37}, EbmlMaster.class);
        CueReference = mKVType128;
        MKVType mKVType129 = new MKVType("CueRefTime", new byte[]{-106}, EbmlUint.class);
        CueRefTime = mKVType129;
        MKVType mKVType130 = new MKVType("Attachments", new byte[]{25, 65, -92, 105}, EbmlMaster.class);
        Attachments = mKVType130;
        MKVType mKVType131 = new MKVType("AttachedFile", new byte[]{97, -89}, EbmlMaster.class);
        AttachedFile = mKVType131;
        MKVType mKVType132 = new MKVType("FileDescription", new byte[]{70, 126}, EbmlString.class);
        FileDescription = mKVType132;
        MKVType mKVType133 = new MKVType("FileName", new byte[]{70, 110}, EbmlString.class);
        FileName = mKVType133;
        MKVType mKVType134 = new MKVType("FileMimeType", new byte[]{70, 96}, EbmlString.class);
        FileMimeType = mKVType134;
        MKVType mKVType135 = new MKVType("FileData", new byte[]{70, 92}, EbmlBin.class);
        FileData = mKVType135;
        MKVType mKVType136 = new MKVType("FileUID", new byte[]{70, -82}, EbmlUint.class);
        FileUID = mKVType136;
        MKVType mKVType137 = new MKVType("Chapters", new byte[]{cb.n, 67, -89, 112}, EbmlMaster.class);
        Chapters = mKVType137;
        MKVType mKVType138 = new MKVType("EditionEntry", new byte[]{69, -71}, EbmlMaster.class);
        EditionEntry = mKVType138;
        MKVType mKVType139 = new MKVType("EditionUID", new byte[]{69, -68}, EbmlUint.class);
        EditionUID = mKVType139;
        MKVType mKVType140 = new MKVType("EditionFlagHidden", new byte[]{69, -67}, EbmlUint.class);
        EditionFlagHidden = mKVType140;
        MKVType mKVType141 = new MKVType("EditionFlagDefault", new byte[]{69, -37}, EbmlUint.class);
        EditionFlagDefault = mKVType141;
        MKVType mKVType142 = new MKVType("EditionFlagOrdered", new byte[]{69, -35}, EbmlUint.class);
        EditionFlagOrdered = mKVType142;
        MKVType mKVType143 = new MKVType("ChapterAtom", new byte[]{-74}, EbmlMaster.class);
        ChapterAtom = mKVType143;
        MKVType mKVType144 = new MKVType("ChapterUID", new byte[]{115, -60}, EbmlUint.class);
        ChapterUID = mKVType144;
        MKVType mKVType145 = new MKVType("ChapterStringUID", new byte[]{86, 84}, EbmlString.class);
        ChapterStringUID = mKVType145;
        MKVType mKVType146 = new MKVType("ChapterTimeStart", new byte[]{-111}, EbmlUint.class);
        ChapterTimeStart = mKVType146;
        MKVType mKVType147 = new MKVType("ChapterTimeEnd", new byte[]{-110}, EbmlUint.class);
        ChapterTimeEnd = mKVType147;
        MKVType mKVType148 = new MKVType("ChapterFlagHidden", new byte[]{-104}, EbmlUint.class);
        ChapterFlagHidden = mKVType148;
        MKVType mKVType149 = new MKVType("ChapterFlagEnabled", new byte[]{69, -104}, EbmlUint.class);
        ChapterFlagEnabled = mKVType149;
        MKVType mKVType150 = new MKVType("ChapterSegmentUID", new byte[]{110, 103}, EbmlBin.class);
        ChapterSegmentUID = mKVType150;
        MKVType mKVType151 = new MKVType("ChapterSegmentEditionUID", new byte[]{110, -68}, EbmlUint.class);
        ChapterSegmentEditionUID = mKVType151;
        MKVType mKVType152 = new MKVType("ChapterPhysicalEquiv", new byte[]{99, -61}, EbmlUint.class);
        ChapterPhysicalEquiv = mKVType152;
        MKVType mKVType153 = new MKVType("ChapterTrack", new byte[]{-113}, EbmlMaster.class);
        ChapterTrack = mKVType153;
        MKVType mKVType154 = new MKVType("ChapterTrackNumber", new byte[]{-119}, EbmlUint.class);
        ChapterTrackNumber = mKVType154;
        MKVType mKVType155 = new MKVType("ChapterDisplay", new byte[]{BER.ASN_LONG_LEN}, EbmlMaster.class);
        ChapterDisplay = mKVType155;
        MKVType mKVType156 = new MKVType("ChapString", new byte[]{-123}, EbmlString.class);
        ChapString = mKVType156;
        MKVType mKVType157 = new MKVType("ChapLanguage", new byte[]{67, 124}, EbmlString.class);
        ChapLanguage = mKVType157;
        MKVType mKVType158 = new MKVType("ChapCountry", new byte[]{67, 126}, EbmlString.class);
        ChapCountry = mKVType158;
        MKVType mKVType159 = new MKVType("ChapProcess", new byte[]{105, 68}, EbmlMaster.class);
        ChapProcess = mKVType159;
        MKVType mKVType160 = new MKVType("ChapProcessCodecID", new byte[]{105, 85}, EbmlUint.class);
        ChapProcessCodecID = mKVType160;
        MKVType mKVType161 = new MKVType("ChapProcessPrivate", new byte[]{69, cb.k}, EbmlBin.class);
        ChapProcessPrivate = mKVType161;
        MKVType mKVType162 = new MKVType("ChapProcessCommand", new byte[]{105, 17}, EbmlMaster.class);
        ChapProcessCommand = mKVType162;
        MKVType mKVType163 = new MKVType("ChapProcessTime", new byte[]{105, 34}, EbmlUint.class);
        ChapProcessTime = mKVType163;
        MKVType mKVType164 = new MKVType("ChapProcessData", new byte[]{105, 51}, EbmlBin.class);
        ChapProcessData = mKVType164;
        MKVType mKVType165 = new MKVType("Tags", new byte[]{18, 84, -61, 103}, EbmlMaster.class);
        Tags = mKVType165;
        MKVType mKVType166 = new MKVType("Tag", new byte[]{115, 115}, EbmlMaster.class);
        Tag = mKVType166;
        MKVType mKVType167 = new MKVType("Targets", new byte[]{99, -64}, EbmlMaster.class);
        Targets = mKVType167;
        MKVType mKVType168 = new MKVType("TargetTypeValue", new byte[]{104, -54}, EbmlUint.class);
        TargetTypeValue = mKVType168;
        MKVType mKVType169 = new MKVType("TargetType", new byte[]{99, -54}, EbmlString.class);
        TargetType = mKVType169;
        MKVType mKVType170 = new MKVType("TagTrackUID", new byte[]{99, -59}, EbmlUint.class);
        TagTrackUID = mKVType170;
        MKVType mKVType171 = new MKVType("TagEditionUID", new byte[]{99, -55}, EbmlUint.class);
        TagEditionUID = mKVType171;
        MKVType mKVType172 = new MKVType("TagChapterUID", new byte[]{99, -60}, EbmlUint.class);
        TagChapterUID = mKVType172;
        MKVType mKVType173 = new MKVType("TagAttachmentUID", new byte[]{99, -58}, EbmlUint.class);
        TagAttachmentUID = mKVType173;
        MKVType mKVType174 = new MKVType("SimpleTag", new byte[]{103, -56}, EbmlMaster.class);
        SimpleTag = mKVType174;
        MKVType mKVType175 = new MKVType("TagName", new byte[]{69, -93}, EbmlString.class);
        TagName = mKVType175;
        MKVType mKVType176 = new MKVType("TagLanguage", new byte[]{68, 122}, EbmlString.class);
        TagLanguage = mKVType176;
        MKVType mKVType177 = new MKVType("TagDefault", new byte[]{68, -124}, EbmlUint.class);
        TagDefault = mKVType177;
        MKVType mKVType178 = new MKVType("TagString", new byte[]{68, -121}, EbmlString.class);
        TagString = mKVType178;
        MKVType mKVType179 = new MKVType("TagBinary", new byte[]{68, -123}, EbmlBin.class);
        TagBinary = mKVType179;
        firstLevelHeaders = new MKVType[]{mKVType10, mKVType14, mKVType32, mKVType52, mKVType118, mKVType130, mKVType137, mKVType165, mKVType2, mKVType3, mKVType4, mKVType5, mKVType6, mKVType7, mKVType8};
        HashMap map = new HashMap();
        children = map;
        map.put(mKVType, new HashSet(Arrays.asList(mKVType2, mKVType3, mKVType4, mKVType5, mKVType6, mKVType7, mKVType8)));
        map.put(mKVType9, new HashSet(Arrays.asList(mKVType10, mKVType14, mKVType32, mKVType52, mKVType118, mKVType130, mKVType137, mKVType165)));
        map.put(mKVType10, new HashSet(Arrays.asList(mKVType11)));
        map.put(mKVType11, new HashSet(Arrays.asList(mKVType12, mKVType13)));
        map.put(mKVType14, new HashSet(Arrays.asList(mKVType15, mKVType16, mKVType17, mKVType18, mKVType19, mKVType20, mKVType21, mKVType22, mKVType26, mKVType27, mKVType28, mKVType29, mKVType30, mKVType31)));
        map.put(mKVType22, new HashSet(Arrays.asList(mKVType23, mKVType24, mKVType25)));
        map.put(mKVType32, new HashSet(Arrays.asList(mKVType33, mKVType34, mKVType36, mKVType37, mKVType38, mKVType39)));
        map.put(mKVType34, new HashSet(Arrays.asList(mKVType35)));
        map.put(mKVType39, new HashSet(Arrays.asList(mKVType40, mKVType41, mKVType45, mKVType46, mKVType47, mKVType48, mKVType49)));
        map.put(mKVType41, new HashSet(Arrays.asList(mKVType42)));
        map.put(mKVType42, new HashSet(Arrays.asList(mKVType43, mKVType44)));
        map.put(mKVType49, new HashSet(Arrays.asList(mKVType50)));
        map.put(mKVType50, new HashSet(Arrays.asList(mKVType51)));
        map.put(mKVType52, new HashSet(Arrays.asList(mKVType53)));
        map.put(mKVType53, new HashSet(Arrays.asList(mKVType54, mKVType55, mKVType56, mKVType56, mKVType57, mKVType58, mKVType59, mKVType60, mKVType61, mKVType62, mKVType63, mKVType64, mKVType65, mKVType66, mKVType67, mKVType68, mKVType69, mKVType70, mKVType71, mKVType72, mKVType76, mKVType91, mKVType96, mKVType103)));
        map.put(mKVType72, new HashSet(Arrays.asList(mKVType73, mKVType74, mKVType75)));
        map.put(mKVType76, new HashSet(Arrays.asList(mKVType77, mKVType78, mKVType79, mKVType80, mKVType81, mKVType82, mKVType83, mKVType84, mKVType85, mKVType86, mKVType87, mKVType88, mKVType89, mKVType90)));
        map.put(mKVType91, new HashSet(Arrays.asList(mKVType92, mKVType93, mKVType94, mKVType95)));
        map.put(mKVType96, new HashSet(Arrays.asList(mKVType97, mKVType101)));
        map.put(mKVType97, new HashSet(Arrays.asList(mKVType98)));
        map.put(mKVType98, new HashSet(Arrays.asList(mKVType99, mKVType100)));
        map.put(mKVType101, new HashSet(Arrays.asList(mKVType102)));
        map.put(mKVType103, new HashSet(Arrays.asList(mKVType104)));
        map.put(mKVType104, new HashSet(Arrays.asList(mKVType105, mKVType106, mKVType107, mKVType108, mKVType111)));
        map.put(mKVType108, new HashSet(Arrays.asList(mKVType109, mKVType110)));
        map.put(mKVType111, new HashSet(Arrays.asList(mKVType112, mKVType113, mKVType114, mKVType115, mKVType116, mKVType117)));
        map.put(mKVType118, new HashSet(Arrays.asList(mKVType119)));
        map.put(mKVType119, new HashSet(Arrays.asList(mKVType120, mKVType121)));
        map.put(mKVType121, new HashSet(Arrays.asList(mKVType122, mKVType123, mKVType124, mKVType125, mKVType126, mKVType127, mKVType128)));
        map.put(mKVType128, new HashSet(Arrays.asList(mKVType129)));
        map.put(mKVType130, new HashSet(Arrays.asList(mKVType131)));
        map.put(mKVType131, new HashSet(Arrays.asList(mKVType132, mKVType133, mKVType134, mKVType135, mKVType136)));
        map.put(mKVType137, new HashSet(Arrays.asList(mKVType138)));
        map.put(mKVType138, new HashSet(Arrays.asList(mKVType139, mKVType140, mKVType141, mKVType142, mKVType143)));
        map.put(mKVType143, new HashSet(Arrays.asList(mKVType144, mKVType145, mKVType146, mKVType147, mKVType148, mKVType149, mKVType150, mKVType151, mKVType152, mKVType153, mKVType155, mKVType159)));
        map.put(mKVType153, new HashSet(Arrays.asList(mKVType154)));
        map.put(mKVType155, new HashSet(Arrays.asList(mKVType156, mKVType157, mKVType158)));
        map.put(mKVType159, new HashSet(Arrays.asList(mKVType160, mKVType161, mKVType162)));
        map.put(mKVType162, new HashSet(Arrays.asList(mKVType163, mKVType164)));
        map.put(mKVType165, new HashSet(Arrays.asList(mKVType166)));
        map.put(mKVType166, new HashSet(Arrays.asList(mKVType167, mKVType174)));
        map.put(mKVType167, new HashSet(Arrays.asList(mKVType168, mKVType169, mKVType170, mKVType171, mKVType172, mKVType173)));
        map.put(mKVType174, new HashSet(Arrays.asList(mKVType175, mKVType176, mKVType177, mKVType178, mKVType179)));
    }

    private MKVType(String str, byte[] bArr, Class<? extends EbmlBase> cls) {
        this._name = str;
        this.id = bArr;
        this.clazz = cls;
        _values.add(this);
    }

    public static <T extends EbmlBase> T createById(byte[] bArr, long j) {
        for (MKVType mKVType : values()) {
            if (Platform.arrayEqualsByte(mKVType.id, bArr)) {
                return (T) createByType(mKVType);
            }
        }
        System.err.println("WARNING: unspecified ebml ID (" + EbmlUtil.toHexString(bArr) + ") encountered at position 0x" + Long.toHexString(j).toUpperCase());
        EbmlVoid ebmlVoid = new EbmlVoid(bArr);
        ebmlVoid.type = Void;
        return ebmlVoid;
    }

    public static <T extends EbmlBase> T createByType(MKVType mKVType) {
        try {
            T t = (T) Platform.newInstance(mKVType.clazz, new Object[]{mKVType.id});
            t.type = mKVType;
            return t;
        } catch (Exception e2) {
            e2.printStackTrace();
            return new EbmlBin(mKVType.id);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T[] findAll(EbmlBase ebmlBase, Class<T> cls, boolean z, MKVType[] mKVTypeArr) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList(Arrays.asList(mKVTypeArr));
        if (!ebmlBase.type.equals(linkedList2.get(0))) {
            return (T[]) linkedList.toArray((Object[]) Array.newInstance((Class<?>) cls, 0));
        }
        linkedList2.remove(0);
        findSub(ebmlBase, linkedList2, linkedList);
        return (T[]) linkedList.toArray((Object[]) Array.newInstance((Class<?>) cls, 0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T[] findAllTree(List<? extends EbmlBase> list, Class<T> cls, MKVType[] mKVTypeArr) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList(Arrays.asList(mKVTypeArr));
        if (linkedList2.size() > 0) {
            for (EbmlBase ebmlBase : list) {
                MKVType mKVType = (MKVType) linkedList2.remove(0);
                if (mKVType == null || mKVType.equals(ebmlBase.type)) {
                    findSub(ebmlBase, linkedList2, linkedList);
                }
                linkedList2.add(0, mKVType);
            }
        }
        return (T[]) linkedList.toArray((Object[]) Array.newInstance((Class<?>) cls, 0));
    }

    public static EbmlBase findFirst(EbmlBase ebmlBase, MKVType[] mKVTypeArr) {
        return findFirstSub(ebmlBase, new LinkedList(Arrays.asList(mKVTypeArr)));
    }

    private static EbmlBase findFirstSub(EbmlBase ebmlBase, List<MKVType> list) {
        EbmlBase ebmlBaseFindFirstSub = null;
        if (list.size() == 0 || !ebmlBase.type.equals(list.get(0))) {
            return null;
        }
        if (list.size() == 1) {
            return ebmlBase;
        }
        MKVType mKVTypeRemove = list.remove(0);
        if (ebmlBase instanceof EbmlMaster) {
            Iterator<EbmlBase> it = ((EbmlMaster) ebmlBase).children.iterator();
            while (it.hasNext() && ebmlBaseFindFirstSub == null) {
                ebmlBaseFindFirstSub = findFirstSub(it.next(), list);
            }
        }
        list.add(0, mKVTypeRemove);
        return ebmlBaseFindFirstSub;
    }

    public static <T> T findFirstTree(List<? extends EbmlBase> list, MKVType[] mKVTypeArr) {
        LinkedList linkedList = new LinkedList(Arrays.asList(mKVTypeArr));
        Iterator<? extends EbmlBase> it = list.iterator();
        while (it.hasNext()) {
            T t = (T) findFirstSub(it.next(), linkedList);
            if (t != null) {
                return t;
            }
        }
        return null;
    }

    public static <T> List<T> findList(List<? extends EbmlBase> list, Class<T> cls, MKVType[] mKVTypeArr) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList(Arrays.asList(mKVTypeArr));
        if (linkedList2.size() > 0) {
            for (EbmlBase ebmlBase : list) {
                MKVType mKVType = (MKVType) linkedList2.remove(0);
                if (mKVType == null || mKVType.equals(ebmlBase.type)) {
                    findSubList(ebmlBase, linkedList2, linkedList);
                }
                linkedList2.add(0, mKVType);
            }
        }
        return linkedList;
    }

    private static void findSub(EbmlBase ebmlBase, List<MKVType> list, Collection<EbmlBase> collection) {
        if (list.size() <= 0) {
            collection.add(ebmlBase);
            return;
        }
        MKVType mKVTypeRemove = list.remove(0);
        if (ebmlBase instanceof EbmlMaster) {
            Iterator<EbmlBase> it = ((EbmlMaster) ebmlBase).children.iterator();
            while (it.hasNext()) {
                EbmlBase next = it.next();
                if (mKVTypeRemove == null || mKVTypeRemove.equals(next.type)) {
                    findSub(next, list, collection);
                }
            }
        }
        list.add(0, mKVTypeRemove);
    }

    private static <T> void findSubList(EbmlBase ebmlBase, List<MKVType> list, Collection<T> collection) {
        if (list.size() <= 0) {
            collection.add(ebmlBase);
            return;
        }
        MKVType mKVTypeRemove = list.remove(0);
        if (ebmlBase instanceof EbmlMaster) {
            Iterator<EbmlBase> it = ((EbmlMaster) ebmlBase).children.iterator();
            while (it.hasNext()) {
                EbmlBase next = it.next();
                if (mKVTypeRemove == null || mKVTypeRemove.equals(next.type)) {
                    findSubList(next, list, collection);
                }
            }
        }
        list.add(0, mKVTypeRemove);
    }

    public static MKVType getParent(MKVType mKVType) {
        for (Map.Entry<MKVType, Set<MKVType>> entry : children.entrySet()) {
            if (entry.getValue().contains(mKVType)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static boolean isFirstLevelHeader(byte[] bArr) {
        for (MKVType mKVType : firstLevelHeaders) {
            if (Platform.arrayEqualsByte(mKVType.id, bArr)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isHeaderFirstByte(byte b) {
        for (MKVType mKVType : values()) {
            if (mKVType.id[0] == b) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSpecifiedHeader(byte[] bArr) {
        for (MKVType mKVType : values()) {
            if (Platform.arrayEqualsByte(mKVType.id, bArr)) {
                return true;
            }
        }
        return false;
    }

    public static boolean possibleChild(EbmlMaster ebmlMaster, EbmlBase ebmlBase) {
        if (ebmlMaster == null) {
            MKVType mKVType = ebmlBase.type;
            return mKVType == EBML || mKVType == Segment;
        }
        byte[] bArr = ebmlBase.id;
        MKVType mKVType2 = Void;
        if (!Platform.arrayEqualsByte(bArr, mKVType2.id)) {
            byte[] bArr2 = ebmlBase.id;
            MKVType mKVType3 = CRC32;
            if (!Platform.arrayEqualsByte(bArr2, mKVType3.id)) {
                MKVType mKVType4 = ebmlBase.type;
                if (mKVType4 == mKVType2 || mKVType4 == mKVType3) {
                    return true;
                }
                Set<MKVType> set = children.get(ebmlMaster.type);
                return set != null && set.contains(ebmlBase.type);
            }
        }
        return ebmlBase.offset != ebmlMaster.dataOffset + ((long) ebmlMaster.dataLen);
    }

    public static boolean possibleChildById(EbmlMaster ebmlMaster, byte[] bArr) {
        if (ebmlMaster == null && (Platform.arrayEqualsByte(EBML.id, bArr) || Platform.arrayEqualsByte(Segment.id, bArr))) {
            return true;
        }
        if (ebmlMaster == null) {
            return false;
        }
        if (Platform.arrayEqualsByte(Void.id, bArr) || Platform.arrayEqualsByte(CRC32.id, bArr)) {
            return true;
        }
        Iterator<MKVType> it = children.get(ebmlMaster.type).iterator();
        while (it.hasNext()) {
            if (Platform.arrayEqualsByte(it.next().id, bArr)) {
                return true;
            }
        }
        return false;
    }

    public static MKVType[] values() {
        return (MKVType[]) _values.toArray(new MKVType[0]);
    }

    public String name() {
        return this._name;
    }

    public String toString() {
        return this._name;
    }
}
