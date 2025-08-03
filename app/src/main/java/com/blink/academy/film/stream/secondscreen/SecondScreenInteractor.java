package com.blink.academy.film.stream.secondscreen;

import android.app.Activity;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.WindowManager;
import androidx.core.hardware.display.DisplayManagerCompat;
import com.blink.academy.film.FilmApp;
import defpackage.C4638;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class SecondScreenInteractor {
    private static final String TAG = "SecondScreenInteractor";
    public DisplayManager.DisplayListener mDisplayListener;
    private SecondScreenListener mSecondScreenListener;
    public DisplayManager mDisplayManager = null;
    public ArrayList<Integer> mDisplayIds = new ArrayList<>();
    public ArrayList<Display> mCanUseDisplay = new ArrayList<>();
    public Display mSelectDisplay = null;

    public interface SecondScreenListener {
        void onSecondScreenReady(Display display);

        void onSecondScreenRemove();
    }

    public SecondScreenInteractor(Activity activity, SecondScreenListener secondScreenListener) {
        this.mSecondScreenListener = secondScreenListener;
        setupDisplays();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkSecondScreenReady() {
        this.mCanUseDisplay.clear();
        Display defaultDisplay = ((WindowManager) FilmApp.m405().getSystemService("window")).getDefaultDisplay();
        Iterator<Integer> it = this.mDisplayIds.iterator();
        while (it.hasNext()) {
            Display display = this.mDisplayManager.getDisplay(it.next().intValue());
            if (display != null && display.getDisplayId() != defaultDisplay.getDisplayId() && (display.getFlags() & 8) != 0) {
                this.mCanUseDisplay.add(display);
            }
        }
        if (this.mCanUseDisplay.size() <= 0) {
            this.mSelectDisplay = null;
            if (this.mSecondScreenListener != null) {
                C4638.m14099(TAG, String.format("onSecondScreenRemove : %s ", "null"));
                this.mSecondScreenListener.onSecondScreenRemove();
                return;
            }
            return;
        }
        Display display2 = this.mCanUseDisplay.get(0);
        if (this.mSelectDisplay != display2) {
            this.mSelectDisplay = display2;
            if (this.mSecondScreenListener != null) {
                C4638.m14099(TAG, String.format("onSecondScreenReady : %s ", display2.toString()));
                this.mSecondScreenListener.onSecondScreenReady(this.mSelectDisplay);
            }
        }
    }

    private void setupDisplays() {
        this.mDisplayManager = (DisplayManager) FilmApp.m405().getSystemService("display");
        this.mDisplayIds.clear();
        this.mCanUseDisplay.clear();
        this.mSelectDisplay = null;
        DisplayManager.DisplayListener displayListener = new DisplayManager.DisplayListener() { // from class: com.blink.academy.film.stream.secondscreen.SecondScreenInteractor.1
            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayAdded(int i) {
                Display display = SecondScreenInteractor.this.mDisplayManager.getDisplay(i);
                if (display != null) {
                    C4638.m14099(SecondScreenInteractor.TAG, String.format("Adding a display: %s", display.toString()));
                }
                SecondScreenInteractor.this.mDisplayIds.add(Integer.valueOf(i));
                SecondScreenInteractor.this.checkSecondScreenReady();
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayChanged(int i) {
                Display display = SecondScreenInteractor.this.mDisplayManager.getDisplay(i);
                if (display != null) {
                    C4638.m14099(SecondScreenInteractor.TAG, String.format("Updating a display : %s ", display.toString()));
                }
                SecondScreenInteractor.this.mDisplayIds.remove(Integer.valueOf(i));
                SecondScreenInteractor.this.mDisplayIds.add(Integer.valueOf(i));
                SecondScreenInteractor.this.checkSecondScreenReady();
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayRemoved(int i) {
                Display display = SecondScreenInteractor.this.mDisplayManager.getDisplay(i);
                if (display != null) {
                    C4638.m14099(SecondScreenInteractor.TAG, String.format("Removing a display: %s ", display.toString()));
                }
                SecondScreenInteractor.this.mDisplayIds.remove(Integer.valueOf(i));
                SecondScreenInteractor.this.checkSecondScreenReady();
            }
        };
        this.mDisplayListener = displayListener;
        this.mDisplayManager.registerDisplayListener(displayListener, null);
        Display defaultDisplay = ((WindowManager) FilmApp.m405().getSystemService("window")).getDefaultDisplay();
        if (!this.mDisplayIds.contains(Integer.valueOf(defaultDisplay.getDisplayId()))) {
            C4638.m14099(TAG, String.format("Adding default display : %s ", defaultDisplay.toString()));
            this.mDisplayIds.add(Integer.valueOf(defaultDisplay.getDisplayId()));
        }
        for (Display display : this.mDisplayManager.getDisplays(DisplayManagerCompat.DISPLAY_CATEGORY_PRESENTATION)) {
            C4638.m14099(TAG, String.format("Adding a display : %s ", display.toString()));
            this.mDisplayIds.add(Integer.valueOf(display.getDisplayId()));
        }
        checkSecondScreenReady();
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void release() {
        C4638.m14099(TAG, String.format("release : %s ", "SecondScreenInteractor"));
        DisplayManager displayManager = this.mDisplayManager;
        if (displayManager != null) {
            displayManager.unregisterDisplayListener(this.mDisplayListener);
        }
        this.mDisplayListener = null;
        this.mDisplayManager = null;
        this.mDisplayIds.clear();
        this.mCanUseDisplay.clear();
        this.mSelectDisplay = null;
        SecondScreenListener secondScreenListener = this.mSecondScreenListener;
        if (secondScreenListener != null) {
            secondScreenListener.onSecondScreenRemove();
        }
        this.mSecondScreenListener = null;
    }
}
