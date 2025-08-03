package io.michaelrocks.libphonenumber.android;

import io.michaelrocks.libphonenumber.android.Phonemetadata;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
final class MultiFileMetadataSourceImpl implements MetadataSource {
    private final String alternateFormatsFilePrefix;
    private final ConcurrentHashMap<String, Phonemetadata.PhoneMetadata> geographicalRegions;
    private final MetadataManager metadataManager;
    private final ConcurrentHashMap<Integer, Phonemetadata.PhoneMetadata> nonGeographicalRegions;
    private final String phoneNumberMetadataFilePrefix;
    private final String shortNumberFilePrefix;

    public MultiFileMetadataSourceImpl(String str, String str2, String str3, MetadataLoader metadataLoader) {
        this.geographicalRegions = new ConcurrentHashMap<>();
        this.nonGeographicalRegions = new ConcurrentHashMap<>();
        this.phoneNumberMetadataFilePrefix = str;
        this.alternateFormatsFilePrefix = str2;
        this.shortNumberFilePrefix = str3;
        this.metadataManager = new MetadataManager(metadataLoader);
    }

    private boolean isNonGeographical(int i) {
        List<String> list = CountryCodeToRegionCodeMap.getCountryCodeToRegionCodeMap().get(Integer.valueOf(i));
        return list.size() == 1 && PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY.equals(list.get(0));
    }

    @Override // io.michaelrocks.libphonenumber.android.MetadataSource
    public Phonemetadata.PhoneMetadata getAlternateFormatsForCountry(int i) {
        return this.metadataManager.getAlternateFormatsForCountry(i, this.alternateFormatsFilePrefix);
    }

    @Override // io.michaelrocks.libphonenumber.android.MetadataSource
    public Phonemetadata.PhoneMetadata getMetadataForNonGeographicalRegion(int i) {
        if (isNonGeographical(i)) {
            return this.metadataManager.getMetadataFromMultiFilePrefix(Integer.valueOf(i), this.nonGeographicalRegions, this.phoneNumberMetadataFilePrefix);
        }
        return null;
    }

    @Override // io.michaelrocks.libphonenumber.android.MetadataSource
    public Phonemetadata.PhoneMetadata getMetadataForRegion(String str) {
        return this.metadataManager.getMetadataFromMultiFilePrefix(str, this.geographicalRegions, this.phoneNumberMetadataFilePrefix);
    }

    @Override // io.michaelrocks.libphonenumber.android.MetadataSource
    public Phonemetadata.PhoneMetadata getShortNumberMetadataForRegion(String str) {
        return this.metadataManager.getShortNumberMetadataForRegion(str, this.shortNumberFilePrefix);
    }

    public MultiFileMetadataSourceImpl(MetadataLoader metadataLoader) {
        this(MetadataManager.MULTI_FILE_PHONE_NUMBER_METADATA_FILE_PREFIX, MetadataManager.ALTERNATE_FORMATS_FILE_PREFIX, MetadataManager.SHORT_NUMBER_METADATA_FILE_PREFIX, metadataLoader);
    }
}
