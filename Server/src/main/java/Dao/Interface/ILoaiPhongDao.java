package Dao.Interface;

import java.util.List;

import Entity.LoaiPhong;

public interface ILoaiPhongDao extends IBaseDao<LoaiPhong> {

	List<LoaiPhong> getAllLoaiPhong();
}
