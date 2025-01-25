import Texture.TextureReader;
import states.GameState;
import states.GamePlayState;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.glu.GLU;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class PackmanGLEventListener extends  PackmanListener{
    GameState gameState;
    GamePlayState gameplayState;
    CollisionManger collisionManger = new CollisionManger();


    String textureNames[] = {"Background.jpeg" , "menu.jpg","b2.png"
                            ,"b1.png","b2.png","b3.png","l1.png","l2.png"
                            ,"l3.png","r1.png","r2.png","r3.png","t1.png"
                            ,"t2.png","t3.png","buttons.png","GameOver.png","Win.png"
                            ,"soundOff.png","soundOn.png","wall_2.jpg","singlemutimenu.jpg"
                            ,"dot.png","blinky.png","blue_ghost.png","heart.png"
                            ,"pause.png","titleScreen.jpg","strawberry.png","apple.png"

                             };
    TextureReader.Texture texture[] = new TextureReader.Texture[textureNames.length];
    int textures[] = new int[textureNames.length];

    public void init(GLAutoDrawable glAutoDrawable) {

        GL gl = glAutoDrawable.getGL();
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);    //This Will Clear The Background Color To Black

        gl.glEnable(GL.GL_TEXTURE_2D);  // Enable Texture Mapping
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
        gl.glGenTextures(textureNames.length, textures, 0);

        for(int i = 0; i < textureNames.length; i++){
            try {
                texture[i] = TextureReader.readTexture(PackmanFolderName + "//" + textureNames[i] , true);
                gl.glBindTexture(GL.GL_TEXTURE_2D, textures[i]);

//                mipmapsFromPNG(gl, new GLU(), texture[i]);
                new GLU().gluBuild2DMipmaps(
                        GL.GL_TEXTURE_2D,
                        GL.GL_RGBA, // Internal Texel Format,
                        texture[i].getWidth(), texture[i].getHeight(),
                        GL.GL_RGBA, // External format from image,
                        GL.GL_UNSIGNED_BYTE,
                        texture[i].getPixels() // Imagedata
                );
            } catch( IOException e ) {
                System.out.println(e);
                e.printStackTrace();
            }
        }
        gameState = new GameState();

        gameState.setStartPlay();

        gameplayState = new GamePlayState(1);
        gameplayState.setEasyMode();
    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        GL gl = glAutoDrawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glLoadIdentity();

        DrawBackground(gl, 1);

        switch (gameState.getGameState()) {
            case "start": {


            }
            break;

            case "instruction":


                break;

            case "chooseMode":



                break;

            case "chooseNumberOfPlayers":


                break;

            case "chooseModeFor2Players":


                break;

            case "startPlay":

            {
                DrawBackground(gl, 0);

                if (gameplayState.isLose) {


                } else if (gameplayState.isPaused) {

                } else {




                }


            }
            break;

            default:
                System.out.println("Unknown state.");
                break;
        }


    }
    public void DrawBackground(GL gl, int i) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[i]);
        gl.glPushMatrix();
        gl.glBegin(GL.GL_QUADS);
        gl.glTexCoord2f(0.0F, 0.0F);
        gl.glVertex3f(-1.0F, -1.0F, -1.0F);
        gl.glTexCoord2f(1.0F, 0.0F);
        gl.glVertex3f(1.0F, -1.0F, -1.0F);
        gl.glTexCoord2f(1.0F, 1.0F);
        gl.glVertex3f(1.0F, 1.0F, -1.0F);
        gl.glTexCoord2f(0.0F, 1.0F);
        gl.glVertex3f(-1.0F, 1.0F, -1.0F);
        gl.glEnd();
        gl.glPopMatrix();
        gl.glDisable(GL.GL_BLEND);
    }


    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

    @Override
    public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (gameState.getGameState()) {
            case "start": {
            }
            break;
            case "instruction": {

            }
            break;
            case "chooseMode": {
            }
            break;
            case "chooseNumberOfPlayers": {
            }
            break;
            case "chooseModeFor2Players": {
            }
            break;
            case "startPlay": {
                if (gameplayState.isLose) {
                }
             else if (gameplayState.isPaused) {

                }
             else{
             }
            }
            break;

            default:
                System.out.println("Unknown state.");
                break;

            }



    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}
