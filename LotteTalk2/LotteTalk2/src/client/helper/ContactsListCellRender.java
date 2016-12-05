package client.helper;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import entity.Contact;

public class ContactsListCellRender implements ListCellRenderer {

	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		JLabel cellComp = new JLabel();
		ImageIcon offIcon=new ImageIcon("images/offline.png");
		ImageIcon onIcon=new ImageIcon("images/online.png");
		if(value instanceof Contact){
			Contact contact = (Contact)value;
			int uid = contact.getUid();
			String uname = contact.getUname();
			String lableText = "<"+uid+">"+uname;
			if(isSelected){
				cellComp.setIcon(onIcon);
				cellComp.setForeground(list.getSelectionForeground());
				cellComp.setBackground(list.getSelectionBackground());
			}
			if(contact.getOnline()==1){                              //ѡ��������ɫ
				cellComp.setIcon(onIcon);
				cellComp.setForeground(Color.GREEN);                 //ѡ�񱳾���ɫ
				cellComp.setBackground(list.getBackground());
			}else{
				cellComp.setIcon(offIcon);
				cellComp.setForeground(Color.RED);
				cellComp.setBackground(list.getBackground());
			}
			
			if (contact.isSender()) {
				lableText=lableText+"<Incoming msgs...> ";
						cellComp.setForeground(Color.BLUE);
				
			}
			if(isSelected){
				
				cellComp.setForeground(list.getSelectionForeground());
				cellComp.setBackground(list.getSelectionBackground());
			}
			
			cellComp.setText(lableText);
		}
		
		// TODO Auto-generated method stub
		cellComp.setOpaque(true);
		return cellComp;
	}
}
