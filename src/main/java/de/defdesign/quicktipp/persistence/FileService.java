package de.defdesign.quicktipp.persistence;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.TreeSet;

public class FileService {

    public void saveToDisk(Set<Integer> set) {
        try (PrintWriter writer = new PrintWriter(new File("blacklist.usr"))) {
            set.forEach(x -> writer.println(x));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public Set<Integer> readFromDisk() {
        TreeSet<Integer> set = new TreeSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("blacklist.usr"))) {
            while (reader.ready()) {
                set.add(Integer.parseInt(reader.readLine()));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return set;
    }

    public void fileInitializer(){
        try {
            Path pathFile = Paths.get("blacklist.usr");
            System.out.println(pathFile.toAbsolutePath());
            if (!Files.exists(pathFile)) {
                Files.createFile(pathFile);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
