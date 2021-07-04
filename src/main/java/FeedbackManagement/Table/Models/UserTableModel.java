/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FeedbackManagement.Table.Models;

import FeedbackManagement.Models.User;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Serhat Korkmaz
 */
public class UserTableModel extends AbstractTableModel {
   private String[] columnNames = {"User ID","E-Mail","User Type","User Name","User DoB"};
   private ArrayList<User> myList = new ArrayList();
   
   
      public UserTableModel(List<User> list){
         this.myList = (ArrayList<User>) list;
    }
   public int getColumnCount() {
      return columnNames.length;
   }
   public int getRowCount() {
      int size;
      if (myList == null) {
         size = 0;
      }
      else {
         size = myList.size();
      }
      return size;
   }
   public Object getValueAt(int row, int col) {
      User user = myList.get(row);
        switch (col) {
            case 0: 
                return user.getUserID();
            case 1:
                return user.getEmail();
            case 2:
                return user.getUserType();
            case 3:
                return user.getUserName();
            case 4:
                return user.getDateOfBirth();
           }
           return null;
   }
   
    public Class<?> getColumnClass(int columnIndex){
          switch (columnIndex){
             case 0:
               return Integer.class;
             case 1:
               return String.class;
             case 2:
               return Enum.class;
             case 3:
               return String.class;
             case 4:
               return String.class;
             }
             return null;
      }
   
   public String getColumnName(int col) {
      return columnNames[col];
   }
}