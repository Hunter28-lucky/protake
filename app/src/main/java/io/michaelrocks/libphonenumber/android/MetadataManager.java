package io.michaelrocks.libphonenumber.android;

import io.michaelrocks.libphonenumber.android.Phonemetadata;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
final class MetadataManager {
    public static final String ALTERNATE_FORMATS_FILE_PREFIX = "/io/michaelrocks/libphonenumber/android/data/PhoneNumberAlternateFormatsProto";
    public static final String MULTI_FILE_PHONE_NUMBER_METADATA_FILE_PREFIX = "/io/michaelrocks/libphonenumber/android/data/PhoneNumberMetadataProto";
    public static final String SHORT_NUMBER_METADATA_FILE_PREFIX = "/io/michaelrocks/libphonenumber/android/data/ShortNumberMetadataProto";
    private static final Logger logger = Logger.getLogger(MetadataManager.class.getName());
    private final MetadataLoader metadataLoader;
    private final ConcurrentHashMap<Integer, Phonemetadata.PhoneMetadata> alternateFormatsMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Phonemetadata.PhoneMetadata> shortNumberMetadataMap = new ConcurrentHashMap<>();
    private final Set<Integer> alternateFormatsCountryCodes = AlternateFormatsCountryCodeSet.getCountryCodeSet();
    private final Set<String> shortNumberMetadataRegionCodes = ShortNumbersRegionCodeSet.getRegionCodeSet();

    public MetadataManager(MetadataLoader metadataLoader) {
        this.metadataLoader = metadataLoader;
    }

    private static List<Phonemetadata.PhoneMetadata> getMetadataFromSingleFileName(String str, MetadataLoader metadataLoader) {
        InputStream inputStreamLoadMetadata = metadataLoader.loadMetadata(str);
        if (inputStreamLoadMetadata == null) {
            throw new IllegalStateException("missing metadata: " + str);
        }
        List<Phonemetadata.PhoneMetadata> metadataList = loadMetadataAndCloseInput(inputStreamLoadMetadata).getMetadataList();
        if (metadataList.size() != 0) {
            return metadataList;
        }
        throw new IllegalStateException("empty metadata: " + str);
    }

    private static Phonemetadata.PhoneMetadataCollection loadMetadataAndCloseInput(InputStream inputStream) throws Throwable {
        ObjectInputStream objectInputStream;
        ObjectInputStream objectInputStream2 = null;
        try {
            try {
                objectInputStream = new ObjectInputStream(inputStream);
            } catch (IOException e2) {
                throw new RuntimeException("cannot load/parse metadata", e2);
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            Phonemetadata.PhoneMetadataCollection phoneMetadataCollection = new Phonemetadata.PhoneMetadataCollection();
            try {
                phoneMetadataCollection.readExternal(objectInputStream);
                try {
                    objectInputStream.close();
                } catch (IOException e3) {
                    logger.log(Level.WARNING, "error closing input stream (ignored)", (Throwable) e3);
                }
                return phoneMetadataCollection;
            } catch (IOException e4) {
                throw new RuntimeException("cannot load/parse metadata", e4);
            }
        } catch (Throwable th2) {
            th = th2;
            objectInputStream2 = objectInputStream;
            try {
                if (objectInputStream2 != null) {
                    objectInputStream2.close();
                } else {
                    inputStream.close();
                }
            } catch (IOException e5) {
                logger.log(Level.WARNING, "error closing input stream (ignored)", (Throwable) e5);
            }
            throw th;
        }
    }

    public Phonemetadata.PhoneMetadata getAlternateFormatsForCountry(int i, String str) {
        if (this.alternateFormatsCountryCodes.contains(Integer.valueOf(i))) {
            return getMetadataFromMultiFilePrefix(Integer.valueOf(i), this.alternateFormatsMap, str);
        }
        return null;
    }

    public <T> Phonemetadata.PhoneMetadata getMetadataFromMultiFilePrefix(T t, ConcurrentHashMap<T, Phonemetadata.PhoneMetadata> concurrentHashMap, String str) {
        Phonemetadata.PhoneMetadata phoneMetadata = concurrentHashMap.get(t);
        if (phoneMetadata != null) {
            return phoneMetadata;
        }
        String str2 = str + "_" + t;
        List<Phonemetadata.PhoneMetadata> metadataFromSingleFileName = getMetadataFromSingleFileName(str2, this.metadataLoader);
        if (metadataFromSingleFileName.size() > 1) {
            logger.log(Level.WARNING, "more than one metadata in file " + str2);
        }
        Phonemetadata.PhoneMetadata phoneMetadata2 = metadataFromSingleFileName.get(0);
        Phonemetadata.PhoneMetadata phoneMetadataPutIfAbsent = concurrentHashMap.putIfAbsent(t, phoneMetadata2);
        return phoneMetadataPutIfAbsent != null ? phoneMetadataPutIfAbsent : phoneMetadata2;
    }

    public Phonemetadata.PhoneMetadata getShortNumberMetadataForRegion(String str, String str2) {
        if (this.shortNumberMetadataRegionCodes.contains(str)) {
            return getMetadataFromMultiFilePrefix(str, this.shortNumberMetadataMap, str2);
        }
        return null;
    }

    public Set<String> getSupportedShortNumberRegions() {
        return Collections.unmodifiableSet(this.shortNumberMetadataRegionCodes);
    }
}
