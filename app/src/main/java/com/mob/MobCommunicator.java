package com.mob;

import com.mob.tools.network.NetCommunicator;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.util.HashMap;
import java.util.concurrent.ThreadPoolExecutor;

@Deprecated
/* loaded from: classes2.dex */
public final class MobCommunicator implements PublicMemberKeeper {
    private NetCommunicator a;

    public static class Callback<T> implements PublicMemberKeeper {
        public void onResultError(Throwable th) {
        }

        public void onResultOk(T t) {
        }
    }

    public static class NetworkError extends Exception implements PublicMemberKeeper {
        private static final long serialVersionUID = -8447657431687664787L;

        public NetworkError(String str) {
            super(str);
        }
    }

    public MobCommunicator(int i, String str, String str2) {
        this.a = new NetCommunicator(i, str, str2);
    }

    public static HashMap<String, String> getCommonDefaultHeaders() throws Throwable {
        return NetCommunicator.getCommonDefaultHeaders();
    }

    public <T> void request(HashMap<String, Object> map, String str, boolean z, Callback<T> callback) {
        request(true, null, map, str, z, callback);
    }

    public <T> T requestSynchronized(HashMap<String, Object> map, String str, boolean z) throws Throwable {
        return (T) requestSynchronized((HashMap<String, String>) null, map, str, z);
    }

    public void setThreadPool(ThreadPoolExecutor threadPoolExecutor) {
        this.a.setThreadPool(threadPoolExecutor);
    }

    public <T> void request(HashMap<String, String> map, HashMap<String, Object> map2, String str, boolean z, Callback<T> callback) {
        request(true, map, map2, str, z, callback);
    }

    public <T> T requestSynchronized(HashMap<String, String> map, HashMap<String, Object> map2, String str, boolean z) throws Throwable {
        return (T) requestSynchronized(true, map, map2, str, z);
    }

    public <T> void request(boolean z, HashMap<String, String> map, HashMap<String, Object> map2, String str, boolean z2, final Callback<T> callback) {
        if (callback == null) {
            this.a.request(z, map, map2, str, z2, null);
        } else {
            this.a.request(z, map, map2, str, z2, new NetCommunicator.Callback<T>() { // from class: com.mob.MobCommunicator.1
                @Override // com.mob.tools.network.NetCommunicator.Callback
                public void onResultError(Throwable th) {
                    callback.onResultError(th);
                }

                @Override // com.mob.tools.network.NetCommunicator.Callback
                public void onResultOk(T t) {
                    callback.onResultOk(t);
                }
            });
        }
    }

    public <T> T requestSynchronized(String str, String str2, boolean z) throws Throwable {
        return (T) requestSynchronized((HashMap<String, String>) null, str, str2, z);
    }

    public <T> T requestSynchronized(HashMap<String, String> map, String str, String str2, boolean z) throws Throwable {
        return (T) requestSynchronized(true, map, str, str2, z);
    }

    public <T> T requestSynchronized(boolean z, HashMap<String, String> map, HashMap<String, Object> map2, String str, boolean z2) throws Throwable {
        return (T) this.a.requestSynchronized(z, map, map2, str, z2);
    }

    public <T> T requestSynchronized(boolean z, HashMap<String, String> map, String str, String str2, boolean z2) throws Throwable {
        return (T) this.a.requestSynchronized(z, map, str, str2, z2);
    }
}
