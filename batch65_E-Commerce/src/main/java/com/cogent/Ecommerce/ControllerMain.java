package com.cogent.Ecommerce;

import java.sql.SQLException;


public class ControllerMain {

	public static void main(String[] args) throws SQLException {

		BusinessLogic b1 = new BusinessLogic();
		//b1.createData(777, "Mobile", 240.88f, 14.36f, 165, 124);

		b1.readData();
	}

}
