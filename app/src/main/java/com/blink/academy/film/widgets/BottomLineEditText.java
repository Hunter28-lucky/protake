package com.blink.academy.film.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import defpackage.C2579;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class BottomLineEditText extends AppCompatEditText {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Paint f1997;

    /* renamed from: com.blink.academy.film.widgets.BottomLineEditText$Ϳ, reason: contains not printable characters */
    public class ViewOnTouchListenerC0871 implements View.OnTouchListener {
        public ViewOnTouchListenerC0871() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            BottomLineEditText.this.clearFocus();
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.BottomLineEditText$Ԩ, reason: contains not printable characters */
    public class ActionModeCallbackC0872 implements ActionMode.Callback {
        public ActionModeCallbackC0872() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        public /* synthetic */ ActionModeCallbackC0872(BottomLineEditText bottomLineEditText, ViewOnTouchListenerC0871 viewOnTouchListenerC0871) {
            this();
        }
    }

    public BottomLineEditText(Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView
    public boolean isSuggestionsEnabled() {
        return false;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0.0f, (getHeight() - getPaddingBottom()) - 1, getWidth() - 1, (getHeight() - getPaddingBottom()) - 1, this.f1997);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (motionEvent.getAction() == 0) {
            m2190();
        }
        return super.onTouchEvent(motionEvent);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m2188() {
        setCustomSelectionActionModeCallback(new ActionModeCallbackC0872(this, null));
        setLongClickable(false);
        setOnTouchListener(new ViewOnTouchListenerC0871());
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m2189() {
        Paint paint = new Paint();
        this.f1997 = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f1997.setColor(Color.parseColor("#000000"));
        this.f1997.setAntiAlias(true);
        this.f1997.setStrokeWidth(C2579.m9438(1.0f));
        m2188();
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m2190() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        try {
            Field declaredField = TextView.class.getDeclaredField("mEditor");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            Field declaredField2 = Class.forName("android.widget.Editor").getDeclaredField("mInsertionControllerEnabled");
            declaredField2.setAccessible(true);
            declaredField2.set(obj, Boolean.FALSE);
        } catch (Exception unused) {
        }
    }

    public BottomLineEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomLineEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2189();
    }
}
