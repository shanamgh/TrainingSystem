package com.mahan.present;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class ToolBar extends JToolBar implements ActionListener{
private JButton saveBtn;
private JButton refreshBtn;
private toolbarListener toolbarListener;

public ToolBar (){
	setBorder(BorderFactory.createEtchedBorder());
	setFloatable(true);
	
	saveBtn = new JButton();
	saveBtn.setIcon(Utils.createIcon("/Image/Save16.gif"));
	saveBtn.setToolTipText("Save to DB");
	refreshBtn = new JButton();
	refreshBtn.setToolTipText("Refresh");
	refreshBtn.setIcon(Utils.createIcon("/Image/Refresh16.gif"));
	saveBtn.addActionListener(this);

	add(saveBtn);
	addSeparator();
	add(refreshBtn);
}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked=(JButton) e.getSource();
		if(clicked==saveBtn){
			if(this.toolbarListener != null){
				toolbarListener.saveEventOccured();
			}
		}else
		{
			if(this.toolbarListener !=null){
				toolbarListener.refreshEventOccured();
			}
		}
		}
	
	
	public void setToolbarListener(toolbarListener t){
		
		this.toolbarListener=t;
	}

}
