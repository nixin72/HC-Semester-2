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

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class SaveAsFileChooser extends JFileChooser {
    private static final long serialVersionUID = 1L;

    public File getSelectedFile() {
        File file = super.getSelectedFile();
        if (file != null) {
            final Filterable filter = (Filterable)getFileFilter();
            String fileName = file.getPath();
            final String extension = "." + filter.getExtension().toLowerCase();
            if (fileName.toLowerCase().indexOf(extension) == -1) {
                fileName = fileName + extension;
                file = new File(fileName);
            }
        }
        return file;
    }

    public void approveSelection() {
        File file = getSelectedFile();
        final Filterable filter = (Filterable)getFileFilter();
        String fileName = file.getPath();
        final String extension = "." + filter.getExtension().toLowerCase();
        if (fileName.toLowerCase().indexOf(extension) == -1) {
            fileName = fileName + extension;
            file = new File(fileName);
        }
        if (file.exists()) {
            final int result = AudioOptionPane.showConfirmDialog(this,
                 "'" + file + "' already exists.\nOverwrite?",
                 "Save As", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION)
                super.approveSelection();
        } else {
            super.approveSelection();
        }
    }
}
