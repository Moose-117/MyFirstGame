 package com.mycompany.myfirstgame;

import java.util.ArrayList;

import com.google.inject.Inject;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import java.util.HashMap;

public class Landscape {
    private Sprites sprites;
    private Canvas canvas;
    private BorderPane root;
    private Scene scene;
    private GraphicsContext context;

    @Inject
    public Landscape(Sprites sprites) {
        this.sprites = sprites;
        this.canvas = new Canvas(600, 600);
        this.root = new BorderPane();
        this.scene = new Scene(root);
        this.context = canvas.getGraphicsContext2D();
        initialize();
    }

    private void initialize() {
        context.setFill(Color.FORESTGREEN);
        context.fillRect(0, 0, 600, 600);
        root.setCenter(canvas); // Aggiungi il canvas al root qui
    }

    public void render() {
        context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight()); // Pulisci il canvas
        context.setFill(Color.FORESTGREEN); // Imposta il colore
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight()); // Riempi lo sfondo
        context.drawImage(Sprites.sprites.get("Chicorita").getImages().get(0), Sprites.sprites.get("Chicorita").getHitbox().getLayoutX(), Sprites.sprites.get("Chicorita").getHitbox().getLayoutY());
    }

    @Inject
    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }
    

    public Scene getScene() {
        return scene;
    }
}
