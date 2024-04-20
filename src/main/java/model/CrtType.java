package model;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "crt")
@XmlEnum
public enum CrtType {

    @XmlEnumValue("MAT")
    MAT,
    @XmlEnumValue("CLES")
    CLES,
    @XmlEnumValue("TOEIC")
    TOEIC;

    public String value() {
        return name();
    }

    public static CrtType fromValue(String v) {
        return valueOf(v);
    }

}