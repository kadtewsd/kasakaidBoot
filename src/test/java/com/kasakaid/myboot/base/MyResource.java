package com.kasakaid.myboot.base;

import org.apache.commons.logging.impl.SLF4JLog;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.csv.CsvDataSet;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.junit.rules.ExternalResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.sql.SQLException;

@Component
public class MyResource extends ExternalResource {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    /** ApplicationContext */
    @Autowired
    protected ApplicationContext context;

    /** データソース */
    @Resource
    private TransactionAwareDataSourceProxy masterDataSource;

    /** CSVデータ格納ディレクトリ */
    private static final String CSV_DIRECTORY = "src/test/resources/testData/";

    @Override
    public void before() {
        logger.info(this.getClass().getName() + "before start.");
    }
    @Override
    public void after() {
        logger.info(this.getClass().getName() + "after start");
    }
    /**
     * テストデータ投入メソッド
     *
     * @param datas テストデータ
     * @throws Exception 例外
     */
    public void insertData(String... testData) throws Exception {
        DatabaseConnection dbConn = null;
        try {
            // DatabaseConnectionの作成
            dbConn = openDbConn();
            for (String data : testData) {
                // データセットの取得
                CsvDataSet dataSet = new CsvDataSet(new File(CSV_DIRECTORY + data));
                // セットアップ実行
                DatabaseOperation.CLEAN_INSERT.execute(dbConn, dataSet);
            }
        } finally {
            // DatabaseConnectionの破棄
            closeDbConn(dbConn);
        }
    }

    /**
     * テストデータ投入メソッド
     *
     * @param datas テストデータ
     * @throws Exception 例外
     */
    public void deleteData(String... datas) throws Exception {
        DatabaseConnection dbConn = null;
        try {
            // DatabaseConnectionの作成
            dbConn = openDbConn();
            for (String data : datas) {
                // データセットの取得
                CsvDataSet dataSet = new CsvDataSet(new File(CSV_DIRECTORY + data));
                // セットアップ実行
                DatabaseOperation.DELETE_ALL.execute(dbConn, dataSet);
            }
        } finally {
            // DatabaseConnectionの破棄
            closeDbConn(dbConn);
        }
    }

    private DatabaseConnection openDbConn() throws DatabaseUnitException {
        DatabaseConnection databaseConnection = new DatabaseConnection(DataSourceUtils.getConnection(masterDataSource));
        DatabaseConfig config = databaseConnection.getConfig();
        config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MySqlDataTypeFactory());
        return databaseConnection;
    }

    private void closeDbConn(DatabaseConnection dbConn) throws SQLException {
        if (dbConn != null) {
            dbConn.close();
        }
    }
}

