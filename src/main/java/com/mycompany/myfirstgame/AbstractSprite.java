package com.mycompany.myfirstgame;

import java.util.ArrayList;
import java.util.function.IntPredicate;

import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
/**
 *
 * @author marco
 */
public abstract class AbstractSprite {

    private static final String HERO_IMAGE_LOC_2 = "file:src\\main\\resources\\frame_2.png";
    private static final String HERO_IMAGE_LOC_3 = "file:src\\main\\resources\\frame_3.png";
    private static final String HERO_IMAGE_BULBA =   "file:src\\main\\resources\\bulba.png";

    public Rectangle hitbox = new Rectangle();
    private ArrayList<Image> images = new ArrayList<>();
    private DirectionEnum directionEnum;

    AbstractSprite(String imageUrl) {
        System.out.println("sto rigenereando lo sprite");
        hitbox.setLayoutX(300);
        hitbox.setLayoutY(300);
        hitbox.setHeight(59.00);
        hitbox.setWidth(50.00);
        hitbox.setFill(new ImagePattern(new Image(imageUrl)));
        images.add(new Image(imageUrl));
        images.add(new Image(imageUrl));
        images.add(new Image(imageUrl));
        directionEnum = DirectionEnum.STILL;
    }

    public void goRight() {
        directionEnum = DirectionEnum.RIGHT;
        images.set(0, this.wagTail());
        this.getHitbox().setLayoutX(this.getHitbox().getLayoutX() + 10);
    }

    public void goLeft() {        
        directionEnum = DirectionEnum.LEFT;
        images.set(0, this.wagTail());
        this.getHitbox().setLayoutX(this.getHitbox().getLayoutX() - 10);
    }

    public Image wagTail() {
        //the sprite visualized image is linked to its position along x axes (getLayoutX)
        return images.get((int) hitbox.getLayoutX()%3);
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public void setHitbox(Rectangle hitbox) {
        this.hitbox = hitbox;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }

    

    public DirectionEnum getDirectionEnum() {
        return directionEnum;
    }

    public void setDirectionEnum(DirectionEnum directionEnum) {
        this.directionEnum = directionEnum;
    }

    protected abstract void getInputCommands(Stage stage);


    }

     // @Override
    // public void jump() {
    //     System.out.println("caso UP");
    //     this.getHitbox().setLayoutY(this.getHitbox().getLayoutY() - 100);
    //     this.render(context, this.getImages().get(0));
    //     new java.util.Timer().schedule(
    //             new java.util.TimerTask() {
    //         @Override
    //         public void run() {
    //             Landscape.setLandscapeColor(Color.BLUEVIOLET);
    //             this.getHitbox().setLayoutY(chicoritaSprite.getHitbox().getLayoutY() + 100);
    //         }
    //     },
    //             1000
    //     );
    // }    

