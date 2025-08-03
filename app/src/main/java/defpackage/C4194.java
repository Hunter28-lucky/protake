package defpackage;

import android.content.Context;
import android.view.ViewGroup;
import com.blink.academy.film.widgets.StrokeImageViewWithBottomBlock;
import com.blink.academy.film.widgets.StrokeTextViewWithBottomBlock;
import com.blink.academy.film.widgets.adapter.fps.FpsAutoStrokeView;
import com.blink.academy.film.widgets.adapter.fps.ImageClickView;
import com.blink.academy.film.widgets.beauty.BeautyItemView;
import com.blink.academy.film.widgets.grids.GridsItemView;
import com.blink.academy.film.widgets.looks.C1358;
import com.blink.academy.film.widgets.looks.C1360;
import com.blink.academy.film.widgets.looks.PreviewItemView;
import com.blink.academy.film.widgets.socket.SocketAddressItem;
import defpackage.AbstractC4975;
import java.util.List;

/* compiled from: FilmTextChooseAdapter.java */
/* renamed from: ব, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4194 extends AbstractC2366<C4196> {
    public C4194(Context context, List<C4196> list, AbstractC4975.InterfaceC4976 interfaceC4976) {
        super(context, list, interfaceC4976);
    }

    @Override // defpackage.AbstractC5158
    /* renamed from: Ԯ */
    public AbstractC2769<C4196> mo9386(ViewGroup viewGroup, int i) {
        switch (i) {
            case 1:
                return new C3221(new StrokeImageViewWithBottomBlock(viewGroup.getContext()), viewGroup.getContext(), this, this.f12579);
            case 2:
                return new C1360(new PreviewItemView(viewGroup.getContext()), viewGroup.getContext(), this, (AbstractC4975.InterfaceC4980) this.f12579);
            case 3:
                return new C2324(new GridsItemView(viewGroup.getContext()), viewGroup.getContext(), this, this.f12579);
            case 4:
                return new C3769(new FpsAutoStrokeView(viewGroup.getContext()), viewGroup.getContext(), this, this.f12579);
            case 5:
                return new C2886(new StrokeTextViewWithBottomBlock(viewGroup.getContext()), viewGroup.getContext(), this, this.f12579);
            case 6:
                return new C4311(new StrokeTextViewWithBottomBlock(viewGroup.getContext()), viewGroup.getContext(), this, this.f12579);
            case 7:
                return new C1358(new PreviewItemView(viewGroup.getContext()), viewGroup.getContext(), this, (AbstractC4975.InterfaceC4980) this.f12579);
            case 8:
                return new C4098(new ImageClickView(viewGroup.getContext()), viewGroup.getContext(), this, this.f12579);
            case 9:
                return new C5186(new BeautyItemView(viewGroup.getContext()), viewGroup.getContext(), this, (AbstractC4975.InterfaceC4978) this.f12579);
            case 10:
                return new C4818(new SocketAddressItem(viewGroup.getContext()), m15079(), this, (AbstractC4975.InterfaceC4979) this.f12579);
            default:
                return new C2334(new StrokeTextViewWithBottomBlock(viewGroup.getContext()), viewGroup.getContext(), this, this.f12579);
        }
    }
}
