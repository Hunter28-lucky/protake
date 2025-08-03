package org.jcodec.movtool;

import org.jcodec.movtool.QTEdit;

/* loaded from: classes2.dex */
public class QTRefEdit {
    public final QTEdit.EditFactory[] factories;

    public QTRefEdit(QTEdit.EditFactory[] editFactoryArr) {
        this.factories = editFactoryArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0060, code lost:
    
        if (r1 != r5.factories.length) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void execute(java.lang.String[] r6) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.movtool.QTRefEdit.execute(java.lang.String[]):void");
    }

    public void help() {
        System.out.println("Quicktime movie editor");
        System.out.println("Syntax: qtedit <command1> <options> ... <commandN> <options> <movie> <output>");
        System.out.println("Where options:");
        for (QTEdit.EditFactory editFactory : this.factories) {
            System.out.println("\t" + editFactory.getHelp());
        }
        System.exit(-1);
    }
}
