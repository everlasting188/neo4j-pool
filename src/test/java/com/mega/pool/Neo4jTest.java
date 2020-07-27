package com.mega.pool;

import org.neo4j.driver.v1.*;
import org.neo4j.driver.v1.types.Node;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhaoyq on 2020/7/24.
 */
public class Neo4jTest {

    public void testPool(){
        Neo4jPool neo4jPool = new Neo4jPool();
        Neo4jSession neo4jSession=neo4jPool.getResource();
        neo4jSession.close();
    }

    private void init(){
        Driver driver = GraphDatabase.driver("bolt://xxxxxx:7687", AuthTokens.basic("xxxxx", "xxxxx"));
        long startTime = System.currentTimeMillis();
        Session sessionLocal = driver.session();
        try (Session session = driver.session()) {
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
            System.out.println("========================"+costTime+"ms====");
        }
        driver.close();
    }
}
