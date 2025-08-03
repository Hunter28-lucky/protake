package com.polidea.rxandroidble2;

import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public class LogOptions {

    @Nullable
    private final Integer logLevel;

    @Nullable
    private final Logger logger;

    @Nullable
    private final Integer macAddressLogSetting;

    @Nullable
    private final Boolean shouldLogAttributeValues;

    @Nullable
    private final Boolean shouldLogScannedPeripherals;

    @Nullable
    private final Integer uuidLogSetting;

    public static class Builder {

        @Nullable
        private Integer logLevel;

        @Nullable
        private Logger logger;

        @Nullable
        private Integer macAddressLogSetting;

        @Nullable
        private Boolean shouldLogAttributeValues;

        @Nullable
        private Boolean shouldLogScannedPeripherals;

        @Nullable
        private Integer uuidsLogSetting;

        public LogOptions build() {
            return new LogOptions(this.logLevel, this.macAddressLogSetting, this.uuidsLogSetting, this.shouldLogAttributeValues, this.shouldLogScannedPeripherals, this.logger);
        }

        public Builder setLogLevel(@Nullable Integer num) {
            this.logLevel = num;
            return this;
        }

        public Builder setLogger(@Nullable Logger logger) {
            this.logger = logger;
            return this;
        }

        public Builder setMacAddressLogSetting(@Nullable Integer num) {
            this.macAddressLogSetting = num;
            return this;
        }

        public Builder setShouldLogAttributeValues(@Nullable Boolean bool) {
            this.shouldLogAttributeValues = bool;
            return this;
        }

        public Builder setShouldLogScannedPeripherals(@Nullable Boolean bool) {
            this.shouldLogScannedPeripherals = bool;
            return this;
        }

        public Builder setUuidsLogSetting(@Nullable Integer num) {
            this.uuidsLogSetting = num;
            return this;
        }
    }

    public interface Logger {
        void log(int i, String str, String str2);
    }

    public LogOptions(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Logger logger) {
        this.logLevel = num;
        this.macAddressLogSetting = num2;
        this.uuidLogSetting = num3;
        this.shouldLogAttributeValues = bool;
        this.shouldLogScannedPeripherals = bool2;
        this.logger = logger;
    }

    @Nullable
    public Integer getLogLevel() {
        return this.logLevel;
    }

    @Nullable
    public Logger getLogger() {
        return this.logger;
    }

    @Nullable
    public Integer getMacAddressLogSetting() {
        return this.macAddressLogSetting;
    }

    @Nullable
    public Boolean getShouldLogAttributeValues() {
        return this.shouldLogAttributeValues;
    }

    @Nullable
    public Boolean getShouldLogScannedPeripherals() {
        return this.shouldLogScannedPeripherals;
    }

    @Nullable
    public Integer getUuidLogSetting() {
        return this.uuidLogSetting;
    }

    public String toString() {
        return "LogOptions{logLevel=" + this.logLevel + ", macAddressLogSetting=" + this.macAddressLogSetting + ", uuidLogSetting=" + this.uuidLogSetting + ", shouldLogAttributeValues=" + this.shouldLogAttributeValues + ", shouldLogScannedPeripherals=" + this.shouldLogScannedPeripherals + ", logger=" + this.logger + '}';
    }
}
