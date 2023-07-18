package org.zerock.persistance;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

@Slf4j
public class JDBCTests {

    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testConnection(){
        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
            log.info("conn : {}",conn);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
