/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;


import BL.StammBaumBL;
import BL.TableModel;
import family.person.RelationType;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Lukas Schuchlenz
 */
public class StammbaumGUI extends JFrame implements MouseListener{
    
    private TableModel tm;

    public StammbaumGUI() throws HeadlessException {
        super("Stammbaum");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(735, 400));
        initComponents();
    }
private JTextField search = new JTextField();
    private void initComponents() 
    {
        //MenuBar
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
        
        //Container erstellen
        Container cont = this.getContentPane();
        cont.setLayout(new BorderLayout(3, 3));
        
        //Suchspalte
        search.setVisible(true);
        JPanel plSearch = new JPanel(new BorderLayout(3,3));
        ImageIcon imgLupe = new ImageIcon("src/icon/lupe.png");
        imgLupe.setImage(imgLupe.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        JLabel lbLupe = new JLabel();
        lbLupe.addMouseListener(this);
        search.setVisible(false);
        lbLupe.setIcon(imgLupe);
        plSearch.add(lbLupe, BorderLayout.LINE_START);
        plSearch.add(search, BorderLayout.CENTER);
        
        //Add
        ImageIcon imgAdd = new ImageIcon("src/icon/plus.png");
        JButton btAdd = new JButton();
        btAdd.setIcon(imgAdd);
        btAdd.addActionListener(e -> onAdd(e));
        this.setJMenuBar(mbMenu);
        
        //Container befüllen
        JPanel plAdd = new JPanel();
        plAdd.setLayout(new BorderLayout(3,3));
        plAdd.add(plSearch, BorderLayout.NORTH);
        plAdd.add(btAdd, BorderLayout.CENTER);
        cont.add(plAdd, BorderLayout.CENTER);
        cont.add(onShow(), BorderLayout.LINE_END);
        
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

    private void onAdd(ActionEvent e) 
    {
        AddingDLG dlg = new AddingDLG(sbl);
    }
    
    private void onSave() 
    {

    }

    private void onLoad() 
    {

    }

    private void onExit() 
    {

    }
    private JTable tablePersonen = new JTable();
    private Component onShow() 
    {
        tm = sbl.getTableModel();
        JScrollPane sp ;
        tablePersonen.setModel(tm);
        sp = new JScrollPane(tablePersonen);
        sp.setViewportView(tablePersonen); 
        return sp;
    }
    private StammBaumBL sbl = new StammBaumBL();

    @Override
    public void mouseClicked(MouseEvent e) 
    {
        search.setVisible(true);
        this.pack();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }


   
}
