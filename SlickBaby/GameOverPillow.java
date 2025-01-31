import greenfoot.*;

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverPillow extends World
{
    TextDisplay textDisplay = new TextDisplay("Score: ");

    public GameOverPillow(int score)
    {    
        super(900, 600, 1);
        prepare();
        textDisplay.setText("Score: "+score);
        addObject(textDisplay, super.getWidth()/2+50, 180);
    }
    
    private void prepare(){
        Restart restart = new Restart();
        Quit quit = new Quit();
        addObject(restart, getWidth()/2, 230);
        addObject(quit, getWidth()/2, 300);
    }
}
