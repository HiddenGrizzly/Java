package JavaEnterpriseComponents.model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DAOInterface<T> {

    void  insert(T t) throws SQLException;

    T selectById(String id) throws SQLException;

    T selectByName(String name) throws SQLException;

    ArrayList<T> selectAll() throws SQLException;

}
