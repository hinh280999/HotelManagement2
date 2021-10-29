package Rmi.Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBaseService<T> extends Remote {
	boolean addChucVu(T objectDTO) throws RemoteException;
	T getChucVuById(int id)throws RemoteException;
	boolean updateChucVu(T objectDTO)throws RemoteException;
	boolean deleteChucVu(int objectId)throws RemoteException;
}
