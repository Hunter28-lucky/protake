package org.jcodec.scale.highbd;

import java.util.HashMap;
import java.util.Map;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.PictureHiBD;

/* loaded from: classes2.dex */
public class ColorUtilHiBD {
    private static Map<ColorSpace, Map<ColorSpace, TransformHiBD>> map = new HashMap();

    public static class Idential implements TransformHiBD {
        @Override // org.jcodec.scale.highbd.TransformHiBD
        public void transform(PictureHiBD pictureHiBD, PictureHiBD pictureHiBD2) {
            for (int i = 0; i < 3; i++) {
                System.arraycopy(pictureHiBD.getPlaneData(i), 0, pictureHiBD2.getPlaneData(i), 0, Math.min(pictureHiBD.getPlaneWidth(i) * pictureHiBD.getPlaneHeight(i), pictureHiBD2.getPlaneWidth(i) * pictureHiBD2.getPlaneHeight(i)));
            }
        }
    }

    static {
        HashMap map2 = new HashMap();
        ColorSpace colorSpace = ColorSpace.RGB;
        map2.put(colorSpace, new Idential());
        ColorSpace colorSpace2 = ColorSpace.YUV420;
        map2.put(colorSpace2, new RgbToYuv420pHiBD(0, 0));
        ColorSpace colorSpace3 = ColorSpace.YUV420J;
        map2.put(colorSpace3, new RgbToYuv420jHiBD());
        ColorSpace colorSpace4 = ColorSpace.YUV422;
        map2.put(colorSpace4, new RgbToYuv422pHiBD(0, 0));
        ColorSpace colorSpace5 = ColorSpace.YUV422_10;
        map2.put(colorSpace5, new RgbToYuv422pHiBD(2, 0));
        map.put(colorSpace, map2);
        HashMap map3 = new HashMap();
        map3.put(colorSpace2, new Idential());
        map3.put(colorSpace, new Yuv420pToRgbHiBD(0, 0));
        map3.put(colorSpace4, new Yuv420pToYuv422pHiBD(0, 0));
        map3.put(colorSpace5, new Yuv420pToYuv422pHiBD(0, 2));
        map.put(colorSpace2, map3);
        HashMap map4 = new HashMap();
        map4.put(colorSpace4, new Idential());
        map4.put(colorSpace, new Yuv422pToRgbHiBD(0, 0));
        map4.put(colorSpace2, new Yuv422pToYuv420pHiBD(0, 0));
        map4.put(colorSpace3, new Yuv422pToYuv420jHiBD(0, 0));
        map.put(colorSpace4, map4);
        HashMap map5 = new HashMap();
        map5.put(colorSpace5, new Idential());
        map5.put(colorSpace, new Yuv422pToRgbHiBD(2, 0));
        map5.put(colorSpace2, new Yuv422pToYuv420pHiBD(0, 2));
        map5.put(colorSpace3, new Yuv422pToYuv420jHiBD(0, 2));
        map.put(colorSpace5, map5);
        HashMap map6 = new HashMap();
        ColorSpace colorSpace6 = ColorSpace.YUV444;
        map6.put(colorSpace6, new Idential());
        map6.put(colorSpace, new Yuv444pToRgb(0, 0));
        map6.put(colorSpace2, new Yuv444pToYuv420pHiBD(0, 0));
        map.put(colorSpace6, map6);
        HashMap map7 = new HashMap();
        ColorSpace colorSpace7 = ColorSpace.YUV444_10;
        map7.put(colorSpace7, new Idential());
        map7.put(colorSpace, new Yuv444pToRgb(2, 0));
        map7.put(colorSpace2, new Yuv444pToYuv420pHiBD(0, 2));
        map.put(colorSpace7, map7);
        HashMap map8 = new HashMap();
        map8.put(colorSpace3, new Idential());
        map8.put(colorSpace, new Yuv420jToRgbHiBD());
        map8.put(colorSpace2, new Yuv420jToYuv420HiBD());
        map.put(colorSpace3, map8);
        HashMap map9 = new HashMap();
        ColorSpace colorSpace8 = ColorSpace.YUV422J;
        map9.put(colorSpace8, new Idential());
        map9.put(colorSpace, new Yuv422jToRgbHiBD());
        map9.put(colorSpace2, new Yuv422jToYuv420pHiBD());
        map9.put(colorSpace3, new Yuv422pToYuv420pHiBD(0, 0));
        map.put(colorSpace8, map9);
        HashMap map10 = new HashMap();
        ColorSpace colorSpace9 = ColorSpace.YUV444J;
        map10.put(colorSpace9, new Idential());
        map10.put(colorSpace, new Yuv444jToRgbHiBD());
        map10.put(colorSpace2, new Yuv444jToYuv420pHiBD());
        map10.put(colorSpace3, new Yuv444pToYuv420pHiBD(0, 0));
        map.put(colorSpace9, map10);
    }

    public static TransformHiBD getTransform(ColorSpace colorSpace, ColorSpace colorSpace2) {
        Map<ColorSpace, TransformHiBD> map2 = map.get(colorSpace);
        if (map2 == null) {
            return null;
        }
        return map2.get(colorSpace2);
    }
}
