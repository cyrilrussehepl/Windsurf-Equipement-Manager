package Model;

import Windsurf.*;
import Windsurf.Foil.Foil;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.apache.commons.lang3.*;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Model implements Serializable {
    //Variables---------------------------------------------------------------------------------------------------------
    private static Model instance;
    private ArrayList<Board> boards = new ArrayList<Board>();
    private ArrayList<Sail> sails = new ArrayList<Sail>();
    private ArrayList<Wishbone> wishbones = new ArrayList<Wishbone>();
    private ArrayList<Mast> masts = new ArrayList<Mast>();
    private ArrayList<Fin> fins = new ArrayList<Fin>();
    private ArrayList<Foil> foils = new ArrayList<Foil>();

    //Constructors------------------------------------------------------------------------------------------------------
    private Model() {

    }

    public static Model getInstance() {
        if (instance == null)
            instance = new Model();
        return instance;
    }

    //Methods-----------------------------------------------------------------------------------------------------------
    //Boards
    public void addBoard(Board board) {
        boards.add(board);
    }

    public void removeBoard(int index) {
        boards.remove(index);
    }

    public void updateBoard(int index, Board board) {
        boards.set(index, board);
    }

    public ArrayList<Board> getBoards() {
        return boards;
    }

    //Sails
    public void addSail(Sail sail) {
        sails.add(sail);
    }

    public void removeSail(int index) {
        sails.remove(index);
    }

    public void updateSail(int index, Sail sail) {
        sails.set(index, sail);
    }

    public ArrayList<Sail> getSails() {
        return sails;
    }

    //Wishbone
    public void addWishboon(Wishbone wishbone) {
        wishbones.add(wishbone);
    }

    public void removeWishboon(int index) {
        wishbones.remove(index);
    }

    public void updateWishboon(int index, Wishbone wishbone) {
        wishbones.set(index, wishbone);
    }

    public ArrayList<Wishbone> getWishboons() {
        return wishbones;
    }

    //Mast
    public void addMast(Mast mast) {
        masts.add(mast);
    }

    public void removeMast(int index) {
        masts.remove(index);
    }

    public void updateMast(int index, Mast mast) {
        masts.set(index, mast);
    }

    public ArrayList<Mast> getMasts() {
        return masts;
    }

    //Fin
    public void addFin(Fin fin) {
        fins.add(fin);
    }

    public void removeFin(int index) {
        fins.remove(index);
    }

    public void updateFin(int index, Fin fin) {
        fins.set(index, fin);
    }

    public ArrayList<Fin> getFins() {
        return fins;
    }

    //Foil
    public void addFoil(Foil foil) {
        foils.add(foil);
    }

    public void removeFoil(int index) {
        foils.remove(index);
    }

    public void updateFoil(int index, Foil foil) {
        foils.set(index, foil);
    }

    public ArrayList<Foil> getFoils() {
        return foils;
    }

    public void save(String filename) {
        try {
            FileOutputStream fos = new FileOutputStream(new File(filename));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(boards);
            oos.writeObject(sails);
            oos.writeObject(wishbones);
            oos.writeObject(masts);
            oos.writeObject(fins);
            oos.flush();
            oos.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Invalid save file");
        } catch (IOException e) {
            System.out.println("Error io");
        }
    }

    public void load(String filename) {
        try {
            FileInputStream fis = new FileInputStream(new File(filename));
            ObjectInputStream ois = new ObjectInputStream(fis);
            boards = (ArrayList<Board>) ois.readObject();
            sails = (ArrayList<Sail>) ois.readObject();
            wishbones = (ArrayList<Wishbone>) ois.readObject();
            masts = (ArrayList<Mast>) ois.readObject();
            fins = (ArrayList<Fin>) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Invalid load file");
        } catch (IOException e) {
            System.out.println("Io exception");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
    }

    public void loadCSV(){
        try(CSVReader reader = new CSVReader(new FileReader(System.getProperty("user.dir")+"\\test.csv")))
        {
            reader.readNext();

            List<String[]> lignes = reader.readAll();
            for(String[] ligne : lignes)
            {
                int year = Integer.parseInt(ligne[0]);
                String model = ligne[1];
                String brand = ligne[2];
                Equipment.Discipline discipline = null;
                switch (ligne[3]){
                    case "SLALOM" -> discipline = Equipment.Discipline.SLALOM;
                    case "RACE" -> discipline = Equipment.Discipline.RACE;
                    case "FREERACE" -> discipline = Equipment.Discipline.FREERACE;
                    case "FREERIDE" -> discipline = Equipment.Discipline.FREERIDE;
                    case "FREESTYLE" -> discipline = Equipment.Discipline.FREESTYLE;
                    case "WAVE" -> discipline = Equipment.Discipline.WAVE;
                }
                int volume = Integer.parseInt(ligne[4]);
                int width = Integer.parseInt(ligne[5]);
                Fin.BoxType boxType = null;
                switch (ligne[6]){
                    case "DEEP_TUTTLE" -> boxType = Fin.BoxType.DEEP_TUTTLE;
                    case "TUTTLE" -> boxType = Fin.BoxType.TUTTLE;
                    case "POWER_BOX" -> boxType = Fin.BoxType.POWER_BOX;
                }
                Equipment.Category category = null;
                switch (ligne[7]){
                    case "PLANCHE" -> category = Equipment.Category.PLANCHE;
                    case "FOIL" -> category = Equipment.Category.FOIL;
                    case "BOTH" -> category = Equipment.Category.BOTH;
                }
                addBoard(new Board(year, brand, category, volume, width, model));
            }
        }
        catch (IOException | CsvException e)
        {
            System.out.println("Probleme avec le fichier csv");
        }
    }

}
