package model;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "status")
@XmlEnum
public enum StatutType {

    @XmlEnumValue("stage")
    STAGE("stage"),
    @XmlEnumValue("emploi")
    EMPLOI("emploi");
    private final String value;

    StatutType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StatutType fromValue(String v) {
        for (StatutType c: StatutType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}