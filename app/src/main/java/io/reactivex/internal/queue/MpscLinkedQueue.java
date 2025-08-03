package io.reactivex.internal.queue;

import defpackage.InterfaceC2475;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class MpscLinkedQueue<T> implements InterfaceC2475<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AtomicReference<LinkedQueueNode<T>> f7642 = new AtomicReference<>();

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final AtomicReference<LinkedQueueNode<T>> f7643 = new AtomicReference<>();

    public static final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
        private static final long serialVersionUID = 2404266111789071508L;
        private E value;

        public LinkedQueueNode() {
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public E m6974() {
            E eM6975 = m6975();
            m6978(null);
            return eM6975;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public E m6975() {
            return this.value;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public LinkedQueueNode<E> m6976() {
            return get();
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6977(LinkedQueueNode<E> linkedQueueNode) {
            lazySet(linkedQueueNode);
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public void m6978(E e2) {
            this.value = e2;
        }

        public LinkedQueueNode(E e2) {
            m6978(e2);
        }
    }

    public MpscLinkedQueue() {
        LinkedQueueNode<T> linkedQueueNode = new LinkedQueueNode<>();
        m6972(linkedQueueNode);
        m6973(linkedQueueNode);
    }

    @Override // defpackage.InterfaceC4851
    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    @Override // defpackage.InterfaceC4851
    public boolean isEmpty() {
        return m6970() == m6971();
    }

    @Override // defpackage.InterfaceC4851
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        LinkedQueueNode<T> linkedQueueNode = new LinkedQueueNode<>(t);
        m6973(linkedQueueNode).m6977(linkedQueueNode);
        return true;
    }

    @Override // defpackage.InterfaceC2475, defpackage.InterfaceC4851
    public T poll() {
        LinkedQueueNode<T> linkedQueueNodeM6976;
        LinkedQueueNode<T> linkedQueueNodeM6969 = m6969();
        LinkedQueueNode<T> linkedQueueNodeM69762 = linkedQueueNodeM6969.m6976();
        if (linkedQueueNodeM69762 != null) {
            T tM6974 = linkedQueueNodeM69762.m6974();
            m6972(linkedQueueNodeM69762);
            return tM6974;
        }
        if (linkedQueueNodeM6969 == m6971()) {
            return null;
        }
        do {
            linkedQueueNodeM6976 = linkedQueueNodeM6969.m6976();
        } while (linkedQueueNodeM6976 == null);
        T tM69742 = linkedQueueNodeM6976.m6974();
        m6972(linkedQueueNodeM6976);
        return tM69742;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public LinkedQueueNode<T> m6969() {
        return this.f7643.get();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public LinkedQueueNode<T> m6970() {
        return this.f7643.get();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public LinkedQueueNode<T> m6971() {
        return this.f7642.get();
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m6972(LinkedQueueNode<T> linkedQueueNode) {
        this.f7643.lazySet(linkedQueueNode);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public LinkedQueueNode<T> m6973(LinkedQueueNode<T> linkedQueueNode) {
        return this.f7642.getAndSet(linkedQueueNode);
    }
}
