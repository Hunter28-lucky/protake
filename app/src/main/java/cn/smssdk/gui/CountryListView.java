package cn.smssdk.gui;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.smssdk.gui.GroupListView;
import cn.smssdk.gui.layout.SizeHelper;
import com.mob.tools.utils.ResHelper;

/* loaded from: classes.dex */
public class CountryListView extends RelativeLayout implements View.OnTouchListener {
    private CountryAdapter adapter;
    private LinearLayout llScroll;
    private GroupListView lvCountries;
    private TextView tvScroll;

    public CountryListView(Context context) {
        super(context);
        init(context);
    }

    private TextView createScrollItem(Context context, String str) {
        TextView textView = new TextView(context);
        textView.setText(str);
        textView.setTextSize(0, ResHelper.dipToPx(context, 11));
        textView.setGravity(17);
        textView.setTextColor(context.getResources().getColor(ResHelper.getColorRes(context, "smssdk_black")));
        return textView;
    }

    private void init(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        this.llScroll = linearLayout;
        linearLayout.setId(ResHelper.getIdRes(context, "ll_scroll"));
        int bitmapRes = ResHelper.getBitmapRes(context, "smssdk_country_group_scroll_up");
        if (bitmapRes > 0) {
            this.llScroll.setBackgroundResource(bitmapRes);
        }
        this.llScroll.setOrientation(1);
        this.llScroll.setPadding(0, 0, 0, ResHelper.dipToPx(context, 15));
        this.llScroll.setOnTouchListener(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ResHelper.dipToPx(context, 30), -1);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.llScroll, layoutParams);
        this.lvCountries = new GroupListView(context);
        int colorRes = ResHelper.getColorRes(context, "smssdk_f6f6f6");
        if (colorRes > 0) {
            this.lvCountries.setDivider(new ColorDrawable(context.getResources().getColor(colorRes)));
        }
        this.lvCountries.setDividerHeight(ResHelper.dipToPx(context, 1));
        CountryAdapter countryAdapter = new CountryAdapter(this.lvCountries);
        this.adapter = countryAdapter;
        this.lvCountries.setAdapter(countryAdapter);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(0, ResHelper.getIdRes(context, "ll_scroll"));
        addView(this.lvCountries, layoutParams2);
        initScroll(context);
        this.tvScroll = new TextView(context);
        int colorRes2 = ResHelper.getColorRes(context, "smssdk_main_color");
        if (colorRes2 > 0) {
            this.tvScroll.setTextColor(context.getResources().getColor(colorRes2));
        }
        int bitmapRes2 = ResHelper.getBitmapRes(context, "smssdk_country_group_scroll_down");
        if (bitmapRes2 > 0) {
            this.tvScroll.setBackgroundResource(bitmapRes2);
        }
        this.tvScroll.setTextSize(0, SizeHelper.fromPxWidth(context, 80));
        this.tvScroll.setTypeface(Typeface.DEFAULT);
        this.tvScroll.setVisibility(8);
        this.tvScroll.setGravity(17);
        int iFromPxWidth = SizeHelper.fromPxWidth(context, 120);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iFromPxWidth, iFromPxWidth);
        layoutParams3.addRule(13);
        addView(this.tvScroll, layoutParams3);
    }

    private void initScroll(Context context) {
        this.llScroll.removeAllViews();
        int groupCount = this.adapter.getGroupCount();
        this.llScroll.addView(createScrollItem(context, "#"), new LinearLayout.LayoutParams(-1, 0, 1.0f));
        for (int i = 0; i < groupCount; i++) {
            this.llScroll.addView(createScrollItem(context, this.adapter.getGroupTitle(i)), new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
    }

    public String[] getCountry(int i, int i2) {
        return this.adapter.getItem(i, i2);
    }

    public void onScroll(ViewGroup viewGroup, float f, float f2) {
        int childCount = viewGroup.getChildCount();
        int i = 0;
        while (i < childCount) {
            TextView textView = (TextView) viewGroup.getChildAt(i);
            if (f >= textView.getLeft() && f <= textView.getRight() && f2 >= textView.getTop() && f2 <= textView.getBottom()) {
                if (i > 0) {
                    i--;
                }
                this.lvCountries.setSelection(i);
                this.tvScroll.setVisibility(0);
                this.tvScroll.setText(textView.getText());
                return;
            }
            i++;
        }
    }

    public void onSearch(String str) {
        this.adapter.search(str);
        this.adapter.notifyDataSetChanged();
        this.llScroll.setVisibility(TextUtils.isEmpty(str) ? 0 : 8);
        initScroll(getContext());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r4, android.view.MotionEvent r5) {
        /*
            r3 = this;
            int r0 = r5.getAction()
            r1 = 1
            if (r0 == 0) goto L35
            if (r0 == r1) goto L1e
            r2 = 2
            if (r0 == r2) goto L10
            r5 = 3
            if (r0 == r5) goto L1e
            goto L51
        L10:
            float r0 = r5.getX()
            float r5 = r5.getY()
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            r3.onScroll(r4, r0, r5)
            goto L51
        L1e:
            android.content.Context r5 = r4.getContext()
            java.lang.String r0 = "smssdk_country_group_scroll_up"
            int r5 = com.mob.tools.utils.ResHelper.getBitmapRes(r5, r0)
            if (r5 <= 0) goto L2d
            r4.setBackgroundResource(r5)
        L2d:
            android.widget.TextView r4 = r3.tvScroll
            r5 = 8
            r4.setVisibility(r5)
            goto L51
        L35:
            android.content.Context r0 = r4.getContext()
            java.lang.String r2 = "smssdk_country_group_scroll_down"
            int r0 = com.mob.tools.utils.ResHelper.getBitmapRes(r0, r2)
            if (r0 <= 0) goto L44
            r4.setBackgroundResource(r0)
        L44:
            float r0 = r5.getX()
            float r5 = r5.getY()
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            r3.onScroll(r4, r0, r5)
        L51:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.smssdk.gui.CountryListView.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void setCurrentCountryId(String str) {
        GroupListView groupListView = this.lvCountries;
        if (groupListView != null) {
            groupListView.setCurrentCountryId(str);
        }
    }

    public void setOnItemClickListener(GroupListView.OnItemClickListener onItemClickListener) {
        this.lvCountries.setOnItemClickListener(onItemClickListener);
    }

    public CountryListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public CountryListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}
