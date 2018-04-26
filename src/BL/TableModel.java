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
    private int sortSpalte = 0;

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
            case 3: if(!list.get(rowIndex).getDeathDate().equals(null)){return sdf.format(list.get(rowIndex).getDeathDate());}break;
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

    /**
     * Sortiert Spalte
     * @param spalte 1 --> Nach erstellung 2 --> Geburtsdatum 3 --> Sterbedatum 4 --> Vorname 0 --> NAchname
     */
    public void listSort(int spalte)
    {
        sortSpalte = spalte;
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
                list.sort((Person e1,Person e2)->{
                                                    int help = 0;
                                                    if(e1.getDeathDate() == null)
                                                    {
                                                        help--;
                                                    }
                                                    if(e2.getDeathDate() == null)
                                                    {
                                                        help++;
                                                    }
                                                    if(e1.getDeathDate()==null||e2.getDeathDate()==null)
                                                    {
                                                        return help;
                                                    }
                                                    if(e1.getDeathDate().compareTo(e2.getDeathDate())==0)
                                                        {
                                                            return e1.getLastName().compareTo(e2.getLastName());
                                                        }
                                                        return e1.getBirthDate().compareTo(e2.getBirthDate());
                                                    });
                                                    break;
            case 4:
                list.sort((Person e1,Person e2)->{if(e1.getFirstName().compareTo(e2.getFirstName())==0)
                {
                    return e1.getLastName().compareTo(e2.getLastName());
                }
                    return e1.getFirstName().compareTo(e2.getFirstName());
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
