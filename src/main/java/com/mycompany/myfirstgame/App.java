package com.mycompany.myfirstgame;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.stage.Stage;

import javax.crypto.spec.PBEKeySpec;

import com.google.inject.Guice;
import com.google.inject.Injector;
import javafx.animation.AnimationTimer;

public class App extends Application {

    private Sprites sprites; 
    private Landscape landscape;
    private static final String HERO_IMAGE_BULBA =   "file:src\\main\\resources\\bulba.png";
    private static final String HERO_IMAGE_LOC =   "file:src\\main\\resources\\frame_1.png";
    private static final String LANDSCAPE=   "file:src\\main\\resources\\50624202.jpg";
    int i =0;

    @Override
    public void start(Stage stage) throws Exception {
        Injector injector = Guice.createInjector(new AppModule());         
        initSprites(injector);
        Image image = new Image(LANDSCAPE);
        initLandscape(injector, image);
        // BinaryConverter.convertDecimalToBynary();
        //scrollLandscape(injector, image);
        initUI(stage);
    }

    // private void scrollLandscape(int i, Image image) {
    //         BackgroundPosition bgpos = new BackgroundPosition(Side.LEFT, i, false, null, 100, false);
    //         BackgroundImage bgImage =new BackgroundImage(image, null, null,bgpos, null);
    //         Background bg = new Background(bgImage);
    //         landscape.setBackground(bg);
    //         this.i--;
    //     }        

    private void initLandscape(final Injector injector, final Image image) {
        landscape = injector.getInstance(Landscape.class);
        BackgroundImage bgImage =new BackgroundImage(image, null, null,null, null);
        Background bg = new Background(bgImage);
        landscape.setBackground(bg);
    }

    private void initSprites(Injector injector) {
        sprites = injector.getInstance(Sprites.class);
        ChicoritaSprite chicoritaSprite = new ChicoritaSprite(HERO_IMAGE_LOC);
        sprites.getInstance().put("Chicorita", chicoritaSprite);

        BulbasaurSprite bulbasaurSprite = new BulbasaurSprite(HERO_IMAGE_BULBA);
         sprites.getInstance().put("Bulbasaur", bulbasaurSprite);
    }
    
    private void initUI(Stage stage) {
        stage.setTitle("Chicorita's Dream");
        stage.setScene(landscape.getScene());
        sprites.getInstance().get("Chicorita").getInputCommands(stage);
        sprites.getInstance().get("Bulbasaur").getInputCommands(stage);         
    
        // Inizializza il loop di rendering
        AnimationTimer loop = new MyTimer() {
            @Override
            public void handle(long now) {
                Image image = new Image(LANDSCAPE);
                // scrollLandscape(i, image);

                






                landscape.render(); // Renderizza il paesaggio e lo sprite in ogni ciclo
            }
        };
        loop.start(); // Avvia il loop di animazione

        // Mostra la finestra
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
