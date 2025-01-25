package states;

public class GamePlayState {
    public Long sTimer;
    public boolean isPaused;
    public boolean isLose;
    public boolean isPlay;
    public  int gameSpeed;
    public int numOfPlayers;

    public GamePlayState(int numOfPlayers){
        this.numOfPlayers=numOfPlayers;
        isPaused=false;
        isLose=false;
        sTimer=System.currentTimeMillis();
    }
    public void setPaused() {
        isPaused = true;
    }
    public void setEasyMode(){

    }
    public void setMediumMode(){

    }
    public void setHardMode(){

    }

    public void setLose() {
        isLose = true;
    }
    public void setPlay() {
        isLose = false;
        isPaused = false;
    }
    public void setRestart(){

    }

}
