package com.jonseijo.life;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameLife extends ApplicationAdapter {

    private AssetLoader assetLoader;

    private Jon jon;
    private Tablero tablero;

    private SpriteBatch batch;
    private Viewport viewport;
    private OrthographicCamera camera;

	@Override
	public void create () {
	    this.assetLoader = new AssetLoader();
	    this.jon = new Jon();
	    this.tablero = new Tablero(25);

	    this.tablero.set(0, 0, true);
	    this.tablero.set(1, 1, true);
	    this.tablero.set(2, 2   , true);

        this.batch = new SpriteBatch();
        this.camera = new OrthographicCamera();


        // @JONNO
        // viewport y la camara estan siendo seteados por valores arbitrarios,
        // Deberia crear unidades del juego para ser consistente y no usar valores magicos
        this.viewport = new ExtendViewport(400, 600, this.camera);
        this.camera.position.set(200, 300, 0);

        Gdx.input.setInputProcessor(new GameInputAdapter(this));
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
