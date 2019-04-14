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
package logic;

public class TruthValue {
    public static int TRUE_FALSE = 0,
                      ZERO_ONE   = 1;

    public static String getTruthValueString(final boolean value, final int displayMethod) {
        String valueString;
        if (displayMethod == TRUE_FALSE) {
            valueString = (value == true) ? "T" : "F";
        } else {
            valueString = (value == true) ? "1" : "0";
        }
        return valueString;
    }
}
