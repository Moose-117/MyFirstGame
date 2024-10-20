package com.mycompany.myfirstgame;

import java.util.HashMap;
import com.google.inject.Inject;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;

public class Landscape {
    protected Sprites sprites;
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
        setLandscapeBeforeRendering();
        HashMap<String, SpriteImplementation> spriteMap = sprites.getInstance();
        spriteMap.forEach((key, value) -> renderSprite(value));        
    }

    private void renderSprite(SpriteImplementation sprite) {
        if (sprite != null) {
            context.drawImage(sprite.getImages().get(0), sprite.getHitbox().getLayoutX(), sprite.getHitbox().getLayoutY());
        }
    }

    private void setLandscapeBeforeRendering() {
        context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        context.setFill(Color.FORESTGREEN);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    public Scene getScene() {
        return scene;
    }

    public Canvas getCanvas() {
        return canvas;
    }
}