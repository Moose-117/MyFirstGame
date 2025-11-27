/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myfirstgame;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author marco
 */
public class Sprite {

    private int i = 0;

    private Rectangle hitbox = new Rectangle();
    private ArrayList<Image> images = new ArrayList<>();

    private static final String HERO_IMAGE_LOC_DX = "file:C:\\Users\\marco\\OneDrive\\Desktop\\sprites\\moveDx\\idle1.png";
    private static final String HERO_IMAGE_LOC_2_DX = "file:C:\\Users\\marco\\OneDrive\\Desktop\\sprites\\moveDx\\idle2.png";
    private static final String HERO_IMAGE_LOC_3_DX = "file:C:\\Users\\marco\\OneDrive\\Desktop\\sprites\\moveDx\\idle3.png";

    private static final String HERO_IMAGE_LOC = "file:C:\\Users\\marco\\OneDrive\\Desktop\\sprites\\idle1.png";
    private static final String HERO_IMAGE_LOC_2 = "file:C:\\Users\\marco\\OneDrive\\Desktop\\sprites\\idle2.png";
    private static final String HERO_IMAGE_LOC_3 = "file:C:\\Users\\marco\\OneDrive\\Desktop\\sprites\\idle3.png";

    Sprite() {

        hitbox.setLayoutX(300);
        hitbox.setLayoutY(300);
        hitbox.setHeight(59.00);
        hitbox.setWidth(50.00);
        hitbox.setFill(new ImagePattern(new Image(HERO_IMAGE_LOC)));
        images.add(new Image(HERO_IMAGE_LOC));
        images.add(new Image(HERO_IMAGE_LOC_2));
        images.add(new Image(HERO_IMAGE_LOC_3));
    }

    public Image wagTail(ArrayList<Image> images) {
        this.images = images;
        if (i > 1000) {
            i = 0;
        }
        i++;
        switch (i % 3) {
            case 0:
                return images.get(0);

            case 1:
                return images.get(1);
            default:
                return images.get(2);
        }
    }

    public ArrayList<Image> getImageLeft() {
        ArrayList<Image> images = new ArrayList<>();
        images.add(new Image(HERO_IMAGE_LOC));
        images.add(new Image(HERO_IMAGE_LOC_2));
        images.add(new Image(HERO_IMAGE_LOC_3));
        return images;
    }

    public ArrayList<Image> getImageRight() {
        ArrayList<Image> images = new ArrayList<>();
        images.add(new Image(HERO_IMAGE_LOC_DX));
        images.add(new Image(HERO_IMAGE_LOC_2_DX));
        images.add(new Image(HERO_IMAGE_LOC_3_DX));
        return images;
    }

    public void render(GraphicsContext context, Image image) {

        context.drawImage(image, hitbox.getLayoutX(), hitbox.getLayoutY());
    }

    public void setImage(ArrayList<Image> image) {
        this.images = image;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public void setHitbox(Rectangle hitbox) {
        this.hitbox = hitbox;
    }
}
