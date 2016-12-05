package client.helper;
import java.util.Hashtable;
	//单子的概念相似
	//key:String value:Object
public class SysRegistry {
	private static Hashtable<String,Object>sysReg;
	
	public static Hashtable<String, Object>getSysReg(){
	if(sysReg==null){
		sysReg=new Hashtable<String, Object>();
		}return sysReg;
	}
	//将contactsModel、boxRegistry中东西放进去！
}
