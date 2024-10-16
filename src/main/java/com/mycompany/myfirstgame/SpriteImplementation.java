/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myfirstgame;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
/**
 *
 * @author marco
 */
public class SpriteImplementation implements Movement{

    public Rectangle hitbox = new Rectangle();
    private ArrayList<Image> images = new ArrayList<>();

    private static final String HERO_IMAGE_LOC_DX =   " file:/home/marco/Scrivania/Progetti Java/MyFirstGame/src/main/resources/frame_1.png";
    private static final String HERO_IMAGE_LOC_2_DX = "file:/home/marco/Scrivania/Progetti Java/MyFirstGame/src/main/resources/frame_2.png";
    private static final String HERO_IMAGE_LOC_3_DX = "file:/home/marco/Scrivania/Progetti Java/MyFirstGame/src/main/resources/frame_3.png";

    private static final String HERO_IMAGE_LOC = "file:/home/marco/Scrivania/Progetti Java/MyFirstGame/src/main/resources/frame_1.png";
    private static final String HERO_IMAGE_LOC_2 = "file:/home/marco/Scrivania/Progetti Java/MyFirstGame/src/main/resources/frame_2.png";
    private static final String HERO_IMAGE_LOC_3 = "file:/home/marco/Scrivania/Progetti Java/MyFirstGame/src/main/resources/frame_3.png";

    SpriteImplementation() {
        System.out.println("sto rigenereando lo sprite");
        hitbox.setLayoutX(300);
        hitbox.setLayoutY(300);
        hitbox.setHeight(59.00);
        hitbox.setWidth(50.00);
        hitbox.setFill(new ImagePattern(new Image(HERO_IMAGE_LOC)));
        images.add(new Image(HERO_IMAGE_LOC));
        images.add(new Image(HERO_IMAGE_LOC_2));
        images.add(new Image(HERO_IMAGE_LOC_3));
    }

    public Image wagTail() {
        //the sprite visualized image is linked to its position along x axes (getLayoutX)
        return images.get((int) hitbox.getLayoutX()%3);
    }

    @Override
    public void goRight() {
        images.add(new Image(HERO_IMAGE_LOC_DX));
        images.add(new Image(HERO_IMAGE_LOC_2_DX));
        images.add(new Image(HERO_IMAGE_LOC_3_DX));        images.set(0, this.wagTail());
        this.getHitbox().setLayoutX(this.getHitbox().getLayoutX() + 1);
    }

    @Override
    public void goLeft() {
        images.add(new Image(HERO_IMAGE_LOC));
        images.add(new Image(HERO_IMAGE_LOC_2));
        images.add(new Image(HERO_IMAGE_LOC_3));        images.set(0, this.wagTail());
        this.getHitbox().setLayoutX(this.getHitbox().getLayoutX() - 1);
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

    @Override
    public void jump() {
        // TODO Auto-generated method stub
        
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
}
