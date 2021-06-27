/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FeedbackManagement.Table.Models;

import FeedbackManagement.Models.Feedback;
import FeedbackManagement.Models.User;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Serhat Korkmaz
 */
public class FeedbackTableModel extends AbstractTableModel {
   private String[] columnNames = {"Feedback ID","Message","Status","Employee ID","Department Code","Customer ID","Category ID","Feedback Date"};
   private ArrayList<Feedback> myList = new ArrayList();
   
   
      public FeedbackTableModel(List<Feedback> list){
         this.myList = (ArrayList<Feedback>) list;
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
      Feedback feedback = myList.get(row);
        switch (col) {
            case 0: 
                return feedback.getFeedbackID();
            case 1:
                return feedback.getMessage();
            case 2:
                return feedback.getStatus();
            case 3:
                return feedback.getEmpID();
            case 4:
                return feedback.getDepCode();
            case 5:
                return feedback.getCustomerID();
            case 6:
                return feedback.getCategoryID();
            case 7:
                return feedback.getFeedbackDate();
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
               return String.class;
             case 3:
               return Integer.class;
             case 4:
               return Integer.class;
             case 5:
               return Integer.class;
             case 6:
               return Integer.class;
             case 7:
               return Date.class;
             }
             return null;
      }
   
   public String getColumnName(int col) {
      return columnNames[col];
   }
}
