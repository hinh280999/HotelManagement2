package Dao.Interface;

import Entity.Phong;

public interface IPhongDao extends IBaseDao<Phong> {
	Phong getPhongTrong();
}
