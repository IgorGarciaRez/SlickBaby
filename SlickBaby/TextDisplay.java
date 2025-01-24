import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextDisplay extends Actor
{
    private String text;

    public TextDisplay(String text) {
        this.text = text;
        updateText();
    }

    public void updateText() {
        GreenfootImage image = new GreenfootImage(200, 50);
        image.setColor(Color.WHITE);
        image.setFont(new Font("Arial", 24));
        image.drawString(text, 10, 30); 
        setImage(image); 
    }

    public void setText(String newText) {
        this.text = newText;
        updateText();
    }
}
