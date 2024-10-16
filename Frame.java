import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Frame extends JFrame {
    Pixels canvas;
    JLabel l1;
    JLabel l2;
    JTextField inp1;
    JTextField inp2;
    JButton btn;
    JButton rbtn;

    ActionListener pressed = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            double x0, y0;

            try {
                x0 = Float.parseFloat(inp1.getText());
                y0 = Float.parseFloat(inp2.getText());

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                return;
            }

            canvas.update_pixels(new JuliaSet(x0, y0));
        }
    };


    ActionListener rand_pressed = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Random rand = new Random();

            double x0 = Math.round(rand.nextDouble(-1.0, 1.0) * 100000.0) / 100000.0;
            double y0 = Math.round(rand.nextDouble(-1.0, 1.0) * 100000.0) / 100000.0;

            inp1.setText(String.valueOf(x0));
            inp2.setText(String.valueOf(y0));

            canvas.update_pixels(new JuliaSet(x0, y0));
        }
    };

    public Frame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(null);

        setSize(850, 700);
        setResizable(false);

        canvas = new Pixels();
        canvas.setBackground(Color.black);
        canvas.setBounds(25, 25, 600, 600);
        add(canvas);

        l1 = new JLabel("Re C = ");
        l1.setBounds(650, 50, 50, 20);
        add(l1);

        inp1 = new JTextField();
        inp1.setBounds(700, 50, 80, 20);
        add(inp1);

        l2 = new JLabel("Im C = ");
        l2.setBounds(650, 80, 50, 20);
        add(l2);

        inp2 = new JTextField();
        inp2.setBounds(700, 80, 80, 20);
        add(inp2);

        btn = new JButton("Draw");
        btn.setBounds(670, 120, 100, 30);
        add(btn);
        btn.addActionListener(pressed);

        rbtn = new JButton("Random");
        rbtn.setBounds(670, 160, 100, 30);
        add(rbtn);
        rbtn.addActionListener(rand_pressed);

        setVisible(true);
    }
}
