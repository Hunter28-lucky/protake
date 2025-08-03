package org.jcodec.movtool;

import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.movtool.Flatten;

/* loaded from: classes2.dex */
public class QTEdit {
    public final EditFactory[] factories;
    private final List<Flatten.ProgressListener> listeners = new ArrayList();

    public static abstract class BaseCommand implements MP4Edit {
        @Override // org.jcodec.movtool.MP4Edit
        public abstract void apply(MovieBox movieBox);

        public void applyRefs(MovieBox movieBox, FileChannel[][] fileChannelArr) {
            apply(movieBox);
        }
    }

    public interface EditFactory {
        String getHelp();

        String getName();

        MP4Edit parseArgs(List<String> list);
    }

    public QTEdit(EditFactory[] editFactoryArr) {
        this.factories = editFactoryArr;
    }

    public void addProgressListener(Flatten.ProgressListener progressListener) {
        this.listeners.add(progressListener);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0060, code lost:
    
        if (r1 != r5.factories.length) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void execute(java.lang.String[] r6) throws java.lang.Exception {
        /*
            r5 = this;
            java.util.LinkedList r0 = new java.util.LinkedList
            java.util.List r6 = java.util.Arrays.asList(r6)
            r0.<init>(r6)
            java.util.LinkedList r6 = new java.util.LinkedList
            r6.<init>()
        Le:
            int r1 = r0.size()
            r2 = 0
            if (r1 <= 0) goto L62
            r1 = r2
        L16:
            org.jcodec.movtool.QTEdit$EditFactory[] r3 = r5.factories
            int r3 = r3.length
            if (r1 >= r3) goto L5d
            java.lang.Object r3 = r0.get(r2)
            java.lang.String r3 = (java.lang.String) r3
            org.jcodec.movtool.QTEdit$EditFactory[] r4 = r5.factories
            r4 = r4[r1]
            java.lang.String r4 = r4.getName()
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L5a
            r0.remove(r2)
            org.jcodec.movtool.QTEdit$EditFactory[] r3 = r5.factories     // Catch: java.lang.Exception -> L3e
            r3 = r3[r1]     // Catch: java.lang.Exception -> L3e
            org.jcodec.movtool.MP4Edit r3 = r3.parseArgs(r0)     // Catch: java.lang.Exception -> L3e
            r6.add(r3)     // Catch: java.lang.Exception -> L3e
            goto L5d
        L3e:
            r6 = move-exception
            java.io.PrintStream r0 = java.lang.System.err
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "ERROR: "
            r1.append(r2)
            java.lang.String r6 = r6.getMessage()
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0.println(r6)
            return
        L5a:
            int r1 = r1 + 1
            goto L16
        L5d:
            org.jcodec.movtool.QTEdit$EditFactory[] r3 = r5.factories
            int r3 = r3.length
            if (r1 != r3) goto Le
        L62:
            int r1 = r0.size()
            if (r1 != 0) goto L72
            java.io.PrintStream r1 = java.lang.System.err
            java.lang.String r3 = "ERROR: A movie file should be specified"
            r1.println(r3)
            r5.help()
        L72:
            int r1 = r6.size()
            if (r1 != 0) goto L82
            java.io.PrintStream r1 = java.lang.System.err
            java.lang.String r3 = "ERROR: At least one command should be specified"
            r1.println(r3)
            r5.help()
        L82:
            java.io.File r1 = new java.io.File
            java.lang.Object r0 = r0.remove(r2)
            java.lang.String r0 = (java.lang.String) r0
            r1.<init>(r0)
            boolean r0 = r1.exists()
            if (r0 != 0) goto Lb5
            java.io.PrintStream r0 = java.lang.System.err
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "ERROR: Input file '"
            r2.append(r3)
            java.lang.String r3 = r1.getAbsolutePath()
            r2.append(r3)
            java.lang.String r3 = "' doesn't exist"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.println(r2)
            r5.help()
        Lb5:
            org.jcodec.movtool.ReplaceMP4Editor r0 = new org.jcodec.movtool.ReplaceMP4Editor
            r0.<init>()
            org.jcodec.movtool.CompoundMP4Edit r2 = new org.jcodec.movtool.CompoundMP4Edit
            r2.<init>(r6)
            r0.replace(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.movtool.QTEdit.execute(java.lang.String[]):void");
    }

    public void help() {
        System.out.println("Quicktime movie editor");
        System.out.println("Syntax: qtedit <command1> <options> ... <commandN> <options> <movie>");
        System.out.println("Where options:");
        for (EditFactory editFactory : this.factories) {
            System.out.println("\t" + editFactory.getHelp());
        }
        System.exit(-1);
    }
}
