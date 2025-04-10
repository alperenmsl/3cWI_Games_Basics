package at.alperen.games.rantest;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

public class ScreenOne extends BasicGameState {
    private boolean stateFinished = false;
    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.drawRect(50,50,100,100);
        graphics.drawRect(170,50,100,100);
        graphics.drawRect(290,50,100,100);
        graphics.drawRect(410,50,100,100);

        graphics.drawString("Level 1",70,70);
        graphics.drawString("Level 2",190,70);
        graphics.drawString("Level 3",310,70);
        graphics.drawString("Level 4",430,70);

    }
    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        if (stateFinished){stateBasedGame.enterState(1);}
    }

    @Override
    public void keyPressed(int key, char c) {
        System.out.println("Key pressed: " + key);
        this.stateFinished = true;

    }
}
