module com.mycompany.myfirstgame {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.myfirstgame to javafx.fxml;
    exports com.mycompany.myfirstgame;
}
