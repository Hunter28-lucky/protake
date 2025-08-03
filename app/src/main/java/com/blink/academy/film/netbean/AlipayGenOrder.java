package com.blink.academy.film.netbean;

/* loaded from: classes.dex */
public class AlipayGenOrder {
    private boolean has_bought;
    private String order_str;
    private String out_trade_no;

    public boolean getHas_bought() {
        return this.has_bought;
    }

    public String getOrder_str() {
        return this.order_str;
    }

    public String getOut_trade_no() {
        return this.out_trade_no;
    }

    public void setHas_bought(boolean z) {
        this.has_bought = z;
    }

    public void setOrder_str(String str) {
        this.order_str = str;
    }

    public void setOut_trade_no(String str) {
        this.out_trade_no = str;
    }
}
