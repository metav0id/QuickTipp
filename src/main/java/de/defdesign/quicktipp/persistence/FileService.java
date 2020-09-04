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
     * Writes a Set to harddisk
     * @param set containing Integer values
     */

    public void saveToDisk(Set<Integer> set) {
        try (PrintWriter writer = new PrintWriter(new File("blacklist.usr"))) {
            set.forEach(x -> writer.println(x));
        } catch (IOException ioe) {
            new Logger().log(ioe.toString());
        }
    }

    /**
     * Reads a Set containing Integer values from harddisk
     * @return Set <Integer>
     */


    public Set<Integer> readFromDisk() {
        TreeSet<Integer> set = new TreeSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("blacklist.usr"))) {
            while (reader.ready()) {
                set.add(Integer.parseInt(reader.readLine()));
            }
        } catch (IOException ioe) {
            new Logger().log(ioe.toString());
        }
        return set;
    }

    /**
     * ensures that a specific file exists and can be read
     * @param fileName
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
        try (PrintWriter writer = new PrintWriter(new File("log.txt"))) {
            writer.append(LocalDateTime.now().toString());
            writer.append(errorLog);
        } catch (IOException ioe) {
            new Logger().log(ioe.toString());
        }
    }
}
