package com.mega.pool.exception;

/**
 * Created by zhaoyq on 2020/7/27.
 */
public class Neo4jConnectionException extends Neo4jException {
    private static final long serialVersionUID = -2946266495682282677L;

    public Neo4jConnectionException(String message) {
        super(message);
    }

    public Neo4jConnectionException(Throwable e) {
        super(e);
    }

    public Neo4jConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}

