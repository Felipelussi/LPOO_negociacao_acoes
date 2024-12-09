/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author felipe
 */
public class ComboBoxHelper {
    
    public static <T> void preencherComboBox(JComboBox<T> comboBox, List<T> items) {
        DefaultComboBoxModel<T> modelo = new DefaultComboBoxModel<>();
        
     
        for (T item : items) {
            modelo.addElement(item);
        }
        
        comboBox.setModel(modelo);
    }
}
