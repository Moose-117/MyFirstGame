module com.mycompany.myfirstgame {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.guice;

    opens com.mycompany.myfirstgame to javafx.fxml;
    exports com.mycompany.myfirstgame;
}
