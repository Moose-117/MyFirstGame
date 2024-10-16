package com.mycompany.myfirstgame;

import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import javafx.animation.AnimationTimer;

public class App extends Application {

    private Sprites sprites; // Memorizziamo lo sprite qui per poterlo usare negli eventi
    private Landscape landscape;


    @Override
    public void start(Stage stage) throws Exception {

        SpriteImplementation spriteImplementation = new SpriteImplementation();
        sprites = new Sprites();
        Sprites.sprites.put("Chicorita", spriteImplementation);
        landscape = new Landscape(sprites);

        Injector injector = Guice.createInjector();
        sprites = injector.getInstance(Sprites.class);
        addCharactersToLandscape(sprites, landscape);
        initUI(stage); // Imposta l'interfaccia
    }

    void initUI(Stage stage) {

        stage.setTitle("Chicorita's Dream");
        stage.setScene(landscape.getScene());
        getInputCommands(stage);
        // Inizializza il loop di rendering
        AnimationTimer loop = new MyTimer() {
            @Override
            public void handle(long now) {
                landscape.render(); // Renderizza il paesaggio e lo sprite in ogni ciclo
            }
        };
        loop.start(); // Avvia il loop di animazione

        // Mostra la finestra
        stage.show();
    }

    private void getInputCommands(Stage stage) {
        // Aggiungi il gestore di eventi per i tasti
        stage.getScene().addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if (key.getCode() == KeyCode.LEFT) {
                System.out.println("You pressed Left");
                Sprites.sprites.get("Chicorita").goLeft(); // Usa lo sprite esistente
            }
            if (key.getCode() == KeyCode.RIGHT) {
                System.out.println("You pressed Right");
                Sprites.sprites.get("Chicorita").goRight(); // Usa lo sprite esistente
            }
            if (key.getCode() == KeyCode.UP) {
                System.out.println("You pressed UP");
                Sprites.sprites.get("Chicorita").goLeft(); // Usa lo sprite esistente
            }
            if (key.getCode() == KeyCode.DOWN) {
                System.out.println("You pressed Down");
                Sprites.sprites.get("Chicorita").goRight(); // Usa lo sprite esistente
            }
        });
    }

    @Inject
    void addCharactersToLandscape(Sprites sprites, Landscape landscape) {
        landscape.setSprites(sprites);
    }

    @Inject
    Landscape setLandscape(Landscape landscape) {
        return this.landscape = landscape;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
