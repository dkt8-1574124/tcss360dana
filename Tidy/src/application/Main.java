package application;

import java.awt.EventQueue;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * A main class that calls for the frame to be created using the metal look
 * and feel.
 * @author Nick
 * @version Feb 2019
 */
public final class Main {
    /**
     * private constructor to prevent initialization.
     */
    private Main() {
        throw new IllegalStateException();
    }
    /**
     * Sets look and feel and runs GUI.
     * @param theArgs the arguments.
     */
    public static void main(final String[] theArgs) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (final UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (final IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (final InstantiationException ex) {
            ex.printStackTrace();
        } catch (final ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                final MainFrame mainFrame = new MainFrame();
                mainFrame.start();
            }
        });
    }
}
