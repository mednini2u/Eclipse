package CB;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ClientCBintf extends Remote {
	public void retourMsg(String msg) throws RemoteException;
}
