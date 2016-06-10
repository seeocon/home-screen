/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileDownloader;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 068684570
 */
public class dropboxConnect {

    /*
    
    
     static String code;
     static DbxClient client;

     public static void authenticate() {
     // Get your app key and secret from the Dropbox developers website.
     final String APP_KEY = "INSERT_APP_KEY";
     final String APP_SECRET = "INSERT_APP_SECRET";

     DbxAppInfo appInfo = new DbxAppInfo(APP_KEY, APP_SECRET);

     DbxRequestConfig config = new DbxRequestConfig(
     "JavaTutorial/1.0", Locale.getDefault().toString());
     DbxWebAuthNoRedirect webAuth = new DbxWebAuthNoRedirect(config, appInfo);

     String authorizeUrl = webAuth.start();
     System.out.println("1. Go to: " + authorizeUrl);
     System.out.println("2. Click \"Allow\" (you might have to log in first)");
     System.out.println("3. Copy the authorization code.");
     try {
     code = new BufferedReader(new InputStreamReader(System.in)).readLine().trim();
     } catch (IOException ex) {
     Logger.getLogger(dropboxConnect.class.getName()).log(Level.SEVERE, null, ex);
     }
     DbxAuthFinish authFinish = null;
     try {
     authFinish = webAuth.finish(code);
     } catch (DbxException ex) {
     Logger.getLogger(dropboxConnect.class.getName()).log(Level.SEVERE, null, ex);
     }
     String accessToken = authFinish.accessToken;
     client = new DbxClient(config, accessToken);
     try {
     System.out.println("Linked account: " + client.getAccountInfo().displayName);
     } catch (DbxException ex) {
     Logger.getLogger(dropboxConnect.class.getName()).log(Level.SEVERE, null, ex);
     }
     }

     public static DbxEntry.File download() {
     DbxEntry.File downloadedFile = null;
     FileOutputStream outputStream = null;
     try {
     outputStream = new FileOutputStream("magnum-opus.txt");
     } catch (FileNotFoundException ex) {
     Logger.getLogger(dropboxConnect.class.getName()).log(Level.SEVERE, null, ex);
     }
     try {
     downloadedFile = client.getFile("/magnum-opus.txt", null,
     outputStream);
     System.out.println("Metadata: " + downloadedFile.toString());
     } catch (DbxException ex) {
     Logger.getLogger(dropboxConnect.class.getName()).log(Level.SEVERE, null, ex);
     } catch (IOException ex) {
     Logger.getLogger(dropboxConnect.class.getName()).log(Level.SEVERE, null, ex);
     } finally {
     try {
     outputStream.close();
     } catch (IOException ex) {
     Logger.getLogger(dropboxConnect.class.getName()).log(Level.SEVERE, null, ex);
     }
     }
     return downloadedFile;
     }                                                                       
    
     */
    /**
     * Downloads a file from an online directory, preferably Dropbox. This is a
     * simple method, try the commented method above if this fails.
     * @param sourceUrl Direct URL of file to be downloaded.
     * @param targetDirectory Directory the file will be downloaded to
     * @return The location of the file.
     */
    public static Path download(String sourceUrl,
            String targetDirectory) {

        URL url = null;

        try {
            url = new URL(sourceUrl);
        } catch (MalformedURLException ex) {
            Logger.getLogger(dropboxConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

        String fileName = url.getFile();

        Path targetPath = new File(targetDirectory + fileName).toPath();

        try {
            Files.copy(url.openStream(), targetPath,
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(dropboxConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

        return targetPath;
    }

}
