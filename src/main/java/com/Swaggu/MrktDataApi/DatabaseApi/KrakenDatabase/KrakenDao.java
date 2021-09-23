package com.Swaggu.MrktDataApi.DatabaseApi.KrakenDatabase;

import com.Swaggu.MrktDataApi.Config.DaoConfigBuilder;
import com.Swaggu.MrktDataApi.DatabaseApi.MrktDao;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KrakenDao implements MrktDao {
    private Logger logger = LoggerFactory.getLogger(KrakenDao.class);

    private final ObjectMapper mapper = new ObjectMapper();

    private Connection c;

    private String databaseUrl;
    private String username;
    private String password;
    private String driver;

    public KrakenDao(DaoConfigBuilder databaseConfig) {
        this.databaseUrl = databaseConfig.getUrl();
        this.driver = databaseConfig.getDriver();
        this.username = databaseConfig.getUsername();
        this.password = databaseConfig.getPassword();
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection c = null;
        Class.forName(driver);
        c = DriverManager.getConnection(databaseUrl, username, password);
        c.setAutoCommit(false);
        return c;
    }

    @Override
    public JsonNode retrieveData(String pair, String channelname) {
        String data = null;
        try {
            c = getConnection();
            String sql = "SELECT getKrakenData(?,?);";
            PreparedStatement cstmt = c.prepareStatement(sql);
            cstmt.setString(1, pair);
            cstmt.setString(2, channelname);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                data = rs.getString(1);
                // logger.info(data);
            }
            cstmt.close();
            c.commit();
            c.close();
            return mapper.readTree(data);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            logger.info("Error retrieving data");
            return null;
        }
    }
}
