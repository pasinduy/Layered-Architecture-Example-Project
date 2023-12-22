package com.example.layeredarchitecture.controller;

import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dao.custom.Impl.CustomerDAOImpl;
import com.example.layeredarchitecture.dao.custom.Impl.QueryDAOImpl;
import com.example.layeredarchitecture.dao.custom.QueryDAO;
import com.jfoenix.controls.JFXComboBox;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchOrderFormController {
    public AnchorPane root;
    public JFXComboBox cmbCustomerId;
    public TableColumn clmnCusID;
    public TableColumn clmnCusName;
    public TableColumn clmnOrderID;
    CustomerDAO customerDAO = new CustomerDAOImpl();
    QueryDAO queryDAO = new QueryDAOImpl();

    public void initialize(){
        loadAllCustomerIds();
    }
    public void navigateToHome(MouseEvent mouseEvent) throws IOException {
        URL resource = this.getClass().getResource("/com/example/layeredarchitecture/main-form.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        Platform.runLater(() -> primaryStage.sizeToScene());
    }


    private void loadAllCustomerIds() {
        try {
            ArrayList<String > list = customerDAO.load();
            for (String a: list) {
                cmbCustomerId.getItems().add(a);
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to load customer ids").show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void btnSearchOnAction(ActionEvent actionEvent) {
        try {
            queryDAO.customerOrderDetails();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
