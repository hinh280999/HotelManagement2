package Rmi.Interface;

import java.rmi.RemoteException;

import Rmi.DTO.PhieuDichVuDTO;

public interface IPhieuDichVuService extends IBaseService<PhieuDichVuDTO> {
	boolean addPhieuDichVuByMaPhong(int maPhong, int maDichVu,int soluong) throws RemoteException;
}
