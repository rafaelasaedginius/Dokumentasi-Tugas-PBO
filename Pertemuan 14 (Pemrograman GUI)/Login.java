import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login {
    String Username = "rafaelasa";
    String Password = "maingui";
    String msg = " ";

    JTextField txtUsername;
    JPasswordField txtPassword;

    public static void main(String[] args) {
        Login gui = new Login();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame("Login Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 10, 10));

        JLabel lblUsername = new JLabel("Username:");
        JLabel lblPassword = new JLabel("Password:");

        txtUsername = new JTextField(20);
        txtPassword = new JPasswordField(20);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new LoginListener());

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new CancelListener());

        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(btnLogin);
        panel.add(btnCancel);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setSize(400, 150);
        frame.setVisible(true);
    }

    public class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (Username.equals(txtUsername.getText())) {
                if (Password.equals(new String(txtPassword.getPassword()))) {
                    msg = "Login Berhasil";
                } else {
                    msg = "Login Gagal";
                }
            } else {
                msg = "Login Gagal";
            }
            JOptionPane.showMessageDialog(null, msg);
        }
    }

    public class CancelListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            txtUsername.setText("");
            txtPassword.setText("");
            txtUsername.requestFocus();
        }
    }
}