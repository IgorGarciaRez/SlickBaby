import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private int velocidade = 4;
    private boolean isAlive = true;
    
    private GreenfootImage[] idleFront = new GreenfootImage[4];
    private GreenfootImage[] idleRight = new GreenfootImage[4];
    private GreenfootImage[] idleBack = new GreenfootImage[4];
    private GreenfootImage[] idleLeft = new GreenfootImage[4];
    
    private GreenfootImage[] walkFront = new GreenfootImage[4];
    private GreenfootImage[] walkRight = new GreenfootImage[4];
    private GreenfootImage[] walkBack = new GreenfootImage[4];
    private GreenfootImage[] walkLeft = new GreenfootImage[4];
    
    private GreenfootSound soundSpit = new GreenfootSound("laserShoot.wav");
    
    private int frameIndex = 0;
    private int animCounter = 0;
    private int animSpeed = 8;
    
    private int timeReload = 25;
    private int timeFromLastShoot;
    
    private String direction = "front";
    
    public Player(){
        initAnimationSprites();
        timeFromLastShoot = 25;
    }
    
    public void act()
    {
        if(isAlive){
            timeFromLastShoot++;
            setDirection();
            if(direction.equals("right")){
                setImage(idleRight[animar()]);
            }if(direction.equals("front")){
                setImage(idleFront[animar()]);
            }if(direction.equals("left")){
                setImage(idleLeft[animar()]);
            }if(direction.equals("back")){
                setImage(idleBack[animar()]);
            }if(Greenfoot.isKeyDown("space")){
                shoot();
            }
            moveAround();
        }else{
            Greenfoot.setWorld(new GameOver());
        }
    }
    
    public void moveAround(){
        if(Greenfoot.isKeyDown("d")){
            if(Greenfoot.isKeyDown("d") && Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("d") && Greenfoot.isKeyDown("s")){
                setDirectionWalking();
                setLocation(getX()+(velocidade/2), getY());
            }
            else{
                setDirectionWalking();
                setLocation(getX()+velocidade, getY());
            }
        }
        if(Greenfoot.isKeyDown("a")){
            if(Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("s")){
                setDirectionWalking();
                setLocation(getX()-(velocidade/2), getY());
            }else{
                setDirectionWalking();
                setLocation(getX()-velocidade, getY());
            }
        }
        if(Greenfoot.isKeyDown("w")){
            setDirectionWalking();
            setLocation(getX(), getY()-velocidade);
        }
        if(Greenfoot.isKeyDown("s")){
            setDirectionWalking();
            setLocation(getX(), getY()+velocidade);
        }
    }
    
    public int getAngle(){
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (mi != null) {
            int mouseX = mi.getX();
            int mouseY = mi.getY();
            int deltaX = mouseX - getX();
            int deltaY = mouseY - getY();
            double angleInRadians = Math.atan2(deltaY, deltaX);
            int angleInDegrees = (int) Math.toDegrees(angleInRadians);
            if (angleInDegrees < 0) {
                angleInDegrees += 360;
            }
            return angleInDegrees;
        }else{
            return 0;
        }
    }
    
    public void setDirection(){
        int angle = getAngle();
        if(315 <= angle || (angle > 0 && angle < 45)){
            direction = "right";
        }if(45 <= angle && angle < 135){
            direction = "front";
        }if(135 <= angle && angle < 225){
            direction = "left";
        }if(225 <= angle && angle < 315){
            direction = "back";
        }if(Greenfoot.isKeyDown("space")){
            shoot();
        }
    }
    
    public void setDirectionWalking(){
        if(direction.equals("right")){
            setImage(walkRight[animar()]);
        }if(direction.equals("front")){
            setImage(walkFront[animar()]);
        }if(direction.equals("left")){
            setImage(walkLeft[animar()]);
        }if(direction.equals("back")){
            setImage(walkBack[animar()]);
        }
    }
    
    public void shoot(){
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (mi != null && timeFromLastShoot >= timeReload) {
            soundSpit.play();
            Pacifier pacifier = new Pacifier(8);
            pacifier.setRotation(getAngle());
            getWorld().addObject(pacifier, getX(), getY());
            timeFromLastShoot = 0;
        }
    }
    
    public boolean isAlive(){
        return isAlive;
    }
    
    public void die(){
        isAlive = false;
        MyWorld world = getWorldOfType(MyWorld.class);
        world.endGame();
    }
    
    public int animar(){
        animCounter++;
        if (animCounter >= animSpeed) {
            animCounter = 0;
            frameIndex = (frameIndex + 1) % 4;
        }
        return frameIndex;
    }
    
    public void initAnimationSprites(){
        for(int i = 0; i < 4; i++){
            idleFront[i] = new GreenfootImage("idle-front"+(i+1)+".png");
            idleRight[i] = new GreenfootImage("idle-right"+(i+1)+".png");
            idleBack[i] = new GreenfootImage("idle-back"+(i+1)+".png");
            idleLeft[i] = new GreenfootImage("idle-left"+(i+1)+".png");
            
            walkFront[i] = new GreenfootImage("walking-front"+(i+1)+".png");
            walkRight[i] = new GreenfootImage("walking-right"+(i+1)+".png");
            walkBack[i] = new GreenfootImage("walking-back"+(i+1)+".png");
            walkLeft[i] = new GreenfootImage("walking-left"+(i+1)+".png");
        }
    }
    
}
