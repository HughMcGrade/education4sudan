/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package education4sudanschoolclient;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Hugh
 * @param <T>
 */
public abstract class SchoolData<T> {
    
    private final String fileLocation;
    protected final ArrayList<T> data;
    private final Type type;
    
    public SchoolData(String fileName, Type collectionType) {
        this.fileLocation = getDataFileLocation(fileName);
        this.type = collectionType;
        data = loadData();
    }
    
    /***
     * @return Json of this data object
     */
    public String getJson() {
        Gson gson = new Gson();
        return gson.toJson(data);
    }
    
    /***
     * 
     * @return 
     */
    private ArrayList<T> loadData() {
            StringBuilder builder = new StringBuilder();
            
            try (BufferedReader fileReader = new BufferedReader (new FileReader(fileLocation))) {
                while (fileReader.ready()) {
                    builder.append(fileReader.readLine());
                    builder.append(System.getProperty("line.separator"));
                }
            }
            catch (FileNotFoundException e) {
                // No inventory file
                createEmptyDataFile();
                return new ArrayList<>();
                // Set builder?
            }
            catch (IOException e) {
                // TODO handle
                return new ArrayList<>();
            }

            String inventoryJSON = builder.toString();
            Gson gson = new Gson();
            //java.lang.reflect.Type collectionType = new TypeToken<ArrayList<T>>(){}.getType();
            ArrayList<T> loadedInventory = gson.fromJson(inventoryJSON, type);
            
            if (loadedInventory == null) {
                return new ArrayList<>();
            }
            else {
                return loadedInventory;
            }
        }
    
    /***
     * Remove item from data at index. Table should then be redrawn.
     * @param index 
     */
    protected void removeItem(final int index) {
         data.remove(index);
         writeData();
    }
    
    /***
     * Add item (probably empty). Table should then be redrawn.
     * @param item 
     */
    protected void addItem(final T item) {
        data.add(item);
        writeData();
    }
    
    protected void setItem(final int index, final T item) {
        data.set(index, item);
        writeData();
    }
    
    protected int getSize() {
        return data.size();
    }
    
    protected T getItem(final int index) {
        return data.get(index);
    }
    
    private void writeData() {
        String json = getJson();

        try (FileWriter writer = new FileWriter(new File(fileLocation))) {
            writer.write(json);
        }
        catch (IOException e) {
            e.printStackTrace();
            // TODO Handle file lost
        }
    }
    
    private void createEmptyDataFile() {
        File newFile = new File(fileLocation);
        try {
            newFile.createNewFile();
        }
        catch (IOException e) {
            e.printStackTrace();
            // TODO Handle wrong path from inventory file location
        }
    }
    
    public static String getDataFileLocation(String fileName) {
        JFileChooser fileChooser = new JFileChooser();
        FileSystemView fileSystemView = fileChooser.getFileSystemView();
        String inventoryFileLocation = fileSystemView.getDefaultDirectory().toString() + File.separator + fileName + ".json";
        return inventoryFileLocation;
    }
}
