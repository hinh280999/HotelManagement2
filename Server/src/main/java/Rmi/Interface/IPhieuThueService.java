package Rmi.Interface;

import java.rmi.RemoteException;

import Rmi.DTO.PhieuThueDTO;

public interface IPhieuThueService extends IBaseService<PhieuThueDTO> {
	PhieuThueDTO getPhieuThueByCMT(String cmt) throws RemoteException;
}
