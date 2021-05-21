package com.andromoticaia.valletparking.database;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "driver")
public class DriverEntity implements Parcelable {

    @ColumnInfo(name = "name")
    String name;

    @ColumnInfo(name = "licenseplate")
    String licenseplate;

    @ColumnInfo(name = "admissionDate")
    String admissionDate;

    @ColumnInfo(name = "enterokay")
    Boolean enterokay;

    @ColumnInfo(name = "out")
    Boolean out;

    @PrimaryKey(autoGenerate = true)
    Long ID;

    public DriverEntity(Long ID,String name, String admissionDate, String licenseplate, Boolean in, Boolean out) {
        this.ID = ID;
        this.name = name;
        this.admissionDate = admissionDate;
        this.licenseplate = licenseplate;
        this.enterokay = in;
        this.out = out;
    }

    public DriverEntity() {
    }

    protected DriverEntity(Parcel in) {
        name = in.readString();
        licenseplate = in.readString();
        admissionDate = in.readString();
        byte tmpInside = in.readByte();
        enterokay = tmpInside == 0 ? null : tmpInside == 1;
        byte tmpOut = in.readByte();
        out = tmpOut == 0 ? null : tmpOut == 1;
        if (in.readByte() == 0) {
            ID = null;
        } else {
            ID = in.readLong();
        }
    }

    public static final Creator<DriverEntity> CREATOR = new Creator<DriverEntity>() {
        @Override
        public DriverEntity createFromParcel(Parcel in) {
            return new DriverEntity(in);
        }

        @Override
        public DriverEntity[] newArray(int size) {
            return new DriverEntity[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getLicenseplate() {
        return licenseplate;
    }

    public void setLicenseplate(String licenseplate) {
        this.licenseplate = licenseplate;
    }

    public Boolean getInside() {
        return enterokay;
    }

    public void setInside(Boolean inside) {
        this.enterokay = inside;
    }

    public Boolean getOut() {
        return out;
    }

    public void setOut(Boolean out) {
        this.out = out;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(licenseplate);
        parcel.writeString(admissionDate);
        parcel.writeByte((byte) (enterokay == null ? 0 : enterokay ? 1 : 2));
        parcel.writeByte((byte) (out == null ? 0 : out ? 1 : 2));
        if (ID == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(ID);
        }
    }
}
