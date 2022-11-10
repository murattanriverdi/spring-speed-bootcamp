package com.murattanriverdi.shopping.data.entity;

public enum CartStatus {
    NEW(0,"Yeni"),END(1,"Bitmiş");

    private final int code;
    private final String value;
    CartStatus(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
