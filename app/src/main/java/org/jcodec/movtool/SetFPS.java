package org.jcodec.movtool;

import java.io.File;
import org.jcodec.common.model.RationalLarge;
import org.jcodec.common.tools.MainUtils;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.MovieFragmentBox;

/* loaded from: classes2.dex */
public class SetFPS {
    private static final int MIN_TIMESCALE_ALLOWED = 25;

    public static void main1(String[] strArr) throws Exception {
        MainUtils.Cmd arguments = MainUtils.parseArguments(strArr, new MainUtils.Flag[0]);
        if (arguments.argsLength() < 2) {
            MainUtils.printHelpNoFlags("movie", "num:den");
            System.exit(-1);
        }
        final RationalLarge rationalLarge = RationalLarge.parse(arguments.getArg(1));
        new InplaceMP4Editor().modify(new File(arguments.getArg(0)), new MP4Edit() { // from class: org.jcodec.movtool.SetFPS.1
            /*  JADX ERROR: NullPointerException in pass: LoopRegionVisitor
                java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.use(jadx.core.dex.instructions.args.RegisterArg)" because "ssaVar" is null
                	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:493)
                	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:496)
                */
            @Override // org.jcodec.movtool.MP4Edit
            public void apply(org.jcodec.containers.mp4.boxes.MovieBox r15) {
                /*
                    r14 = this;
                    org.jcodec.containers.mp4.boxes.TrakBox r0 = r15.getVideoTrack()
                    org.jcodec.containers.mp4.boxes.TimeToSampleBox r1 = r0.getStts()
                    org.jcodec.containers.mp4.boxes.TimeToSampleBox$TimeToSampleEntry[] r1 = r1.getEntries()
                    int r2 = r1.length
                    r3 = 0
                    r4 = 0
                    r8 = r3
                    r6 = r4
                L12:
                    if (r8 >= r2) goto L2a
                    r9 = r1[r8]
                    int r10 = r9.getSampleCount()
                    long r10 = (long) r10
                    long r6 = r6 + r10
                    int r10 = r9.getSampleCount()
                    int r9 = r9.getSampleDuration()
                    int r10 = r10 * r9
                    long r9 = (long) r10
                    long r4 = r4 + r9
                    int r8 = r8 + 1
                    goto L12
                L2a:
                    org.jcodec.common.model.RationalLarge r2 = r1
                    org.jcodec.common.model.RationalLarge r8 = new org.jcodec.common.model.RationalLarge
                    r8.<init>(r4, r6)
                    org.jcodec.common.model.RationalLarge r2 = r2.multiply(r8)
                    long r8 = r2.scalarClip()
                    int r2 = (int) r8
                    r8 = 25
                    if (r2 < r8) goto L42
                    r0.setTimescale(r2)
                    goto L89
                L42:
                    org.jcodec.common.model.RationalLarge r8 = new org.jcodec.common.model.RationalLarge
                    int r9 = r0.getTimescale()
                    long r9 = (long) r9
                    long r9 = r9 * r4
                    r8.<init>(r9, r6)
                    org.jcodec.common.model.RationalLarge r6 = r1
                    org.jcodec.common.model.RationalLarge r6 = r8.divideBy(r6)
                    double r6 = r6.scalar()
                    java.lang.StringBuilder r8 = new java.lang.StringBuilder
                    r8.<init>()
                    java.lang.String r9 = "Applying multiplier to sample durations: "
                    r8.append(r9)
                    r8.append(r6)
                    java.lang.String r8 = r8.toString()
                    org.jcodec.common.logging.Logger.info(r8)
                    int r8 = r1.length
                L6c:
                    if (r3 >= r8) goto L80
                    r9 = r1[r3]
                    int r10 = r9.getSampleDuration()
                    double r10 = (double) r10
                    double r10 = r10 * r6
                    r12 = 4636737291354636288(0x4059000000000000, double:100.0)
                    double r10 = r10 * r12
                    int r10 = (int) r10
                    r9.setSampleDuration(r10)
                    int r3 = r3 + 1
                    goto L6c
                L80:
                    int r1 = r0.getTimescale()
                    int r1 = r1 * 100
                    r0.setTimescale(r1)
                L89:
                    int r1 = r0.getTimescale()
                    if (r2 == r1) goto Lba
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r2 = "Changing timescale to: "
                    r1.append(r2)
                    int r2 = r0.getTimescale()
                    r1.append(r2)
                    java.lang.String r1 = r1.toString()
                    org.jcodec.common.logging.Logger.info(r1)
                    int r1 = r15.getTimescale()
                    long r1 = (long) r1
                    long r4 = r4 * r1
                    int r1 = r0.getTimescale()
                    long r1 = (long) r1
                    long r4 = r4 / r1
                    r15.setDuration(r4)
                    r0.setDuration(r4)
                    goto Ld9
                Lba:
                    java.lang.StringBuilder r15 = new java.lang.StringBuilder
                    r15.<init>()
                    java.lang.String r0 = "Already at "
                    r15.append(r0)
                    org.jcodec.common.model.RationalLarge r0 = r1
                    java.lang.String r0 = r0.toString()
                    r15.append(r0)
                    java.lang.String r0 = "fps, not changing."
                    r15.append(r0)
                    java.lang.String r15 = r15.toString()
                    org.jcodec.common.logging.Logger.info(r15)
                Ld9:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: org.jcodec.movtool.SetFPS.AnonymousClass1.apply(org.jcodec.containers.mp4.boxes.MovieBox):void");
            }

            @Override // org.jcodec.movtool.MP4Edit
            public void applyToFragment(MovieBox movieBox, MovieFragmentBox[] movieFragmentBoxArr) {
                throw new RuntimeException("Unsupported");
            }
        });
    }
}
