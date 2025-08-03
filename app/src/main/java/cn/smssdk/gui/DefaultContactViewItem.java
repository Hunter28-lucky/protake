package cn.smssdk.gui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import cn.smssdk.gui.layout.ContactsListviewItemLayout;
import cn.smssdk.utils.SMSLog;
import com.mob.tools.gui.AsyncImageView;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class DefaultContactViewItem implements ContactItemMaker {

    public class ViewHolder {
        public View bg;
        public Button btnAdd;
        public AsyncImageView ivContact;
        public TextView tvContact;
        public TextView tvName;

        public ViewHolder() {
        }
    }

    @Override // cn.smssdk.gui.ContactItemMaker
    public View getView(final HashMap<String, Object> map, View view, final ViewGroup viewGroup) {
        View viewCreate;
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            Context context = viewGroup.getContext();
            viewCreate = ContactsListviewItemLayout.create(context);
            viewHolder.ivContact = (AsyncImageView) viewCreate.findViewById(ResHelper.getIdRes(context, "iv_contact"));
            viewHolder.tvName = (TextView) viewCreate.findViewById(ResHelper.getIdRes(context, "tv_name"));
            viewHolder.tvContact = (TextView) viewCreate.findViewById(ResHelper.getIdRes(context, "tv_contact"));
            viewHolder.btnAdd = (Button) viewCreate.findViewById(ResHelper.getIdRes(context, "btn_add"));
            viewHolder.bg = viewCreate.findViewById(ResHelper.getIdRes(context, "rl_lv_item_bg"));
            viewCreate.setTag(viewHolder);
        } else {
            viewCreate = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        if (map != null) {
            if (map.containsKey("fia")) {
                viewHolder.tvName.setText(String.valueOf(map.get("nickname")));
                viewHolder.tvContact.setVisibility(0);
                String str = (String) map.get("displayname");
                if (TextUtils.isEmpty(str)) {
                    viewHolder.tvContact.setText(String.valueOf(map.get("phone")));
                } else {
                    viewHolder.tvContact.setText(str);
                }
                int stringRes = ResHelper.getStringRes(viewGroup.getContext(), "smssdk_add_contact");
                if (stringRes > 0) {
                    viewHolder.btnAdd.setText(stringRes);
                    viewHolder.btnAdd.setTextColor(viewGroup.getResources().getColor(ResHelper.getColorRes(viewGroup.getContext(), "smssdk_white")));
                    viewHolder.btnAdd.setBackgroundResource(ResHelper.getBitmapRes(viewGroup.getContext(), "smssdk_btn_enable"));
                }
            } else {
                String str2 = (String) map.get("displayname");
                if (TextUtils.isEmpty(str2)) {
                    ArrayList arrayList = (ArrayList) map.get("phones");
                    if (arrayList != null && arrayList.size() > 0) {
                        viewHolder.tvName.setText((String) ((HashMap) arrayList.get(0)).get("phone"));
                    }
                } else {
                    viewHolder.tvName.setText(str2);
                }
                viewHolder.tvContact.setVisibility(8);
                int stringRes2 = ResHelper.getStringRes(viewGroup.getContext(), "smssdk_invite");
                if (stringRes2 > 0) {
                    viewHolder.btnAdd.setText(stringRes2);
                    viewHolder.btnAdd.setTextColor(viewGroup.getResources().getColor(ResHelper.getColorRes(viewGroup.getContext(), "smssdk_main_color")));
                    viewHolder.btnAdd.setBackgroundResource(ResHelper.getBitmapRes(viewGroup.getContext(), "smssdk_btn_line_bg"));
                }
            }
            viewHolder.bg.setBackgroundColor(-1);
            if (map.containsKey("isnew") && Boolean.valueOf(String.valueOf(map.get("isnew"))).booleanValue()) {
                viewHolder.bg.setBackgroundColor(-525057);
            }
            String str3 = map.containsKey("avatar") ? (String) map.get("avatar") : null;
            int bitmapRes = ResHelper.getBitmapRes(viewGroup.getContext(), "smssdk_cp_default_avatar");
            if (bitmapRes > 0) {
                viewHolder.ivContact.execute((String) null, bitmapRes);
            }
            if (!TextUtils.isEmpty(str3)) {
                SMSLog.getInstance().i(String.valueOf(map.get("displayname")) + " icon url ==>> " + str3);
                viewHolder.ivContact.execute(str3, bitmapRes);
            }
            viewHolder.btnAdd.setOnClickListener(new View.OnClickListener() { // from class: cn.smssdk.gui.DefaultContactViewItem.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) throws Resources.NotFoundException {
                    if (map.containsKey("fia")) {
                        PopupDialog.create(viewGroup.getContext(), (String) null, String.valueOf(map), viewGroup.getResources().getString(ResHelper.getStringRes(viewGroup.getContext(), "smssdk_i_know")), new View.OnClickListener() { // from class: cn.smssdk.gui.DefaultContactViewItem.1.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                            }
                        }, (String) null, (View.OnClickListener) null, true, true, false).show();
                    } else {
                        ContactDetailPage contactDetailPage = new ContactDetailPage();
                        contactDetailPage.setContact(map);
                        contactDetailPage.show(viewGroup.getContext(), null);
                    }
                }
            });
        }
        return viewCreate;
    }
}
