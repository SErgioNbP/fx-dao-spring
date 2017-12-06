package org.academiadecodigo.bootcamp.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.academiadecodigo.bootcamp.model.Bootcamp;
import org.academiadecodigo.bootcamp.model.CodeCadet;
import org.academiadecodigo.bootcamp.service.bootcamp.BootcampService;
import org.academiadecodigo.bootcamp.service.bootcamp.BootcampServiceImpl;

public class BootcampDetailsController implements Controller {

    private static final String EMPTY_DATE = "TBD";

    @FXML
    Label startLabel;
    @FXML
    Label endLabel;
    @FXML
    private Label idLabel;
    @FXML
    private Label locationLabel;
    @FXML
    private TableView<CodeCadet> cadetTable;
    @FXML
    private TableColumn<CodeCadet, String> nameCol;
    @FXML
    private TableColumn<CodeCadet, String> genderCol;
    @FXML
    private TableColumn<Bootcamp, String> addressCol;
    @FXML
    private TableColumn<Bootcamp, String> cityCol;
    @FXML
    private TableColumn<Bootcamp, String> phoneCol;
    @FXML
    private TableColumn<Bootcamp, String> birthCol;
    @FXML
    private TableColumn<Bootcamp, Integer> bootcampCol;

    //private BootcampService bootcampService;
    private MainController mainController;

    private ObservableList<CodeCadet> tableData;
    private BootcampService bootcampService;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void initialize() {

        //bootcampService = (BootcampService) ServiceRegistry.getServiceRegistry().getService(BootcampService.class.getSimpleName());

        nameCol.setCellValueFactory(new PropertyValueFactory<CodeCadet, String>("name"));
        genderCol.setCellValueFactory(new PropertyValueFactory<CodeCadet, String>("gender"));
        addressCol.setCellValueFactory(new PropertyValueFactory<Bootcamp, String>("address"));
        cityCol.setCellValueFactory(new PropertyValueFactory<Bootcamp, String>("city"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<Bootcamp, String>("phone"));
        birthCol.setCellValueFactory(new PropertyValueFactory<Bootcamp, String>("birthdate"));
        bootcampCol.setCellValueFactory(new PropertyValueFactory<Bootcamp, Integer>("bootcampId"));

        tableData = FXCollections.observableArrayList();
        cadetTable.setItems(tableData);
    }

    public void loadBootcamp(int id) {

        Bootcamp bootcamp = bootcampService.findById(id);

        if (bootcamp == null) {
            return;
        }

        idLabel.setText(bootcamp.getId().toString());
        locationLabel.setText(bootcamp.getLocation());

        if (bootcamp.getStart() != null) {
            startLabel.setText(bootcamp.getStart().toString());
        } else {
            startLabel.setText(EMPTY_DATE);
        }

        if (bootcamp.getEnd() != null) {
            endLabel.setText(bootcamp.getEnd().toString());
        } else {
            endLabel.setText(EMPTY_DATE);
        }

        tableData.clear();
        tableData.addAll(bootcampService.listCadets(id));
    }

    public void onButton(ActionEvent actionEvent) {
        mainController.showBootcampList();
    }

    public void setBootcampService(BootcampService bootcampService) {
        this.bootcampService = bootcampService;
    }

}

