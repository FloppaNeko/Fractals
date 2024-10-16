public class JuliaSet {
    double cx;
    double cy;

    final double esc_R = 1.5;
    final int max_it = 256;

    public JuliaSet (double cx1, double cy1) {
        cx = cx1;
        cy = cy1;
    }

    public int get_pixel(int x, int y) {
        double zx = (double)(x) * (esc_R / 300.0) - esc_R;
        double zy = (double)(y) * (esc_R / 300.0) - esc_R;

        int it = 0;

        while (zx * zx + zy * zy < esc_R * esc_R  && it < max_it) {
            double xtemp = zx * zx - zy * zy;
            zy = 2 * zx * zy  + cy;
            zx = xtemp + cx;

            it++;
        }

        return it;
    }
}
