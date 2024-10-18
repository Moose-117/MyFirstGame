package com.mycompany.myfirstgame;

import java.util.HashMap;

public class Sprites {

    private static HashMap<String, SpriteImplementation> map = new HashMap<>();

    public HashMap<String, SpriteImplementation> getInstance() {
        return map;
    }
}