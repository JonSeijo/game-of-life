package com.jonseijo.life;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameLife extends ApplicationAdapter {

    public static final float SENSIBILIDAD_PAN_X = 0.9f;
    public static final float SENSIBILIDAD_PAN_Y = 0.9f;

    private AssetLoader assetLoader;

    private Jon jon;
    private Tablero tablero;
    private Tablero temporal;

    private SpriteBatch batch;
    private Viewport viewport;
    private OrthographicCamera camera;

	@Override
	public void create () {
	    this.assetLoader = new AssetLoader();

        this.crearTablero(25);

        /*
        Glider:
            0 1 1
            1 0 1
            0 0 1
         */
	    this.tablero.set(2, 0, true);
        this.tablero.set(2, 1, true);
        this.tablero.set(2, 2, true);
        this.tablero.set(1, 2, true);
	    this.tablero.set(0, 1, true);

        this.batch = new SpriteBatch();
        this.camera = new OrthographicCamera();


        // @JONNO
        // viewport y la camara estan siendo seteados por valores arbitrarios,
        // Deberia crear unidades del juego para ser consistente y no usar valores magicos
        this.viewport = new ExtendViewport(400, 600, this.camera);
        this.camera.position.set(200, 300, 0);

        InputMultiplexer multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(new GestureDetector(new GameGestureAdapter(this)));
        multiplexer.addProcessor(new GameInputAdapter(this));
        Gdx.input.setInputProcessor(multiplexer);
	}

    // @JONNO
    // Quiza Jon deberia encargarse del tablero posta
	public void crearTablero(int tam) {
        this.jon = new Jon(tam);
        this.tablero = new Tablero(tam);
    }

	@Override
	public void render () {

        this.camera.update();
        batch.setProjectionMatrix(this.camera.combined);

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();

		this.tablero.render(batch);

		batch.end();
	}

	public void siguienteGeneracion() {
        // Jon es quien se encarga de aplicar las reglas de la vida al tablero
        this.jon.simular(this.tablero);
    }

    public void zoomIn() {
        if (this.camera.zoom < 10) {
            this.camera.zoom += 0.04f;
        }
    }

    public void zoomOut() {
        if (this.camera.zoom > 0.5f) {
            this.camera.zoom -= 0.04f;
        }
	}

    public void pan(float x, float y, float deltaX, float deltaY) {
        camera.position.add(
                -deltaX * camera.zoom * this.SENSIBILIDAD_PAN_X,
                deltaY * camera.zoom * this.SENSIBILIDAD_PAN_Y, 0);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }
	
	@Override
	public void dispose () {
        assetLoader.dispose();
		batch.dispose();
	}
}
