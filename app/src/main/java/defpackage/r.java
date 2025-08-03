package defpackage;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import androidx.annotation.NonNull;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamLocalUriFetcher.java */
/* loaded from: classes.dex */
public class r extends AbstractC3121<InputStream> {

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final UriMatcher f8463;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f8463 = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        uriMatcher.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public r(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    @Override // defpackage.InterfaceC3129
    @NonNull
    /* renamed from: Ϳ */
    public Class<InputStream> mo7075() {
        return InputStream.class;
    }

    @Override // defpackage.AbstractC3121
    /* renamed from: ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public void mo8131(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // defpackage.AbstractC3121
    /* renamed from: Ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public InputStream mo8132(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        InputStream inputStreamM8135 = m8135(uri, contentResolver);
        if (inputStreamM8135 != null) {
            return inputStreamM8135;
        }
        throw new FileNotFoundException("InputStream is null for " + uri);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final InputStream m8135(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        int iMatch = f8463.match(uri);
        if (iMatch != 1) {
            if (iMatch == 3) {
                return m8136(contentResolver, uri);
            }
            if (iMatch != 5) {
                return contentResolver.openInputStream(uri);
            }
        }
        Uri uriLookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (uriLookupContact != null) {
            return m8136(contentResolver, uriLookupContact);
        }
        throw new FileNotFoundException("Contact cannot be found");
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final InputStream m8136(ContentResolver contentResolver, Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }
}
