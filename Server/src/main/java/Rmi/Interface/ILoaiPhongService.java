package Rmi.Interface;

import java.rmi.RemoteException;
import java.util.List;

import Rmi.DTO.LoaiPhongDTO;

public interface ILoaiPhongService extends IBaseService<LoaiPhongDTO> {

	List<LoaiPhongDTO> getAllLoaiPhong() throws RemoteException;

}
