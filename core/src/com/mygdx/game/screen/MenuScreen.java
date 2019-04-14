package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Vector2 touch;
    private Vector2 pos;
    private Vector2 v;
    private Texture img;

    @Override
    public void show() {
        super.show();
        touch = new Vector2();
        pos = new Vector2();
        v = new Vector2(0.2f, 0.5f);
        img = new Texture("badlogic.jpg");
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        pos.add(v);
        batch.begin();
        batch.draw(img, pos.x, pos.y);
        batch.end();
        if (((Math.round(pos.x) == Math.round(touch.x)) && (Math.round(pos.y) == Math.round(touch.y)))) {
            v.setZero();
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        System.out.println("touchDown touch.x = " + touch.x + " touch.y = " + touch.y);
        v = getNewVector();
        return false;
    }

    private Vector2 getNewVector() {
        Vector2 newVector = new Vector2(touch.x - pos.x, touch.y - pos.y);
        double c = (Math.sqrt(newVector.x * newVector.x + newVector.y * newVector.y) / Math.sqrt(v.x * v.x + v.y * v.y));
        newVector.set((float) (newVector.x / c), (float) (newVector.y / c));
        return newVector;
    }
}



