package logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The FileLogger class creates and writes to a text file using various write methods,
 * and closes the file when done.
 */
public class FileLogger implements ILogger{

    private BufferedWriter writer;

    /**
     * Constructs a FileLogger object that writes to the specified file.
     *
     * @param filename the name of the file to write to
     */
    public FileLogger(String filename) {
        try {
            writer = new BufferedWriter(new FileWriter(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes a long value to the file, followed by a newline character.
     *
     * @param param the long value to write
     */
    public void write(long param) {
        try {
            writer.write(Long.toString(param));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes a String to the file, followed by a newline character.
     *
     * @param param the String to write
     */
    public void write(String param) {
        try {
            writer.write(param);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes an array of Objects to the file, separated by spaces and followed by a newline character.
     *
     * @param values the array of Objects to write
     */
    public void write(Object... values) {
        try {
            for (Object obj : values) {
                writer.write(obj.toString() + " ");
            }
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Closes the file writer.
     */
    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is not implemented for this class yet.
     * @param value the value to write
     * @param unit the time unit to use
     */
    public void writeTime(long value, TimeUnit unit){
        //throw new UnsupportedOperationException("This method is not implemented for this class.");
    }

    /**
     * This method is not implemented for this class yet.
     * @param string the string to write
     * @param value the value to write
     * @param unit the time unit to use
     */
    public void writeTime(String string, long value, TimeUnit unit){
        //throw new UnsupportedOperationException("This method is not implemented for this class.");
    }
}

