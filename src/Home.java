import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.*;

            class  Window extends  JFrame {

                JTextField jt, jt1, jt2, jt3, jt4, jt5, jt6, jt7, jt8, jt9;
                JButton root, clear;
                JLabel jl, jl1, jl2, jl3, jl4, jl5, jl6, jl7, title;

                 Window() {
                     getContentPane().setBackground(Color.DARK_GRAY);
                    jt = new JTextField(20);
                    jt.setBounds(100, 25, 120, 25);
                     add(jt);
                    jt1 = new JTextField(20);
                    jt1.setBounds(100, 60, 120, 25);
                     add(jt1);
                    jt2 = new JTextField(20);
                    jt2.setBounds(100, 95, 120, 25);
                     add(jt2);
                    jt3 = new JTextField(20);
                    jt3.setBounds(100, 130, 120, 25);
                     add(jt3);
                    jt4 = new JTextField(20);
                    jt4.setBounds(100, 165, 120, 25);
                     add(jt4);
                    jt5 = new JTextField(20);
                    jt5.setBounds(100, 200, 120, 25);
                     add(jt5);
                    jt6 = new JTextField(20);
                    jt6.setBounds(100, 235, 120, 25);
                     add(jt6);
                    jt7 = new JTextField(50);
                    jt7.setBounds(250, 305, 200, 25);
                     add(jt7);
                    jt8 = new JTextField(50);
                    jt8.setBounds(250, 340, 200, 25);
                     add(jt8);
                    jt9 = new JTextField(50);
                    jt9.setBounds(250, 375, 200, 25);
                     add(jt9);
                    title = new JLabel("Bisection and Newton and Chord Methods ");
                    title.setBounds(300, 50, 350, 20);
                     add(title);
                    title.setForeground(Color.white);
                    jl = new JLabel("a=");
                    jl.setForeground(Color.white);
                    jl.setBounds(70, 25, 120, 25);
                     add(jl);
                    jl1 = new JLabel("b=");
                    jl1.setForeground(Color.white);
                    jl1.setBounds(70, 60, 120, 25);
                     add(jl1);
                    jl2 = new JLabel("c=");
                    jl2.setForeground(Color.white);
                    jl2.setBounds(70, 95, 120, 25);
                     add(jl2);
                    jl3 = new JLabel("d=");
                    jl3.setForeground(Color.white);
                    jl3.setBounds(70, 130, 120, 25);
                     add(jl3);
                    jl4 = new JLabel("x0=");
                    jl4.setForeground(Color.white);
                    jl4.setBounds(70, 165, 120, 25);
                     add(jl4);
                    jl5 = new JLabel("xN=");
                    jl5.setForeground(Color.white);
                    jl5.setBounds(70, 200, 120, 25);
                     add(jl5);
                    jl6 = new JLabel("e=");
                    jl6.setForeground(Color.white);
                    jl6.setBounds(70, 235, 120, 25);
                     add(jl6);
                    jl7 = new JLabel("Roots");
                    jl7.setForeground(Color.white);
                    jl7.setBounds(270, 270, 120, 25);
                     add(jl7);
                    root = new JButton("Roots");
                    root.setBounds(100, 340, 120, 25);
                     add(root);
                    clear = new JButton("clear");
                    clear.setBounds(100, 375, 120, 25);
                    add(clear);
                    clear.addActionListener(new Listen(jt, jt1, jt2, jt3, jt4, jt5, jt5, jt6,jt7,jt8));
                     root.addActionListener(new Listen(jt, jt1, jt2, jt3, jt4, jt5, jt5, jt6,jt7,jt8));
                      setLayout(null);
                     setVisible(true);
                     setSize(1250, 600);
                     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    Graph  panel= new Graph();

                     panel.setVisible(true);
                     panel.setBackground(Color.white);
                    panel.setBounds(600,50,20,20);
                     panel.setSize(600,500);
                     getContentPane().add(panel);

                }


            }
class Listen implements ActionListener{//реализацич
    JTextField a,b,c,d,ib,ie,e,bi,nt,ch;//параметры
    Listen(JTextField a,JTextField b,JTextField c,JTextField d,JTextField ib,JTextField ie,JTextField e,JTextField bi,JTextField nt,JTextField ch){
        this.a=a;//конструктор передаем параметры
        this.b=b;
        this.c=c;
        this.d=d;
        this.ib=ib;
        this.ie=ie;
        this.e=e;
        this.bi=bi;
        this.nt=nt;
        this.ch=ch;

    }
    public void actionPerformed(ActionEvent act){ //функция что делает кнопка
//a*x*x*x+b*x*x+c*x+d
        float a=Integer.parseInt(this.a.getText());
        float b=Integer.parseInt(this.b.getText());
        float c=Integer.parseInt(this.c.getText());
        float d=Integer.parseInt(this.d.getText());
        float ib = Float.parseFloat(this.ib.getText());
        float ie=Float.parseFloat(this.ie.getText());
        float e=Float.parseFloat(this.e.getText());

        FindRoot rt = new FindRoot(a,b,c,d,ib,ie,e);

        this.bi.setText(String.valueOf(rt.biSection()));
        this.nt.setText(String.valueOf(rt.newton()));
        this.ch.setText(String.valueOf(rt.chord()));


    }
}




class FindRoot  {



float a,b,c,d,ib,ie,e;
    FindRoot(float a, float b, float c, float d, float ib, float ie, float e) {
         this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.ib = ib;
        this.ie = ie;
        this.e = e;
    }


    public float func(float x, float a, float b, float c, float d) {
        return a * x * x * x + b * x * x + c * x + d;
    }

    public float deriv(float x, float a, float b, float c) {

        return 3 * a * x * x + 2 * b * x + c;
    }

   float biSection() {




        if (func(ib, a, b, c, d) * func(ie, a, b, c, d) >= 0) {
            JOptionPane.showMessageDialog(null, "В методе Bisection ,в интервалах [" + ib + "  " + ie + "]  нет корней ");

        }

        float root = ib;
        while ((ie - ib) >= e) {
            // Find middle point
            root = (ib + ie) / 2;
            if (func(root, a, b, c, d) == 0.0) break;

            else if (func(root, a, b, c, d) * func(ib, a, b, c, d) < 0) ie = root;
            else ib = root;
        }
   return root;
    }


float newton() {

        float root = 0;


        float h = func(ib, a, b, c, d) / deriv(ib, a, b, c);
        while (Math.abs(h) >= e) {
            h = func(ib, a, b, c, d) / deriv(ib, a, b, c);

            ib = ib - h;
            root = ib;
        }
      return root;
    }


    float chord() {

        int MAX_ITER = 1000000;
        float root;


        if (func(ib, a, b, c, d) * func(ie, a, b, c, d) >= 0) {
            JOptionPane.showMessageDialog(null, "В Методе Хорд нет  корней ");
        }

        root = ib;

        for (int i = 0; i < MAX_ITER; i++) {

            root = (ib * func(ie, a, b, c, d) - ie * func(ib, a, b, c, d)) / (func(ie, a, b, c, d) - func(ib, a, b, c, d));

            if (func(root, a, b, c, d) == 0) break;


            else if (func(root, a, b, c, d) * func(root, a, b, c, d) < 0) ie = root;
            else ie = root;
        }
      return root;
    }

}


class Graph extends JPanel
{
    private int kd  , oyn  , oxn  , ly , lx , l2;
    private    float  kx , ky ;

    public Graph()
    {
        kd = 10;
        ky = (float)0.5;
        kx = (float)0.5;
        oyn = 15;
        oxn = 25 ;
        ly = 500;
        lx = 500;


    }

    public void paint(Graphics g) {
        super.paint(g);
//y линия
        g.drawLine((int) (lx * kx + oxn), oyn, (int) (lx * kx + oxn), ly + oyn);//y линия
        g.drawLine((int) (lx * kx + oxn), oyn, (int) (lx * kx + oxn) - 3, oyn + 10); //стрелки
        g.drawLine((int) (lx * kx + oxn), oyn, (int) (lx * kx + oxn) + 3, oyn + 10);
        g.drawString("Y", (int) (lx * kx + oxn) - 10, oyn + 12);
        g.drawString("0", (int) (lx * kx + oxn) - 10, (int) (ly * ky + oyn) + 12);

        int l1 = (int) (ly * ky);
        l2 = ly - l1;
        int k1 = (int) l1 / kd;
        int k2 = (int) l2 / kd;
        for (int i = 1; i < k1 + 1; i++) {
            g.drawLine((int) (lx * kx - 2 + oxn), l1 - kd + oyn, (int) (lx * kx + 2 + oxn), l1 - kd + oyn);
            l1 = l1 - kd;
        }
        l1 = ly - l2;
        for (int i = 1; i < k2 + 1; i++) {
            g.drawLine((int) (lx * kx - 2 + oxn), l1 + kd + oyn, (int) (lx * kx + 2 + oxn), l1 + kd + oyn);
            l1 = l1 + kd;
        }
//x линия
        g.drawLine(oxn, (int) (ly * ky + oyn), lx + oxn, (int) (ly * ky + oyn));
        g.drawLine(lx + oxn, (int) (ly * ky + oyn), lx + oxn - 10, (int) (ly * ky + oyn) - 3);
        g.drawLine(lx + oxn, (int) (ly * ky + oyn), lx + oxn - 10, (int) (ly * ky + oyn) + 3);

        g.drawString("Х", lx + oyn - 10, (int) (ly * ky + oyn) - 10);

        l1 = (int) (lx * kx);
        l2 = lx - l1;
        k1 = (int) l1 / kd;
        k2 = (int) l2 / kd;
        for (int i = 1; i < k1 + 1; i++) {

            g.drawLine(l1 - kd + oxn, (int) (ly * ky - 2 + oyn), l1 - kd + oxn, (int) (ly * ky + 2 + oyn));
            l1 = l1 - kd;
        }
        l1 = lx - l2;

        for (int i = 1; i < k2 + 1; i++) {
            g.drawLine(l1 + kd + oxn, (int) (ly * ky - 2 + oyn), l1 + kd + oxn, (int) (ly * ky + 2 + oyn));
            l1 = l1 + kd;
        }
    }}



public class Home {
    public static void main(String[] args){

Window hm = new Window();
    hm.setVisible(true);


    }
}
