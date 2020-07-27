package com.mega.pool;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.neo4j.driver.v1.*;
import org.neo4j.driver.v1.types.Node;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * neo4jpool测试
 * Created by zhaoyq on 2020/7/27.
 */
public class Neo4jPoolTest {
    public static void main(String[] args) {
        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();

        Neo4jPool neo4jPool = new Neo4jPool(genericObjectPoolConfig,"bolt://xxxxxx:port","neo4j","neo4j-ai","testzyq");
        long startTime = System.currentTimeMillis();
        int count = 1000;
        for(int i=0;i<count;i++){
            Neo4jSession neo4jSession=neo4jPool.getResource();
            test(neo4jSession);
            neo4jSession.close();
        }
        System.out.println("######################ending#######################");
        System.out.println("cost times:"+(System.currentTimeMillis()-startTime));
    }


    private static void test(Neo4jSession neo4jSession){
        long startTime = System.currentTimeMillis();
        Session session = neo4jSession.getSession();

        String entityName = "感冒";
        String queryCyper="match p=(s_node)-[relation]-(e_node) where s_node.name='"+entityName+"'return s_node,e_node,relation";
        StatementResult result = session.run(queryCyper);
        Set<String> entitySet = new HashSet<>();

        //说明处理
        for(Record record:result.list()){
            if (record.get("e_node")!=null){
                Node node =record.get("e_node").asNode();
                Map<String, Object> propMap=node.asMap();
                ;
                String relaName=(String)propMap.get("name");
                entitySet.add(relaName);
            }
        }

        long costTime = System.currentTimeMillis() - startTime;
        //System.out.println("========================"+costTime+"ms====");
    }
}
