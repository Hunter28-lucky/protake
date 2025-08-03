package com.blink.academy.film.support.stream.ts.google.Core.PSIP;

import com.blink.academy.film.support.stream.ts.google.API.BitOutputStream;
import com.blink.academy.film.support.stream.ts.google.API.Descriptor.Descriptor;
import com.blink.academy.film.support.stream.ts.google.API.MultiString.MultipleStringStructure;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.RRT;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.RRTDimension;
import com.blink.academy.film.support.stream.ts.google.API.Section;
import com.blink.academy.film.support.stream.ts.google.API.SectionFactory;
import com.blink.academy.film.support.stream.ts.google.API.TableID;
import com.blink.academy.film.support.stream.ts.google.Core.SITableAbstractImpl;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* loaded from: classes.dex */
public class RRTDefaultImpl extends SITableAbstractImpl implements RRT {
    public int rating_region;
    public MultipleStringStructure rating_region_name_text;
    public int version_number = 0;
    public List<RRTDimension> dimensions = new Vector();
    public List<Descriptor> descs = new Vector();
    public long interval_millis = 60000;

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod
    public boolean addDescriptor(Descriptor descriptor) {
        this.descs.add(descriptor);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod
    public boolean addDescriptorAt(int i, Descriptor descriptor) {
        if (i < 0 || i > this.descs.size()) {
            return false;
        }
        this.descs.add(i, descriptor);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRT
    public boolean addDimension(RRTDimension rRTDimension) {
        this.dimensions.add(rRTDimension);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRT
    public boolean addDimensionAt(int i, RRTDimension rRTDimension) {
        if (i < 0 || i > this.dimensions.size()) {
            return false;
        }
        this.dimensions.add(i, rRTDimension);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod
    public Descriptor getDescriptorAt(int i) {
        if (i < 0 || i >= this.descs.size()) {
            return null;
        }
        return this.descs.get(i);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod
    public int getDescriptorSize() {
        return this.descs.size();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod
    public Iterator<Descriptor> getDescriptors() {
        return this.descs.iterator();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod
    public int getDescriptorsLength() {
        Iterator<Descriptor> it = this.descs.iterator();
        int sizeInBytes = 0;
        while (it.hasNext()) {
            sizeInBytes += it.next().getSizeInBytes();
        }
        return sizeInBytes;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRT
    public RRTDimension getDimensionAt(int i) {
        if (i < 0 || i >= this.dimensions.size()) {
            return null;
        }
        return this.dimensions.get(i);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRT
    public Iterator<RRTDimension> getDimensions() {
        return this.dimensions.iterator();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRT
    public int getDimensionsDefined() {
        return this.dimensions.size();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRT
    public int getDimensionsLength() {
        Iterator<RRTDimension> it = this.dimensions.iterator();
        int sizeInBytes = 0;
        while (it.hasNext()) {
            sizeInBytes += it.next().getSizeInBytes();
        }
        return sizeInBytes;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public long getIntervalMillis() {
        return this.interval_millis;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRT
    public int getRatingRegion() {
        return this.rating_region;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRT
    public int getRatingRegionNameLength() {
        MultipleStringStructure multipleStringStructure = this.rating_region_name_text;
        if (multipleStringStructure == null) {
            return 0;
        }
        return multipleStringStructure.getSizeInBytes();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRT
    public MultipleStringStructure getRatingRegionNameText() {
        return this.rating_region_name_text;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public TableID getTableID() {
        return TableID.RATING_REGION_TABLE;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public int getTablePID() {
        return 8187;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public int getTableVersion() {
        return getVersionNumber();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.SectionRepresentation
    public int getTotalSectionNumber() {
        int ratingRegionNameLength = 1021 - ((getRatingRegionNameLength() + 14) + getDescriptorsLength());
        int i = 0;
        int i2 = 0;
        while (i < getDimensionsDefined()) {
            int sizeInBytes = 0;
            while (i < getDimensionsDefined() && getDimensionAt(i).getSizeInBytes() + sizeInBytes < ratingRegionNameLength) {
                sizeInBytes += getDimensionAt(i).getSizeInBytes();
                i++;
            }
            i2++;
        }
        return i2;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRT
    public int getVersionNumber() {
        return this.version_number;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.SectionRepresentation
    public boolean isMultiSection() {
        return getTotalSectionNumber() > 1;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod
    public void removeAllDescriptors() {
        List<Descriptor> list = this.descs;
        list.removeAll(list);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRT
    public void removeAllDimensions() {
        List<RRTDimension> list = this.dimensions;
        list.removeAll(list);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod
    public boolean removeDescriptor(Descriptor descriptor) {
        return this.descs.remove(descriptor);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod
    public boolean removeDescriptorAt(int i) {
        if (i < 0 || i >= this.descs.size()) {
            return false;
        }
        this.descs.remove(i);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRT
    public boolean removeDimension(RRTDimension rRTDimension) {
        return this.dimensions.remove(rRTDimension);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRT
    public boolean removeDimensionAt(int i, RRTDimension rRTDimension) {
        if (i < 0 || i >= this.dimensions.size()) {
            return false;
        }
        this.dimensions.remove(i);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod
    public boolean setDescriptorAt(int i, Descriptor descriptor) {
        if (i < 0 || i >= this.descs.size()) {
            return false;
        }
        this.descs.set(i, descriptor);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRT
    public boolean setDimensionAt(int i, RRTDimension rRTDimension) {
        if (i < 0 || i >= this.dimensions.size()) {
            return false;
        }
        this.dimensions.set(i, rRTDimension);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public void setIntervalMillis(long j) {
        this.interval_millis = j;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRT
    public void setRatingRegion(int i) {
        this.rating_region = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRT
    public void setRatingRegionNameText(MultipleStringStructure multipleStringStructure) {
        this.rating_region_name_text = multipleStringStructure;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRT
    public void setVersionNumber(int i) {
        this.version_number = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.SectionRepresentation
    public Section[] toSection() {
        int ratingRegionNameLength = 1021 - ((getRatingRegionNameLength() + 14) + getDescriptorsLength());
        int totalSectionNumber = getTotalSectionNumber();
        Section[] sectionArr = new Section[totalSectionNumber];
        int i = 0;
        int i2 = 0;
        while (i < totalSectionNumber) {
            sectionArr[i] = SectionFactory.createRRTSection(this, this.rating_region, i, totalSectionNumber - 1);
            int sizeInBytes = 0;
            int i3 = i2;
            while (i3 < getDimensionsDefined() && getDimensionAt(i3).getSizeInBytes() + sizeInBytes < ratingRegionNameLength) {
                sizeInBytes += getDimensionAt(i3).getSizeInBytes();
                i3++;
            }
            BitOutputStream bitOutputStream = new BitOutputStream((getRatingRegionNameLength() + 2 + 1 + sizeInBytes + 2 + getDescriptorsLength()) * 8);
            bitOutputStream.writeFromLSB(0, 8);
            bitOutputStream.writeFromLSB(getRatingRegionNameLength(), 8);
            MultipleStringStructure multipleStringStructure = this.rating_region_name_text;
            if (multipleStringStructure != null) {
                bitOutputStream.write(multipleStringStructure.toByteArray());
            }
            bitOutputStream.writeFromLSB(getDimensionsDefined(), 8);
            while (i2 < i3) {
                bitOutputStream.write(getDimensionAt(i2).toByteArray());
                i2++;
            }
            bitOutputStream.writeFromLSB(255, 6);
            bitOutputStream.writeFromLSB(getDescriptorsLength(), 10);
            if (getDescriptorSize() > 0) {
                Iterator<Descriptor> descriptors = getDescriptors();
                while (descriptors.hasNext()) {
                    bitOutputStream.write(descriptors.next().toByteArray());
                }
            }
            sectionArr[i].setPrivateData(bitOutputStream.toByteArray());
            i++;
            i2 = i3;
        }
        return sectionArr;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.XMLRepresentation
    public String toXMLString(int i) {
        String str = new String() + MyUTIL.whiteSpaceStr(i) + "<RRT>\n";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        int i2 = i + 2;
        sb.append(MyUTIL.whiteSpaceStr(i2));
        sb.append("<table_id>");
        sb.append(TableID.RATING_REGION_TABLE.getValue());
        sb.append("</table_id>\n");
        String str2 = (sb.toString() + MyUTIL.whiteSpaceStr(i2) + "<rating_region>" + this.rating_region + "</rating_region>\n") + MyUTIL.whiteSpaceStr(i2) + "<version_number>" + this.version_number + "</version_number>\n";
        if (this.rating_region_name_text != null) {
            str2 = str2 + this.rating_region_name_text.toXMLString(i2);
        }
        if (getDimensionsDefined() > 0) {
            Iterator<RRTDimension> dimensions = getDimensions();
            String str3 = str2 + MyUTIL.whiteSpaceStr(i2) + "<RatingDimensionLoop>\n";
            while (dimensions.hasNext()) {
                str3 = str3 + dimensions.next().toXMLString(i + 4);
            }
            str2 = str3 + MyUTIL.whiteSpaceStr(i2) + "</RatingDimensionLoop>\n";
        }
        if (getDescriptorSize() > 0) {
            Iterator<Descriptor> descriptors = getDescriptors();
            String str4 = str2 + MyUTIL.whiteSpaceStr(i2) + "<DescriptorLoop>\n";
            while (descriptors.hasNext()) {
                str4 = str4 + descriptors.next().toXMLString(i + 4);
            }
            str2 = str4 + MyUTIL.whiteSpaceStr(i2) + "</DescriptorLoop>\n";
        }
        return str2 + MyUTIL.whiteSpaceStr(i) + "</RRT>\n";
    }
}
