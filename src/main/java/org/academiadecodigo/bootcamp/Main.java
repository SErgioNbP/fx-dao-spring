package org.academiadecodigo.bootcamp;

import javafx.application.Application;
import javafx.stage.Stage;
import org.academiadecodigo.bootcamp.controller.LoginController;
import org.academiadecodigo.bootcamp.model.Bootcamp;
import org.academiadecodigo.bootcamp.model.CodeCadet;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.persistence.TransactionManager;
import org.academiadecodigo.bootcamp.persistence.dao.BootcampDao;
import org.academiadecodigo.bootcamp.persistence.dao.CodeCadetDao;
import org.academiadecodigo.bootcamp.persistence.dao.UserDao;
import org.academiadecodigo.bootcamp.persistence.dao.jpa.JpaBootcampDao;
import org.academiadecodigo.bootcamp.persistence.dao.jpa.JpaCodeCadetDao;
import org.academiadecodigo.bootcamp.persistence.dao.jpa.JpaUserDao;
import org.academiadecodigo.bootcamp.persistence.jpa.JpaSessionManager;
import org.academiadecodigo.bootcamp.persistence.jpa.JpaTransactionManager;
import org.academiadecodigo.bootcamp.service.bootcamp.BootcampService;
import org.academiadecodigo.bootcamp.service.bootcamp.BootcampServiceImpl;
import org.academiadecodigo.bootcamp.service.user.UserService;
import org.academiadecodigo.bootcamp.service.user.UserServiceImpl;
import org.academiadecodigo.bootcamp.utils.Gender;
import org.academiadecodigo.bootcamp.utils.Security;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;

public class Main extends Application {

    private static final String PERSISTENCE_UNIT = "test";
    private EntityManagerFactory emf;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {


        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);

        JpaSessionManager sm = new JpaSessionManager(emf);
        TransactionManager tx = new JpaTransactionManager(sm);

        UserDao userDao = new JpaUserDao(sm);
        BootcampDao bootcampDao = new JpaBootcampDao(sm);
        CodeCadetDao codeCadetDao = new JpaCodeCadetDao(sm);

        // Instantiate a user service
        //UserService userService = new MockUserService();
        //BootcampService bootcampService = new MockBootcampService();
        UserService userService = new UserServiceImpl(userDao, tx);
        BootcampService bootcampService = new BootcampServiceImpl(bootcampDao, tx);

        User user = new User();
        user.setUsername("Rui");
        user.setEmail("rui.ferrao@academiadecodigo.org");
        user.setPassword(Security.getHash("codigoergosum"));
        userService.addUser(user);

        user = new User();
        user.setUsername("Catarina Campino");
        user.setEmail("catarina.campino@academiadecodigo.org");
        user.setPassword(Security.getHash("codigoergosum"));
        userService.addUser(user);

        user = new User();
        user.setUsername("Daniel Francisco");
        user.setEmail("daniel.francisco@gmail.com");
        user.setPassword(Security.getHash("codigoergosum"));
        userService.addUser(user);

        user = new User();
        user.setUsername("Lopo Antunes");
        user.setEmail("lopo.antunes@gmail.com");
        user.setPassword(Security.getHash("codigoergosum"));
        userService.addUser(user);

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setLocation("Lisboa");
        bootcampService.addBootcamp(bootcamp);

        bootcamp = new Bootcamp();
        bootcamp.setLocation("Lisboa");
        bootcampService.addBootcamp(bootcamp);

        bootcamp = new Bootcamp();
        bootcamp.setLocation("Lisboa");
        bootcampService.addBootcamp(bootcamp);

        bootcamp = new Bootcamp();
        bootcamp.setLocation("Fundão");
        bootcampService.addBootcamp(bootcamp);

        CodeCadet cadet1 = new CodeCadet();
        cadet1.setUser(userService.findByName("Lopo Antunes"));
        cadet1.setAddress("Rua 1");
        cadet1.setCity("Coimbra");
        cadet1.setPhone("666999");
        cadet1.setGender(Gender.M);

        CodeCadet cadet2 = new CodeCadet();
        cadet2.setUser(userService.findByName("Daniel Francisco"));
        cadet2.setAddress("Rua 1");
        cadet2.setCity("Coimbra");
        cadet2.setPhone("666999");
        cadet2.setGender(Gender.M);

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(0);

        cadet1.setBirthdate(cal.getTime());
        cadet2.setBirthdate(cal.getTime());

        bootcampService.addCadet(bootcampService.findAll().get(0).getId(), cadet1);
        bootcampService.addCadet(bootcampService.findAll().get(0).getId(), cadet2);

        //ServiceRegistry.getServiceRegistry().registerService(userService);
        //ServiceRegistry.getServiceRegistry().registerService(bootcampService);

    }

    @Override
    public void start(Stage primaryStage) {


        // Instantiate the navigation singleton and set the stage
        Navigation navigation = Navigation.getInstance();
        navigation.setStage(primaryStage);

        // Load the login screen
        navigation.loadScreen(LoginController.getName());

        // Render the UI
        primaryStage.setTitle("Academia Código");
        primaryStage.show();

    }

    @Override
    public void stop() {
        emf.close();
    }

}

