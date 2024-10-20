package com.mycompany.myfirstgame;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.checkerframework.checker.units.qual.s;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.mycompany.myfirstgame.App;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TestApp extends Application {
    private static App app;
    private static Stage stage;
    private Sprites sprites;

    @BeforeClass
    public static void setup() {
        Thread thread = new Thread(() -> Application.launch(TestApp.class));
        thread.setDaemon(true);
        thread.start();
        // Attendere che l'applicazione JavaFX si avvii
        try {
            Thread.sleep(1000); // Potresti dover regolare questo valore
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDown() {
        Platform.exit();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        app = new App(); // Inizializza l'app qui
        primaryStage.setTitle("Chicorita's Dream");
        stage = primaryStage;
        app.start(stage); // Chiama il metodo start dell'app
    }

    @Test
    public void test1() {
        assertEquals("Chicorita's Dream", stage.getTitle());
    }

    @Test
    public void getInputLeftCommandsTest(){
        Injector injector = Guice.createInjector(new AppModule()); 
        sprites = injector.getInstance(Sprites.class);

        Double spritePositionBefore = sprites.getInstance().get("Chicorita").getHitbox().getLayoutX();
        System.out.println("spritePositionBefore" + spritePositionBefore);

        app.getInputCommands(stage);
        sprites.getInstance().get("Chicorita").goLeft();

        Double spritePositionAfter = sprites.getInstance().get("Chicorita").getHitbox().getLayoutX();
        System.out.println("spritePositionAfter" + spritePositionAfter);

        assertNotEquals(spritePositionBefore, spritePositionAfter);
    }

    @Test
    public void getInputRightCommandsTest(){
        Injector injector = Guice.createInjector(new AppModule()); 
        sprites = injector.getInstance(Sprites.class);

        Double spritePositionBefore = sprites.getInstance().get("Chicorita").getHitbox().getLayoutX();
        System.out.println("spritePositionBefore" + spritePositionBefore);

        app.getInputCommands(stage);
        sprites.getInstance().get("Chicorita").goRight();

        Double spritePositionAfter = sprites.getInstance().get("Chicorita").getHitbox().getLayoutX();
        System.out.println("spritePositionAfter" + spritePositionAfter);

        assertNotEquals(spritePositionBefore, spritePositionAfter);
    }

    // @Test
    // public void getInputJumpCommandsTest(){
    //     Injector injector = Guice.createInjector(new AppModule()); 
    //     sprites = injector.getInstance(Sprites.class);

    //     Double spritePositionBefore = sprites.getInstance().get("Chicorita").getHitbox().getLayoutX();
    //     System.out.println("spritePositionBefore" + spritePositionBefore);

    //     app.getInputCommands(stage);
    //     sprites.getInstance().get("Chicorita").goLeft();

    //     Double spritePositionAfter = sprites.getInstance().get("Chicorita").getHitbox().getLayoutX();
    //     System.out.println("spritePositionAfter" + spritePositionAfter);

    //     assertNotEquals(spritePositionBefore, spritePositionAfter);
    // }
}
