import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


/**
 * Implements the user interface here
 */
public class gui extends JFrame implements WindowListener{

    private String selectedQuality;
    private String status = "Video not Found";

    public gui(){
        // Implement the user interface here
        super("Youtube Downloader");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        addWindowListener(this);
        addGuiComponent();
    }
    
    private void addGuiComponent(){

        // Implements a banner on the top left
        JLabel bannerLabel = new JLabel("YouTube Video Downloader by heyimmitzu -------- AlphaBuild" ); 
        bannerLabel.setBounds(20, 20, 1000, 25);
        add(bannerLabel);

        //Implement the search bar
        JTextField searchBar = new JTextField();
        searchBar.setBounds(20, 50, 850, 25);
        searchBar.setFont(new Font("Dialog", Font.PLAIN, 13));
        add(searchBar);

        //Implements the search button
        JButton searchButton = new JButton("Search");
        searchButton.setBounds(880, 50, 100, 25);
        add(searchButton);
        
        //Implements quality select banner
        JLabel bannerQuality = new JLabel("Quality Setting: " ); 
        bannerQuality.setBounds(20, 90, 150, 25);
        add(bannerQuality);

        //Implements the quality checkboxes in a seperate method (to clean up code)
        addGuiQualityBoxes();

        //Implements a status to see if the video was found
        JLabel statusLabel = new JLabel("Status: " + status);
        statusLabel.setBounds(20, 120, 150, 25);
        add(statusLabel);

        //Implements the download button
        JButton downloadButton = new JButton("Download");
        downloadButton.setBounds(880, 120, 100, 25);
        add(downloadButton);
    }

    private void addGuiQualityBoxes()
    {
        //Creates the quality check box
        JCheckBox   qualityBox480p = new JCheckBox("480p");
        JCheckBox   qualityBox720p = new JCheckBox("720p");
        JCheckBox   qualityBox1080p = new JCheckBox("1080p");
        qualityBox480p.setBounds(120, 90, 75, 25);
        qualityBox720p.setBounds(190, 90, 75, 25);
        qualityBox1080p.setBounds(260, 90,75, 25);

        // Creates a ButtonGroup to ensure only one quality checkbox can be selected at a time
        // Loops through the quality checkboxes and adds them to the ButtonGroup and GUI
        // Also adds an ActionListener to each checkbox to keep track of the selected quality
        ButtonGroup qualityGroup = new ButtonGroup();
        JCheckBox[] qualityBoxes = { qualityBox480p, qualityBox720p, qualityBox1080p };
        for (JCheckBox box : qualityBoxes) {
            qualityGroup.add(box);
            add(box);
            box.addActionListener(e -> {
                // If the checkbox is selected, set the selected quality to the text of the checkbox
                if (box.isSelected()) {
                    selectedQuality = box.getText();
                }
            });
        }        
    }

    //Getter for selected Quality
    public String getSelectedQuality() {
        return selectedQuality;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    // WindowListener methods --> only window closing is needed, other methods are not needed, working on a better solution
    @Override
    public void windowOpened(WindowEvent e) {
        // Not needed in this case
    }

    @Override
    public void windowClosing(WindowEvent e) {
        mainApp.destroyProcess();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        // Not needed in this case
    }

    @Override
    public void windowIconified(WindowEvent e) {
        // Not needed in this case
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // Not needed in this case
    }

    @Override
    public void windowActivated(WindowEvent e) {
        // Not needed in this case
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // Not needed in this case
    }
}