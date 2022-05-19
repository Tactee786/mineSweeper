public class Tile {
    // Attributes
    boolean visible;
    boolean bomb;
    boolean flag;
    String state;
    int bombCount;

    // Constructor
    public Tile(boolean myVisible, boolean myBomb, boolean myFlag, String myState, int myBombCount){
        this.visible = myVisible;
        this.bomb = myBomb;
        this.flag = myFlag;
        this.state = myState;
        this.bombCount = myBombCount;
    }

    // Methods
    public String getTileState(){
        return this.state;
    }

    public void setFlag(){
        this.flag = !this.flag;
        //System.out.println(getBomb());
        if ((this.flag) == true){
            this.state = "F";
        } else if (this.flag == false && this.bomb == true) {
            this.state = "X";
        } else if (this.flag == false && this.bomb == false){
            this.state = Integer.toString(bombCount);
        }
    }

    public void setBomb(){
        this.bomb = true;
        this.state = "X";
    }

    public boolean getBomb(){
        return this.bomb;
    }
    public void setState(int bombCount){
        this.state = Integer.toString(bombCount);
    }

}
