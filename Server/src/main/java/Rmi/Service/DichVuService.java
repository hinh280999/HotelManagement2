package Rmi.Service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Dao.Impliment.DichVuDao;
import Dao.Interface.IDichVuDao;
import Entity.DichVu;
import Rmi.DTO.DichVuDTO;
import Rmi.Interface.IDichVuService;
import Utilities.MappingDtoFacade;

public class DichVuService extends UnicastRemoteObject implements IDichVuService {

	private static final long serialVersionUID = 1L;
	private IDichVuDao dichVuDao;

	public DichVuService() throws RemoteException {
		super();
		dichVuDao = new DichVuDao();
	}

	@Override
	public boolean addObject(DichVuDTO objectDTO) throws RemoteException {
		DichVu addObject = MappingDtoFacade.mapToDichVu(objectDTO);
		return dichVuDao.add(addObject);
	}

	@Override
	public DichVuDTO getObjectById(int id) throws RemoteException {
		try {
			DichVuDTO rv = MappingDtoFacade.mapToDichVuDTO(dichVuDao.get(id));
			return rv;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateObject(DichVuDTO objectDTO) throws RemoteException {
		DichVu updateObject = MappingDtoFacade.mapToDichVu(objectDTO);
		updateObject.setMaDv(objectDTO.getMaDv());
		return dichVuDao.update(updateObject);
	}

	@Override
	public boolean deleteObjectById(int objectId) throws RemoteException {

		return dichVuDao.delete(objectId);
	}

}
