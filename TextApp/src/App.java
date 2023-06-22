import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class App implements ActionListener {
    JFrame frame;
    JTextArea textArea1, textArea2;
    JButton button;
    JPanel panel;
    Font font = new Font("Times New Roman", Font.BOLD, 20);
    // String imagePath = "C:\\Users\\HP\\Pictures\\icon.png";
    boolean copyToTextArea2 = true;

    public static void main(String[] args) throws Exception {
        App text = new App();
    }

    App() {
        frame = new JFrame("TextApp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(620, 550);
        frame.setLayout(new BorderLayout());
        frame.setBackground(new Color(10, 93, 0));

        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        frame.add(contentPanel, BorderLayout.CENTER);

        JLabel descriptionLabel = new JLabel("Add text and click the button to copy it to the other textarea");
        contentPanel.add(descriptionLabel, BorderLayout.NORTH);

        textArea1 = new JTextArea();
        textArea1.setFont(font);
        textArea1.setBackground(new Color(251, 250, 240));
        textArea1.setEditable(true);
        JScrollPane scrollPane1 = new JScrollPane(textArea1);
        scrollPane1.setPreferredSize(new Dimension(270, 400));
        contentPanel.add(scrollPane1, BorderLayout.WEST);

        textArea2 = new JTextArea();
        textArea2.setFont(font);
        textArea2.setBackground(new Color(255, 229, 217));
        textArea2.setEditable(true);
        JScrollPane scrollPane2 = new JScrollPane(textArea2);
        scrollPane2.setPreferredSize(new Dimension(270, 400));
        contentPanel.add(scrollPane2, BorderLayout.EAST);

        button = new JButton("\u276F");
        button.setPreferredSize(new Dimension(60, 50));
        button.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            if (copyToTextArea2) {
                button.setText("\u276E");
                String text = textArea1.getText();
                textArea2.setText(text);
                textArea1.setText("");
            } else {
                button.setText("\u276F");
                String text = textArea2.getText();
                textArea1.setText(text);
                textArea2.setText("");
            }

            copyToTextArea2 = !copyToTextArea2;
        }
    }
}
