package com.mega.pool;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * 连接池
 * Created by zhaoyq on 2020/7/24.
 */
public class Neo4jPool extends Pool<Neo4jSession> {

    public Neo4jPool(){

    }

    public Neo4jPool(final GenericObjectPoolConfig poolConfig, final String uri,
                     final String user, final String password, final String clientName) {
        super(poolConfig, new Neo4jSessionFactory(uri,  user, password, clientName));
    }

    @Override
    public Neo4jSession getResource() {
        Neo4jSession session = super.getResource();
        session.setDataSource(this);
        return session;
    }

    protected void returnBrokenResource(Neo4jSession resource) {
        super.returnResource(resource);
    }

    protected void returnResource(Neo4jSession resource) {
        super.returnResource(resource);
    }
}
