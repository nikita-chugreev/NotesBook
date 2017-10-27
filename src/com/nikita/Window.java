package com.nikita;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.TreeSet;

public class Window extends JFrame {

    private TreeSet treeSet = new TreeSet();

    private JTextField fieldFio;
    private JTextField endFieldFio;
    private JTextField fieldPhone;
    private JTextField endFieldPhone;
    private JTextField count;

    private JButton button;

    private JLabel lblFio;
    private JLabel lblPhone;
    private JLabel lblCount;
    private JLabel endFio;
    private JLabel endPhone;

    private JPanel panelFio;
    private JPanel endFioPanel;
    private JPanel panelPhone;
    private JPanel endPhonePanel;
    private JPanel panelPrint;
    private JPanel firstPanel;
    private JPanel secondPanel;
    private JPanel endFioAndPhone;

    public Window() {

        super("NotesBook");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        setSize(400, 250);
        Container c = getContentPane();


        fieldFio = new JTextField(30);
        fieldPhone = new JTextField(30);
        endFieldFio = new JTextField(30);
        endFieldFio.setEnabled(false);
        endFieldPhone = new JTextField(30);
        endFieldPhone.setEnabled(false);
        count = new JTextField("0", 4);

        lblFio = new JLabel("Фамилия");
        lblPhone = new JLabel("Телефон");
        button = new JButton("Печатать");
        lblCount = new JLabel("Количество записей");
        endFio = new JLabel("Последняя фамилия");
        endPhone = new JLabel("Последний номер");

        firstPanel = new JPanel(new GridLayout(3,1));
        firstPanel.setBorder(BorderFactory.createEtchedBorder());
        panelFio = new JPanel();
        panelPhone = new JPanel();
        panelPrint = new JPanel();
        secondPanel = new JPanel();
        secondPanel.setBorder(BorderFactory.createEtchedBorder());
        endFioPanel = new JPanel();
        endFioAndPhone = new JPanel();
        endPhonePanel = new JPanel();


        panelFio.add(lblFio);
        panelFio.add(fieldFio);
        firstPanel.add(panelFio);


        panelPhone.add(lblPhone);
        panelPhone.add(fieldPhone);
        firstPanel.add(panelPhone);


        panelPrint.add(button);
        firstPanel.add(panelPrint);
        c.add(firstPanel, BorderLayout.NORTH);


        endFioPanel.add(endFio);
        endFioPanel.add(endFieldFio);

        endPhonePanel.add(endPhone);
        endPhonePanel.add(endFieldPhone);
        endFioAndPhone.add(endFioPanel, BorderLayout.NORTH);
        endFioAndPhone.add(endPhonePanel, BorderLayout.SOUTH);
        c.add(endFioAndPhone, BorderLayout.CENTER);

        fieldPhone.addActionListener(e -> {
            Person person = new Person(fieldFio.getText(), fieldPhone.getText());
            endFieldFio.setText(fieldFio.getText());
            endFieldPhone.setText(fieldPhone.getText());
            fieldFio.setText("");
            fieldPhone.setText("");
            treeSet.add(person);
            count.setText("" + treeSet.size());
            fieldFio.requestFocus();
        });

        button.addActionListener(e -> {
            Iterator iterator = treeSet.iterator();
            for (; iterator.hasNext(); ) {
                Person cur = (Person) iterator.next();
                String string = cur.toString();
                try {
                    byte[] bytes = string.getBytes("UTF-8");
                    System.out.write(bytes);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        setLocationRelativeTo(c);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
