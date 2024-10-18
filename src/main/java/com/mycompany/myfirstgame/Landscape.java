package com.mycompany.myfirstgame;

import com.google.inject.Inject;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;

public class Landscape {
    private Sprites sprites;
    private Canvas canvas;
    private BorderPane root;
    private Scene scene;
    private GraphicsContext context;

    @Inject
    public Landscape(Sprites sprites) {
       
        initializeGraphics();
        initializeSprites(sprites);
    }

    public void initializeSprites(Sprites sprites) {
    this.sprites = sprites;    
    }

    private void initializeGraphics() {
        this.canvas = new Canvas(600, 600);
        this.root = new BorderPane();
        this.scene = new Scene(root);
        this.context = canvas.getGraphicsContext2D();
        context.setFill(Color.FORESTGREEN);
        context.fillRect(0, 0, 600, 600);
        root.setCenter(canvas);   
    }
    
    public void render() {
        context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        context.setFill(Color.FORESTGREEN);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        SpriteImplementation chicorita = sprites.getInstance().get("Chicorita");
        if (chicorita != null) {
            context.drawImage(chicorita.getImages().get(0), chicorita.getHitbox().getLayoutX(), chicorita.getHitbox().getLayoutY());
        }
    }

    public Scene getScene() {
        return scene;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }
}
