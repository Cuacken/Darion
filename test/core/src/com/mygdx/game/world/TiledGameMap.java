package com.mygdx.game.world;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class TiledGameMap extends GameMap {

	TiledMap tiledMap;
	OrthogonalTiledMapRenderer tiledMapRenderer;
	
	public TiledGameMap() {
		tiledMap = new TmxMapLoader().load("map.tmx");
		tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
	}
	
	public void render(OrthographicCamera camera, SpriteBatch batch) {
		tiledMapRenderer.setView(camera);
		tiledMapRenderer.render();
		batch.setProjectionMatrix(camera.combined);

		super.render(camera, batch);

		
	}

	public void update(float delta) {
		super.update(delta);
	}

	public void dispose() {
		tiledMapRenderer.dispose();
	}
	public int getWidth() {
		return ((TiledMapTileLayer) tiledMap.getLayers().get(0)).getWidth();
	}

	public int getHeight() {
		return ((TiledMapTileLayer) tiledMap.getLayers().get(0)).getHeight();
	}

	public int getLayers() {
		return tiledMap.getLayers().getCount();
	}

	@Override
	public TileType getTileTypeByCoordinate(int layer, int col, int row) {
		Cell cell = ((TiledMapTileLayer)tiledMap.getLayers().get(layer)).getCell(col, row);
		if (cell!=null) {
			TiledMapTile tile = cell.getTile();
			if (tile != null) {
				int id =tile.getId();
				return TileType.getTileTypeById(id);
			}
		}
		return null;
	}

}
