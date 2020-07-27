package com.mega.pool;

import org.neo4j.driver.v1.Session;

/**
 * 连接对象
 * Created by zhaoyq on 2020/7/24.
 */
public class Neo4jSession {
    Neo4jPool dataSource;
    Session session;

    public void setDataSource(Neo4jPool neo4jPool) {
        this.dataSource=neo4jPool;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public boolean isOpen(){
        return this.session.isOpen();
    }

    public void close(){
        //dataSource.returnBrokenResource(this);   returnBrokenResource是将brock的资源释放掉
        dataSource.returnResource(this);
    }
}
