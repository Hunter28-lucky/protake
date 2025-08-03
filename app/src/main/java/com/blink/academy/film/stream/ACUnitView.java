package com.blink.academy.film.stream;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import com.blink.academy.film.support.face.ui.C0789;
import com.blink.academy.film.support.face.ui.GraphicOverlay;
import com.blink.academy.protake.R;
import defpackage.AbstractC4418;
import defpackage.C2870;
import defpackage.C3483;
import java.util.List;

/* loaded from: classes.dex */
public class ACUnitView extends RelativeLayout {
    public static final int LINK_INDEX_A = 0;
    public static final int LINK_INDEX_B = 1;
    public static final int LINK_INDEX_C = 2;
    public static final int LINK_INDEX_D = 3;
    public static final int LINK_INDEX_OFF = -1;
    private C0789 faceDataStabilization;
    private GraphicOverlay graphicOverlay;
    private AbstractC4418 mBinding;
    private int mLinkIndex;

    public ACUnitView(Context context) {
        super(context);
        this.mLinkIndex = -1;
        init(context);
    }

    private void init(Context context) {
        this.mBinding = (AbstractC4418) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_ac_unit_view, this, true);
        initListener();
        this.mBinding.f15234.setVisibility(8);
        this.mBinding.f15231.setVisibility(8);
        this.graphicOverlay = this.mBinding.f15232;
        this.faceDataStabilization = new C0789(this.graphicOverlay);
        this.mBinding.f15233.setFaceDetectCallback(new C2870.InterfaceC2871() { // from class: com.blink.academy.film.stream.ACUnitView.1
            @Override // defpackage.C2870.InterfaceC2871
            public void onFaceDetected(List<C3483> list, int i, int i2) {
                ACUnitView.this.faceDataStabilization.m1901(list, i, i2);
            }
        });
    }

    private void initListener() {
        this.mBinding.f15226.setOnClickListener(new View.OnClickListener() { // from class: com.blink.academy.film.stream.ACUnitView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ACUnitView.this.mLinkIndex = 0;
                ACUnitView.this.mBinding.f15233.setLinkIndex(0);
            }
        });
        this.mBinding.f15227.setOnClickListener(new View.OnClickListener() { // from class: com.blink.academy.film.stream.ACUnitView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ACUnitView.this.mLinkIndex = 1;
                ACUnitView.this.mBinding.f15233.setLinkIndex(1);
            }
        });
        this.mBinding.f15228.setOnClickListener(new View.OnClickListener() { // from class: com.blink.academy.film.stream.ACUnitView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ACUnitView.this.mLinkIndex = 2;
                ACUnitView.this.mBinding.f15233.setLinkIndex(2);
            }
        });
        this.mBinding.f15230.setOnClickListener(new View.OnClickListener() { // from class: com.blink.academy.film.stream.ACUnitView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ACUnitView.this.mLinkIndex = 3;
                ACUnitView.this.mBinding.f15233.setLinkIndex(3);
            }
        });
        this.mBinding.f15229.setOnClickListener(new View.OnClickListener() { // from class: com.blink.academy.film.stream.ACUnitView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ACUnitView.this.mLinkIndex = -1;
                ACUnitView.this.mBinding.f15233.setLinkIndex(-1);
            }
        });
    }

    public void changeToTestMode() {
        this.mBinding.f15234.setVisibility(0);
        this.mBinding.f15231.setVisibility(0);
    }

    public void clearTexture() {
        this.mBinding.f15233.setDrawData(-1, this.mLinkIndex, null, 0, 0);
    }

    public void enableFaceDetect(boolean z) {
        this.mBinding.f15233.enableFaceDetectEngine(z);
        enableFaceOverlay(z);
    }

    public void enableFaceOverlay(boolean z) {
        if (z) {
            this.graphicOverlay.m1894(true);
        } else {
            this.graphicOverlay.m1894(false);
            this.graphicOverlay.m1893();
        }
    }

    public int getLinkIndex() {
        return this.mLinkIndex;
    }

    public ACGLTextureView getTextureView() {
        return this.mBinding.f15233;
    }

    public void refreshConnBtnState() {
        this.mBinding.f15226.setTextColor(-65536);
        this.mBinding.f15227.setTextColor(-65536);
        this.mBinding.f15228.setTextColor(-65536);
        this.mBinding.f15230.setTextColor(-65536);
        this.mBinding.f15226.setEnabled(false);
        this.mBinding.f15227.setEnabled(false);
        this.mBinding.f15228.setEnabled(false);
        this.mBinding.f15230.setEnabled(false);
        if (FinderManager.getInstance().machineCanConnect("1") > 0) {
            this.mBinding.f15226.setEnabled(true);
            if (this.mLinkIndex == 0) {
                this.mBinding.f15226.setTextColor(-16711936);
                this.mBinding.f15233.setCanRender(true);
            } else {
                this.mBinding.f15226.setTextColor(-1);
            }
        } else if (this.mLinkIndex == 0) {
            this.mLinkIndex = -1;
            this.mBinding.f15233.setLinkIndex(-1);
        }
        if (FinderManager.getInstance().machineCanConnect("2") > 0) {
            this.mBinding.f15227.setEnabled(true);
            if (this.mLinkIndex == 1) {
                this.mBinding.f15227.setTextColor(-16711936);
                this.mBinding.f15233.setCanRender(true);
            } else {
                this.mBinding.f15227.setTextColor(-1);
            }
        } else if (this.mLinkIndex == 1) {
            this.mLinkIndex = -1;
            this.mBinding.f15233.setLinkIndex(-1);
        }
        if (FinderManager.getInstance().machineCanConnect(FinderManager.MACHINE_C) > 0) {
            this.mBinding.f15228.setEnabled(true);
            if (this.mLinkIndex == 2) {
                this.mBinding.f15233.setCanRender(true);
                this.mBinding.f15228.setTextColor(-16711936);
            } else {
                this.mBinding.f15228.setTextColor(-1);
            }
        } else if (this.mLinkIndex == 2) {
            this.mLinkIndex = -1;
            this.mBinding.f15233.setLinkIndex(-1);
        }
        if (FinderManager.getInstance().machineCanConnect(FinderManager.MACHINE_D) > 0) {
            this.mBinding.f15230.setEnabled(true);
            if (this.mLinkIndex == 3) {
                this.mBinding.f15233.setCanRender(true);
                this.mBinding.f15230.setTextColor(-16711936);
            } else {
                this.mBinding.f15230.setTextColor(-1);
            }
        } else if (this.mLinkIndex == 3) {
            this.mLinkIndex = -1;
            this.mBinding.f15233.setLinkIndex(-1);
        }
        if (this.mLinkIndex == -1) {
            this.mBinding.f15233.setCanRender(false);
            this.mBinding.f15229.setTextColor(-16711936);
        } else {
            this.mBinding.f15229.setTextColor(-1);
        }
        enableFaceOverlay(this.mBinding.f15233.isCanRender());
        int linkStatusByLinkIndex = LinkManager.getInstance().getLinkStatusByLinkIndex(this.mLinkIndex);
        ACCameraInfoBean aCCameraInfoBeanByLinkIndex = LinkManager.getInstance().getACCameraInfoBeanByLinkIndex(this.mLinkIndex);
        StringBuilder sb = new StringBuilder();
        sb.append("link status:" + linkStatusByLinkIndex);
        if (aCCameraInfoBeanByLinkIndex != null && aCCameraInfoBeanByLinkIndex.isInit()) {
            sb.append("machine:");
            sb.append(aCCameraInfoBeanByLinkIndex.getMachine());
            sb.append("WiFi-Level:");
            sb.append(ACHelper.getInstance().wifiLevel(aCCameraInfoBeanByLinkIndex.getWifiStatus()));
            sb.append("res:");
            sb.append(aCCameraInfoBeanByLinkIndex.getDimension());
            sb.append("fps:");
            sb.append(aCCameraInfoBeanByLinkIndex.getFps());
            sb.append("ratio:");
            sb.append(aCCameraInfoBeanByLinkIndex.getRatio());
        }
        this.mBinding.f15234.setText(sb.toString());
    }

    public void setInSingle(boolean z) {
        this.mBinding.f15233.setSingle(z);
    }

    public void setLinkIndex(int i) {
        this.mLinkIndex = i;
        this.mBinding.f15233.setLinkIndex(i);
    }

    public void setTextureCanRender(boolean z) {
        this.mBinding.f15233.setCanRender(z);
        enableFaceOverlay(z);
    }

    public ACUnitView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLinkIndex = -1;
        init(context);
    }

    public ACUnitView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLinkIndex = -1;
        init(context);
    }
}
