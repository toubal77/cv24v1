package model;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "genre")
@XmlEnum
public enum GenreType {

    @XmlEnumValue("M.")
    M("M."),
    @XmlEnumValue("Mme")
    MME("Mme"),
    @XmlEnumValue("Mrs")
    MRS("Mrs"),
    @XmlEnumValue("Miss")
    MISS("Miss"),
    @XmlEnumValue("Mr")
    MR("Mr");
    private final String value;

    GenreType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GenreType fromValue(String v) {
        for (GenreType c: GenreType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}