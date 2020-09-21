/**
 * Put your Jeroo methods in this class.
 * @author Steve Aronson
 */
public class Jeroo extends JerooBase {

    /**
     *  Jeroo should pick all plants in the rectangle shown
     *  that is 3 wide and 4 tall
     *     >FFF
     *      FFF
     *      FFF
     *      FFF
     *  
     * IMPORTANT:  You should be calling the same helper method
     *             four times to achieve this.
     */
    public void turnAround(){
      turn(LEFT);
      turn(LEFT);
    }
    public void hopPick(){
      hop();
      pick();
    }
    public void pickUpX3(){
      hopPick();
      hopPick();
      hopPick();
      turnAround();
      hop();
      hop();
      hop();
      turn(LEFT);
      hop();
      turn(LEFT);
    }
  public void pickRectangle()
    {
      pickUpX3();
      pickUpX3();
      pickUpX3();
      pickUpX3();
    }

    


    /**
     * if the Jeroo is on a flower and there is a net in front of it,
     * it should pick up the flower and use it to disable the net
     * and then hop onto the newly clear space.
     */
    public void disableNet() {
      if (isFlower(HERE)){
        if (isNet(AHEAD)){
          pick();
          toss();
          hop();
        }
      }
    }


    /**
     * Jeroo should hop forward only if there is at least one
     *     flower on its left or on its right
     */
    public void hopCheckFlowersOr() 
    {
      if (isFlower(LEFT))
        hop();
      else if (isFlower(RIGHT))
        hop();
    }

    /**
     * Jeroo should hop forward only if there is a flower 
     *   on its left and on its right
     */
    public void hopCheckFlowersAnd() 
   {
      if (isFlower(LEFT)){
        if (isFlower(RIGHT)){
          hop();
        }
      }
   }
    // Do NOT touch the code below here
    public Jeroo() {super();}

    public Jeroo(int flowers) {super(flowers); }

    public Jeroo(int y, int x) { super(y, x); }

    public Jeroo(int y, int x, CompassDirection direction) { super (y, x, direction);}

    public Jeroo(int y, int x, int flowers) { super (y, x, flowers);}

    public Jeroo(int y, int x, CompassDirection direction, int flowers) { super(y, x, direction, flowers);}
}

