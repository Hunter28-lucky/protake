package com.blink.academy.film.stream.ban;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import defpackage.C2618;
import defpackage.C3184;
import defpackage.r1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class ACBanManager {
    public static final Object banFence = new Object();
    private static ACBanManager instance;
    private List<String> alreadySetControlUUidList;
    private List<String> banControlUUidList;
    private final List<ACBanBean> mList = C3184.m10827().m10856();

    private ACBanManager() {
        this.banControlUUidList = new ArrayList();
        String strM9569 = C2618.m9569("control_set_list_sp", "");
        if (r1.m8143(strM9569)) {
            this.alreadySetControlUUidList = (List) new Gson().fromJson(strM9569, new TypeToken<ArrayList<String>>() { // from class: com.blink.academy.film.stream.ban.ACBanManager.1
            }.getType());
        }
        String strM95692 = C2618.m9569("control_ban_list_sp", "");
        if (r1.m8143(strM95692)) {
            this.banControlUUidList = (List) new Gson().fromJson(strM95692, new TypeToken<ArrayList<String>>() { // from class: com.blink.academy.film.stream.ban.ACBanManager.2
            }.getType());
        }
        if (this.alreadySetControlUUidList == null) {
            this.alreadySetControlUUidList = new ArrayList();
        }
        if (this.banControlUUidList == null) {
            this.banControlUUidList = new ArrayList();
        }
    }

    public static ACBanManager getInstance() {
        if (instance == null) {
            synchronized (ACBanManager.class) {
                if (instance == null) {
                    instance = new ACBanManager();
                }
            }
        }
        return instance;
    }

    public void addToAlreadySetControl(String str) {
        if (this.alreadySetControlUUidList.contains(str)) {
            return;
        }
        this.alreadySetControlUUidList.add(str);
        C2618.m9573("control_set_list_sp", new Gson().toJson(this.alreadySetControlUUidList));
    }

    public void addToBanList(String str, String str2, String str3) {
        synchronized (banFence) {
            boolean z = false;
            if (r1.m8144(this.mList)) {
                Iterator<ACBanBean> it = this.mList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (str.equals(it.next().getUuid())) {
                        z = true;
                        break;
                    }
                }
            }
            if (!z) {
                ACBanBean aCBanBean = new ACBanBean();
                aCBanBean.setUuid(str);
                aCBanBean.setName(str2);
                aCBanBean.setSuffix(str3);
                this.mList.add(aCBanBean);
                C3184.m10827().m10836(aCBanBean);
            }
        }
    }

    public boolean banned(String str) {
        synchronized (banFence) {
            if (r1.m8144(this.mList)) {
                Iterator<ACBanBean> it = this.mList.iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next().getUuid())) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public void clearAlreadySetControl() {
        this.alreadySetControlUUidList.clear();
        this.banControlUUidList.clear();
        C2618.m9573("control_set_list_sp", new Gson().toJson(this.alreadySetControlUUidList));
        C2618.m9573("control_ban_list_sp", new Gson().toJson(this.banControlUUidList));
    }

    public void disableControl(String str) {
        if (this.banControlUUidList.contains(str)) {
            return;
        }
        this.banControlUUidList.add(str);
        C2618.m9573("control_ban_list_sp", new Gson().toJson(this.banControlUUidList));
    }

    public void enableControl(String str) {
        if (this.banControlUUidList.contains(str)) {
            this.banControlUUidList.remove(str);
            C2618.m9573("control_ban_list_sp", new Gson().toJson(this.banControlUUidList));
        }
    }

    public List<String> getBanControlUUidList() {
        return this.banControlUUidList;
    }

    public List<ACBanBean> getList() {
        return this.mList;
    }

    public boolean isInAlreadySetControl(String str) {
        return this.alreadySetControlUUidList.contains(str);
    }

    public boolean isInControlList(String str) {
        return getBanControlUUidList().contains(str);
    }

    public void removeFromBanList(String str) {
        synchronized (banFence) {
            if (r1.m8144(this.mList)) {
                Iterator<ACBanBean> it = this.mList.iterator();
                while (it.hasNext()) {
                    ACBanBean next = it.next();
                    if (str.equals(next.getUuid())) {
                        it.remove();
                        C3184.m10827().m10862(next);
                    }
                }
            }
        }
    }
}
