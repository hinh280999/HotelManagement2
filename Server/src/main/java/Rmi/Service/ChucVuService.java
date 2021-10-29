package Rmi.Service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Dao.Impliment.ChucVuDao;
import Dao.Interface.IChucVu;
import Entity.ChucVu;
import Rmi.DTO.ChucVuDTO;
import Rmi.Interface.IChucVuService;
import Utilities.MappingChucVuDTO;

public class ChucVuService extends UnicastRemoteObject implements IChucVuService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IChucVu chucVuDao;
	public ChucVuService() throws RemoteException{
		chucVuDao = new ChucVuDao();
	}
	
	@Override
	public boolean addChucVu(ChucVuDTO object) throws RemoteException{
		ChucVu addObject  = MappingChucVuDTO.mapToChucVu(object);
		return chucVuDao.add(addObject);
	}

	@Override
	public ChucVuDTO getChucVuById(int id) throws RemoteException{
		try {
			ChucVu chucvu = chucVuDao.get(id);
			return MappingChucVuDTO.mapToChucVuDTO(chucvu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateChucVu(ChucVuDTO objectDTO) throws RemoteException{
		ChucVu chucvu = new ChucVu(objectDTO.getTenCV(), objectDTO.getLuong());
		chucvu.setMaCV(objectDTO.getMaCV());
		return chucVuDao.update(chucvu);
	}

	@Override
	public boolean deleteChucVu(int object) throws RemoteException{
		return chucVuDao.delete(object);
	}

}
