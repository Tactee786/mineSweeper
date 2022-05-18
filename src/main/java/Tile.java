public class Tile {
    // Attributes
    boolean visible = false;
    boolean bomb = false;
    boolean flag = false;
    String state = "O";
    int bombCount = 0;

    // Constructor
    public Tile(boolean myVisible, boolean myBomb, boolean myFlag, String myState, int myBombCount){
        this.visible = myVisible;
        this.bomb = myBomb;
        this.flag = myFlag;
        this.state = myState;
        this.bombCount = myBombCount;
    }

    // Methods
    public String getState(){
        return this.state;
    }

    public void setFlag(){
        this.flag = !this.flag;
        if ((this.flag) == true){
            this.state = "F";
        } else if (this.flag == false) {
            this.state = "O";
        }
    }

    public void setBomb(){
        this.bomb = true;
        this.state = "X";
    }

    public void setState(int bombCount){
        this.state = Integer.toString(bombCount);
    }

}
