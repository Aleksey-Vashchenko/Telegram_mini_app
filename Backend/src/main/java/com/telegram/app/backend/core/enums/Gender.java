package com.telegram.app.backend.core.enums;

public enum Gender {
    MALE, FEMALE, BOTH;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
