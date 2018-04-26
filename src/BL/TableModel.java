/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import family.person.Person;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel
{
    ArrayList<Person> list= new ArrayList<Person>();

    @Override
    public int getRowCount() 
    {
        return list.size();
    }

    @Override
    public int getColumnCount() 
    {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
    { 
        System.out.println("hier");
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        switch(columnIndex)
        {
            case 0: return list.get(rowIndex).getFirstName();
            case 1: return list.get(rowIndex).getLastName();
            case 2: return sdf.format(list.get(rowIndex).getBirthDate());
            case 3: if(!list.get(rowIndex).getDeathDate().equals(null)){return sdf.format(list.get(rowIndex).getDeathDate());}          
        }
        return null;
    }

    String [] daten = {"FirstName", "LastName", "BirthDate", "DeathDate"};
    
    @Override
    public String getColumnName(int column) 
    {
        return daten[column];
    }

    public void add(Person p) 
    {
        list.add(p);
        this.fireTableDataChanged();
    }

    public void listSort(int spalte)
    {
        switch (spalte)
        {

            case 1:
                list.sort((Person e1,Person e2)->{if(e1.getEquivalent()[0]-e2.getEquivalent()[0]==0)
                                                        {
                                                            return e1.getEquivalent()[1]-e2.getEquivalent()[1];
                                                        }
                                                        return e1.getEquivalent()[0]-e2.getEquivalent()[0];
                                                    });
                break;
            case 2:
                list.sort((Person e1,Person e2)->{if(e1.getBirthDate().compareTo(e2.getBirthDate())==0)
                                                        {
                                                            return e1.getLastName().compareTo(e2.getLastName());
                                                        }
                                                        return e1.getBirthDate().compareTo(e2.getBirthDate());
                                                    });
                break;
            case 3:
                list.sort((Person e1,Person e2)->{if(e1.getDeathDate().compareTo(e2.getDeathDate())==0)
                                                        {
                                                            return e1.getLastName().compareTo(e2.getLastName());
                                                        }
                                                        return e1.getBirthDate().compareTo(e2.getBirthDate());
                                                    });
                                                    break;
            case 0:
            default:
                list.sort((Person e1,Person e2)->{if(e1.getLastName().compareTo(e2.getLastName())==0)
                                                            {
                                                                return e1.getFirstName().compareTo(e2.getFirstName());
                                                            }
                                                            return e1.getLastName().compareTo(e2.getLastName());
                                                    });
                break;
        }
    }


    public TableModel(ArrayList<Person> persons)
    {
        this.list = persons;
    }

    
    
}
