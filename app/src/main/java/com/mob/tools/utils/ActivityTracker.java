package com.mob.tools.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.mob.tools.MobLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.util.HashSet;

/* loaded from: classes2.dex */
public class ActivityTracker implements PublicMemberKeeper {
    private static ActivityTracker a;
    private HashSet<Tracker> b = new HashSet<>();

    public interface EachTracker extends PublicMemberKeeper {
        void each(Tracker tracker);
    }

    public interface Tracker extends PublicMemberKeeper {
        void onCreated(Activity activity, Bundle bundle);

        void onDestroyed(Activity activity);

        void onPaused(Activity activity);

        void onResumed(Activity activity);

        void onSaveInstanceState(Activity activity, Bundle bundle);

        void onStarted(Activity activity);

        void onStopped(Activity activity);
    }

    private ActivityTracker(Context context) {
        a(context);
    }

    public static synchronized ActivityTracker getInstance(Context context) {
        if (a == null) {
            a = new ActivityTracker(context);
        }
        return a;
    }

    public void addTracker(Tracker tracker) {
        synchronized (this.b) {
            this.b.add(tracker);
        }
    }

    public void removeTracker(Tracker tracker) {
        synchronized (this.b) {
            this.b.remove(tracker);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final Activity activity) {
        a(new EachTracker() { // from class: com.mob.tools.utils.ActivityTracker.5
            @Override // com.mob.tools.utils.ActivityTracker.EachTracker
            public void each(Tracker tracker) {
                tracker.onPaused(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final Activity activity) {
        a(new EachTracker() { // from class: com.mob.tools.utils.ActivityTracker.6
            @Override // com.mob.tools.utils.ActivityTracker.EachTracker
            public void each(Tracker tracker) {
                tracker.onStopped(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final Activity activity) {
        a(new EachTracker() { // from class: com.mob.tools.utils.ActivityTracker.7
            @Override // com.mob.tools.utils.ActivityTracker.EachTracker
            public void each(Tracker tracker) {
                tracker.onDestroyed(activity);
            }
        });
    }

    private void a(Context context) {
        try {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.mob.tools.utils.ActivityTracker.1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    ActivityTracker.this.a(activity, bundle);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    ActivityTracker.this.e(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    ActivityTracker.this.c(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    ActivityTracker.this.b(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    ActivityTracker.this.b(activity, bundle);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    ActivityTracker.this.a(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    ActivityTracker.this.d(activity);
                }
            });
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final Activity activity) {
        a(new EachTracker() { // from class: com.mob.tools.utils.ActivityTracker.4
            @Override // com.mob.tools.utils.ActivityTracker.EachTracker
            public void each(Tracker tracker) {
                tracker.onResumed(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final Activity activity, final Bundle bundle) {
        a(new EachTracker() { // from class: com.mob.tools.utils.ActivityTracker.8
            @Override // com.mob.tools.utils.ActivityTracker.EachTracker
            public void each(Tracker tracker) {
                tracker.onSaveInstanceState(activity, bundle);
            }
        });
    }

    private void a(EachTracker eachTracker) {
        Tracker[] trackerArr;
        try {
            synchronized (this.b) {
                HashSet<Tracker> hashSet = this.b;
                trackerArr = (Tracker[]) hashSet.toArray(new Tracker[hashSet.size()]);
            }
            for (Tracker tracker : trackerArr) {
                if (tracker != null) {
                    eachTracker.each(tracker);
                }
            }
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Activity activity, final Bundle bundle) {
        a(new EachTracker() { // from class: com.mob.tools.utils.ActivityTracker.2
            @Override // com.mob.tools.utils.ActivityTracker.EachTracker
            public void each(Tracker tracker) {
                tracker.onCreated(activity, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Activity activity) {
        a(new EachTracker() { // from class: com.mob.tools.utils.ActivityTracker.3
            @Override // com.mob.tools.utils.ActivityTracker.EachTracker
            public void each(Tracker tracker) {
                tracker.onStarted(activity);
            }
        });
    }
}
