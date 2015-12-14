package com.mahan.connector;
import java.sql.SQLException;
import java.util.List;

import com.mahan.present.com.mahan.present.view.studentview.StudentUI;
import com.mahan.data.DataBase;

public class ConnectorLayer {
	DataBase db;
	public ConnectorLayer(){
		db=new DataBase();
	}
	public void save(List<StudentUI> input) throws SQLException{
		this.db.save(input);
	}
}
