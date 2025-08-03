package com.google.mlkit.vision.face.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.mlkit_vision_face.zzbn;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.0.1 */
@KeepForSdk
/* loaded from: classes2.dex */
public class FaceRegistrar implements ComponentRegistrar {
    public static final /* synthetic */ int zza = 0;

    @Override // com.google.firebase.components.ComponentRegistrar
    @NonNull
    public final List getComponents() {
        return zzbn.zzi(Component.builder(zze.class).add(Dependency.required(MlKitContext.class)).factory(new ComponentFactory() { // from class: com.google.mlkit.vision.face.internal.zzk
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return new zze((MlKitContext) componentContainer.get(MlKitContext.class));
            }
        }).build(), Component.builder(zzc.class).add(Dependency.required(zze.class)).add(Dependency.required(ExecutorSelector.class)).factory(new ComponentFactory() { // from class: com.google.mlkit.vision.face.internal.zzl
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return new zzc((zze) componentContainer.get(zze.class), (ExecutorSelector) componentContainer.get(ExecutorSelector.class));
            }
        }).build());
    }
}
