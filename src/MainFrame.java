import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JPanel jpnc = new JPanel(new GridLayout(2, 2, 3, 3));
    private JPanel jpnp = new JPanel(new GridLayout(4, 4, 3, 3));
    private JLabel jlb = new JLabel(" ", JLabel.RIGHT);
    private ImageIcon icon0 = new ImageIcon("0.png");
    private ImageIcon icon1 = new ImageIcon("1.png");
    private ImageIcon icon2 = new ImageIcon("2.png");
    private ImageIcon icon3 = new ImageIcon("3.png");
    private ImageIcon icon4 = new ImageIcon("4.png");
    private ImageIcon icon5 = new ImageIcon("5.png");
    private ImageIcon icon6 = new ImageIcon("6.png");
    private ImageIcon icon7 = new ImageIcon("7.png");
    private ImageIcon icon8 = new ImageIcon("8.png");
    private ImageIcon icon9 = new ImageIcon("9.png");
    private JButton jbtn[][] = new JButton[4][5];
    private Container cp;
    int op = -1;
    double v1 = 0;
    double v2 = 0;
    ImageIcon image[] = new ImageIcon[10];

    public MainFrame() {
        this.init();
    }

    public void init() {
        this.setBounds(80, 60, 600, 600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        cp.add(jpnc, BorderLayout.NORTH);
        cp.add(jpnp, BorderLayout.CENTER);
        jpnc.add(jlb);

        jlb.setFont(new Font(null, Font.BOLD, 36));
        jbtn[0][0] = new JButton("");//7
        jbtn[0][1] = new JButton("");//8
        jbtn[0][2] = new JButton("");//9
        jbtn[0][3] = new JButton("/");
        jbtn[0][4] = new JButton("AC");
        jbtn[1][0] = new JButton("");//4
        jbtn[1][1] = new JButton("");//5
        jbtn[1][2] = new JButton("");//6
        jbtn[1][3] = new JButton("*");
        jbtn[1][4] = new JButton("SQRT");
        jbtn[2][0] = new JButton("");//3
        jbtn[2][1] = new JButton("");//2
        jbtn[2][2] = new JButton("");//1
        jbtn[2][3] = new JButton("-");
        jbtn[2][4] = new JButton("PI");
        jbtn[3][0] = new JButton("");//0
        jbtn[3][1] = new JButton(".");
        jbtn[3][2] = new JButton("=");
        jbtn[3][3] = new JButton("+");
        jbtn[3][4] = new JButton("Exit");
        jbtn[0][0].setIcon(icon7);
        jbtn[0][1].setIcon(icon8);
        jbtn[0][2].setIcon(icon9);
        jbtn[1][0].setIcon(icon4);
        jbtn[1][1].setIcon(icon5);
        jbtn[1][2].setIcon(icon6);
        jbtn[2][0].setIcon(icon3);
        jbtn[2][1].setIcon(icon2);
        jbtn[2][2].setIcon(icon1);
        jbtn[3][0].setIcon(icon0);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                jpnp.add(jbtn[i][j]);
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                jbtn[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton jbt = (JButton) e.getSource();
                        switch (jbt.getText()) {
                            case "AC":
                                jlb.setText("0");
                                break;
                            case "PI":
                                jlb.setText(Double.toString(Math.PI));
                                break;
                            case "SQRT":
                                jlb.setText(Double.toString(Math.sqrt(Double.parseDouble(jlb.getText()))));
                                break;
                            case "Exit":
                                System.exit(0);
                                break;
                            case "+":
                                op = 0;
                                v1 = Double.parseDouble(jlb.getText());
                                break;
                            case "-":
                                op = 1;
                                v1 = Double.parseDouble(jlb.getText());
                                break;
                            case "*":
                                op = 2;
                                v1 = Double.parseDouble(jlb.getText());
                                break;
                            case "/":
                                op = 3;
                                v1 = Double.parseDouble(jlb.getText());
                                break;
                            case "=":
                                v2 = Double.parseDouble(jlb.getText());
                                double v3 = 0;
                                switch (op) {
                                    case 0:
                                        v3 = v1 + v2;
                                        break;
                                    case 1:
                                        v3 = v1 - v2;
                                        break;
                                    case 2:
                                        v3 = v1 * v2;
                                        break;
                                    case 3:
                                        v3 = v1 / v2;
                                        break;
                                }
                                jlb.setText(Double.toString(v3));
                                op = -1;
                                break;
                            default:
                                if (jlb.getText().equals("0") || op > -1) {
                                    jlb.setText(jbt.getText());
                                } else {
                                    jlb.setText(jlb.getText() + jbt.getText());
                                }
                                break;
                        }
                    }
                });
            }
        }
    }
}
