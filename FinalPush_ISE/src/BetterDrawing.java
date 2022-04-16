import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class BetterDrawing {

    public static void main(String[] args) {
        new BetterDrawing();
    }

    public BetterDrawing() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                /*try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch () {
                }*/

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new PaintPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class PaintPane extends JPanel {

        private BufferedImage background;

        public PaintPane() {
            try {
                background = ImageIO.read(new File("C:\\Users\\CJohn\\OneDrive\\Desktop\\Intro_SE\\final\\numMy_logo.png"));
                // Use this instead to load embedded resources instead
                //background = ImageIO.read(getClass().getResource("/path/to/image"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return background == null ? super.getPreferredSize() : new Dimension(background.getWidth(), background.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (background != null) {

                int x = (getWidth() - background.getWidth()) / 2;
                int y = (getHeight() - background.getHeight()) / 2;

                g.drawImage(background, x, y, this);

            }

        }
    }
}