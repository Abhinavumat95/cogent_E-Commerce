package com.cogent.Ecommerce;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BusinessLogic {
	Connection conn = null;

	// Insert
	void createData(int id, String name, float cost, float discount, int available, int sold) throws SQLException {
		conn = ConnectToDB.connectSetUp();
		PreparedStatement stmt = conn.prepareStatement(
				"insert into Products (id, name, cost, discount, available, sold) values(?,?,?,?,?,?)");
		stmt.setInt(1, id);
		stmt.setString(2, name);
		stmt.setFloat(3, (float) cost);
		stmt.setFloat(4, (float) discount);
		stmt.setInt(5, available);
		stmt.setInt(6, sold);
		int i = stmt.executeUpdate();
		System.out.println(i + " records inserted");

	}

	// Select
	void readData() throws SQLException {
		conn = ConnectToDB.connectSetUp();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Products");

		ArrayList<Products> productBucket = new ArrayList<Products>();
		while (rs.next()) {

			productBucket.add(new Products(rs.getInt("id"), rs.getString("name"), rs.getFloat("cost"),
					rs.getFloat("discount"), rs.getInt("available"), rs.getInt("sold")));

		}
		
		System.out.println(":::::::::::::::::::");
		//Records in the Collection
		System.out.println("Records are now in Collection");
		productBucket.stream().forEach(System.out::println);

		System.out.println(":::::::::::::::::::");
		// Products as per Discount
		System.out.println("Items as per Discount: ");
		List<Products> productsAsPerDiscount = productBucket.stream()
				.sorted(Comparator.comparing(Products::getDiscount)).collect(Collectors.toList());
		productsAsPerDiscount.stream().forEach(System.out::println);

		System.out.println(":::::::::::::::::::");
		// Products as per items sold
		System.out.println("Items as per Items Sold: ");
		List<Products> productsAsPerSold = productBucket.stream().sorted(Comparator.comparing(Products::getSold))
				.collect(Collectors.toList());
		productsAsPerSold.stream().forEach(System.out::println);

		System.out.println(":::::::::::::::::::");
		// Products as per Cost
		System.out.println("Items as per Cost: ");
		List<Products> productsAsPerCost = productBucket.stream().sorted(Comparator.comparing(Products::getCost))
				.collect(Collectors.toList());
		productsAsPerCost.stream().forEach(System.out::println);
		
		
		System.out.println(":::::::::::::::::::");
		// Printing Items which has sold less than 10 and needs its discount to be increased
		System.out.println("Items whose Discount needs to be increased: ");
		productsAsPerSold.stream().filter(s -> s.sold < 10).forEach(System.out::println);
		productsAsPerSold.stream().filter(s -> s.sold < 10).forEach(f -> f.setDiscount(f.getDiscount() + 10));
		
		System.out.println(":::::::::::::::::::");
		//Records in the Collection
		System.out.println("Records are now in Collection after increasing discount");
		productBucket.stream().forEach(System.out::println);

	}
}
