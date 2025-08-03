package org.jcodec.movtool;

import com.blink.academy.film.support.stream.ts.TsConstants;
import com.google.android.gms.actions.SearchIntents;
import com.umeng.analytics.pro.am;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;
import org.jcodec.common.io.IOUtils;
import org.jcodec.common.tools.MainUtils;
import org.jcodec.containers.mp4.boxes.MetaValue;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class MetadataEditorMain {
    private static final MainUtils.Flag FLAG_DROP_ITUNES;
    private static final MainUtils.Flag FLAG_DROP_KEYED;
    private static final MainUtils.Flag FLAG_FAST;
    private static final MainUtils.Flag FLAG_QUERY;
    private static final MainUtils.Flag FLAG_SET_ITUNES;
    private static final MainUtils.Flag FLAG_SET_ITUNES_BLOB;
    private static final MainUtils.Flag FLAG_SET_KEYED;
    private static final String TYPENAME_FLOAT = "float";
    private static final String TYPENAME_INT = "int";
    private static final String TYPENAME_INT2 = "integer";
    private static final MainUtils.Flag[] flags;
    private static Map<String, Integer> strToType;

    static {
        MainUtils.Flag flag = MainUtils.Flag.flag("set-keyed", "sk", "key1[,type1]=value1:key2[,type2]=value2[,...] Sets the metadata piece into a file.");
        FLAG_SET_KEYED = flag;
        MainUtils.Flag flag2 = MainUtils.Flag.flag("set-itunes", "si", "key1[,type1]=value1:key2[,type2]=value2[,...] Sets the metadata piece into a file.");
        FLAG_SET_ITUNES = flag2;
        MainUtils.Flag flag3 = MainUtils.Flag.flag("set-itunes-blob", "sib", "key[,type]=file Sets the data read from a file into the metadata field 'key'. If file is not present stdin is read.");
        FLAG_SET_ITUNES_BLOB = flag3;
        MainUtils.Flag flag4 = MainUtils.Flag.flag(SearchIntents.EXTRA_QUERY, "q", "Query the value of one key from the metadata set.");
        FLAG_QUERY = flag4;
        MainUtils.Flag flag5 = new MainUtils.Flag("fast", TsConstants.kLinkParam_recording, "Fast edit, will move the header to the end of the file when ther's no room to fit it.", MainUtils.FlagType.VOID);
        FLAG_FAST = flag5;
        MainUtils.Flag flag6 = MainUtils.Flag.flag("drop-keyed", am.bo, "Drop the field(s) from keyed metadata, format: key1,key2,key3,...");
        FLAG_DROP_KEYED = flag6;
        MainUtils.Flag flag7 = MainUtils.Flag.flag("drop-itunes", "di", "Drop the field(s) from iTunes metadata, format: key1,key2,key3,...");
        FLAG_DROP_ITUNES = flag7;
        flags = new MainUtils.Flag[]{flag, flag2, flag4, flag5, flag3, flag6, flag7};
        HashMap map = new HashMap();
        strToType = map;
        map.put("utf8", 1);
        strToType.put("utf16", 2);
        strToType.put("float", 23);
        strToType.put(TYPENAME_INT, 21);
        strToType.put("integer", 21);
        strToType.put("jpeg", 13);
        strToType.put("jpg", 13);
        strToType.put("png", 14);
        strToType.put("bmp", 27);
    }

    private static String fourccToString(int i) {
        byte[] bArr = new byte[4];
        ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).putInt(i);
        return Platform.stringFromCharset(bArr, Platform.ISO8859_1);
    }

    public static void main(String[] strArr) throws Throwable {
        boolean z;
        MainUtils.Flag[] flagArr = flags;
        MainUtils.Cmd arguments = MainUtils.parseArguments(strArr, flagArr);
        boolean z2 = true;
        if (arguments.argsLength() < 1) {
            MainUtils.printHelpCmdVa("metaedit", flagArr, "file name");
            System.exit(-1);
            return;
        }
        MetadataEditor metadataEditorCreateFrom = MetadataEditor.createFrom(new File(arguments.getArg(0)));
        String stringFlag = arguments.getStringFlag(FLAG_SET_KEYED);
        if (stringFlag != null) {
            Map<String, MetaValue> metaSpec = parseMetaSpec(stringFlag);
            z = (metaSpec.size() > 0) | false;
            metadataEditorCreateFrom.getKeyedMeta().putAll(metaSpec);
        } else {
            z = false;
        }
        String stringFlag2 = arguments.getStringFlag(FLAG_DROP_KEYED);
        if (stringFlag2 != null) {
            String[] strArrSplit = stringFlag2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            Map<String, MetaValue> keyedMeta = metadataEditorCreateFrom.getKeyedMeta();
            for (String str : strArrSplit) {
                z |= keyedMeta.remove(str) != null;
            }
        }
        String stringFlag3 = arguments.getStringFlag(FLAG_DROP_ITUNES);
        if (stringFlag3 != null) {
            String[] strArrSplit2 = stringFlag3.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            Map<Integer, MetaValue> itunesMeta = metadataEditorCreateFrom.getItunesMeta();
            for (String str2 : strArrSplit2) {
                z |= itunesMeta.remove(Integer.valueOf(stringToFourcc(str2))) != null;
            }
        }
        String stringFlag4 = arguments.getStringFlag(FLAG_SET_ITUNES);
        if (stringFlag4 != null) {
            Map<Integer, MetaValue> fourccMeta = toFourccMeta(parseMetaSpec(stringFlag4));
            z |= fourccMeta.size() > 0;
            metadataEditorCreateFrom.getItunesMeta().putAll(fourccMeta);
        }
        String stringFlag5 = arguments.getStringFlag(FLAG_SET_ITUNES_BLOB);
        if (stringFlag5 != null) {
            String[] strArrSplit3 = stringFlag5.split("=");
            String[] strArrSplit4 = strArrSplit3[0].split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            String str3 = strArrSplit4[0];
            Integer num = strArrSplit4.length > 1 ? strToType.get(strArrSplit4[1]) : 1;
            if (num != null) {
                metadataEditorCreateFrom.getItunesMeta().put(Integer.valueOf(stringToFourcc(str3)), MetaValue.createOther(num.intValue(), readStdin(strArrSplit3.length > 1 ? strArrSplit3[1] : null)));
            } else {
                System.err.println("Unsupported metadata type: " + strArrSplit4[1]);
                z2 = z;
            }
        } else {
            z2 = z;
        }
        if (z2) {
            metadataEditorCreateFrom.save(arguments.getBooleanFlag(FLAG_FAST).booleanValue());
            metadataEditorCreateFrom = MetadataEditor.createFrom(new File(arguments.getArg(0)));
        }
        Map<String, MetaValue> keyedMeta2 = metadataEditorCreateFrom.getKeyedMeta();
        if (keyedMeta2 != null) {
            String stringFlag6 = arguments.getStringFlag(FLAG_QUERY);
            if (stringFlag6 == null) {
                System.out.println("Keyed metadata:");
                for (Map.Entry<String, MetaValue> entry : keyedMeta2.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            } else {
                printValue(keyedMeta2.get(stringFlag6));
            }
        }
        Map<Integer, MetaValue> itunesMeta2 = metadataEditorCreateFrom.getItunesMeta();
        if (itunesMeta2 != null) {
            String stringFlag7 = arguments.getStringFlag(FLAG_QUERY);
            if (stringFlag7 != null) {
                printValue(itunesMeta2.get(Integer.valueOf(stringToFourcc(stringFlag7))));
                return;
            }
            System.out.println("iTunes metadata:");
            for (Map.Entry<Integer, MetaValue> entry2 : itunesMeta2.entrySet()) {
                System.out.println(fourccToString(entry2.getKey().intValue()) + ": " + entry2.getValue());
            }
        }
    }

    private static Map<String, MetaValue> parseMetaSpec(String str) {
        HashMap map = new HashMap();
        for (String str2 : str.split(Constants.COLON_SEPARATOR)) {
            String[] strArrSplit = str2.split("=");
            String[] strArrSplit2 = strArrSplit[0].split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            String str3 = strArrSplit2[0];
            String str4 = null;
            String str5 = strArrSplit.length > 1 ? strArrSplit[1] : null;
            if (strArrSplit2.length > 1) {
                str4 = strArrSplit2[1];
            }
            map.put(str3, typedValue(str5, str4));
        }
        return map;
    }

    private static void printValue(MetaValue metaValue) throws IOException {
        if (metaValue == null) {
            return;
        }
        if (metaValue.isBlob()) {
            System.out.write(metaValue.getData());
        } else {
            System.out.println(metaValue);
        }
    }

    private static byte[] readStdin(String str) throws Throwable {
        FileInputStream fileInputStream = null;
        try {
            if (str == null) {
                byte[] byteArray = IOUtils.toByteArray(Platform.stdin());
                IOUtils.closeQuietly(null);
                return byteArray;
            }
            FileInputStream fileInputStream2 = new FileInputStream(new File(str));
            try {
                byte[] byteArray2 = IOUtils.toByteArray(fileInputStream2);
                IOUtils.closeQuietly(fileInputStream2);
                return byteArray2;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                IOUtils.closeQuietly(fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static int stringToFourcc(String str) {
        if (str.length() != 4) {
            return 0;
        }
        return ByteBuffer.wrap(Platform.getBytesForCharset(str, Platform.ISO8859_1)).order(ByteOrder.BIG_ENDIAN).getInt();
    }

    private static Map<Integer, MetaValue> toFourccMeta(Map<String, MetaValue> map) {
        HashMap map2 = new HashMap();
        for (Map.Entry<String, MetaValue> entry : map.entrySet()) {
            map2.put(Integer.valueOf(stringToFourcc(entry.getKey())), entry.getValue());
        }
        return map2;
    }

    private static MetaValue typedValue(String str, String str2) {
        return (TYPENAME_INT.equalsIgnoreCase(str2) || "integer".equalsIgnoreCase(str2)) ? MetaValue.createInt(Integer.parseInt(str)) : "float".equalsIgnoreCase(str2) ? MetaValue.createFloat(Float.parseFloat(str)) : MetaValue.createString(str);
    }
}
