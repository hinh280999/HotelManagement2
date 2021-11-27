package Rmi.Interface;

import java.rmi.RemoteException;

import Model.PageList;
import Rmi.DTO.DichVuDTO;

public interface IDichVuService extends IBaseService<DichVuDTO> {
	PageList<DichVuDTO> getListDichVuByPage(int pageNumb, int maxRow, String DichVuName) throws RemoteException;
}
