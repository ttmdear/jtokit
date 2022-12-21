package com.jtokit.collections;

public interface IdentifiableLong extends Identifiable<Long> {

    @Override
    Long identifiableBy();
}
