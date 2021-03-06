package org.academiadecodigo.bootcamp.controller;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import org.academiadecodigo.bootcamp.Navigation;
import org.academiadecodigo.bootcamp.service.bootcamp.BootcampService;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;

/**
 * Controller for the main view
 */
public class MainController implements Controller {

    private static final String NAME = "main";
    private static final String BOOTCAMP_LIST = "bootcamp-list";
    private static final String BOOTCAMP_DETAILS = "bootcamp-details";

    @FXML
    private VBox container;

    private Parent bootcampListView;
    private Parent bootcampDetailsView;

    private BootcampService bootcampService;
    private BootcampDetailsController bootcampDetailsController;

    public static String getName() {
        return NAME;
    }

    /**
     * Called reflectively by JavaFX after all bindings are done and
     * the root element has been completely processed
     */
    public void initialize() {

        bootcampService = (BootcampService) ServiceRegistry.getServiceRegistry().getService(BootcampService.class.getSimpleName());

        if (bootcampService == null) {
            throw new IllegalStateException("Unable to load user service from registry");
        }

        setupBootcampList();
        setupBootcampDetails();

        showBootcampList();

    }

    public void onQuit() {

        Navigation.getInstance().close();

    }

    public void onLogout() {

        Navigation.getInstance().back();

    }

    private void setupBootcampList() {

        bootcampListView = Navigation.getInstance().loadView(BOOTCAMP_LIST);
        BootcampListController bootcampListController = (BootcampListController) Navigation.getInstance().getController(BOOTCAMP_LIST);
        bootcampListController.setMainController(this);

    }

    private void setupBootcampDetails() {
        bootcampDetailsView = Navigation.getInstance().loadView(BOOTCAMP_DETAILS);
        bootcampDetailsController = (BootcampDetailsController) Navigation.getInstance().getController(BOOTCAMP_DETAILS);
        bootcampDetailsController.setMainController(this);
    }

    public void showBootcampList() {

        if (!container.getChildren().isEmpty()) {
            container.getChildren().clear();
        }

        container.getChildren().add(bootcampListView);
    }

    public void showBootcampDetail(int id) {

        if (!container.getChildren().isEmpty()) {
            container.getChildren().clear();
        }

        bootcampDetailsController.loadBootcamp(id);
        container.getChildren().add(bootcampDetailsView);
    }
}

