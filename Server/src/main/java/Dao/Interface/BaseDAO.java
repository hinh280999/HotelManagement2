package Dao.Interface;

import java.util.List;

public interface BaseDAO<T> {

	T get(int id) throws Exception;
    
    List<T> getAll();
    
    boolean add(T addObject);
    
    boolean update(T updateObject);
    
    boolean delete(T deleteObject);
    
    List<T> getListByPage(int pageNumb);
}
