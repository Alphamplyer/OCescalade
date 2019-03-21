package com.alphamplyer.ocescalade.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * Class to get Database
 */
@Repository
public class AbstractDAO {
    /**
     * DataSource
     */
    @Autowired
    private static DataSource dataSource;

    /**
     * Get Data source
     * @return Data Source
     */
    protected DataSource getDataSource() {
        return dataSource;
    }

    public static void setDataSource(DataSource dataSource) {
        AbstractDAO.dataSource = dataSource;
    }
}
