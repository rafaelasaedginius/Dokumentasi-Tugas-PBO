import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Calendar;

class ClockDisplay extends JFrame {
    private static final long serialVersionUID = 1L;

    JTextField timeField;
    JPanel panel;

    private TimeDisplay hour;
    private TimeDisplay minute;
    private TimeDisplay second;
    private String currentTimeString;

    public ClockDisplay() {

        setTitle("Display jam");

        hour = new TimeDisplay(24);
        minute = new TimeDisplay(60);
        second = new TimeDisplay(60);

        Calendar now = Calendar.getInstance();
        setTime(now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), now.get(Calendar.SECOND));

        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);

        panel = new JPanel();
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        timeField = new JTextField(20);
        timeField.setEditable(false);
        timeField.setFont(new Font("Comic Sans", Font.BOLD, 24));
        timeField.setHorizontalAlignment(JTextField.CENTER);

        panel.add(timeField);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        add(panel, gbc);

        Timer t = new Timer(1000, new Listener());
        t.start();

        setVisible(true);
    }

    public String getTime() {
        return currentTimeString;
    }

    public void setTime(int hr, int min, int sec) {
        hour.setValue(hr);
        minute.setValue(min);
        second.setValue(sec);
    }

    public void setTimeString() {
        currentTimeString = hour.getDisplayValue() + ":" + minute.getDisplayValue() + ":" + second.getDisplayValue();
    }

    public void secIncrement() {
        second.increment();
        if (second.getValue() == 0) {
            minute.increment();
        }
        if (minute.getValue() == 0 && second.getValue() == 0) {
            hour.increment();
        }
    }

    class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            setTimeString();
            timeField.setText("Pukul : " + currentTimeString);
            secIncrement();
        }
    }

    public static void main(String[] args) {
        new ClockDisplay();
    }
}
