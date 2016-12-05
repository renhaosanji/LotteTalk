/*
 * NetFORM.java
 *
 * Created on __DATE__, __TIME__
 */

package client.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.util.Hashtable;
import java.util.Vector;
import javax.swing.DefaultListModel;
import client.helper.ContactsListCellRender;
import client.helper.NetAccessHelper;
import client.helper.SysRegistry;
import entity.Contact;
import entity.RequestObject;
import entity.ResponseObject;
import entity.ChatInfo;

/**
 *
 * @author  __USER__s
 */
public class MainForm extends javax.swing.JFrame implements ActionListener {
	/** Creates new form NetFORM */
	private int currUID;
	private Hashtable<Contact,ChatBox> boxRegistry;
	
	public MainForm( int uid) {
		/*****************************26New*********************************************/
		initComponents();
		this.currUID = uid;
		this.boxRegistry=new Hashtable<Contact,ChatBox>();
		
		//////////////////////////////////////////////////17:43
		//将boxRegistry中内容放到公共存储区——哈希表sysReg
		SysRegistry.getSysReg().put("boxRegistry",this.boxRegistry);
		setTitle(""+uid);
		ListContacts.setCellRenderer(new ContactsListCellRender());
		
		//刷新
		/******************26new*******************************************************/
//		refreshContacts(true);
//		initOfflineMsgs();
//		startTimer();
		}
       	public void startTimer() {
		// TODO Auto-generated method stub
		Timer timer = new Timer(1000, this);
		timer.start();
	}

/*****************************public void initOfflineMsgs() *****************************/
	public void initOfflineMsgs() {
		// TODO Auto-generated method stub
		RequestObject requestObject=
				new RequestObject(RequestObject.INIT_MSGS_REQ, ""+currUID);
		ResponseObject responseObject=NetAccessHelper.sendRequest(requestObject);
			
		System.out.println(responseObject);
		/************************26new***************************/
		Vector<ChatInfo>allChats=(Vector<ChatInfo>)responseObject.getResBody();
		entity.ChatInfo chatInfo=null;
		
		Contact	tmpContact=new Contact();
		tmpContact.setUid(currUID);
		int idx=
				contactsModel.indexOf(tmpContact);
		Contact bfContact,gfContact;
		int senderId;
		
		bfContact=(Contact)contactsModel.elementAt(idx);
		/**************************************/
		ChatBox chatBox=null;
		//只通过uid将发送方的信息chatInfo实体找到
		for (int i=0;i<allChats.size();i++){
			chatInfo=(ChatInfo)allChats.elementAt(i);
			senderId=chatInfo.getSenderId();
			tmpContact.setUid(senderId);
			idx=contactsModel.indexOf(tmpContact);
			
			gfContact=(Contact)contactsModel.elementAt(idx);
			gfContact.setSender(true);
			chatBox=getChatBox(bfContact, gfContact);
			chatBox.appendMsg(chatInfo.getContent());
					}
		}

	/**********************26_11:46*****************************/
	//////////////////////离线通信
	
	
	private Contact getContactByuid(int uid,DefaultListModel Model){
		Contact resultContact=null;
		Contact tmpContact=new Contact();
		tmpContact.setUid(uid);
		int idx=Model.indexOf(tmpContact);
		resultContact=(Contact)Model.elementAt(idx);
		return resultContact;
	}

	public void refreshContacts(boolean isInit) {
		// TODO Auto-generated method stub
		// TODO add your handling code here:
		RequestObject requestObject = new RequestObject(RequestObject.INIT_REQ,null);
		ResponseObject responseObject = NetAccessHelper
				.sendRequest(requestObject);
		Vector<Contact> allContacts = (Vector<Contact>) responseObject.getResBody();
		int size = allContacts.size();
		//注意：实例化 contactsModel！！！
		
		/**************************************************/
		DefaultListModel oldModel=contactsModel;
		contactsModel = new DefaultListModel();
		contactsModel.setSize(size);
		/******************************************/
		int onidx=1,offidx=size-1;	
		///contactsModel.setSize(allContacts.size());
		Contact contact = null;
		Contact oldContact=null;
		int tmpUid;
		//对象拷贝,把vector的数据拷贝到Model中
		for (int i = 0; i < size; i++) {
			contact = allContacts.elementAt(i);
			tmpUid=contact.getUid();
			
			if(!isInit){
				
				oldContact=
						getContactByuid(tmpUid, oldModel);
				contact.setSender(
						oldContact.isSender());
			}
			if(tmpUid==currUID){
				
				contactsModel.setElementAt(contact, 0);
				continue;
			}
			
			if(contact.getOnline()==1){
				contactsModel.setElementAt(contact, onidx);
				onidx++;
				
			}
			else{
				
				contactsModel.setElementAt(contact, offidx);
				offidx--;
			}
		}
		this.ListContacts.setModel(contactsModel);
		//refresh 之后，将contactsModel中内容放到公共存储区中
		SysRegistry.getSysReg().put("contactsModel", contactsModel);
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		ListContacts = new javax.swing.JList();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				formWindowClosing(evt);
			}
		});

		ListContacts.setModel(new javax.swing.AbstractListModel() {
			String[] strings = { "Hello" };

			public int getSize() {
				return strings.length;
			}

			public Object getElementAt(int i) {
				return strings[i];
			}
		});
		////////////////////////////////////////////////////
		ListContacts.setSelectionBackground(new java.awt.Color(51, 51, 255));
		////////////////////////////////////////////////////
		ListContacts.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				ListContactsMouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(ListContacts);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 527,
				Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup()
						.addContainerGap(55, Short.MAX_VALUE)
						.addComponent(jScrollPane1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 402,
								javax.swing.GroupLayout.PREFERRED_SIZE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents
/***********************************第二件事情**********************************/
	private void ListContactsMouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		
		//排序后，将自己屏蔽
		if(evt.getClickCount()==2){
			if(ListContacts.getSelectedIndex()==0)
				return;
			
			Contact bfContact,gfContact;
			//获取gf实体的信息
			gfContact=(Contact)
			  		ListContacts.getSelectedValue();
			    
			    Contact tmpContact=new Contact();
			    tmpContact.setUid(this.currUID);
			    
			    int idx=this.contactsModel.indexOf(tmpContact);
			    
			    bfContact=(Contact)contactsModel.elementAt(idx);
			     
				ChatBox chatBox= getChatBox(bfContact,gfContact);
//						new ChatBox(bfContact,gfContact);
				gfContact.setSender(false);
				chatBox.setVisible(true);
			
		}
	}
	
	
	/**********26new**************************/
	private ChatBox getChatBox(Contact bfContact,Contact gfContact){
	
		ChatBox chatBox=null;
	try {
		
	     chatBox=boxRegistry.get(gfContact);
		if(chatBox==null)
		{
		chatBox=new ChatBox(bfContact,gfContact);
	//记录其他人的窗口！！！
		boxRegistry.put(gfContact,chatBox);
	}
		} catch (Exception e) {
		// TODO: handle exception
			e.printStackTrace();
	}
		return chatBox;
	}
	
	/*************************************formWindowClosing****************************/
	private void formWindowClosing(java.awt.event.WindowEvent evt) {
		// TODO add your handling code here:
		//传uid
		RequestObject requestObject = new RequestObject(
				RequestObject.LOGOFF_REQ, this.currUID + "");

		//int 专为Integer//new Integer(value);
		NetAccessHelper.sendRequest(requestObject);
	}

	/**
	 * @param args the command line arguments
	 */

		public static void main(String args[]) {
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					//new MainForm(uid).setVisible(true);
				}
			});
		}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JList ListContacts;
	private javax.swing.JScrollPane jScrollPane1;
	// End of variables declaration//GEN-END:variables

	/****************************************************************************************************************/
	//定义一个Model
	private DefaultListModel contactsModel;
	//

	///////////////////////////////////////////////////////////26_17:36
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		refreshContacts(false);
	}
}
