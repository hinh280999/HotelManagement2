package Rmi.Service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Dao.Impliment.PhieuThueDao;
import Dao.Interface.IPhieuThue;
import Entity.PhieuThue;
import Rmi.DTO.PhieuThueDTO;
import Rmi.Interface.IPhieuThueService;
import Utilities.MappingDtoFacade;

public class PhieuThueService extends UnicastRemoteObject implements IPhieuThueService {
	private static final long serialVersionUID = 1L;
	private IPhieuThue phieuThueDao;

	public PhieuThueService() throws RemoteException {
		phieuThueDao = new PhieuThueDao();
	}

	@Override
	public boolean addObject(PhieuThueDTO objectDTO) throws RemoteException {
		PhieuThue addObj = MappingDtoFacade.mapToPhieuThueAdd(objectDTO);
		return phieuThueDao.add(addObj);
	}

	@Override
	public PhieuThueDTO getObjectById(int id) throws RemoteException {

		try {
			PhieuThueDTO phieuThueDto = MappingDtoFacade.mapToPhieuThueDTO(phieuThueDao.get(id));
			return phieuThueDto;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateObject(PhieuThueDTO objectDTO) throws RemoteException {
		PhieuThue updateObj = MappingDtoFacade.mapToPhieuThueAdd(objectDTO);
		updateObj.setTrangThai(objectDTO.getTrangThai());
		return phieuThueDao.update(updateObj);
	}

	@Override
	public boolean deleteObjectById(int objectId) throws RemoteException {
		return phieuThueDao.delete(objectId);
	}

}
