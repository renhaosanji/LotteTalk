package client.helper;
import java.util.Hashtable;
	//���ӵĸ�������
	//key:String value:Object
public class SysRegistry {
	private static Hashtable<String,Object>sysReg;
	
	public static Hashtable<String, Object>getSysReg(){
	if(sysReg==null){
		sysReg=new Hashtable<String, Object>();
		}return sysReg;
	}
	//��contactsModel��boxRegistry�ж����Ž�ȥ��
}
