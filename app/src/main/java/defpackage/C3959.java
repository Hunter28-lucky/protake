package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blink.academy.film.player.view.FilmPlayer;
import com.blink.academy.film.player.view.FootagePanel;
import com.blink.academy.film.widgets.FilmSeekBar;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.StyleHintView;
import com.blink.academy.film.widgets.SubscribeDialog;
import com.blink.academy.film.widgets.TagView;
import com.blink.academy.film.widgets.dialog.SettingHintDialog;
import com.blink.academy.film.widgets.dialog.login.PrivacyWebView;
import com.blink.academy.film.widgets.transmit.ChangeTintImageView;
import com.blink.academy.film.widgets.transmit.ChangeTintLeftImageTextView;
import com.blink.academy.protake.R;

/* compiled from: ActivityPlayerBindingImpl.java */
/* renamed from: ࡦ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3959 extends AbstractC3958 {

    /* renamed from: ࡨ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13738 = null;

    /* renamed from: ࡩ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f13739;

    /* renamed from: ࡧ, reason: contains not printable characters */
    public long f13740;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13739 = sparseIntArray;
        sparseIntArray.put(R.id.player_card, 1);
        sparseIntArray.put(R.id.root_parent, 2);
        sparseIntArray.put(R.id.root, 3);
        sparseIntArray.put(R.id.player, 4);
        sparseIntArray.put(R.id.player_top, 5);
        sparseIntArray.put(R.id.tv_progress, 6);
        sparseIntArray.put(R.id.tv_name, 7);
        sparseIntArray.put(R.id.back_button, 8);
        sparseIntArray.put(R.id.iv_back, 9);
        sparseIntArray.put(R.id.iv_player_transmit, 10);
        sparseIntArray.put(R.id.tv_player_transmit, 11);
        sparseIntArray.put(R.id.home_tv_connected_num, 12);
        sparseIntArray.put(R.id.transmit_click, 13);
        sparseIntArray.put(R.id.bottom_container, 14);
        sparseIntArray.put(R.id.tv_multiple_filter, 15);
        sparseIntArray.put(R.id.tv_filter_all, 16);
        sparseIntArray.put(R.id.iv_filter_good, 17);
        sparseIntArray.put(R.id.iv_filter_keep, 18);
        sparseIntArray.put(R.id.iv_filter_ng, 19);
        sparseIntArray.put(R.id.filter_bg_click, 20);
        sparseIntArray.put(R.id.filter_all_click, 21);
        sparseIntArray.put(R.id.filter_good_click, 22);
        sparseIntArray.put(R.id.filter_keep_click, 23);
        sparseIntArray.put(R.id.filter_ng_click, 24);
        sparseIntArray.put(R.id.iv_fps, 25);
        sparseIntArray.put(R.id.iv_pre, 26);
        sparseIntArray.put(R.id.iv_play, 27);
        sparseIntArray.put(R.id.iv_next, 28);
        sparseIntArray.put(R.id.seek_bar, 29);
        sparseIntArray.put(R.id.iv_repeat, 30);
        sparseIntArray.put(R.id.iv_delete, 31);
        sparseIntArray.put(R.id.iv_folder, 32);
        sparseIntArray.put(R.id.iv_share, 33);
        sparseIntArray.put(R.id.share_click, 34);
        sparseIntArray.put(R.id.folder_click, 35);
        sparseIntArray.put(R.id.delete_click, 36);
        sparseIntArray.put(R.id.repeat_click, 37);
        sparseIntArray.put(R.id.play_click, 38);
        sparseIntArray.put(R.id.next_click, 39);
        sparseIntArray.put(R.id.pre_click, 40);
        sparseIntArray.put(R.id.bt_fps, 41);
        sparseIntArray.put(R.id.click_multiple, 42);
        sparseIntArray.put(R.id.tv_multiple, 43);
        sparseIntArray.put(R.id.tag_good, 44);
        sparseIntArray.put(R.id.tag_keep, 45);
        sparseIntArray.put(R.id.tag_ng, 46);
        sparseIntArray.put(R.id.rv_parent, 47);
        sparseIntArray.put(R.id.rv, 48);
        sparseIntArray.put(R.id.fps_panel, 49);
        sparseIntArray.put(R.id.hint_dialog, 50);
        sparseIntArray.put(R.id.play_fr, 51);
        sparseIntArray.put(R.id.subscribe_view, 52);
        sparseIntArray.put(R.id.sign_out_dialog, 53);
        sparseIntArray.put(R.id.click_view, 54);
        sparseIntArray.put(R.id.privacy_dialog, 55);
        sparseIntArray.put(R.id.privacy_web_view, 56);
        sparseIntArray.put(R.id.home_style_hint, 57);
    }

    public C3959(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 58, f13738, f13739));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f13740 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13740 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13740 = 1L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    public C3959(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[8], (RelativeLayout) objArr[14], (View) objArr[41], (RelativeLayout) objArr[42], (View) objArr[54], (View) objArr[36], (View) objArr[21], (View) objArr[20], (View) objArr[22], (View) objArr[23], (View) objArr[24], (View) objArr[35], (FootagePanel) objArr[49], (SettingHintDialog) objArr[50], (StyleHintView) objArr[57], (StrokeTextView) objArr[12], (ImageView) objArr[9], (ImageView) objArr[31], (ImageView) objArr[17], (ImageView) objArr[18], (ImageView) objArr[19], (ImageView) objArr[32], (ImageView) objArr[25], (ImageView) objArr[28], (ImageView) objArr[27], (ChangeTintImageView) objArr[10], (ImageView) objArr[26], (ImageView) objArr[30], (ImageView) objArr[33], (View) objArr[39], (View) objArr[38], (FrameLayout) objArr[51], (FilmPlayer) objArr[4], (CardView) objArr[1], (View) objArr[5], (View) objArr[40], (RelativeLayout) objArr[55], (PrivacyWebView) objArr[56], (View) objArr[37], (RelativeLayout) objArr[3], (ConstraintLayout) objArr[2], (RecyclerView) objArr[48], (FrameLayout) objArr[47], (FilmSeekBar) objArr[29], (View) objArr[34], (SettingHintDialog) objArr[53], (SubscribeDialog) objArr[52], (TagView) objArr[44], (TagView) objArr[45], (TagView) objArr[46], (View) objArr[13], (StrokeTextView) objArr[16], (StrokeTextView) objArr[43], (StrokeTextView) objArr[15], (StrokeTextView) objArr[7], (ChangeTintLeftImageTextView) objArr[11], (StrokeTextView) objArr[6], (ConstraintLayout) objArr[0]);
        this.f13740 = -1L;
        this.f13737.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
