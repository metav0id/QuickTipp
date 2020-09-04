package de.defdesign.quicktipp.log;

import de.defdesign.quicktipp.persistence.FileService;

public class Logger {

    /**
     * logs errors to disk
     * @param errorCode containing exception in String form
     */

    public void log(String errorCode) {
        FileService fs = new FileService();
        fs.fileInitializer("log.txt");
        fs.log(errorCode);
    }
}
