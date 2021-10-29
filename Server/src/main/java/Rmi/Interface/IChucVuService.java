package Rmi.Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Rmi.DTO.ChucVuDTO;

public interface IChucVuService extends Remote {
	boolean addChucVu(ChucVuDTO object) throws RemoteException;
	ChucVuDTO getChucVuById(int id)throws RemoteException;
	boolean updateChucVu(ChucVuDTO object)throws RemoteException;
	boolean deleteChucVu(int object)throws RemoteException;
}
