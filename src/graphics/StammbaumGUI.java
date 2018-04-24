/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import StammbaumBL.StammBaumBL;
import StammbaumBL.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 *
 * @author Lukas Schuchlenz
 */
public class StammbaumGUI extends JFrame {
    
    private TableModel tm = new TableModel();

    public StammbaumGUI() throws HeadlessException {
        super("Stammbaum");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(400, 400));
        initComponents();
    }

    private void initComponents() {
        JMenuBar mbMenu = new JMenuBar();
        JMenu menu = new JMenu("Datei");
        JMenuItem save = new JMenuItem("Speichern");
        JMenuItem load = new JMenuItem("Laden");
        JMenuItem showPerson = new JMenuItem("Personen anzeigen");
        JSeparator sep = new JSeparator();
        JMenuItem exit = new JMenuItem("Schließen");
        save.addActionListener(e -> onSave());
        load.addActionListener(e -> onLoad());
        load.addActionListener(e -> onExit());
        showPerson.addActionListener(e -> onShow());
        menu.add(save);
        menu.add(load);
        menu.add(showPerson);
        menu.add(sep);
        menu.add(exit);
        mbMenu.add(menu);
        Container cont = this.getContentPane();
        cont.setLayout(new BorderLayout(3, 3));
        JTextField search = new JTextField();
        search.setVisible(true);
        JPanel plSearch = new JPanel(new BorderLayout(3,3));
        
        ImageIcon imgLupe = new ImageIcon("src/icon/lupe.png");
        imgLupe.setImage(imgLupe.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        JLabel lbLupe = new JLabel();
        lbLupe.setIcon(imgLupe);
        plSearch.add(lbLupe, BorderLayout.LINE_START);
        plSearch.add(search, BorderLayout.CENTER);
      
        
        ImageIcon imgAdd = new ImageIcon("src/icon/plus.png");
        JButton btAdd = new JButton();
        btAdd.setIcon(imgAdd);
        btAdd.addActionListener(e -> onAdd(e));
        this.setJMenuBar(mbMenu);
        cont.add(plSearch, BorderLayout.NORTH);
        cont.add(btAdd, BorderLayout.CENTER);
        this.pack();
    }

    public static void main(String[] args) 
    {
        new StammbaumGUI().setVisible(true);
    }

    private JPanel paInput = new JPanel();
    private JPanel paDraw = new JPanel();
    private JTextField tfSearch = new JTextField();
    private JButton btHelp = new JButton("Hilfe Tobi hat ka Ahnung");
    private JLabel lbLupe = new JLabel("Das ist eine Lupe");

    private void onAdd(ActionEvent e) {
        new AddingDLG(tm).setVisible(true);
    }
    
    private void onSave() {

    }

    private void onLoad() {

    }

    private void onExit() {

    }

    private void onShow() 
    {
        StammBaumBL sbl = new StammBaumBL();
        tm = sbl.getTableModel();
        new ShowPerson(tm).setVisible(true);
    }

   
}
