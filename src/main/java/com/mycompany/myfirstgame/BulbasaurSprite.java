package com.mycompany.myfirstgame;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class BulbasaurSprite extends AbstractSprite implements inputHandler {

    BulbasaurSprite(String imageUrl) {
        super(imageUrl);
        //TODO Auto-generated constructor stub
    }

    private static final String HERO_IMAGE_LOC_DX =   "file:src\\main\\resources\\frame_1.png";
    private static final String HERO_IMAGE_LOC_2_DX = "file:src\\main\\resources\\frame_2.png";
    private static final String HERO_IMAGE_LOC_3_DX = "file:src\\main\\resources\\frame_3.png";
    private static final String HERO_IMAGE_LOC =   "file:src\\main\\resources\\frame_1.png";

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
