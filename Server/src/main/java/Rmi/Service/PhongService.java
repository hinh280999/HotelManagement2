package Rmi.Service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Dao.Impliment.PhongDao;
import Dao.Interface.IPhongDao;
import Entity.Phong;
import Rmi.DTO.PhongDTO;
import Rmi.Interface.IPhongService;
import Utilities.MappingDtoFacade;

public class PhongService extends UnicastRemoteObject implements IPhongService {
	private static final long serialVersionUID = 1L;
	private IPhongDao phongDao;

	public PhongService() throws RemoteException {
		phongDao = new PhongDao();
	}

	@Override
	public boolean addObject(PhongDTO objectDTO) throws RemoteException {
		Phong addObj = MappingDtoFacade.mapToPhong(objectDTO);
		return phongDao.add(addObj);
	}

	@Override
	public PhongDTO getObjectById(int id) throws RemoteException {
		try {
			PhongDTO phongDto = MappingDtoFacade.mapToPhongDTO(phongDao.get(id));
			return phongDto;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateObject(PhongDTO objectDTO) throws RemoteException {
		Phong updateObj = MappingDtoFacade.mapToPhong(objectDTO);
		updateObj.setMaP(objectDTO.getMaP());
		return phongDao.update(updateObj);
	}

	@Override
	public boolean deleteObjectById(int objectId) throws RemoteException {
		return phongDao.delete(objectId);
	}

	@Override
	public PhongDTO getPhongTrongByLoaiPhongId(int loaiPhongId) throws RemoteException {
		return MappingDtoFacade.mapToPhongDTO(phongDao.getPhongTrongByLoaiPhongId(loaiPhongId));
	}

}
