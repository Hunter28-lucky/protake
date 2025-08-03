package org.dom4j.tree;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.dom4j.IllegalAddException;
import org.dom4j.Node;

/* loaded from: classes2.dex */
public class ContentListFacade<T extends Node> extends AbstractList<T> {
    private AbstractBranch branch;
    private List<T> branchContent;

    public ContentListFacade(AbstractBranch abstractBranch, List<T> list) {
        this.branch = abstractBranch;
        this.branchContent = list;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends T> collection) {
        int size = this.branchContent.size();
        Iterator<? extends T> it = collection.iterator();
        while (it.hasNext()) {
            add((ContentListFacade<T>) it.next());
            size++;
        }
        return size == this.branchContent.size();
    }

    public Node asNode(Object obj) {
        if (obj instanceof Node) {
            return (Node) obj;
        }
        throw new IllegalAddException("This list must contain instances of Node. Invalid type: " + obj);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        Iterator<T> it = iterator();
        while (it.hasNext()) {
            this.branch.childRemoved(it.next());
        }
        this.branchContent.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return this.branchContent.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean containsAll(Collection<?> collection) {
        return this.branchContent.containsAll(collection);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        return this.branchContent.indexOf(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return this.branchContent.isEmpty();
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        return this.branchContent.lastIndexOf(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            this.branch.childRemoved(asNode(it.next()));
        }
        return this.branchContent.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.branchContent.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return this.branchContent.toArray();
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        return this.branchContent.get(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        this.branch.childRemoved(asNode(obj));
        return this.branchContent.remove(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public T set(int i, T t) {
        this.branch.childAdded(t);
        return this.branchContent.set(i, t);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray(Object[] objArr) {
        return this.branchContent.toArray(objArr);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(T t) {
        this.branch.childAdded(t);
        return this.branchContent.add(t);
    }

    @Override // java.util.AbstractList, java.util.List
    public T remove(int i) {
        T tRemove = this.branchContent.remove(i);
        if (tRemove != null) {
            this.branch.childRemoved(tRemove);
        }
        return tRemove;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, T t) {
        this.branch.childAdded(t);
        this.branchContent.add(i, t);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection<? extends T> collection) {
        int size = this.branchContent.size();
        Iterator<? extends T> it = collection.iterator();
        while (it.hasNext()) {
            add(i, (int) it.next());
            size--;
            i++;
        }
        return size == this.branchContent.size();
    }
}
