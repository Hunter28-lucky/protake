package com.blink.academy.film.player.jz.cn.jzvd;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import com.blink.academy.protake.R;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class JzvdStd extends Jzvd {
    public static Timer DISMISS_CONTROL_VIEW_TIMER = null;
    public static int LAST_GET_BATTERYLEVEL_PERCENT = 70;
    public static long LAST_GET_BATTERYLEVEL_TIME;
    public ImageView backButton;
    public BroadcastReceiver battertReceiver;
    public ImageView batteryLevel;
    public LinearLayout batteryTimeLayout;
    public ProgressBar bottomProgressBar;
    public TextView clarity;
    public PopupWindow clarityPopWindow;
    public ArrayDeque<Runnable> delayTask;
    public GestureDetector gestureDetector;
    public ProgressBar loadingProgressBar;
    public Dialog mBrightnessDialog;
    public ProgressBar mDialogBrightnessProgressBar;
    public TextView mDialogBrightnessTextView;
    public ImageView mDialogIcon;
    public ProgressBar mDialogProgressBar;
    public TextView mDialogSeekTime;
    public TextView mDialogTotalTime;
    public ImageView mDialogVolumeImageView;
    public ProgressBar mDialogVolumeProgressBar;
    public TextView mDialogVolumeTextView;
    public DismissControlViewTimerTask mDismissControlViewTimerTask;
    public boolean mIsWifi;
    public Dialog mProgressDialog;
    public TextView mRetryBtn;
    public LinearLayout mRetryLayout;
    public Dialog mVolumeDialog;
    public ImageView posterImageView;
    public TextView replayTextView;
    public ImageView tinyBackImageView;
    public TextView titleTextView;
    public TextView videoCurrentTime;
    public BroadcastReceiver wifiReceiver;

    public class DismissControlViewTimerTask extends TimerTask {
        public DismissControlViewTimerTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            JzvdStd.this.dissmissControlView();
        }
    }

    /* renamed from: com.blink.academy.film.player.jz.cn.jzvd.JzvdStd$Ϳ, reason: contains not printable characters */
    public class C0563 extends BroadcastReceiver {
        public C0563() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                JzvdStd.LAST_GET_BATTERYLEVEL_PERCENT = (intent.getIntExtra("level", 0) * 100) / intent.getIntExtra("scale", 100);
                JzvdStd.this.setBatteryLevel();
                try {
                    JzvdStd jzvdStd = JzvdStd.this;
                    jzvdStd.jzvdContext.unregisterReceiver(jzvdStd.battertReceiver);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.player.jz.cn.jzvd.JzvdStd$Ԩ, reason: contains not printable characters */
    public class C0564 extends BroadcastReceiver {
        public C0564() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                boolean zIsWifiConnected = JZUtils.isWifiConnected(context);
                JzvdStd jzvdStd = JzvdStd.this;
                if (jzvdStd.mIsWifi == zIsWifiConnected) {
                    return;
                }
                jzvdStd.mIsWifi = zIsWifiConnected;
                if (zIsWifiConnected || Jzvd.WIFI_TIP_DIALOG_SHOWED || jzvdStd.state != 5) {
                    return;
                }
                jzvdStd.startButton.performClick();
                JzvdStd.this.showWifiDialog();
            }
        }
    }

    /* renamed from: com.blink.academy.film.player.jz.cn.jzvd.JzvdStd$Ԫ, reason: contains not printable characters */
    public class C0565 extends GestureDetector.SimpleOnGestureListener {
        public C0565() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            int i = JzvdStd.this.state;
            if (i == 5 || i == 6) {
                Log.d("JZVD", "doublClick [" + hashCode() + "] ");
                JzvdStd.this.startButton.performClick();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            JzvdStd jzvdStd = JzvdStd.this;
            if (!jzvdStd.mChangePosition && !jzvdStd.mChangeVolume) {
                jzvdStd.onClickUiToggle();
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    public JzvdStd(Context context) {
        super(context);
        this.battertReceiver = new C0563();
        this.wifiReceiver = new C0564();
        this.delayTask = new ArrayDeque<>();
        this.gestureDetector = new GestureDetector(getContext().getApplicationContext(), new C0565());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dissmissControlView$0() {
        this.bottomContainer.setVisibility(4);
        this.topContainer.setVisibility(4);
        this.startButton.setVisibility(4);
        if (this.screen != 2) {
            this.bottomProgressBar.setVisibility(0);
        }
    }

    public void cancelDismissControlViewTimer() {
        Timer timer = DISMISS_CONTROL_VIEW_TIMER;
        if (timer != null) {
            timer.cancel();
        }
        DismissControlViewTimerTask dismissControlViewTimerTask = this.mDismissControlViewTimerTask;
        if (dismissControlViewTimerTask != null) {
            dismissControlViewTimerTask.cancel();
        }
    }

    public void changeStartButtonSize(int i) {
        ViewGroup.LayoutParams layoutParams = this.startButton.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        ViewGroup.LayoutParams layoutParams2 = this.loadingProgressBar.getLayoutParams();
        layoutParams2.height = i;
        layoutParams2.width = i;
    }

    public void changeUIToPreparingChangeUrl() {
        int i = this.screen;
        if (i == 0 || i == 1) {
            setAllControlsVisiblity(4, 4, 4, 0, 0, 4, 4);
            updateStartImage();
        }
    }

    public void changeUIToPreparingPlaying() {
        int i = this.screen;
        if (i == 0 || i == 1) {
            setAllControlsVisiblity(0, 0, 4, 0, 4, 4, 4);
            updateStartImage();
        }
    }

    public void changeUiToComplete() {
        int i = this.screen;
        if (i == 0 || i == 1) {
            setAllControlsVisiblity(0, 4, 0, 4, 0, 4, 4);
            updateStartImage();
        }
    }

    public void changeUiToError() {
        int i = this.screen;
        if (i == 0) {
            setAllControlsVisiblity(4, 4, 0, 4, 4, 4, 0);
            updateStartImage();
        } else {
            if (i != 1) {
                return;
            }
            setAllControlsVisiblity(0, 4, 0, 4, 4, 4, 0);
            updateStartImage();
        }
    }

    public void changeUiToNormal() {
        int i = this.screen;
        if (i == 0 || i == 1) {
            setAllControlsVisiblity(0, 4, 0, 4, 0, 4, 4);
            updateStartImage();
        }
    }

    public void changeUiToPauseClear() {
        int i = this.screen;
        if (i == 0 || i == 1) {
            setAllControlsVisiblity(4, 4, 4, 4, 4, 0, 4);
        }
    }

    public void changeUiToPauseShow() {
        int i = this.screen;
        if (i == 0 || i == 1) {
            setAllControlsVisiblity(0, 0, 0, 4, 4, 4, 4);
            updateStartImage();
        }
    }

    public void changeUiToPlayingClear() {
        int i = this.screen;
        if (i == 0 || i == 1) {
            setAllControlsVisiblity(4, 4, 4, 4, 4, 0, 4);
        }
    }

    public void changeUiToPlayingShow() {
        int i = this.screen;
        if (i == 0 || i == 1) {
            setAllControlsVisiblity(0, 0, 0, 4, 4, 4, 4);
            updateStartImage();
        }
    }

    public void changeUiToPreparing() {
        int i = this.screen;
        if (i == 0 || i == 1) {
            setAllControlsVisiblity(4, 4, 4, 0, 0, 4, 4);
            updateStartImage();
        }
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd
    public void changeUrl(JZDataSource jZDataSource, long j) {
        super.changeUrl(jZDataSource, j);
        this.titleTextView.setText(jZDataSource.title);
    }

    public void clickBack() {
        Jzvd.backPress();
    }

    public void clickBackTiny() {
        clearFloatScreen();
    }

    public void clickPoster() {
        JZDataSource jZDataSource = this.jzDataSource;
        if (jZDataSource == null || jZDataSource.urlsMap.isEmpty() || this.jzDataSource.getCurrentUrl() == null) {
            return;
        }
        int i = this.state;
        if (i != 0) {
            if (i == 7) {
                onClickUiToggle();
            }
        } else if (this.jzDataSource.getCurrentUrl().toString().startsWith("file") || this.jzDataSource.getCurrentUrl().toString().startsWith("/") || JZUtils.isWifiConnected(this.jzvdContext) || Jzvd.WIFI_TIP_DIALOG_SHOWED) {
            startVideo();
        } else {
            showWifiDialog();
        }
    }

    public void clickRetryBtn() {
        if (this.jzDataSource.urlsMap.isEmpty() || this.jzDataSource.getCurrentUrl() == null) {
            return;
        }
        if (!this.jzDataSource.getCurrentUrl().toString().startsWith("file") && !this.jzDataSource.getCurrentUrl().toString().startsWith("/") && !JZUtils.isWifiConnected(this.jzvdContext) && !Jzvd.WIFI_TIP_DIALOG_SHOWED) {
            showWifiDialog();
        } else {
            this.seekToInAdvance = this.mCurrentPosition;
            startVideo();
        }
    }

    public void clickSurfaceContainer() {
        startDismissControlViewTimer();
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd
    public void dismissBrightnessDialog() {
        super.dismissBrightnessDialog();
        Dialog dialog = this.mBrightnessDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd
    public void dismissProgressDialog() {
        super.dismissProgressDialog();
        Dialog dialog = this.mProgressDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd
    public void dismissVolumeDialog() {
        super.dismissVolumeDialog();
        Dialog dialog = this.mVolumeDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void dissmissControlView() {
        int i = this.state;
        if (i == 0 || i == 8 || i == 7) {
            return;
        }
        post(new Runnable() { // from class: ɑ
            @Override // java.lang.Runnable
            public final void run() {
                this.f9572.lambda$dissmissControlView$0();
            }
        });
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd
    public int getLayoutId() {
        return R.layout.jz_layout_std;
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd
    public void init(Context context) {
        super.init(context);
        this.batteryTimeLayout = (LinearLayout) findViewById(R.id.battery_time_layout);
        this.bottomProgressBar = (ProgressBar) findViewById(R.id.bottom_progress);
        this.titleTextView = (TextView) findViewById(R.id.title);
        this.backButton = (ImageView) findViewById(R.id.back);
        this.posterImageView = (ImageView) findViewById(R.id.poster);
        this.loadingProgressBar = (ProgressBar) findViewById(R.id.loading);
        this.tinyBackImageView = (ImageView) findViewById(R.id.back_tiny);
        this.batteryLevel = (ImageView) findViewById(R.id.battery_level);
        this.videoCurrentTime = (TextView) findViewById(R.id.video_current_time);
        this.replayTextView = (TextView) findViewById(R.id.replay_text);
        this.clarity = (TextView) findViewById(R.id.clarity);
        this.mRetryBtn = (TextView) findViewById(R.id.retry_btn);
        this.mRetryLayout = (LinearLayout) findViewById(R.id.retry_layout);
        if (this.batteryTimeLayout == null) {
            this.batteryTimeLayout = new LinearLayout(context);
        }
        if (this.bottomProgressBar == null) {
            this.bottomProgressBar = new ProgressBar(context);
        }
        if (this.titleTextView == null) {
            this.titleTextView = new TextView(context);
        }
        if (this.backButton == null) {
            this.backButton = new ImageView(context);
        }
        if (this.posterImageView == null) {
            this.posterImageView = new ImageView(context);
        }
        if (this.loadingProgressBar == null) {
            this.loadingProgressBar = new ProgressBar(context);
        }
        if (this.tinyBackImageView == null) {
            this.tinyBackImageView = new ImageView(context);
        }
        if (this.batteryLevel == null) {
            this.batteryLevel = new ImageView(context);
        }
        if (this.videoCurrentTime == null) {
            this.videoCurrentTime = new TextView(context);
        }
        if (this.replayTextView == null) {
            this.replayTextView = new TextView(context);
        }
        if (this.clarity == null) {
            this.clarity = new TextView(context);
        }
        if (this.mRetryBtn == null) {
            this.mRetryBtn = new TextView(context);
        }
        if (this.mRetryLayout == null) {
            this.mRetryLayout = new LinearLayout(context);
        }
        this.posterImageView.setOnClickListener(this);
        this.backButton.setOnClickListener(this);
        this.tinyBackImageView.setOnClickListener(this);
        this.clarity.setOnClickListener(this);
        this.mRetryBtn.setOnClickListener(this);
    }

    public void onCLickUiToggleToClear() {
        int i = this.state;
        if (i == 1) {
            if (this.bottomContainer.getVisibility() == 0) {
                changeUiToPreparing();
            }
        } else if (i == 5) {
            if (this.bottomContainer.getVisibility() == 0) {
                changeUiToPlayingClear();
            }
        } else if (i == 6) {
            if (this.bottomContainer.getVisibility() == 0) {
                changeUiToPauseClear();
            }
        } else if (i == 7 && this.bottomContainer.getVisibility() == 0) {
            changeUiToComplete();
        }
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == R.id.poster) {
            clickPoster();
            return;
        }
        if (id == R.id.surface_container) {
            clickSurfaceContainer();
            PopupWindow popupWindow = this.clarityPopWindow;
            if (popupWindow != null) {
                popupWindow.dismiss();
                return;
            }
            return;
        }
        if (id == R.id.back) {
            clickBack();
            return;
        }
        if (id == R.id.back_tiny) {
            clickBackTiny();
        } else if (id != R.id.clarity && id == R.id.retry_btn) {
            clickRetryBtn();
        }
    }

    public void onClickUiToggle() {
        if (this.bottomContainer.getVisibility() != 0) {
            setSystemTimeAndBattery();
            this.clarity.setText(this.jzDataSource.getCurrentKey().toString());
        }
        int i = this.state;
        if (i == 1) {
            changeUiToPreparing();
            if (this.bottomContainer.getVisibility() == 0) {
                return;
            }
            setSystemTimeAndBattery();
            return;
        }
        if (i == 5) {
            if (this.bottomContainer.getVisibility() == 0) {
                changeUiToPlayingClear();
                return;
            } else {
                changeUiToPlayingShow();
                return;
            }
        }
        if (i == 6) {
            if (this.bottomContainer.getVisibility() == 0) {
                changeUiToPauseClear();
            } else {
                changeUiToPauseShow();
            }
        }
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd
    public void onCompletion() {
        super.onCompletion();
        cancelDismissControlViewTimer();
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd
    public void onProgress(int i, long j, long j2) {
        super.onProgress(i, j, j2);
        this.bottomProgressBar.setProgress(i);
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        super.onStartTrackingTouch(seekBar);
        cancelDismissControlViewTimer();
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd
    public void onStateAutoComplete() {
        super.onStateAutoComplete();
        changeUiToComplete();
        cancelDismissControlViewTimer();
        this.bottomProgressBar.setProgress(100);
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd
    public void onStateError() {
        super.onStateError();
        changeUiToError();
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd
    public void onStateNormal() {
        super.onStateNormal();
        changeUiToNormal();
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd
    public void onStatePause() {
        super.onStatePause();
        changeUiToPauseShow();
        cancelDismissControlViewTimer();
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd
    public void onStatePlaying() {
        super.onStatePlaying();
        changeUiToPlayingClear();
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd
    public void onStatePreparing() {
        super.onStatePreparing();
        changeUiToPreparing();
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd
    public void onStatePreparingChangeUrl() {
        super.onStatePreparingChangeUrl();
        changeUIToPreparingChangeUrl();
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd
    public void onStatePreparingPlaying() {
        super.onStatePreparingPlaying();
        changeUIToPreparingPlaying();
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        super.onStopTrackingTouch(seekBar);
        startDismissControlViewTimer();
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int id = view.getId();
        if (id == R.id.surface_container) {
            if (motionEvent.getAction() == 1) {
                startDismissControlViewTimer();
                if (this.mChangePosition) {
                    long duration = getDuration();
                    long j = this.mSeekTimePosition * 100;
                    if (duration == 0) {
                        duration = 1;
                    }
                    this.bottomProgressBar.setProgress((int) (j / duration));
                }
            }
            this.gestureDetector.onTouchEvent(motionEvent);
        } else if (id == R.id.bottom_seek_progress) {
            int action = motionEvent.getAction();
            if (action == 0) {
                cancelDismissControlViewTimer();
            } else if (action == 1) {
                startDismissControlViewTimer();
            }
        }
        return super.onTouch(view, motionEvent);
    }

    public void registerWifiListener(Context context) {
        if (context == null) {
            return;
        }
        this.mIsWifi = JZUtils.isWifiConnected(context);
        context.registerReceiver(this.wifiReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd
    public void reset() {
        super.reset();
        cancelDismissControlViewTimer();
        unregisterWifiListener(getApplicationContext());
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd
    public void resetProgressAndTime() {
        super.resetProgressAndTime();
        this.bottomProgressBar.setProgress(0);
        this.bottomProgressBar.setSecondaryProgress(0);
    }

    public void setAllControlsVisiblity(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.topContainer.setVisibility(i);
        this.bottomContainer.setVisibility(i2);
        this.startButton.setVisibility(i3);
        this.loadingProgressBar.setVisibility(i4);
        this.posterImageView.setVisibility(i5);
        this.bottomProgressBar.setVisibility(i6);
        this.mRetryLayout.setVisibility(i7);
    }

    public void setBatteryLevel() {
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd
    public void setBufferProgress(int i) {
        super.setBufferProgress(i);
        this.bottomProgressBar.setSecondaryProgress(i);
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd
    public void setScreenFullscreen() {
        super.setScreenFullscreen();
        this.backButton.setVisibility(0);
        this.tinyBackImageView.setVisibility(4);
        this.batteryTimeLayout.setVisibility(0);
        if (this.jzDataSource.urlsMap.size() == 1) {
            this.clarity.setVisibility(8);
        } else {
            this.clarity.setText(this.jzDataSource.getCurrentKey().toString());
            this.clarity.setVisibility(0);
        }
        setSystemTimeAndBattery();
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd
    public void setScreenNormal() {
        super.setScreenNormal();
        this.backButton.setVisibility(8);
        this.tinyBackImageView.setVisibility(4);
        this.batteryTimeLayout.setVisibility(8);
        this.clarity.setVisibility(8);
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd
    public void setScreenTiny() {
        super.setScreenTiny();
        this.tinyBackImageView.setVisibility(0);
        setAllControlsVisiblity(4, 4, 4, 4, 4, 4, 4);
        this.batteryTimeLayout.setVisibility(8);
        this.clarity.setVisibility(8);
    }

    public void setSystemTimeAndBattery() {
        this.videoCurrentTime.setText(new SimpleDateFormat("HH:mm").format(new Date()));
        if (System.currentTimeMillis() - LAST_GET_BATTERYLEVEL_TIME <= 30000) {
            setBatteryLevel();
        } else {
            LAST_GET_BATTERYLEVEL_TIME = System.currentTimeMillis();
            this.jzvdContext.registerReceiver(this.battertReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        }
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd
    public void setUp(JZDataSource jZDataSource, int i, Class cls) {
        if (System.currentTimeMillis() - this.gobakFullscreenTime >= 200 && System.currentTimeMillis() - this.gotoFullscreenTime >= 200) {
            super.setUp(jZDataSource, i, cls);
            this.titleTextView.setText(jZDataSource.title);
            setScreen(i);
        }
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd
    public void showBrightnessDialog(int i) {
        super.showBrightnessDialog(i);
        onCLickUiToggleToClear();
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd
    public void showProgressDialog(float f, String str, long j, String str2, long j2) {
        super.showProgressDialog(f, str, j, str2, j2);
        onCLickUiToggleToClear();
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd
    public void showVolumeDialog(float f, int i) {
        super.showVolumeDialog(f, i);
        onCLickUiToggleToClear();
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd
    public void showWifiDialog() {
        super.showWifiDialog();
    }

    public void startDismissControlViewTimer() {
        cancelDismissControlViewTimer();
        DISMISS_CONTROL_VIEW_TIMER = new Timer();
        DismissControlViewTimerTask dismissControlViewTimerTask = new DismissControlViewTimerTask();
        this.mDismissControlViewTimerTask = dismissControlViewTimerTask;
        DISMISS_CONTROL_VIEW_TIMER.schedule(dismissControlViewTimerTask, 2500L);
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd
    public void startVideo() {
        super.startVideo();
        registerWifiListener(getApplicationContext());
    }

    public void unregisterWifiListener(Context context) {
        if (context == null) {
            return;
        }
        try {
            context.unregisterReceiver(this.wifiReceiver);
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        }
    }

    public void updateStartImage() {
    }

    public JzvdStd(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.battertReceiver = new C0563();
        this.wifiReceiver = new C0564();
        this.delayTask = new ArrayDeque<>();
        this.gestureDetector = new GestureDetector(getContext().getApplicationContext(), new C0565());
    }
}
