package com.mob.pushsdk.biz;

/* loaded from: classes2.dex */
public enum PushErrorCode {
    SUCCESS(0, "success"),
    XIAOMI_SERVICE_UNAVAILABLE(70000001, "xm_service_unavailable"),
    XIAOMI_INTERNAL_ERROR(70000004, "xm_internal_error"),
    XIAOMI_AUTHERICATION_ERROR(70000002, "xm_autherication_error"),
    XIAOMI_INVALID_PAYLOAD(70000003, "xm_invalid_payload"),
    HUAWEI_SERVICE_MISSING(1, "hw_service_missing"),
    HUAWEI_SERVICE_VERSION_UPDATE_REQUIRED(2, "hw_service_version_update_required"),
    HUAWEI_SERVICE_DISABLED(3, "hw_service_disabled"),
    HUAWEI_SIGN_IN_REQUIRED(4, "hw_sign_in_required"),
    HUAWEI_INVALID_ACCOUNT(5, "hw_invalid_account"),
    HUAWEI_BINDFAIL_RESOLUTION_REQUIRED(6, "hw_bindfail_resolution_required"),
    HUAWEI_NETWORK_ERROR(7, "hw_network_error"),
    HUAWEI_INTERNAL_ERROR(8, "hw_internal_error"),
    HUAWEI_SERVICE_INVALID(9, "hw_service_invalid"),
    HUAWEI_DEVELOPER_ERROR(10, "hw_developer_error"),
    HUAWEI_LICENSE_CHECK_FAILED(11, "hw_license_check_failed"),
    HUAWEI_CANCELED(13, "hw_canceled"),
    HUAWEI_TIMEOUT(14, "hw_timeout"),
    HUAWEI_SERVICE_MISSING_PERMISSION(19, "hw_service_missing_permission"),
    HUAWEI_SERVICE_UNSUPPORTED(21, "hw_service_unsupported"),
    HUAWEI_API_UNAVAILABLE(1000, "hw_api_unavailable");

    private long code;
    private String msgRes;

    PushErrorCode(long j, String str) {
        this.code = j;
        this.msgRes = str;
    }

    public long getCode() {
        return this.code;
    }

    public String getMsgRes() {
        return this.msgRes;
    }

    public static PushErrorCode valueOf(long j) {
        for (PushErrorCode pushErrorCode : values()) {
            if (pushErrorCode.getCode() == j) {
                return pushErrorCode;
            }
        }
        return SUCCESS;
    }
}
