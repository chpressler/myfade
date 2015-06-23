package com.jensui.projects.fade.actions;

import com.jensui.projects.fade.FaDE;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import org.apache.commons.io.FileUtils;

public class FileMoveAction extends AbstractAction {

    private static final long serialVersionUID = 1L;

    public void actionPerformed(ActionEvent e) {
        for (File source : FaDE.getInstance().getSelectedFaDEComponent().getIExplorerComponent().getSelectedFiles()) {
            try {
                File destination = new File(FaDE.getInstance().getUnselectedFaDEComponent().getIExplorerComponent().getCurrentDirectory().getAbsolutePath() + "/" + source.getName());
                int x = 0;
                while (destination.exists()) {
                    x++;
                    destination = new File(FaDE.getInstance().getUnselectedFaDEComponent().getIExplorerComponent().getCurrentDirectory().getAbsolutePath() + "/" + "(" + x + ") " + source.getName());
                }
                if (source.isDirectory()) {
                    destination.mkdir();
                    FileUtils.moveDirectory(source, destination);
                    FileUtils.deleteDirectory(source);
                } else {
                    destination.createNewFile();
                    FileUtils.moveFile(source, destination);
                }
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        }
        FaDE.getInstance().repaint();
    }

}