package com.mycompany.myfirstgame;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ChicoritaSprite extends AbstractSprite implements inputHandler {

    private static final String HERO_IMAGE_LOC_DX =   "file:src\\main\\resources\\frame_1.png";
    private static final String HERO_IMAGE_LOC_2_DX = "file:src\\main\\resources\\frame_2.png";
    private static final String HERO_IMAGE_LOC_3_DX = "file:src\\main\\resources\\frame_3.png";
    private static final String HERO_IMAGE_LOC =   "file:src\\main\\resources\\frame_1.png";

    ChicoritaSprite() {
        super(HERO_IMAGE_LOC_DX);
        hitbox.setFill(new ImagePattern(new Image(HERO_IMAGE_LOC_DX)));
    }

     @Override
        public void getInputCommands(Stage stage) {
        stage.getScene().addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
           switch (key.getCode()) {
                case RIGHT: this.goRight();
                break;
                case LEFT: this.goLeft();
                break;
                // case SPACE: this.jump();
                // break;
           }
        });
    }
}
