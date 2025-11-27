package com.mycompany.myfirstgame;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import com.google.inject.Guice;
import com.google.inject.Injector;
import javafx.animation.AnimationTimer;

public class App extends Application {

    private Sprites sprites; 
    private Landscape landscape;

    private static final String LANDSCAPE = "file:src\\main\\resources\\50624202.jpg";

    @Override
    public void start(Stage stage) throws Exception {
        // Carica l'immagine (può avere ancora le pubblicità, verranno rimosse in Landscape)
        Image image = new Image(LANDSCAPE);

        initSprites();          // Inizializza gli sprite
        initLandscape();        // Inizializza il paesaggio, usando gli sprite
        initUI(stage);          // Inizializza la UI
    }

    private void initSprites() {
        Injector injector = Guice.createInjector(new AppModule());         
        sprites = injector.getInstance(Sprites.class);

        ChicoritaSprite chicoritaSprite = new ChicoritaSprite();
        sprites.getInstance().put("Chicorita", chicoritaSprite);

        BulbasaurSprite bulbasaurSprite = new BulbasaurSprite();
        sprites.getInstance().put("Bulbasaur", bulbasaurSprite);
    }

    private void initLandscape() {
        Injector injector = Guice.createInjector(new AppModule());         
        landscape = injector.getInstance(Landscape.class);

        // Imposta gli sprite in Landscape
        landscape.initializeSprites(sprites);
    }
    
    private void initUI(Stage stage) {
        stage.setTitle("Chicorita's Dream");
        stage.setScene(landscape.getScene());

        // Gestione input per gli sprite
        sprites.getInstance().get("Chicorita").getInputCommands(stage);
        sprites.getInstance().get("Bulbasaur").getInputCommands(stage);         

        // Loop di rendering
        AnimationTimer loop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                landscape.render(); // Renderizza sfondo e sprite
            }
        };
        loop.start();

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
