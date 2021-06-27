/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FeedbackManagement.Table.Models;

import FeedbackManagement.Models.Feedback;
import FeedbackManagement.Models.Response;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Serhat Korkmaz
 */
public class ResponseTableModel extends AbstractTableModel {
   private String[] columnNames = {"Response ID","Answer","Response Date","Status","Feedback ID","Employee ID"};
   private ArrayList<Response> myList = new ArrayList();
   
   
      public ResponseTableModel(List<Response> list){
         this.myList = (ArrayList<Response>) list;
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
      Response response = myList.get(row);
        switch (col) {
            case 0: 
                return response.getResponseID();
            case 1:
                return response.getAnswer();
            case 2:
                return response.getResponseDate();
            case 3:
                return response.getStatus();
            case 4:
                return response.getFeedID();
            case 5:
                return response.getEmpID();
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
               return Date.class;
             case 3:
               return String.class;
             case 4:
               return Integer.class;
             case 5:
               return Integer.class;
             }
             return null;
      }
   
   public String getColumnName(int col) {
      return columnNames[col];
   }
}
