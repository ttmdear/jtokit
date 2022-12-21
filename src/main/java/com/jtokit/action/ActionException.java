package com.jtokit.action;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class ActionException extends RuntimeException {
    private final Result result;

    public ActionException(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }
}
