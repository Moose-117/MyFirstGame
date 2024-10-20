package com.mycompany.myfirstgame;

import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import com.google.inject.Guice;
import com.google.inject.Injector;
import javafx.animation.AnimationTimer;

public class App extends Application {

    private Sprites sprites; 
    private Landscape landscape;
    private static final String HERO_IMAGE_BULBA =   "file:src\\main\\resources\\bulba.png";
    private static final String HERO_IMAGE_LOC =   "file:src\\main\\resources\\frame_1.png";



    @Override
    public void start(Stage stage) throws Exception {
        Injector injector = Guice.createInjector(new AppModule()); 

        // Ottieni istanze di Sprites e Landscape da Guice
        sprites = injector.getInstance(Sprites.class);
        
        // Aggiungi lo sprite CHICORITA
        SpriteImplementation spriteImplementationChico = new SpriteImplementation(HERO_IMAGE_LOC);
        sprites.getInstance().put("Chicorita", spriteImplementationChico);

        // Aggiungi lo sprite BULBASAUR
        SpriteImplementation spriteImplementationBulba = new SpriteImplementation(HERO_IMAGE_BULBA);
         sprites.getInstance().put("Bulbasaur", spriteImplementationBulba);
        
        landscape = injector.getInstance(Landscape.class);
        
        // Aggiungi i personaggi al paesaggio
        initUI(stage); // Imposta l'interfaccia
    }
    
    private void initUI(Stage stage) {
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

    protected void getInputCommands(Stage stage) {
        stage.getScene().addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if (key.getCode() == KeyCode.LEFT) {
                System.out.println("You pressed Left");
                sprites.getInstance().get("Chicorita").goLeft(); 
            }
            if (key.getCode() == KeyCode.RIGHT) {
                System.out.println("You pressed Right");
                sprites.getInstance().get("Chicorita").goRight(); 
            }
            if (key.getCode() == KeyCode.UP) {
                System.out.println("You pressed UP");
                // Aggiungi eventuale logica per il salto
            }
            if (key.getCode() == KeyCode.DOWN) {
                System.out.println("You pressed Down");
                // Aggiungi eventuale logica per il movimento verso il basso
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
