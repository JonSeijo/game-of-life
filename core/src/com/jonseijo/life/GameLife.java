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

    private SpriteBatch batch;
	private Texture texture;
    private Viewport viewport;
    private OrthographicCamera camera;

	@Override
	public void create () {
	    this.texture = new Texture(Gdx.files.internal("cell_blue.png"));
        this.batch = new SpriteBatch();
        this.camera = new OrthographicCamera();
        this.viewport = new ExtendViewport(300, 500, this.camera);
	}

	@Override
	public void render () {

        this.camera.update();
        batch.setProjectionMatrix(this.camera.combined);

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();

		batch.draw(texture, 100, 100);

		batch.end();
	}

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }
	
	@Override
	public void dispose () {
		batch.dispose();
		texture.dispose();
	}
}
