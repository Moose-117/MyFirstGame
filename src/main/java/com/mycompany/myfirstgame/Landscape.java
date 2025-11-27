package com.mycompany.myfirstgame;

import java.util.HashMap;
import com.google.inject.Inject;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;

public class Landscape {
    protected Sprites sprites;
    private Canvas canvas;
    private BorderPane root;
    private Scene scene;
    private GraphicsContext context;
    private int i;
    private static final String LANDSCAPE = "file:src\\main\\resources\\50624202.jpg";

    @Inject
    public Landscape(Sprites sprites) {
        initializeGraphics();
        initializeSprites(sprites);
    }

    public void initializeSprites(Sprites sprites) {
        this.sprites = sprites;
        this.sprites.getInstance().get("Chicorita").getHitbox().setLayoutY(canvas.getHeight() -550);
        System.out.println(this.sprites.getInstance().get("Chicorita").getHitbox().getLayoutY());
        System.out.println(canvas.getHeight());
    }

    private void initializeGraphics() {
        this.canvas = new Canvas(1000, 1200);
        this.root = new BorderPane();
        this.scene = new Scene(root);
        this.context = canvas.getGraphicsContext2D();
        root.setCenter(canvas);

        AudioManager am = new AudioManager();
        am.playMusic();
    }

    public void render() {
        Image original = new Image(LANDSCAPE);

        // Ritaglia la fascia pubblicitaria in alto e basso
        int adHeightTop = 100;    // altezza fascia superiore
        int adHeightBottom = 100; // altezza fascia inferiore
        int width = (int) original.getWidth();
        int height = (int) original.getHeight() - adHeightTop - adHeightBottom;

        WritableImage cropped = new WritableImage(original.getPixelReader(), 0, adHeightTop, width, height);

        setLandscapeBeforeRendering(cropped);

        // Renderizza gli sprite
        HashMap<String, AbstractSprite> spriteMap = sprites.getInstance();
        spriteMap.forEach((key, value) -> renderSprite(value));
    }

    private void renderSprite(AbstractSprite sprite) {
        if (sprite != null) {
            context.drawImage(sprite.getImages().get(0), sprite.getHitbox().getLayoutX(),
                    sprite.getHitbox().getLayoutY());
        }
    }

    private void setLandscapeBeforeRendering(Image image) {
        // Pulisce il canvas
        context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // Disegna l'immagine ritagliata centrata
        double offsetX = i;
        double offsetY = (canvas.getHeight() - image.getHeight()) / 2;
        context.drawImage(image, offsetX, offsetY);

        // Ferma Chicorita
        sprites.getInstance().get("Chicorita").setDirectionEnum(DirectionEnum.STILL);

        // Gestione bordi (puoi riadattarla se vuoi)
        double x = sprites.getInstance().get("Chicorita").getHitbox().getLayoutX();
        double width = sprites.getInstance().get("Chicorita").getHitbox().getWidth();
        double canvasWidth = canvas.getWidth();

        if (x + width >= canvasWidth) {
            System.out.println("x + width" + x + width);
            System.out.println("canvasWidth" + canvasWidth);
            this.i = i - 10;
            sprites.getInstance().get("Chicorita").getHitbox().setLayoutX(x - 10);
        }
        
        if (x <= 0) {
            System.out.println("x + width = " + x + width);
            System.out.println("canvasWidth = " + canvasWidth);
            this.i = i + 10;
            sprites.getInstance().get("Chicorita").getHitbox().setLayoutX(x + 10);
        }
    }

    public Scene getScene() {
        return scene;
    }

    public Canvas getCanvas() {
        return canvas;
    }
}
