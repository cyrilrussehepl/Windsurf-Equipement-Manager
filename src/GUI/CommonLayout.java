package GUI;

import Windsurf.Equipment;
import Windsurf.Fin;
import Windsurf.Mast;

import javax.swing.*;

import java.time.LocalDate;

public class CommonLayout {
    public static void addYearItem(JComboBox comboBoxYear){
        for(Integer i = LocalDate.now().getYear(); i>=2000; i--)
            comboBoxYear.addItem(i.toString());
    }
    public static void addNCamberItem(JComboBox comboBoxNCamber){
        for(Integer i = 0; i<5; i++)
            comboBoxNCamber.addItem(i.toString());
    }

    public static int yearIndexToDate(int index){
        return LocalDate.now().getYear()-index;
    }

    public static void addDisciplineItem(JComboBox comboBoxDiscipline){
        for (Equipment.Discipline disciplines: Equipment.Discipline.values())
            comboBoxDiscipline.addItem(disciplines.name());
    }

    public static void addMastCurveItem(JComboBox comboBoxMastCurve){
        for (Mast.Curve curves: Mast.Curve.values())
            comboBoxMastCurve.addItem(curves.name());
    }

    public static void addCategoryItem(JComboBox comboBoxCategory){
        for (Equipment.Category category: Equipment.Category.values())
            comboBoxCategory.addItem(category.name());
    }

    public static void addBoxTypeItem(JComboBox comboBoxBoxType){
        for (Fin.BoxType fin: Fin.BoxType.values())
            comboBoxBoxType.addItem(fin.name());
    }

}
