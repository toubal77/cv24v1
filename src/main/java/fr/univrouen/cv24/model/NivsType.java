package fr.univrouen.cv24.model;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "nivs")
@XmlEnum
public enum NivsType {

    @XmlEnumValue("A1")
    A_1("A1"),
    @XmlEnumValue("A2")
    A_2("A2"),
    @XmlEnumValue("B1")
    B_1("B1"),
    @XmlEnumValue("B2")
    B_2("B2"),
    @XmlEnumValue("C1")
    C_1("C1"),
    @XmlEnumValue("C2")
    C_2("C2");
    private final String valueNivs;

    NivsType(String v) {
        valueNivs = v;
    }

    public String valueNivs() {
        return valueNivs;
    }

    public static NivsType fromValue(String v) {
        for (NivsType c: NivsType.values()) {
            if (c.valueNivs.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

} 
