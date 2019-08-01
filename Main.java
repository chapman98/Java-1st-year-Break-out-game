/**
 * Start the game
 *  The call to startGame() in the model starts 
 *    the actual play of the game
 *  Note: Many issues of mutual exclusion on shared variables
 *        are ignored.
 * @author Mike Smith University of Brighton
 */
public class Main
{
  public static final int H = 800; // Height of window
  public static final int W = 600; // Width of window

  public static void main( String args[] )
  {
    Debug.trace("BreakOut");
    Debug.set( true );              // Set true to get debug info

    Model model = new Model(W,H);   // model of the Game
    View  view  = new View(W,H);    // View of the Game
                  new Controller( model, view );
                          
    model.createGameObjects();       // Ball, Bat & Bricks
    model.addObserver( view );       // Add observer to the model

    view.setVisible(true);           // Make visible
    model.startGame();               // Start playing the game
  }
}
