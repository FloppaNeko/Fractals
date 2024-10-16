import java.awt.*;;

public class Pixels extends Canvas {

    final static Color[] COLORS = {
            new Color(0, 43, 70),
            new Color(47, 76, 97),
            new Color(10, 71, 167),
            new Color(173, 180, 255),
            new Color(242, 126, 224),
            new Color(253, 15, 142),
            new Color(255, 208, 255),
            new Color(215, 250, 254),
            new Color(127, 193, 248),
            new Color(20, 243, 252),
            new Color(5, 254, 103),
            new Color(1, 242, 75),
            new Color(35, 252, 190),
            new Color(162, 211, 249),
            new Color(197, 197, 194),
            new Color(93, 93, 102),
            new Color(0, 0, 0)
    };

    final static int[] BORDERS = {1, 2, 3, 4, 6, 8, 11, 16, 23, 32, 45, 64, 91, 128, 181, 255};

    Color[][] pxl = new Color[600][600];

    public static Color get_color(int v) {
        for (int i = 0; i < 16; ++i) {
            if (v <= BORDERS[i]) {
                return COLORS[i];
            }
        }

        return COLORS[16];
    }


    public void update_pixels(JuliaSet js) {

        for (int x = 0; x < 600; ++x) {
            for (int y = 0; y < 600; ++y) {
                pxl[x][y] = get_color(js.get_pixel(x, y));
            }
        }

        redraw(getGraphics());
    }

    public void redraw(Graphics g) {
        for (int x = 0; x < 600; ++x) {
            for (int y = 0; y < 600; ++y) {
                g.setColor(pxl[x][y]);
                g.fillRect(x, y, 1, 1);
            }
        }
    }
}
