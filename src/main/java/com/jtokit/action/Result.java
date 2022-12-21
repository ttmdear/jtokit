package com.jtokit.action;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Function;

@ParametersAreNonnullByDefault
public class Result {

    @Nonnull
    protected Status status = Status.NONE;

    @Nonnull
    protected String message = "";

    @Nonnull
    protected Errors errors = new Errors();

    public static Result of(Status status) {
        Result result = new Result();
        result.status = status;
        return result;
    }

    public static Result of(Status status, String message) {
        Result result = new Result();
        result.status = status;
        result.message = message;
        return result;
    }

    public static Result of(Status status, Errors errors) {
        Result result = new Result();
        result.status = status;
        result.errors = errors;
        return result;
    }

    public static Result error(Errors errors) {
        Result result = new Result();
        result.status = Status.ERROR;
        result.errors = errors;
        return result;
    }

    public static Result success() {
        Result result = new Result();
        result.status = Status.SUCCESS;
        return result;
    }

    public static Result success(String message) {
        Result result = new Result();
        result.status = Status.SUCCESS;
        result.message = message;
        return result;
    }

    public static <R extends Result, V> V handleResult(R result, Function<R, V> function) {
        if (result.isSuccess()) {
            return function.apply(result);
        } else {
            throw new ActionException(result);
        }
    }

    public boolean isSuccess() {
        return Status.SUCCESS.equals(status);
    }

    @Nonnull
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Nonnull
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Nonnull
    public Errors getErrors() {
        return errors;
    }

    public void throwActionException() {
        throw new ActionException(this);
    }
}
