public class Die
{
  private int numDots;

  // Sets numDots to a random integer from 1 to 6
  public void roll()
  {
    // Your code goes here
    numDots = (int)(Math.random() * 6) + 1;
  }

  // Returns numDots
  public int getNumDots()
  {
    return numDots;
  }
}
