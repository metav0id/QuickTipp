package de.defdesign.quicktipp.persistence;

import de.defdesign.quicktipp.log.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;

public class FileService {

    /**
     * Writes blacklist to harddisk
     * @param set containing Integer values, String containing fileName to be written
     */

    public void saveToDisk(Set<Integer> set, String fileName) {
        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            set.forEach(x -> writer.println(x));
            writer.flush();
        } catch (IOException ioe) {
            new Logger().log(ioe.toString());
        }
    }

    /**
     * Reads a Set containing Integer values from harddisk
     * @return Set <Integer>
     */


    public Set<Integer> readFromDisk(String fileName) {
        TreeSet<Integer> set = new TreeSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                set.add(Integer.parseInt(reader.readLine()));
            }
        } catch (IOException ioe) {
            new Logger().log(ioe.toString());
        }
        return set;
    }

    /**
     * verifies that a specific file exists and creates the file if it doesn't
     * @param fileName containing name of file to be read
     */

    public void fileInitializer(String fileName){
        try {
            Path pathFile = Paths.get(fileName);
            if (!Files.exists(pathFile)) {
                Files.createFile(pathFile);
            }
        } catch (IOException ioe) {
            new Logger().log(ioe.toString());
        }
    }

    /**
     * appends current error and time of occurrence to existing error-log on disk
     * @param errorLog
     */

    public void log(String errorLog) {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(new File("log.txt"), true))) {
            writer.append(LocalDateTime.now().toString()).append(": ");
            writer.append(errorLog).append("\n");
            writer.flush();
        } catch (IOException ioe) {
            new Logger().log(ioe.toString());
        }
    }
}
