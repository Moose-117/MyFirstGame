package com.mycompany.myfirstgame;

import com.google.inject.AbstractModule;

public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Sprites.class).toInstance(new Sprites());
        bind(Landscape.class); // Lascia che Guice usi il costruttore di Landscape
    }
}
