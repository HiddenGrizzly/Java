package dataBean;

import com.mysql.cj.jdbc.CallableStatement;

import java.sql.*;
import java.util.Properties;
import java.util.Vector;

public class DataBean {
    private Connection connection = null;
    private ResultSet resultset = null;
    private PreparedStatement prepareStatement = null;
    private java.sql.CallableStatement storeProc = null;
    private Statement statement = null;
    private int resultsettype = 0;
    private int resultsetconcurrency = 0;
    private String driver = null;
    private String url = null;
    private String username = null;
    private String password = null;
    private Properties properties = null;
    private String database;
    private String table;
    private Vector<String> fields;
    private int error = 0;
    private String errmsg = null;
    private boolean preparestatement = false;

    public int getError() {
        return error;
    }

    public void setUsername(String usr) {
        username = usr;
    }

    public String getUsername() {
        return username;
    }

    public Connection getConnection() {
        if (connection == null) error = 3;

        return connection;
    }

    public void setConnection(Connection con) {
        if (driver == null) {
            error = 1;
        }
        if (url == null)
            error = 2;
        try {
            Class.forName(driver);
            if (properties == null) {
                if ((username == null) && (password == null)) {
                    con = DriverManager.getConnection(url);
                } else {
                    con = DriverManager.getConnection(url, username, password);
                }
            } else {
                con = DriverManager.getConnection(url, properties);

            }
            connection = con;

        } catch (Exception e) {
            errmsg = e.getMessage();
            error = -1;
            System.out.println("Co loi khi tao ket noi");
            return;
        }
        error = 0;
    }

    public ResultSet getResultset() {
        return resultset;
    }

    public void setResultset(ResultSet resultset) {
        this.resultset = resultset;
    }

    public PreparedStatement getPrepareStatement(String sql) {
        try {
            if ((resultsettype == 0) && (resultsetconcurrency == 0))
                prepareStatement = connection.prepareStatement(sql);
            else {
                statement = connection.createStatement(resultsettype, resultsetconcurrency);

            }
        } catch (SQLException e) {
            errmsg = "Error:" + e.getSQLState() + e.getMessage();
            error = -1;
        }
        return prepareStatement;
    }

    public void setPrepareStatement(PreparedStatement prepareStatement) {
        this.prepareStatement = prepareStatement;
    }

    public java.sql.CallableStatement getStoreProc(String sql) {
        try {
            if ((resultsettype == 0) && (resultsetconcurrency == 0)) {
                storeProc = connection.prepareCall(sql);
            } else {
                storeProc = connection.prepareCall(sql, resultsettype, resultsetconcurrency);
            }
        } catch (SQLException e) {
            errmsg = "Error: " + e.getSQLState() + "" + e.getMessage();
            error = -1;
        }
        return storeProc;
    }

    public void setStoreProc(CallableStatement storeProc) {
        this.storeProc = storeProc;
    }

    public Statement getStatement() {
        try {
            if ((resultsettype == 0) && (resultsetconcurrency == 0))
                statement = connection.createStatement();
            else {
                statement = connection.createStatement(resultsettype, resultsetconcurrency);

            }
        } catch (SQLException e) {
            errmsg = "Error:" + e.getSQLState() + e.getMessage();
            error = -1;
        }
        return statement;

    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public int getResultsettype() {
        return resultsettype;
    }

    public void setResultsettype(int resultsettype) {
        this.resultsettype = resultsettype;
    }

    public int getResultsetconcurrency() {
        return resultsetconcurrency;
    }

    public void setResultsetconcurrency(int resultsetconcurrency) {
        this.resultsetconcurrency = resultsetconcurrency;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public Vector<String> getFields() {
        return fields;
    }

    public void setFields(Vector<String> fields) {
        this.fields = fields;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getErrmsg() {
        switch (error) {
            case 0:
                errmsg = "No Error !!!";
                break;

            case 1:
                errmsg = "Driver Invalid IT!";
                break;
            case 2:
                errmsg = "URL Invalid !!!";
                break;
            case 3:
                errmsg = "Connection is not currently established !!!";
                break;
        }
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public void destroy() {
        try {
            if (resultset != null) {
                resultset.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (prepareStatement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            errmsg = "Error: " + e.getSQLState() + "--" + e.getMessage();
            error = -1;
        }
    }

    public void insert(Properties pField) {
        String queryString = "INSERT INTO " + table + " (";
        int t = 0;
        for (int i = 0; i < fields.size(); i++) {
            String s = pField.getProperty(fields.get(i));

            if (s != null) {
                if (t != 0) {
                    queryString += ",";
                }
                queryString = fields.get(i);
                t++;
            }
        }
        queryString += ") VALUES (";

        t = 0;
        for (int i = 0; i < fields.size(); i++) {
            String s = pField.getProperty(fields.get(i));
            if (s != null) {
                if (t != 0) {
                    queryString += ",";
                }
                queryString = "’" + pField.getProperty(fields.get(i)) + "’";
                t++;
            }
        }
        queryString += ");";
        try {
            System.out.println(queryString);
            if (statement == null) {
                System.out.println("Statement NULL");

            }
            statement.executeUpdate(queryString);

        }
        catch (SQLException sqlException) {
            System.out.println(sqlException);
        }

    }
}

