import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int counter = 0;
    private int enemyCounter = 0;
    private int enemyRand;
    private int enemyTimeSpawn = 300;
    private int enemyRandTimeSpawn = 200;
    
    private int score = 0;
    private int scoreCounter = 0;
    TextDisplay textDisplay = new TextDisplay("Score: "+score);
    
    private int difficultyMod = 15;
    private int shadowSpawnSpeed = 100;
    
    private int enemySpeed = 1;
    
    Random random = new Random();
    
    public MyWorld(String pacifierColor)
    {    
        super(900, 600, 1);
        fillBackgroundWithSprite("chao.png");
        addObject(textDisplay, super.getWidth()/2+50, 50);
        Player player = new Player(pacifierColor);
        addObject(player, super.getWidth()/2, super.getHeight()/2);
        enemyRand = random.nextInt(enemyTimeSpawn) + enemyRandTimeSpawn;
    }
    
    public void act(){
        counter++;
        enemyCounter++;
        scoreCounter++;
        if(scoreCounter >= 50){
            score++;
            textDisplay.setText("Score: "+score);
            scoreCounter = 0;
            updateDifficulty();
        }
        if(counter >= shadowSpawnSpeed){
            spawnShadow();
            counter = 0;
        }
        if(enemyCounter >= enemyRand){
            spawnEnemy();
            enemyRand = random.nextInt(enemyTimeSpawn) + enemyRandTimeSpawn;
            enemyCounter = 0;
        }
        if(score >= 150){
            enemySpeed = 4;
            enemyTimeSpawn = 100;
        }else if(score >= 100){
            enemySpeed = 2;
            enemyTimeSpawn = 150;
        }
        removeObject(textDisplay);
        addObject(textDisplay, super.getWidth()/2+50, 50);
    }
    
    public void spawnShadow() {
        int width = getWidth();
        int height = getHeight();
        
        int posX = random.nextInt(0, width);
        int posY = random.nextInt(0, height);
        
        addObject(new Shadow(), posX, posY);
    }
    
    public void spawnEnemy(){
        int x = 0;
        int y = 0;
        int side = random.nextInt(4);
        if(side == 0){
            x = random.nextInt(getWidth());
            y = -50;
        }else if(side == 1){
            x = random.nextInt(getWidth());
            y = getHeight() + 50;
        }else if(side == 2){
            x = -50;
            y = random.nextInt(getHeight());
        }else if(side == 3){
            x = getWidth() + 50;
            y = random.nextInt(getHeight());
        }
        addObject(new Enemy(enemySpeed), x, y);
    }
    
    public void updateDifficulty(){
        if(score % difficultyMod == 0){
            if(enemySpeed < 8){
                enemySpeed++;
            }if(enemyTimeSpawn >= 100){
                enemyTimeSpawn = enemyTimeSpawn - 50;
            }if(shadowSpawnSpeed >= 15){
                shadowSpawnSpeed = shadowSpawnSpeed-5;
            }
        }
    }
    
    public void shake(){
        GreenfootImage originalBg = getBackground();
        int duration = 1;
        int intensity = 10;
        
        for(int i = 0; i < duration; i++) {
            int offsetX = Greenfoot.getRandomNumber(intensity * 2) - intensity;
            int offsetY = Greenfoot.getRandomNumber(intensity * 2) - intensity;
            GreenfootImage shakenImage = new GreenfootImage(originalBg);
            shakenImage.drawImage(originalBg, offsetX, offsetY);setBackground(shakenImage);
            Greenfoot.delay(1);
        }
        
        setBackground(originalBg);
    }
    
    private void fillBackgroundWithSprite(String spriteName) {
        GreenfootImage sprite = new GreenfootImage(spriteName);
        sprite.scale(sprite.getWidth()*3, sprite.getHeight()*3);
        GreenfootImage background = new GreenfootImage(getWidth(), getHeight());
        
        int spriteWidth = sprite.getWidth();
        int spriteHeight = sprite.getHeight();
        
        for (int y = 0; y < getHeight(); y += spriteHeight) {
            for (int x = 0; x < getWidth(); x += spriteWidth) {
                background.drawImage(sprite, x, y);
            }
        }
        
        setBackground(background);
    }
    
    public void endGame(boolean spider){
        if(spider){
            Greenfoot.setWorld(new GameOverSpider(score));
        }else{
            Greenfoot.setWorld(new GameOverPillow(score));
        }
    }
    
}
