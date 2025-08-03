package com.blink.academy.film.http.okhttp.api;

import defpackage.AbstractC2613;
import defpackage.AbstractC4262;
import defpackage.AbstractC4809;
import defpackage.C3577;
import java.util.List;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/* loaded from: classes.dex */
public interface APIService {
    @DELETE
    AbstractC4262<AbstractC4809> delete(@Url String str, @QueryMap Map<String, String> map);

    @DELETE
    AbstractC4262<AbstractC4809> deleteBody(@Url String str, @Body Object obj);

    @DELETE
    AbstractC4262<AbstractC4809> deleteBody(@Url String str, @Body AbstractC2613 abstractC2613);

    @DELETE
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    AbstractC4262<AbstractC4809> deleteJson(@Url String str, @Body AbstractC2613 abstractC2613);

    @Streaming
    @GET
    AbstractC4262<AbstractC4809> downloadFile(@Url String str);

    @GET
    AbstractC4262<AbstractC4809> get(@Url String str, @QueryMap Map<String, String> map);

    @FormUrlEncoded
    @POST
    AbstractC4262<AbstractC4809> post(@Url String str, @FieldMap Map<String, String> map);

    @POST
    AbstractC4262<AbstractC4809> postBody(@Url String str, @Body Object obj);

    @POST
    AbstractC4262<AbstractC4809> postBody(@Url String str, @Body AbstractC2613 abstractC2613);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST
    AbstractC4262<AbstractC4809> postJson(@Url String str, @Body AbstractC2613 abstractC2613);

    @PUT
    AbstractC4262<AbstractC4809> put(@Url String str, @QueryMap Map<String, String> map);

    @PUT
    AbstractC4262<AbstractC4809> putBody(@Url String str, @Body Object obj);

    @POST
    @Multipart
    AbstractC4262<AbstractC4809> uploadFiles(@Url String str, @Part List<C3577.C3580> list);

    @POST
    @Multipart
    AbstractC4262<AbstractC4809> uploadFiles(@Url String str, @PartMap Map<String, AbstractC2613> map);

    @POST
    @Multipart
    AbstractC4262<AbstractC4809> uploadFlie(@Url String str, @Part("description") AbstractC2613 abstractC2613, @Part("files") C3577.C3580 c3580);
}
