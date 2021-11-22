package Rmi.Interface;

import java.rmi.RemoteException;

import Rmi.DTO.PhongDTO;

public interface IPhongService extends IBaseService<PhongDTO> {
	PhongDTO getPhongTrong() throws RemoteException;
}
