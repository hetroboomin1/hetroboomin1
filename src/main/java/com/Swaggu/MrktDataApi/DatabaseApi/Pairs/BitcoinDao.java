package com.Swaggu.MrktDataApi.DatabaseApi.Pairs;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.Swaggu.MrktDataApi.Config.DatabaseConfig;
import com.Swaggu.MrktDataApi.DatabaseApi.MrktDao;
import com.Swaggu.MrktDataApi.Models.OHLC;
import com.Swaggu.MrktDataApi.Models.Spread;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BitcoinDao implements MrktDao{
    private final Logger logger = LoggerFactory.getLogger(BitcoinDao.class);

    private PreparedStatement stmt = null;
    private Connection c;

    private String databaseUrl;
    private String username;
    private String password;
    private String driver;

    public BitcoinDao(DatabaseConfig databaseConfig){
        this.databaseUrl = databaseConfig.getDatabaseUrl();
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

    @Override // Access database and get spread Json
    public Spread getLatestSpread() { // returns latest spread for bitcoin in JSON
        logger.info("Getting spread data from database");
        List<BigDecimal> spreadValuesList = new ArrayList<BigDecimal>();
        try {
            c = getConnection();
            String sql = "select jsonb_array_elements_text(data::jsonb -> 'data')::decimal from spread WHERE (data::jsonb ->> 'pair' = 'XBT/CAD') order by time desc limit 5;";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            c.commit();
            c.close();
            while (rs.next()) {
                spreadValuesList.add(rs.getBigDecimal(1));
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return new Spread(spreadValuesList);
    }

    // @Override
    public OHLC getLatestOHLC() { // returns latest spread for bitcoin in JSON
        logger.info("Getting OHLC from database");
        List<BigDecimal> valuesList = new ArrayList<BigDecimal>();
        try {
            c = getConnection();
            String sql = "select jsonb_array_elements_text(data::jsonb -> 'data')::decimal from ohlc WHERE (data::jsonb ->> 'pair' = 'XBT/CAD') order by time desc limit 9;";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            c.commit();
            c.close();
            while (rs.next()) {
                valuesList.add(rs.getBigDecimal(1)); // for OHLC would be getting decimal AND integer
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return new OHLC(valuesList);
    }
}
