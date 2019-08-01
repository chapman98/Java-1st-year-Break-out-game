/**
 * An Object in the game, represented as a rectangle.
 *  Which holds details of shape, plus possible direction of travel.
 * Would be better to use inheritance.
 * @author Mike Smith University of Brighton
 */
public class GameObj
{
  // All the variables below are vital to the state of the object
  private boolean canSee  = true; // Can see
  private float topX   = 0.0f; // Top left corner X
  private float topY   = 0.0f; // Top left corner Y
  private float width  = 0.0f; // Width of object
  private float height = 0.0f; // Height of object
  private Colour colour;       // Colour of object
  private int   dirX   = 1;    // Direction X (1 or -1)
  private int   dirY   = 1;    // Direction Y (1 or -1)

  /** 
   * Constructor for a game object (x,y width, height, colour)
   * @param x co-ordinate of the game object
   * @param y co-ordinate of the game object
   * @param widthIs  width of the game object
   * @param heightIs height of the game object
   * @param c Colour of the game object
   */
  public GameObj( float x, float y,
                float widthIs, float heightIs, Colour c )
  {
    topX   = x;       topY = y;
    width  = widthIs; height = heightIs; 
    colour = c;
  }

  /**
   * Set the game object visibility
   * @param state is visible true or false
   */
  public void setVisibility( boolean state )
  {
    canSee = state;
  }

  /**
   * Is the game object visible
   * @return visibility true/false
   */
  public boolean isVisible()
  {
    return canSee;
  }
   
  /** 
   * The X co-ordinate of the top left hand corner of the Game Object
   * @return x co-ordinate of the game Object 
   */  
  public float getX()       { return topX; }
  /** 
   * The Y co-ordinate of the top left hand corner of the Game Object
   * @return y co-ordinate of the game Object 
   */  

  public float getY()       { return topY; }
  /**
   * The width of the game object
   *  @return The width of the game Object 
   */ 

  public float getWidth()   { return width; }
  /**
   * The height of the game object
   *  @return The height of the game Object 
   */ 

  public float getHeight()  { return height; }
  /**
   * The colour of the game object
   * @return The colour of the game object 
   */
  public Colour getColour() { return colour; }
  
  /**
   * Move object by X units
   *  The actual direction moved is flipped by changeDirectionX()
   *  @param units units to move
   */

  public void moveX( float units )
  {
    topX += units * dirX;
  }
  
  /**
   * Move object by Y units
   *   The actual direction moved is flipped by changeDirectionY()
   *   @param units units to move
   */
  public void moveY( float units )
  {
    topY += units * dirY;
  }
  
  /**
   * Change direction of future moves in the X direction 
   */
  public void changeDirectionX()
  {
    dirX = -dirX;
  }
  
  /**
   * Change direction of future moves in the Y direction 
   */
  public void changeDirectionY()
  {
    dirY = -dirY;
  }
  
  /**
   * Detect a collision between two GameObjects 
   *  Would be good to know where the object is hit
   *  @param obj Game object to see if 'hit' by 
   *  @return collision True/ False
   */
 
  public boolean hitBy( GameObj obj )
  {
    return ! ( topX >= obj.topX+obj.width     ||
               topX+width <= obj.topX         ||
               topY >= obj.topY+obj.height    ||
               topY+height <= obj.topY );

  }
  
}
