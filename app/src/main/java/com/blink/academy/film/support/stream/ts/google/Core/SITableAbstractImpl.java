package com.blink.academy.film.support.stream.ts.google.Core;

import com.blink.academy.film.support.stream.ts.google.API.SITable;

/* loaded from: classes.dex */
public abstract class SITableAbstractImpl implements SITable {
    public long start_time = 0;
    public long end_time = 0;
    public int unique_id = UniqueIDServer.getUniqueID();

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public long getDuration() {
        return this.end_time - this.start_time;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public long getEndTime() {
        return this.end_time;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public long getStartTime() {
        return this.start_time;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public int getUniqueID() {
        return this.unique_id;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public void setEndTime(long j) {
        this.end_time = j;
        if (j < this.start_time) {
            this.start_time = j;
        }
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public void setStartTime(long j) {
        this.start_time = j;
        if (this.end_time < j) {
            this.end_time = j;
        }
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public SITable m1907clone() {
        try {
            return (SITable) super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
