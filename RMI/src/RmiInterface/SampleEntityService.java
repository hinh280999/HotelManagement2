package RmiInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

import RmiDto.SampleEntityInfoDTO;

public interface SampleEntityService extends Remote{
	
	public boolean AddNewThietBi (SampleEntityInfoDTO tb ) throws RemoteException;
}
