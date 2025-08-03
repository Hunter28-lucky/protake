package com.blink.academy.film.netbean;

/* loaded from: classes.dex */
public class UserBean {
    private String access_token;
    private String aud;
    private String client_nonce;
    private long db_id;
    private long exp;
    private long iat;
    private boolean is_subscription_user;
    private String iss;
    private String jti;
    private long nbf;
    private String products;
    private String redceived_film_ids;
    private String sub;
    private long subscription_expire_time;
    private long timestamp;
    private long uid;
    private String user_phone_number_desensitized;
    private String user_phone_zone;

    public UserBean() {
    }

    public String getAccess_token() {
        return this.access_token;
    }

    public String getAud() {
        return this.aud;
    }

    public String getClient_nonce() {
        return this.client_nonce;
    }

    public long getDb_id() {
        return this.db_id;
    }

    public long getExp() {
        return this.exp;
    }

    public long getIat() {
        return this.iat;
    }

    public long getId() {
        return this.uid;
    }

    public boolean getIs_subscription_user() {
        return this.is_subscription_user;
    }

    public String getIss() {
        return this.iss;
    }

    public String getJti() {
        return this.jti;
    }

    public long getNbf() {
        return this.nbf;
    }

    public String getProducts() {
        return this.products;
    }

    public String getRedceived_film_ids() {
        return this.redceived_film_ids;
    }

    public String getSub() {
        return this.sub;
    }

    public long getSubscription_expire_time() {
        return this.subscription_expire_time;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public long getUid() {
        return this.uid;
    }

    public String getUser_phone_number_desensitized() {
        return this.user_phone_number_desensitized;
    }

    public String getUser_phone_zone() {
        return this.user_phone_zone;
    }

    public void setAccess_token(String str) {
        this.access_token = str;
    }

    public void setAud(String str) {
        this.aud = str;
    }

    public void setClient_nonce(String str) {
        this.client_nonce = str;
    }

    public void setDb_id(long j) {
        this.db_id = j;
    }

    public void setExp(long j) {
        this.exp = j;
    }

    public void setIat(long j) {
        this.iat = j;
    }

    public void setIs_subscription_user(boolean z) {
        this.is_subscription_user = z;
    }

    public void setIss(String str) {
        this.iss = str;
    }

    public void setJti(String str) {
        this.jti = str;
    }

    public void setNbf(long j) {
        this.nbf = j;
    }

    public void setProducts(String str) {
        this.products = str;
    }

    public void setRedceived_film_ids(String str) {
        this.redceived_film_ids = str;
    }

    public void setSub(String str) {
        this.sub = str;
    }

    public void setSubscription_expire_time(long j) {
        this.subscription_expire_time = j;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public void setUid(long j) {
        this.uid = j;
    }

    public void setUser_phone_number_desensitized(String str) {
        this.user_phone_number_desensitized = str;
    }

    public void setUser_phone_zone(String str) {
        this.user_phone_zone = str;
    }

    public UserBean(long j, long j2, String str, boolean z, long j3, String str2, String str3, long j4, String str4, String str5, String str6, String str7, long j5, String str8, long j6, String str9, long j7, String str10) {
        this.db_id = j;
        this.uid = j2;
        this.access_token = str;
        this.is_subscription_user = z;
        this.timestamp = j3;
        this.products = str2;
        this.redceived_film_ids = str3;
        this.subscription_expire_time = j4;
        this.user_phone_number_desensitized = str4;
        this.user_phone_zone = str5;
        this.client_nonce = str6;
        this.aud = str7;
        this.exp = j5;
        this.jti = str8;
        this.iat = j6;
        this.iss = str9;
        this.nbf = j7;
        this.sub = str10;
    }
}
