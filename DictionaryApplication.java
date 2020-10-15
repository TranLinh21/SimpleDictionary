import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class DictionaryApplication extends DictionaryManagement{



   public static void runApplication() throws IOException {
       JFrame mainF = new JFrame("Dictionary");
       JLabel title = new JLabel("Dictionary",JLabel.CENTER);
       JButton SearchB = new JButton("Search");
       JTextField SearchT = new JTextField();
       JTextArea ListT = new JTextArea();
       JTextArea TranslateT = new JTextArea();
       JScrollPane ListS = new JScrollPane(ListT);
       JScrollPane TranslateS = new JScrollPane(TranslateT);
       insertFromFile();

       mainF.setSize(670, 400);

       title.setForeground(Color.YELLOW);
       title.setFont( new Font("Thoma",Font.ITALIC,30));
       title.setBounds(0,0,300,50);
       mainF.add(title);

       SearchT.setBounds(10,50,220,30);
       SearchT.addKeyListener(new KeyAdapter() {
           @Override
           public void keyReleased(KeyEvent e) {
               super.keyReleased(e);
               if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                   TranslateT.setText(dictionaryLookup(SearchT.getText()));
               }
               ListT.setText(Search(SearchT.getText(), 50));
           }
       });
       mainF.add(SearchT);

       SearchB.addActionListener(e -> TranslateT.setText(dictionaryLookup(SearchT.getText())));
       SearchB.setBounds(230,50,80,30);
       mainF.add(SearchB);

       ListT.setEditable(false);
       ListS.setBounds(10,80,300, 270);
       mainF.add(ListS);

       TranslateT.setEditable(false);
       TranslateS.setBounds(320,50,320,300);
       mainF.add(TranslateS);

       mainF.setLayout(null);
       mainF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

       mainF.setVisible(true);
   }

    public static void main(String[] args) throws IOException {
        runApplication();
    }
}
