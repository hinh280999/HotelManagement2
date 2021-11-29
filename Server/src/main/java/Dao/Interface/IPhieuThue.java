package Dao.Interface;

import Entity.PhieuThue;

public interface IPhieuThue extends IBaseDao<PhieuThue>{
	PhieuThue getPhieuThueByCMT(String cmt);
}
