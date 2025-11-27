package com.mycompany.myfirstgame;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class BulbasaurSprite extends AbstractSprite implements inputHandler {

    private static final String HERO_IMAGE_BULBA = "file:src\\main\\resources\\bulba.png";


    BulbasaurSprite() {
        super(HERO_IMAGE_BULBA);
                hitbox.setFill(new ImagePattern(new Image(HERO_IMAGE_BULBA)));
    }

     @Override
        public void getInputCommands(Stage stage) {
        stage.getScene().addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
           switch (key.getCode()) {
                case D: this.goRight();
                break;
                case A: this.goLeft();
                break;
                // case SPACE: this.jump();
                // break;
           }
        });
    }
}
