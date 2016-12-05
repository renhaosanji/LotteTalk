package client.listener;

import java.util.Hashtable;
import javax.swing.DefaultListModel;
import client.gui.ChatBox;
import client.helper.SysRegistry;
import entity.ChatInfo;
import entity.Contact;
import entity.NotifyObject;

public class TesxMsgHandler implements EventHandler {
	@Override
	public void handleEvent(NotifyObject notifyObject) {
		// TODO Auto-generated method stub
		try {
			ChatInfo chatInfo=(ChatInfo)notifyObject.getNotifyBody();
			
////			System.out.println(chatInfo);
//			Java chatInfo
			
			/////////////////////////////////////////////////////////////
			////////////////17:47////////////////////////////////////////
			Hashtable<Contact,ChatBox>boxRegistry=(Hashtable<Contact, ChatBox>)SysRegistry.getSysReg().get("boxRegistry");
			DefaultListModel contactsModel=(DefaultListModel)SysRegistry.getSysReg().get("contactsModel");
			
			int senderId=chatInfo.getSenderId();
			int receiverId=chatInfo.getReceiverid();
			Contact gfContact=getContactByUid(senderId,contactsModel);
			gfContact.setSender(true);
			
			Contact bfContact=getContactByUid(receiverId,contactsModel);
			ChatBox chatBox=boxRegistry.get(gfContact);
			if(chatBox==null){
				chatBox =new ChatBox(bfContact, gfContact);
				boxRegistry.put(gfContact,chatBox);
				}
			chatBox.appendMsg(chatInfo.getContent());
			System.out.println(chatInfo);
			System.out.println("****************************************************");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
			
	//////////////17:52_from MainForm private  getContactByuid 
	private Contact getContactByUid(int uid,DefaultListModel model){
		Contact resultContact=null;
		Contact tmpContact=new Contact();
		tmpContact.setUid(uid);
		int idx=model.indexOf(tmpContact);
		resultContact=(Contact)model.elementAt(idx);
		return resultContact;
	}
}
