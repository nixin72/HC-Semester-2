/**
 * Truth Table Constructor:
 *     generates truth tables for statements in propositional logic
 * Copyright (C) 2006, 2010, 2011  Brian S. Borowski
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 * Email: brian_borowski AT yahoo DOT com
 */

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

public class FontManager {
    private static Font font;

    static {
        final InputStream inputStream =
            FontManager.class.getResourceAsStream("fonts/courier-bold.ttf");
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, inputStream);
        } catch (final FontFormatException ffe) {
            System.err.println("Error: Problem loading font, " + ffe.getMessage());
            loadDefaultFonts();
        } catch (final IOException ioe) {
            System.err.println("Error: Problem loading font, " + ioe.getMessage());
            loadDefaultFonts();
        }
    }

    public static Font getFont(final int style, final float size) {
        return font.deriveFont(style, size);
    }

    private static void loadDefaultFonts() {
        System.out.println("Loading default fonts...");
        font = new Font(Font.MONOSPACED, Font.BOLD, 12);
    }
}
