package com.mycompany.files;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;
import java.nio.file.Files;

/**
 *
 * @author Alex
 */
public class FileTest 
{
    public static void main(String[] args) 
    {
        JFileChooser fc = new JFileChooser();
        fc.removeChoosableFileFilter(fc.getAcceptAllFileFilter());
        
        FileFilter filter = new FileNameExtensionFilter("CSV File", "csv");
        
        fc.addChoosableFileFilter(filter);
        fc.setFileFilter(filter);
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setMultiSelectionEnabled(false);
        fc.showOpenDialog(null);
        
        //For the constructor of the file object, set the full path of the file as a parameter.
        File file = new File(fc.getSelectedFile().toString());
        
        boolean isSymbolicLink = Files.isSymbolicLink(file.toPath());
        
        JOptionPane.showMessageDialog(null, "Selected file: " + fc.getSelectedFile() + ", Is Symlink: " + isSymbolicLink);
    }
}
