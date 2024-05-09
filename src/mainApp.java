import javax.swing.SwingUtilities;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class mainApp {
    public static Process process;
    public static void main(String[] args) {
        gui gu = new gui();
        SwingUtilities.invokeLater(new Runnable() {            
            public void run() {
                gu.setVisible(true);
            }           
        });

        //Implemets the python script --> knowngBug --> script isnt closed properly
        
        ProcessBuilder pb = new ProcessBuilder();
        pb.command("/Library/Frameworks/Python.framework/Versions/3.12/bin/python3", new File(".").getAbsolutePath() + "/src/main.py");
        try {
            process = pb.start();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        
    }
    public static void destroyProcess() {
        process.destroy();
    }
}