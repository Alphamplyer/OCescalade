package com.alphamplyer.ocescalade.dao;

import javax.sql.DataSource;

/**
 * Class to get Database
 */
public class AbstractDAO {
    /**
     * DataSource
     */
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
