package com.mega.pool.exception;

/**
 * Created by zhaoyq on 2020/7/27.
 */
public class Neo4jException extends RuntimeException {
    private static final long serialVersionUID = 3360535414048529387L;

    public Neo4jException(String message) {
        super(message);
    }

    public Neo4jException(Throwable e) {
        super(e);
    }

    public Neo4jException(String message, Throwable cause) {
        super(message, cause);
    }
}

