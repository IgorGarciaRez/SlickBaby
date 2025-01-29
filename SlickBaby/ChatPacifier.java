import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ChatPacifier here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChatPacifier extends Chat
{
    public ChatPacifier(){
        GreenfootImage chat = new GreenfootImage("chat-pacifier.png");
        chat.scale(chat.getWidth()/2, chat.getHeight()/2);
        setImage(chat);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
