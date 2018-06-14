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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Lukas Schuchlenz
 */
public class StammbaumGUI extends JFrame implements MouseListener{
    
    private TableModel tm;
    private JPopupMenu pmKontext = new JPopupMenu();


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
        JSeparator sep = new JSeparator();
        JMenuItem exit = new JMenuItem("Schließen");
        save.addActionListener(e -> onSave());
        load.addActionListener(e -> onLoad());
        load.addActionListener(e -> onExit());
        menu.add(save);
        menu.add(load);
        menu.add(sep);
        menu.add(exit);
        mbMenu.add(menu);
        
        JMenuItem miRemove = new JMenuItem("Löschen");
        miRemove.addActionListener(e -> {
            try {
                onRemove();
            } catch (Exception ex) {
            }
        });
        JMenuItem miAdd = new JMenuItem("Hinzufügen");
        miAdd.addActionListener(e -> onAdd(e));
        JMenuItem miEdit = new JMenuItem("Bearbeiten");
        miEdit.addActionListener(e -> onEdit(e));
        pmKontext.add(miEdit);
        pmKontext.add(miAdd);
        pmKontext.add(new JSeparator());
        pmKontext.add(miRemove);

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
    private JPanel onShow() 
    {
        JPanel plShow = new JPanel();
        plShow.setLayout(new BorderLayout(3, 3));
        String [] sorts = new String[]{"Erstellungsdatum", "Vorname", "Nachname", "Geburtsdatum", "Todesdatum"};
        
        JPanel sort = new JPanel();
        sort.setLayout(new GridLayout(1, 2, 1, 1));
        cbSort = new JComboBox(sorts);
        cbSort.addActionListener(e -> onSort());
        sort.add(new JLabel("Sortieren nach: "));
        sort.add(cbSort);
        plShow.add(sort, BorderLayout.NORTH);
        tm = sbl.getTableModel();
        JScrollPane sp ;
        tablePersonen.setModel(tm);
        tablePersonen.addMouseListener(new MouseAdapter() 
        {          
            public void mouseReleased(MouseEvent e) 
            {
                showPopup(e);
            } 
        });
        sp = new JScrollPane(tablePersonen);
        sp.setViewportView(tablePersonen); 
        sp.addMouseListener(new MouseAdapter() 
        {
           
            public void mouseReleased(MouseEvent e) 
            {
                showPopup(e);
            }   
        });
        plShow.add(sp, BorderLayout.CENTER);
        sp.add(pmKontext);
        return plShow;
    }
    private void showPopup(MouseEvent e) 
    {
        pmKontext.show(e.getComponent(), e.getX(), e.getY());
    }
    private JComboBox cbSort; 
    private StammBaumBL sbl = new StammBaumBL();
    private int count = 0;
    @Override
    public void mouseClicked(MouseEvent e) 
    {   if(count == 0)
        {     
            search.setVisible(true);
            count = 1;
        }
        else
        {
            search.setVisible(false);
            count = 0;
        }
        this.pack();
    }

    @Override
    public void mousePressed(MouseEvent e) 
    {
        
    }

    @Override
    public void mouseReleased(MouseEvent evt) 
    {
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    private void onSort() 
    {
        int art;
        String sortArt = (String) cbSort.getSelectedItem();
        if(sortArt.equals("Erstellungsdatum"))
        {
            art = 1;
        }
        else if(sortArt.equals("Vorname"))
        {
            art = 4;
        }
        else if(sortArt.equals("Geburtsdatum"))
        {
            art = 2;
        }
        else if(sortArt.equals("Todesdatum"))
        {
            art = 3;
        }
        else
        {
            art = 0;
        }
        tm.listSort(art);
    }

    private void onRemove() throws Exception 
    {
        int  i = tablePersonen.getSelectedRow();
        sbl.remove(i);
        repaint();
    }

    private void onEdit(ActionEvent e) 
    {
        int i = tablePersonen.getSelectedRow();
        System.out.println(i);
        tm.onEdit(i);
    }
    


   
}
