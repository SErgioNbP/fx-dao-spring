package org.academiadecodigo.bootcamp.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import org.academiadecodigo.bootcamp.model.Bootcamp;
import org.academiadecodigo.bootcamp.service.bootcamp.BootcampService;
import org.academiadecodigo.bootcamp.service.bootcamp.BootcampServiceImpl;

import java.util.Date;

public class BootcampListController implements Controller {

    @FXML
    private TableView<Bootcamp> bootcampTable;

    @FXML
    private TableColumn<Bootcamp, Integer> idCol;

    @FXML
    private TableColumn<Bootcamp, String> locationCol;

    @FXML
    private TableColumn<Bootcamp, Date> startCol;

    @FXML
    private TableColumn<Bootcamp, Date> endCol;

    //private BootcampService bootcampService;
    private MainController mainController;
    private BootcampService bootcampService;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void initialize() {

        //bootcampService = (BootcampService) ServiceRegistry.getServiceRegistry().getService(BootcampService.class.getSimpleName());

        idCol.setCellValueFactory(new PropertyValueFactory<Bootcamp, Integer>("id"));
        locationCol.setCellValueFactory(new PropertyValueFactory<Bootcamp, String>("location"));
        startCol.setCellValueFactory(new PropertyValueFactory<Bootcamp, Date>("start"));
        endCol.setCellValueFactory(new PropertyValueFactory<Bootcamp, Date>("end"));

        ObservableList<Bootcamp> tableData = FXCollections.observableArrayList(bootcampService.findAll());
        bootcampTable.setItems(tableData);

    }

    public void onClick(MouseEvent event) {

        if (!event.getButton().equals(MouseButton.PRIMARY)) {
            return;
        }

        mainController.showBootcampDetail(bootcampTable.getSelectionModel().getSelectedItem().getId());

    }

    public void setBootcampService(BootcampService bootcampService) {
        this.bootcampService = bootcampService;
    }

}

