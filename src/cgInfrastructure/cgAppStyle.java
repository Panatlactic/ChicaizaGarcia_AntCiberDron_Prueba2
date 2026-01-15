package cgInfrastructure;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class cgAppStyle {
    private static final String FONT_FAMILY = "NovaMono";

    private static final Color COLOR_FONT = new Color(220, 0, 0);
    private static final Color COLOR_FONT_LIGHT = new Color(200, 100, 100);
    private static final Color COLOR_CURSOR = Color.black;
    private static final Color COLOR_BORDER = Color.lightGray;

    private static final Font FONT = new Font(FONT_FAMILY, Font.PLAIN, 14);
    private static final Font FONT_SMALL = new Font(FONT_FAMILY, Font.PLAIN, 10);
    private static final Font FONT_BOLD = new Font(FONT_FAMILY, Font.BOLD | Font.PLAIN, 15);

    private static final int ALIGMENT_LEFT = SwingConstants.LEFT;
    private static final int ALIGMENT_RIGHT = SwingConstants.RIGHT;
    private static final int ALIGMENT_CENTER = SwingConstants.CENTER;

    public static final Cursor CURSOR_HAND = new Cursor(Cursor.HAND_CURSOR);
    public static final Cursor CURSOR_DEFAULT = new Cursor(Cursor.DEFAULT_CURSOR);

    private cgAppStyle () {}
    public static final CompoundBorder CEcreateBorderRect () {
        return BorderFactory.createCompoundBorder(new LineBorder(Color.lightGray), new EmptyBorder(5, 5, 5, 5));
    }
}
