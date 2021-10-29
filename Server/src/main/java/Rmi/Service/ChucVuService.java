package Rmi.Service;

import Dao.Impliment.ChucVuDao;
import Dao.Interface.IChucVu;
import Entity.ChucVu;
import Rmi.DTO.ChucVuDTO;
import Rmi.Interface.IChucVuService;
import Utilities.MappingChucVuDTO;

public class ChucVuService implements IChucVuService {

	private IChucVu chucVuDao;
	public ChucVuService() {
		chucVuDao = new ChucVuDao();
	}
	
	@Override
	public boolean addChucVu(ChucVuDTO object) {
		ChucVu addObject  = MappingChucVuDTO.mapToChucVu(object);
		return chucVuDao.add(addObject);
	}

	@Override
	public ChucVuDTO getChucVuById(int id) {
		try {
			ChucVu chucvu = chucVuDao.get(id);
			return MappingChucVuDTO.mapToChucVuDTO(chucvu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateChucVu(ChucVuDTO objectDTO) {
		ChucVu chucvu = new ChucVu(objectDTO.getTenCV(), objectDTO.getLuong());
		chucvu.setMaCV(objectDTO.getMaCV());
		return chucVuDao.update(chucvu);
	}

	@Override
	public boolean deleteChucVu(int object) {
		// TODO Auto-generated method stub
		return false;
	}

}
