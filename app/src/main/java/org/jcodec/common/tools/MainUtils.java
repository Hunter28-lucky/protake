package org.jcodec.common.tools;

import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jcodec.common.StringUtils;
import org.jcodec.common.io.IOUtils;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class MainUtils {
    private static final String GIT_PROPERTIES = "git.properties";
    private static final String JCODEC_LOG_SINK_COLOR = "jcodec.colorPrint";
    private static final String KEY_GIT_REVISION = "git.commit.id.abbrev";
    private static Pattern flagPattern;
    public static boolean isColorSupported;

    public enum ANSIColor {
        BLACK,
        RED,
        GREEN,
        BROWN,
        BLUE,
        MAGENTA,
        CYAN,
        GREY
    }

    public static class Cmd {
        public String[] args;
        private Map<String, String>[] longArgFlags;
        public Map<String, String> longFlags;
        private Map<String, String>[] shortArgFlags;
        public Map<String, String> shortFlags;

        public Cmd(Map<String, String> map, Map<String, String> map2, String[] strArr, Map<String, String>[] mapArr, Map<String, String>[] mapArr2) {
            this.args = strArr;
            this.longFlags = map;
            this.shortFlags = map2;
            this.longArgFlags = mapArr;
            this.shortArgFlags = mapArr2;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private java.lang.Boolean getBooleanFlagInternal(java.util.Map<java.lang.String, java.lang.String> r5, java.util.Map<java.lang.String, java.lang.String> r6, org.jcodec.common.tools.MainUtils.Flag r7, java.lang.Boolean r8) {
            /*
                r4 = this;
                java.lang.String r0 = r7.getLongName()
                boolean r0 = r5.containsKey(r0)
                r1 = 1
                r2 = 0
                java.lang.String r3 = "false"
                if (r0 == 0) goto L21
                java.lang.String r6 = r7.getLongName()
                java.lang.Object r5 = r5.get(r6)
                java.lang.String r5 = (java.lang.String) r5
                boolean r5 = r3.equalsIgnoreCase(r5)
                if (r5 != 0) goto L1f
                goto L40
            L1f:
                r1 = r2
                goto L40
            L21:
                java.lang.String r5 = r7.getShortName()
                boolean r5 = r6.containsKey(r5)
                if (r5 == 0) goto L3c
                java.lang.String r5 = r7.getShortName()
                java.lang.Object r5 = r6.get(r5)
                java.lang.String r5 = (java.lang.String) r5
                boolean r5 = r3.equalsIgnoreCase(r5)
                if (r5 != 0) goto L1f
                goto L40
            L3c:
                boolean r1 = r8.booleanValue()
            L40:
                java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jcodec.common.tools.MainUtils.Cmd.getBooleanFlagInternal(java.util.Map, java.util.Map, org.jcodec.common.tools.MainUtils$Flag, java.lang.Boolean):java.lang.Boolean");
        }

        private Double getDoubleFlagInternal(Map<String, String> map, Map<String, String> map2, Flag flag, Double d) {
            return map.containsKey(flag.getLongName()) ? new Double(map.get(flag.getLongName())) : map2.containsKey(flag.getShortName()) ? new Double(map2.get(flag.getShortName())) : d;
        }

        private <T extends Enum<T>> T getEnumFlagInternal(Map<String, String> map, Map<String, String> map2, Flag flag, T t, Class<T> cls) {
            String str;
            if (map.containsKey(flag.getLongName())) {
                str = map.get(flag.getLongName());
            } else {
                if (!map2.containsKey(flag.getShortName())) {
                    return t;
                }
                str = map2.get(flag.getShortName());
            }
            String lowerCase = str.toLowerCase();
            Iterator it = EnumSet.allOf(cls).iterator();
            while (it.hasNext()) {
                T t2 = (T) it.next();
                if (t2.name().toLowerCase().equals(lowerCase)) {
                    return t2;
                }
            }
            return null;
        }

        private Integer getIntegerFlagInternal(Map<String, String> map, Map<String, String> map2, Flag flag, Integer num) {
            return map.containsKey(flag.getLongName()) ? new Integer(map.get(flag.getLongName())) : map2.containsKey(flag.getShortName()) ? new Integer(map2.get(flag.getShortName())) : num;
        }

        private Long getLongFlagInternal(Map<String, String> map, Map<String, String> map2, Flag flag, Long l) {
            return map.containsKey(flag.getLongName()) ? new Long(map.get(flag.getLongName())) : map2.containsKey(flag.getShortName()) ? new Long(map2.get(flag.getShortName())) : l;
        }

        private int[] getMultiIntegerFlagInternal(Map<String, String> map, Map<String, String> map2, Flag flag, int[] iArr) {
            String str;
            if (map.containsKey(flag.getLongName())) {
                str = map.get(flag.getLongName());
            } else {
                if (!map2.containsKey(flag.getShortName())) {
                    return iArr;
                }
                str = map2.get(flag.getShortName());
            }
            String[] strArrSplitS = StringUtils.splitS(str, Constants.ACCEPT_TIME_SEPARATOR_SP);
            int[] iArr2 = new int[strArrSplitS.length];
            for (int i = 0; i < strArrSplitS.length; i++) {
                iArr2[i] = Integer.parseInt(strArrSplitS[i]);
            }
            return iArr2;
        }

        private String getStringFlagInternal(Map<String, String> map, Map<String, String> map2, Flag flag, String str) {
            return map.containsKey(flag.getLongName()) ? map.get(flag.getLongName()) : map2.containsKey(flag.getShortName()) ? map2.get(flag.getShortName()) : str;
        }

        public int argsLength() {
            return this.args.length;
        }

        public String getArg(int i) {
            String[] strArr = this.args;
            if (i < strArr.length) {
                return strArr[i];
            }
            return null;
        }

        public Boolean getBooleanFlag(Flag flag) {
            return getBooleanFlagInternal(this.longFlags, this.shortFlags, flag, Boolean.FALSE);
        }

        public Boolean getBooleanFlagD(Flag flag, Boolean bool) {
            return getBooleanFlagInternal(this.longFlags, this.shortFlags, flag, bool);
        }

        public Boolean getBooleanFlagI(int i, Flag flag) {
            return getBooleanFlagInternal(this.longArgFlags[i], this.shortArgFlags[i], flag, Boolean.FALSE);
        }

        public Boolean getBooleanFlagID(int i, Flag flag, Boolean bool) {
            return getBooleanFlagInternal(this.longArgFlags[i], this.shortArgFlags[i], flag, bool);
        }

        public Double getDoubleFlag(Flag flag) {
            return getDoubleFlagInternal(this.longFlags, this.shortFlags, flag, null);
        }

        public Double getDoubleFlagD(Flag flag, Double d) {
            return getDoubleFlagInternal(this.longFlags, this.shortFlags, flag, d);
        }

        public Double getDoubleFlagI(int i, Flag flag) {
            return getDoubleFlagInternal(this.longArgFlags[i], this.shortArgFlags[i], flag, null);
        }

        public Double getDoubleFlagID(int i, Flag flag, Double d) {
            return getDoubleFlagInternal(this.longArgFlags[i], this.shortArgFlags[i], flag, d);
        }

        public <T extends Enum<T>> T getEnumFlag(Flag flag, Class<T> cls) {
            return (T) getEnumFlagInternal(this.longFlags, this.shortFlags, flag, null, cls);
        }

        public <T extends Enum<T>> T getEnumFlagD(Flag flag, T t, Class<T> cls) {
            return (T) getEnumFlagInternal(this.longFlags, this.shortFlags, flag, t, cls);
        }

        public <T extends Enum<T>> T getEnumFlagI(int i, Flag flag, Class<T> cls) {
            return (T) getEnumFlagInternal(this.longArgFlags[i], this.shortArgFlags[i], flag, null, cls);
        }

        public <T extends Enum<T>> T getEnumFlagID(int i, Flag flag, T t, Class<T> cls) {
            return (T) getEnumFlagInternal(this.longArgFlags[i], this.shortArgFlags[i], flag, t, cls);
        }

        public Integer getIntegerFlag(Flag flag) {
            return getIntegerFlagInternal(this.longFlags, this.shortFlags, flag, null);
        }

        public Integer getIntegerFlagD(Flag flag, Integer num) {
            return getIntegerFlagInternal(this.longFlags, this.shortFlags, flag, num);
        }

        public Integer getIntegerFlagI(int i, Flag flag) {
            return getIntegerFlagInternal(this.longArgFlags[i], this.shortArgFlags[i], flag, null);
        }

        public Integer getIntegerFlagID(int i, Flag flag, Integer num) {
            return getIntegerFlagInternal(this.longArgFlags[i], this.shortArgFlags[i], flag, num);
        }

        public Long getLongFlag(Flag flag) {
            return getLongFlagInternal(this.longFlags, this.shortFlags, flag, null);
        }

        public Long getLongFlagD(Flag flag, Long l) {
            return getLongFlagInternal(this.longFlags, this.shortFlags, flag, l);
        }

        public Long getLongFlagI(int i, Flag flag) {
            return getLongFlagInternal(this.longArgFlags[i], this.shortArgFlags[i], flag, null);
        }

        public Long getLongFlagID(int i, Flag flag, Long l) {
            return getLongFlagInternal(this.longArgFlags[i], this.shortArgFlags[i], flag, l);
        }

        public int[] getMultiIntegerFlag(Flag flag) {
            return getMultiIntegerFlagInternal(this.longFlags, this.shortFlags, flag, new int[0]);
        }

        public int[] getMultiIntegerFlagD(Flag flag, int[] iArr) {
            return getMultiIntegerFlagInternal(this.longFlags, this.shortFlags, flag, iArr);
        }

        public int[] getMultiIntegerFlagI(int i, Flag flag) {
            return getMultiIntegerFlagInternal(this.longArgFlags[i], this.shortArgFlags[i], flag, new int[0]);
        }

        public int[] getMultiIntegerFlagID(int i, Flag flag, int[] iArr) {
            return getMultiIntegerFlagInternal(this.longArgFlags[i], this.shortArgFlags[i], flag, iArr);
        }

        public String getStringFlag(Flag flag) {
            return getStringFlagInternal(this.longFlags, this.shortFlags, flag, null);
        }

        public String getStringFlagD(Flag flag, String str) {
            return getStringFlagInternal(this.longFlags, this.shortFlags, flag, str);
        }

        public String getStringFlagI(int i, Flag flag) {
            return getStringFlagInternal(this.longArgFlags[i], this.shortArgFlags[i], flag, null);
        }

        public String getStringFlagID(int i, Flag flag, String str) {
            return getStringFlagInternal(this.longArgFlags[i], this.shortArgFlags[i], flag, str);
        }

        public void popArg() {
            String[] strArr = this.args;
            this.args = (String[]) Platform.copyOfRangeO(strArr, 1, strArr.length);
        }
    }

    public static class Flag {
        private String description;
        private String longName;
        private String shortName;
        private FlagType type;

        public Flag(String str, String str2, String str3, FlagType flagType) {
            this.longName = str;
            this.shortName = str2;
            this.description = str3;
            this.type = flagType;
        }

        public static Flag flag(String str, String str2, String str3) {
            return new Flag(str, str2, str3, FlagType.ANY);
        }

        public String getDescription() {
            return this.description;
        }

        public String getLongName() {
            return this.longName;
        }

        public String getShortName() {
            return this.shortName;
        }

        public FlagType getType() {
            return this.type;
        }
    }

    public enum FlagType {
        VOID,
        STRING,
        INT,
        LONG,
        DOUBLE,
        MULT,
        ENUM,
        ANY
    }

    static {
        isColorSupported = System.console() != null || Boolean.parseBoolean(System.getProperty(JCODEC_LOG_SINK_COLOR));
        flagPattern = Pattern.compile("^--([^=]+)=(.*)$");
    }

    public static String bold(String str) {
        if (!isColorSupported) {
            return str;
        }
        return "\u001b[1m" + str + "\u001b[0m";
    }

    public static String color(String str, ANSIColor aNSIColor) {
        if (!isColorSupported) {
            return str;
        }
        return "\u001b[" + ((aNSIColor.ordinal() & 7) + 30) + "m" + str + "\u001b[0m";
    }

    public static String color3(String str, ANSIColor aNSIColor, ANSIColor aNSIColor2) {
        if (!isColorSupported) {
            return str;
        }
        return "\u001b[" + ((aNSIColor.ordinal() & 7) + 30) + ";" + ((aNSIColor2.ordinal() & 7) + 40) + ";1m" + str + "\u001b[0m";
    }

    public static String color4(String str, ANSIColor aNSIColor, ANSIColor aNSIColor2, boolean z) {
        if (!isColorSupported) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\u001b[");
        sb.append((aNSIColor.ordinal() & 7) + 30);
        sb.append(";");
        sb.append((aNSIColor2.ordinal() & 7) + 40);
        sb.append(";");
        sb.append(z ? 1 : 2);
        sb.append("m");
        sb.append(str);
        sb.append("\u001b[0m");
        return sb.toString();
    }

    public static String colorBright(String str, ANSIColor aNSIColor, boolean z) {
        if (!isColorSupported) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\u001b[");
        sb.append((aNSIColor.ordinal() & 7) + 30);
        sb.append(";");
        sb.append(z ? 1 : 2);
        sb.append("m");
        sb.append(str);
        sb.append("\u001b[0m");
        return sb.toString();
    }

    public static String colorString(String str, String str2) {
        if (!isColorSupported) {
            return str;
        }
        return "\u001b[" + str2 + "m" + str + "\u001b[0m";
    }

    private static String getGitRevision() throws Throwable {
        InputStream resourceAsStream;
        Throwable th;
        try {
            resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(GIT_PROPERTIES);
            if (resourceAsStream == null) {
                IOUtils.closeQuietly(resourceAsStream);
                return null;
            }
            try {
                Properties properties = new Properties();
                properties.load(resourceAsStream);
                String str = (String) properties.get(KEY_GIT_REVISION);
                IOUtils.closeQuietly(resourceAsStream);
                return str;
            } catch (IOException unused) {
                IOUtils.closeQuietly(resourceAsStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                IOUtils.closeQuietly(resourceAsStream);
                throw th;
            }
        } catch (IOException unused2) {
            resourceAsStream = null;
        } catch (Throwable th3) {
            resourceAsStream = null;
            th = th3;
        }
    }

    public static Cmd parseArguments(String[] strArr, Flag[] flagArr) {
        int i;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        HashMap map4 = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int i2 = 0;
        while (i2 < strArr.length) {
            if (strArr[i2].startsWith("--")) {
                Matcher matcher = flagPattern.matcher(strArr[i2]);
                if (matcher.matches()) {
                    map.put(matcher.group(1), matcher.group(2));
                } else {
                    map.put(strArr[i2].substring(2), "true");
                }
                i = 1;
            } else {
                if (strArr[i2].startsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                    String strSubstring = strArr[i2].substring(1);
                    boolean z = false;
                    for (Flag flag : flagArr) {
                        if (strSubstring.equals(flag.getShortName())) {
                            if (flag.getType() != FlagType.VOID) {
                                i2++;
                                map2.put(strSubstring, strArr[i2]);
                            } else {
                                map2.put(strSubstring, "true");
                            }
                            z = true;
                        }
                    }
                    if (!z) {
                        i2++;
                    }
                } else {
                    map3.putAll(map);
                    map4.putAll(map2);
                    arrayList.add(strArr[i2]);
                    arrayList2.add(map);
                    arrayList3.add(map2);
                    map = new HashMap();
                    map2 = new HashMap();
                }
                i = 1;
            }
            i2 += i;
        }
        return new Cmd(map3, map4, (String[]) arrayList.toArray(new String[0]), (Map[]) arrayList2.toArray((Map[]) Array.newInstance(map.getClass(), 0)), (Map[]) arrayList3.toArray((Map[]) Array.newInstance(map2.getClass(), 0)));
    }

    public static void printHelp(Flag[] flagArr, List<String> list) throws Throwable {
        printHelpOut(System.out, "", flagArr, list);
    }

    public static void printHelpArgs(Flag[] flagArr, String[] strArr) throws Throwable {
        printHelpOut(System.out, "", flagArr, Arrays.asList(strArr));
    }

    public static void printHelpCmd(String str, Flag[] flagArr, List<String> list) throws Throwable {
        printHelpOut(System.out, str, flagArr, list);
    }

    public static void printHelpCmdVa(String str, Flag[] flagArr, String str2) throws Throwable {
        printHelpOut(System.out, str, flagArr, Collections.singletonList(str2));
    }

    public static void printHelpNoFlags(String... strArr) throws Throwable {
        printHelpOut(System.out, "", new Flag[0], Arrays.asList(strArr));
    }

    public static void printHelpOut(PrintStream printStream, String str, Flag[] flagArr, List<String> list) throws Throwable {
        String implementationVersion = MainUtils.class.getPackage().getImplementationVersion();
        String gitRevision = getGitRevision();
        if (str == null || str.isEmpty()) {
            str = "jcodec";
        }
        if (gitRevision != null || implementationVersion != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(implementationVersion != null ? " v." + implementationVersion : "");
            sb2.append(gitRevision != null ? " rev. " + gitRevision : "");
            sb.append(bold(sb2.toString()));
            printStream.println(sb.toString());
            printStream.println();
        }
        printStream.print(bold("Syntax: " + str));
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        for (Flag flag : flagArr) {
            sb3.append(" [");
            sb4.append("\t");
            if (flag.getLongName() != null) {
                String str2 = "--" + flag.getLongName() + "=<value>";
                ANSIColor aNSIColor = ANSIColor.MAGENTA;
                sb3.append(bold(color(str2, aNSIColor)));
                sb4.append(bold(color("--" + flag.getLongName(), aNSIColor)));
            }
            if (flag.getShortName() != null) {
                if (flag.getLongName() != null) {
                    sb3.append(" (");
                    sb4.append(" (");
                }
                String str3 = Constants.ACCEPT_TIME_SEPARATOR_SERVER + flag.getShortName() + " <value>";
                ANSIColor aNSIColor2 = ANSIColor.MAGENTA;
                sb3.append(bold(color(str3, aNSIColor2)));
                sb4.append(bold(color(Constants.ACCEPT_TIME_SEPARATOR_SERVER + flag.getShortName(), aNSIColor2)));
                if (flag.getLongName() != null) {
                    sb3.append(")");
                    sb4.append(")");
                }
            }
            sb3.append("]");
            sb4.append("\t\t" + flag.getDescription() + "\n");
        }
        for (String str4 : list) {
            if (str4.charAt(0) != '?') {
                sb3.append(bold(" <" + str4 + ">"));
            } else {
                sb3.append(bold(" [" + str4.substring(1) + "]"));
            }
        }
        printStream.println(sb3);
        printStream.println(bold("Where:"));
        printStream.println(sb4);
    }

    public static File tildeExpand(String str) {
        if (str.startsWith(Constants.WAVE_SEPARATOR)) {
            str = str.replaceFirst(Constants.WAVE_SEPARATOR, System.getProperty("user.home"));
        }
        return new File(str);
    }
}
