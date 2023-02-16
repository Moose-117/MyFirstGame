package com.mycompany.myfirstgame;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import javafx.animation.Animation;
import javafx.animation.Animation.Status;
import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

/**
 * JavaFX App
 */
public class App extends Application {

    Sprite chicoritaSprite = new Sprite();
    Sprite enemySprite = new Sprite();

    Canvas canvas = new Canvas(600, 600);
    BorderPane root = new BorderPane(chicoritaSprite.getHitbox());

    Scene scene = new Scene(root);
    ArrayList<Image> images = new ArrayList<>();
    GraphicsContext context = canvas.getGraphicsContext2D();
    
     // set background image
        
        ImageView background = new ImageView();
        background.setImage(new Image("file:C:\\Users\\marco\\OneDrive\\Desktop\\sprites\\moveDx\\idle1.png"));
        root.getChildren().add(background);

        ImageView background2 = new ImageView();
        background2.setImage(new Image("file:C:\\Users\\marco\\OneDrive\\Desktop\\sprites\\moveDx\\idle2.png"));
        root.getChildren().add(background2);

    @Override
    public void start(Stage stage) throws IOException {

        context.setFill(Color.FORESTGREEN);
        images.add(chicoritaSprite.getImages().get(0));
        context.fillRect(0, 0, 600, 600);
        
       

        AnimationTimer loop = new AnimationTimer() {
            @Override
            public void handle(long nanotime) {

                context.setFill(Color.FORESTGREEN);
                images.add(chicoritaSprite.getImageRight().get(0));
                context.fillRect(0, 0, 600, 600);

                scene.setOnKeyPressed((KeyEvent event) -> {

                    switch (event.getCode()) {
                        case UP:
                            jump();
                            break;
                        case LEFT:
                            goLeft();
                            break;
                        case RIGHT:
                            goRight();
                            break;
                    }
                });
                            chicoritaSprite.render (context, chicoritaSprite.getImages().get(0));
            }

        };

        loop.start();
        root.setCenter(canvas);
        scene.getRoot().requestFocus();
        stage.setTitle("Chicorita's Dream");
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private void goLeft() {
        images = chicoritaSprite.getImageLeft();
        images.set(0, chicoritaSprite.wagTail(images));
        chicoritaSprite.getHitbox().setLayoutX(chicoritaSprite.getHitbox().getLayoutX() - 1);
        
        TranslateTransition trans1 = new TranslateTransition(Duration.minutes(1), background);
        trans1.setFromY(0);
        trans1.setToY(740);
        trans1.setCycleCount(20);
        TranslateTransition trans2 = new TranslateTransition(Duration.minutes(1), background2);
        trans2.setFromY(-740);
        trans2.setToY(0);
        trans2.setCycleCount(20);
        ParallelTransition parTrans = new ParallelTransition(trans1, trans2);
        parTrans.play();
    }

    private void goRight() {
        images = chicoritaSprite.getImageRight();
        images.set(0, chicoritaSprite.wagTail(images));
        chicoritaSprite.getHitbox().setLayoutX(chicoritaSprite.getHitbox().getLayoutX() + 1);
        TranslateTransition trans1 = new TranslateTransition(Duration.minutes(1), background);
        trans1.setFromY(0);
        trans1.setToY(740);
        trans1.setCycleCount(20);
        TranslateTransition trans2 = new TranslateTransition(Duration.minutes(1), background2);
        trans2.setFromY(-740);
        trans2.setToY(0);
        trans2.setCycleCount(20);
        ParallelTransition parTrans = new ParallelTransition(trans1, trans2);
        parTrans.play();
    }

    private void jump() {
        System.out.println("caso UP");
        chicoritaSprite.getHitbox().setLayoutY(chicoritaSprite.getHitbox().getLayoutY() - 100);
        chicoritaSprite.render(context, chicoritaSprite.getImages().get(0));
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
            @Override
            public void run() {
                context.setFill(Color.BLUEVIOLET);
                chicoritaSprite.getHitbox().setLayoutY(chicoritaSprite.getHitbox().getLayoutY() + 100);
            }
        },
                1000
        );
    }
}
