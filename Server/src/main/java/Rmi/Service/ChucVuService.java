package Rmi.Service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Dao.Impliment.ChucVuDao;
import Dao.Interface.IChucVu;
import Entity.ChucVu;
import Rmi.DTO.ChucVuDTO;
import Rmi.Interface.IChucVuService;
import Utilities.MappingDtoFacade;

public class ChucVuService extends UnicastRemoteObject implements IChucVuService {

	private static final long serialVersionUID = 1L;
	private IChucVu chucVuDao;

	public ChucVuService() throws RemoteException {
		chucVuDao = new ChucVuDao();
	}

	@Override
	public boolean addObject(ChucVuDTO object) throws RemoteException {
		ChucVu addObject = MappingDtoFacade.mapToChucVu(object);
		return chucVuDao.add(addObject);
	}

	@Override
	public ChucVuDTO getObjectById(int id) throws RemoteException {
		try {
			ChucVu chucvu = chucVuDao.get(id);
			return MappingDtoFacade.mapToChucVuDTO(chucvu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateObject(ChucVuDTO objectDTO) throws RemoteException {
		ChucVu chucvu = new ChucVu(objectDTO.getTenCV(), objectDTO.getLuong());
		chucvu.setMaCV(objectDTO.getMaCV());
		return chucVuDao.update(chucvu);
	}

	@Override
	public boolean deleteObjectById(int object) throws RemoteException {
		return chucVuDao.delete(object);
	}

}
