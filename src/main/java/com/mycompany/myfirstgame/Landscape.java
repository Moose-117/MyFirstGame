package com.mycompany.myfirstgame;

import java.util.HashMap;
import com.google.inject.Inject;

import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BorderPane;

public class Landscape {
    protected Sprites sprites;
    private Canvas canvas;
    private BorderPane root;
    private Scene scene;
    private GraphicsContext context;
    private int i;
    private static final String LANDSCAPE=   "file:src\\main\\resources\\50624202.jpg";


    @Inject
    public Landscape(Sprites sprites) {
       
        initializeGraphics();
        initializeSprites(sprites);
    }

    public void initializeSprites(Sprites sprites) {
    this.sprites = sprites;    
    }

    private void initializeGraphics() {
        this.canvas = new Canvas(1000, 1080);
        this.root = new BorderPane();
        this.scene = new Scene(root);
        this.context = canvas.getGraphicsContext2D();
        root.setCenter(canvas);   
    }
    
    public void render() {
        Image image = new Image(LANDSCAPE);
        setLandscapeBeforeRendering(image);
        HashMap<String, AbstractSprite> spriteMap = sprites.getInstance();
        spriteMap.forEach((key, value) -> renderSprite(value));        
    }

    private void renderSprite(AbstractSprite sprite) {
        if (sprite != null) {
            context.drawImage(sprite.getImages().get(0), sprite.getHitbox().getLayoutX(), sprite.getHitbox().getLayoutY());
        }
    }

    private void setLandscapeBeforeRendering(Image image) {
        context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        scrollLandscape(i, image, sprites.getInstance().get("Chicorita").getDirectionEnum());  
        sprites.getInstance().get("Chicorita").setDirectionEnum(DirectionEnum.STILL);
    }

    public Scene getScene() {
        return scene;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setBackground(Background bg) {
        
        this.root.setBackground(bg);
        this.scene.setRoot(root);    
    }

      private void scrollLandscape(int i, Image image, DirectionEnum direction) {
        BackgroundPosition bgpos = new BackgroundPosition(Side.LEFT, i, false, null, 100, false);
        BackgroundImage bgImage =new BackgroundImage(image, null, null,bgpos, null);
        Background bg = new Background(bgImage);
        setBackground(bg);

            if(direction == DirectionEnum.RIGHT){
            
                this.i = i-10;
            }
            if(direction == DirectionEnum.LEFT)
                this.i = i+10;

            }
}