
import com.sun.opengl.util.Animator;
import com.sun.opengl.util.FPSAnimator;

import javax.media.opengl.GLCanvas;
import javax.swing.JFrame;
import java.awt.*;


public class Packman extends JFrame {
    GLCanvas glcanvas = new GLCanvas();
    PackmanListener listener = new PackmanGLEventListener();
    static FPSAnimator animator = null;


    public static void main(String[] args) {
        new Packman();
        animator.start();

    }

    public Packman() {
        setTitle("Packman");
        setSize(700, 700);

        glcanvas.addGLEventListener(listener);
        glcanvas.addMouseListener(listener);
        glcanvas.addMouseMotionListener(listener);
        glcanvas.addKeyListener(listener);

        add(glcanvas, BorderLayout.CENTER);
        animator = new FPSAnimator(glcanvas , 120);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setVisible(true);
        setFocusable(true);
    }
}
