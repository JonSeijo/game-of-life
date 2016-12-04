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

    private Tablero tablero;

    private SpriteBatch batch;
    private Viewport viewport;
    private OrthographicCamera camera;

	@Override
	public void create () {
	    this.assetLoader = new AssetLoader();
	    this.tablero = new Tablero(25);

        this.batch = new SpriteBatch();
        this.camera = new OrthographicCamera();
        this.viewport = new ExtendViewport(200, 300, this.camera);

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
