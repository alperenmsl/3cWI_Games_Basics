package at.alperen.games.owngame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public interface Actor {
    void render(Graphics graphics) throws SlickException;
    void update(GameContainer gameContainer, int delta) throws SlickException;
}
