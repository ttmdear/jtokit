package com.jtokit.action;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    protected Error error = new Error();

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

    public static Result of(Status status, Error error) {
        Result result = new Result();
        result.status = status;
        result.error = error;
        return result;
    }

    public static Result error(Error error) {
        Result result = new Result();
        result.status = Status.ERROR;
        result.error = error;
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

    public static Result error() {
        Result result = new Result();
        result.status = Status.ERROR;
        return result;
    }

    public static Result error(String message) {
        Result result = new Result();
        result.status = Status.ERROR;
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

    @JsonIgnore
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
    public Error getError() {
        return error;
    }

    public void throwActionException() {
        throw new ActionException(this);
    }
}
