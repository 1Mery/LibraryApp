package com.example.libraryNew.enums;

public enum MemberLevel {
    STANDARD(3),
    GOLD(5);

    private final int maxBorrow;

    MemberLevel(int maxBorrow) {
        this.maxBorrow = maxBorrow;
    }

    public int getMaxBorrow() {
        return maxBorrow;
    }
}
