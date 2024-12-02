import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ImageViewer extends JFrame {
    private JLabel imageLabel;
    private JButton loadButton;
    private JScrollPane scrollPane;

    public ImageViewer() {
        setTitle("Photos");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        imageLabel = new JLabel("", SwingConstants.CENTER);
        imageLabel.setVerticalAlignment(SwingConstants.TOP);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        scrollPane = new JScrollPane(imageLabel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane, BorderLayout.CENTER);

        loadButton = new JButton("Buka file");
        add(loadButton, BorderLayout.SOUTH);

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadImage();
            }
        });
    }

    private void loadImage() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
                "Image Files", "jpg", "jpeg", "png", "gif"));

        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());

            imageLabel.setIcon(imageIcon);
            imageLabel.setPreferredSize(new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight()));
            imageLabel.revalidate();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ImageViewer viewer = new ImageViewer();
            viewer.setVisible(true);
        });
    }
}
