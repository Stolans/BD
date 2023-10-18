package com.example.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

public class mysqlconnect {
    Connection conn = null;

    public static Connection ConnectDb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.1.129:3306/asus", "root21111", "root21111");
            JOptionPane.showMessageDialog(null, "Соединение установлено");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public static ObservableList<soft> getDatausers() {
        Connection conn = ConnectDb();
        ObservableList<soft> list = FXCollections.observableArrayList();

        try {
            assert conn != null;

            PreparedStatement ps = conn.prepareStatement("select * from qwerty");
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                list.add(new soft(rs.getInt("codtab"),
                        rs.getString("table2"),
                        rs.getString("table3"),
                        rs.getString("table4")));
            }
        } catch (Exception ignored) {

        }
        return list;
    }
}