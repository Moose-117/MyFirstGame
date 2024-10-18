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

    @Override
    public void start(Stage stage) throws Exception {
        Injector injector = Guice.createInjector(new AppModule()); 

        // Ottieni istanze di Sprites e Landscape da Guice
        sprites = injector.getInstance(Sprites.class);
        
        // Aggiungi lo sprite
        SpriteImplementation spriteImplementation = new SpriteImplementation();
        sprites.getInstance().put("Chicorita", spriteImplementation);
        
        landscape = injector.getInstance(Landscape.class);
        
        // Aggiungi i personaggi al paesaggio
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
