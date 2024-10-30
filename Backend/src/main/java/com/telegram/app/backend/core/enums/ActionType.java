package com.telegram.app.backend.core.enums;

public enum ActionType {
    Truth, Dare;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
