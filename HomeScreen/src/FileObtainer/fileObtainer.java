/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileObtainer;

import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;

/**
 *
 * @author Paul
 */
public class fileObtainer {

    static final String rootDirectory = "C:\\Users\\Paul\\Desktop\\memes\\"; // THIS IS THE ROOT DIRECTORY ON THE RASPBERRY PIE TO WHICH ALL FILES WILL BE SAVED. THIS IS AN EXAMPLE.

    static ArrayList<File> picFileList = new ArrayList<>();
    static ArrayList<File> vidFileList = new ArrayList<>();
    
    static ArrayList<String> picNameList = new ArrayList<>();
    static ArrayList<String> vidNameList = new ArrayList<>();

    public void createNames(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                createNames(fileEntry);
            } else if (fileEntry.getName().contains(".avi")) {
                vidNameList.add(fileEntry.getName());
            } else {
                picNameList.add(fileEntry.getName());
            }
        }
    }
    
    public ArrayList<File> getVidFiles(){
       for(int i = 0; i < vidNameList.size(); i++){
            vidFileList.add(new File(rootDirectory + vidNameList.get(i)));
        }
        return vidFileList; 
    }
    
    public ArrayList<File> getPicFiles(){
        for(int i = 0; i < picNameList.size(); i++){
            picFileList.add(new File(rootDirectory + picNameList.get(i)));
        }
        return picFileList;
    }

}
