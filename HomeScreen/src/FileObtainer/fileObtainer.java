/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileObtainer;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Paul
 */
public class fileObtainer {
    
    // OBTAINS ALL THE FILES IN A GIVEN DIRECTORY
    // NOT CURRENTLY USED, CHECK login.interface FOR (ArrayList<File> fileDirectories)
    // static final String rootDirectory = "C:\\Users\\Paul\\Desktop\\memes\\"; THIS IS THE ROOT DIRECTORY ON THE RASPBERRY PIE TO WHICH ALL FILES WILL BE SAVED. THIS IS AN EXAMPLE.

    static ArrayList<File> picFileList = new ArrayList<>();
    static ArrayList<File> vidFileList = new ArrayList<>();
   
    /**
     * Separates an arraylist of assorted files into ArrayList<File> of varying file types
     * @param files The ArrayList to be sorted.
     */
    public void sortFiles(ArrayList<File> files) {
        for (File fileEntry : files) {
            if (fileEntry.getName().contains(".avi")) { //IMPORTANT: CHANGE TO OTHER FILE FORMAT IF NEED BE
                vidFileList.add(fileEntry);
            } else {
                picFileList.add(fileEntry);
            }
        }
    }

    /**
     * Returns the picture ArrayList.
     * @return The picture ArrayList
     */
    public static ArrayList<File> getPicFileList() {
        return picFileList;
    }

    /**
     * Returns the video ArrayList.
     * @return The video ArrayList
     */
    public static ArrayList<File> getVidFileList() {
        return vidFileList;
    }
    
    
}
