package defpackage;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: CustomDividerItemDecoration.java */
/* renamed from: ဎ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5101 extends RecyclerView.ItemDecoration {

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final int[] f16939 = {R.attr.listDivider};

    /* renamed from: Ϳ, reason: contains not printable characters */
    public Drawable f16940;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int f16941;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final Rect f16942 = new Rect();

    public C5101(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(f16939);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        this.f16940 = drawable;
        if (drawable == null) {
            Log.w("DividerItem", "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        typedArrayObtainStyledAttributes.recycle();
        setOrientation(i);
    }

    public final void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        int height;
        int paddingTop;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            paddingTop = recyclerView.getPaddingTop();
            height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), paddingTop, recyclerView.getWidth() - recyclerView.getPaddingRight(), height);
        } else {
            height = recyclerView.getHeight();
            paddingTop = 0;
        }
        int childCount = recyclerView.getChildCount() - 1;
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(childAt, this.f16942);
                int iRound = this.f16942.right + Math.round(childAt.getTranslationX());
                this.f16940.setBounds(iRound - this.f16940.getIntrinsicWidth(), paddingTop, iRound, height);
                this.f16940.draw(canvas);
            }
        }
        canvas.restore();
    }

    public final void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int width;
        int paddingLeft;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            paddingLeft = recyclerView.getPaddingLeft();
            width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(paddingLeft, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            width = recyclerView.getWidth();
            paddingLeft = 0;
        }
        int childCount = recyclerView.getChildCount() - 1;
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                recyclerView.getDecoratedBoundsWithMargins(childAt, this.f16942);
                int iRound = this.f16942.bottom + Math.round(childAt.getTranslationY());
                this.f16940.setBounds(paddingLeft, iRound - this.f16940.getIntrinsicHeight(), width, iRound);
                this.f16940.draw(canvas);
            }
        }
        canvas.restore();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Drawable drawable = this.f16940;
        if (drawable == null) {
            rect.set(0, 0, 0, 0);
        } else if (this.f16941 == 1) {
            rect.set(0, 0, 0, drawable.getIntrinsicHeight());
        } else {
            rect.set(0, 0, drawable.getIntrinsicWidth(), 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getLayoutManager() == null || this.f16940 == null) {
            return;
        }
        if (this.f16941 == 1) {
            drawVertical(canvas, recyclerView);
        } else {
            drawHorizontal(canvas, recyclerView);
        }
    }

    public void setDrawable(@NonNull Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Drawable cannot be null.");
        }
        this.f16940 = drawable;
    }

    public void setOrientation(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
        }
        this.f16941 = i;
    }
}
