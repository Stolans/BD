package com.example.bd;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField codt;

    @FXML
    private TableColumn<soft, Integer> codtab;

    @FXML
    private TableView<soft> table;

    @FXML
    private TableColumn<soft, String> table2;

    @FXML
    private TableColumn<soft, String> table3;

    @FXML
    private TableColumn<soft, String> table4;

    @FXML
    private TextField text2;

    @FXML
    private TextField text3;

    @FXML
    private TextField text4;
    Connection conn = null;
    PreparedStatement pst = null;
    ObservableList<soft> listM;

    public HelloController(){
    }

    @FXML
    void del(ActionEvent event) {
        this.conn = mysqlconnect.ConnectDb();
        String sql = "delete from qwerty where codtab = ?";

        try {
            assert this.conn != null;

            this.pst = this.conn.prepareStatement(sql);
            this.pst.setString(1, this.codt.getText());
            this.pst.execute();
            JOptionPane.showMessageDialog((Component)null, "Изменения внесены, удалено.");
            this.obnov(new ActionEvent());
        } catch (Exception var4) {
            JOptionPane.showMessageDialog((Component)null, var4);
        }

    }


    @FXML
    void dobav(ActionEvent event) {
        conn = mysqlconnect.ConnectDb();
        String sql = "insert into qwerty(codtab, table2, table3, table4) values(?,?,?,?)";
        try {
            assert conn != null;
            pst = conn.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(codt.getText()));
            pst.setString(2, text2.getText());
            pst.setString(3, text3.getText());
            pst.setString(4, text4.getText());

            pst.execute();

            JOptionPane.showMessageDialog(null, "Измененно");
            obnov(new ActionEvent());

        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @FXML
    void exit(ActionEvent event) {
        System.exit(1);

    }

    @FXML
    void obnov(ActionEvent event) {
        this.codtab.setCellValueFactory(new PropertyValueFactory<soft, Integer>("codtab"));
        this.table2.setCellValueFactory(new PropertyValueFactory<soft, String>("table2"));
        this.table3.setCellValueFactory(new PropertyValueFactory<soft, String>("table3"));
        this.table4.setCellValueFactory(new PropertyValueFactory<soft, String>("table4"));

        this.listM = mysqlconnect.getDatausers();
        this.table.setItems(this.listM);

        JOptionPane.showMessageDialog(null, "Обновлено");
    }

    @FXML
    void initialize() {
        assert codt != null : "fx:id=\"codt\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert codtab != null : "fx:id=\"codtab\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert table2 != null : "fx:id=\"table2\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert table3 != null : "fx:id=\"table3\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert table4 != null : "fx:id=\"table4\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert text2 != null : "fx:id=\"text2\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert text3 != null : "fx:id=\"text3\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert text4 != null : "fx:id=\"text4\" was not injected: check your FXML file 'hello-view.fxml'.";

    }

}
