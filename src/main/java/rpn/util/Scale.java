package rpn.util;

import java.math.MathContext;
import java.math.RoundingMode;

public enum Scale {
    CALCULATION_SCALE(16),
    DISPLAY_SCALE(10);

    public final int scale;

    Scale(int scale) {
        this.scale = scale;
    }
}
