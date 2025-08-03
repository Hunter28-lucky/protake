package org.jcodec.scale;

import java.util.HashMap;
import java.util.Map;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;

/* loaded from: classes2.dex */
public class ColorUtil {
    private static Map<ColorSpace, Map<ColorSpace, Transform>> map = new HashMap();

    public static class Idential implements Transform {
        @Override // org.jcodec.scale.Transform
        public void transform(Picture picture, Picture picture2) {
            for (int i = 0; i < Math.min(picture.getData().length, picture2.getData().length); i++) {
                System.arraycopy(picture.getPlaneData(i), 0, picture2.getPlaneData(i), 0, Math.min(picture.getPlaneData(i).length, picture2.getPlaneData(i).length));
            }
            byte[][] lowBits = picture.getLowBits();
            byte[][] lowBits2 = picture2.getLowBits();
            if (lowBits == null || lowBits2 == null) {
                return;
            }
            for (int i2 = 0; i2 < Math.min(picture.getData().length, picture2.getData().length); i2++) {
                System.arraycopy(lowBits[i2], 0, lowBits2[i2], 0, Math.min(picture.getPlaneData(i2).length, picture2.getPlaneData(i2).length));
            }
        }
    }

    static {
        HashMap map2 = new HashMap();
        ColorSpace colorSpace = ColorSpace.RGB;
        map2.put(colorSpace, new Idential());
        ColorSpace colorSpace2 = ColorSpace.YUV420J;
        map2.put(colorSpace2, new RgbToYuv420j());
        ColorSpace colorSpace3 = ColorSpace.YUV420;
        map2.put(colorSpace3, new RgbToYuv420p());
        ColorSpace colorSpace4 = ColorSpace.YUV422;
        map2.put(colorSpace4, new RgbToYuv422p());
        map.put(colorSpace, map2);
        HashMap map3 = new HashMap();
        map3.put(colorSpace3, new Idential());
        map3.put(colorSpace4, new Yuv420pToYuv422p());
        map3.put(colorSpace, new Yuv420pToRgb());
        map3.put(colorSpace2, new Idential());
        map.put(colorSpace3, map3);
        HashMap map4 = new HashMap();
        map4.put(colorSpace4, new Idential());
        map4.put(colorSpace3, new Yuv422pToYuv420p());
        map4.put(colorSpace2, new Yuv422pToYuv420p());
        map4.put(colorSpace, new Yuv422pToRgb());
        map.put(colorSpace4, map4);
        HashMap map5 = new HashMap();
        ColorSpace colorSpace5 = ColorSpace.YUV444;
        map5.put(colorSpace5, new Idential());
        map.put(colorSpace5, map5);
        HashMap map6 = new HashMap();
        ColorSpace colorSpace6 = ColorSpace.YUV444J;
        map6.put(colorSpace6, new Idential());
        map6.put(colorSpace2, new Yuv444jToYuv420j());
        map.put(colorSpace6, map6);
        HashMap map7 = new HashMap();
        map7.put(colorSpace2, new Idential());
        map7.put(colorSpace4, new Yuv420pToYuv422p());
        map7.put(colorSpace, new Yuv420jToRgb());
        map7.put(colorSpace3, new Idential());
        map.put(colorSpace2, map7);
    }

    public static Transform getTransform(ColorSpace colorSpace, ColorSpace colorSpace2) {
        Map<ColorSpace, Transform> map2 = map.get(colorSpace);
        if (map2 == null) {
            return null;
        }
        return map2.get(colorSpace2);
    }
}
