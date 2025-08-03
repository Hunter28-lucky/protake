package com.blink.academy.film.netbean.store;

import defpackage.C2531;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class DownloadFilterTask {
    private int alreadyDoneCount;
    private long currentBytesRead;
    private int doneCount;
    private List<C2531> doneList;
    private List<Integer> errorList;
    private int index;
    private long lastClipBytesRead;
    private Map<Integer, Long> proMap = new HashMap();
    private List<DownloadTaskBean> tasks;
    private long totalBytesRead;

    public int getAlreadyDoneCount() {
        return this.alreadyDoneCount;
    }

    public long getCurrentBytesRead() {
        return this.currentBytesRead;
    }

    public int getDoneCount() {
        return this.doneCount;
    }

    public List<C2531> getDoneList() {
        return this.doneList;
    }

    public List<Integer> getErrorList() {
        return this.errorList;
    }

    public int getIndex() {
        return this.index;
    }

    public long getLastClipBytesRead() {
        return this.lastClipBytesRead;
    }

    public Map<Integer, Long> getProMap() {
        return this.proMap;
    }

    public List<DownloadTaskBean> getTasks() {
        return this.tasks;
    }

    public long getTotalBytesRead() {
        return this.totalBytesRead;
    }

    public void setAlreadyDoneCount(int i) {
        this.alreadyDoneCount = i;
    }

    public DownloadFilterTask setCurrentBytesRead(long j) {
        this.currentBytesRead = j;
        return this;
    }

    public DownloadFilterTask setDoneCount(int i) {
        this.doneCount = i;
        return this;
    }

    public DownloadFilterTask setDoneList(List<C2531> list) {
        this.doneList = list;
        return this;
    }

    public DownloadFilterTask setErrorList(List<Integer> list) {
        this.errorList = list;
        return this;
    }

    public DownloadFilterTask setIndex(int i) {
        this.index = i;
        return this;
    }

    public DownloadFilterTask setLastClipBytesRead(long j) {
        this.lastClipBytesRead = j;
        return this;
    }

    public DownloadFilterTask setProMap(Map<Integer, Long> map) {
        this.proMap = map;
        return this;
    }

    public DownloadFilterTask setTasks(List<DownloadTaskBean> list) {
        this.tasks = list;
        return this;
    }

    public DownloadFilterTask setTotalBytesRead(long j) {
        this.totalBytesRead = j;
        return this;
    }
}
