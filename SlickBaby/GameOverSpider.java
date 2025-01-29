import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverSpider here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverSpider extends World
{
    TextDisplay textDisplay = new TextDisplay("Score: ");

    public GameOverSpider(int score)
    {    
        super(900, 600, 1);
        prepare();
        textDisplay.setText("Score: "+score);
        addObject(textDisplay, super.getWidth()/2+50, 250);
    }
    
    private void prepare(){
        Restart restart = new Restart();
        Quit quit = new Quit();
        addObject(restart, getWidth()/2, 300);
        addObject(quit, getWidth()/2, 370);
    }
}
