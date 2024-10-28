package com.mycompany.myfirstgame;

import java.util.HashMap;

public class Sprites {

    private static HashMap<String, AbstractSprite> map = new HashMap<>();

    public HashMap<String, AbstractSprite> getInstance() {
        return map;
    }
}