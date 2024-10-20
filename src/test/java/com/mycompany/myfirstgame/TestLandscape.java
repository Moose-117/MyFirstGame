package com.mycompany.myfirstgame;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import com.google.inject.Guice;
import com.google.inject.Injector;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

public class TestLandscape {

    private Sprites sprites;
    private Canvas canvas;
    private BorderPane root;
    private Scene scene;
    private GraphicsContext context;
    Landscape landscape;

    @Before
    public void init(){
        this.canvas = new Canvas(600, 600);
        this.root = new BorderPane();
        this.scene = new Scene(root);
        this.context = canvas.getGraphicsContext2D();
        context.setFill(Color.FORESTGREEN);
        context.fillRect(0, 0, 600, 600);
        root.setCenter(canvas);
         Injector injector = Guice.createInjector(new AppModule()); 
        sprites = injector.getInstance(Sprites.class);
        landscape = injector.getInstance(Landscape.class);
    }

    @Test
    public void renderLandscapeTest(){
        landscape.render();
        assertEquals(Color.FORESTGREEN, landscape.getCanvas().getGraphicsContext2D().getFill());
    }

    // @Test
    // public void testRenderChicorita() {
    //     // Crea un mock del contesto grafico
    //     GraphicsContext mockedContext = mock(GraphicsContext.class);

    //     // Crea un mock dello sprite Chicorita
    //     SpriteImplementation chicorita = mock(SpriteImplementation.class);
        
    //     // Simula un'immagine e la posizione dello sprite
    //     Image chicoritaImage = mock(Image.class);
    //     when(chicorita.getImages()).thenReturn((ArrayList<Image>) List.of(chicoritaImage));
    //     when(chicorita.getHitbox().getLayoutX()).thenReturn(100.0);
    //     when(chicorita.getHitbox().getLayoutY()).thenReturn(200.0);

    //     // Mock del Landscape o dell'oggetto che gestisce i render
    //     Landscape landscape = mock(Landscape.class);
    //     when(landscape.sprites.getInstance().get("Chicorita")).thenReturn(chicorita);

    //     // Chiama il metodo render
    //     landscape.render();

    //     // Verifica che drawImage sia stato chiamato con i parametri corretti
    //     verify(mockedContext).drawImage(chicoritaImage, 100.0, 200.0);
    // }
    }