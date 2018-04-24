/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import BL.TableModel;
import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ShowPerson extends JDialog
{
    TableModel tm;
    private JTable tablePeronen;
    public ShowPerson(TableModel tm)
    {
        this.tm = tm;
        this.setTitle("Hinzufügen");
        this.setLocationRelativeTo(null);
        this.setPreferredSize(new Dimension(500,300));
        this.add(addTable());
        this.pack();
    }

    private JScrollPane addTable()
    {
        JScrollPane sp ;
        tablePeronen = new JTable();
        tablePeronen.setModel(tm);
        sp = new JScrollPane(tablePeronen);
        sp.setViewportView(tablePeronen); 
        return sp;
    }

}
