package Model;

import Windsurf.*;
import Windsurf.Foil.*;

import java.util.ArrayList;

public class Model {
    //Variables---------------------------------------------------------------------------------------------------------
    private ArrayList<Board> boards = new ArrayList<Board>();
    private ArrayList<Sail> sails = new ArrayList<Sail>();
    private ArrayList<Wishboon> wishboons = new ArrayList<Wishboon>();
    private ArrayList<Mast> masts = new ArrayList<Mast>();
    private ArrayList<Fin> fins = new ArrayList<Fin>();
    private ArrayList<Foil> foils = new ArrayList<Foil>();

    //Constructors------------------------------------------------------------------------------------------------------
    public Model(){

    }

    //Methods-----------------------------------------------------------------------------------------------------------
    //Boards
    public void addBoard(Board board){
        boards.add(board);
    }

    public void removeBoard(int index){
        boards.remove(index);
    }

    public void updateBoard(int index, Board board){
        boards.set(index, board);
    }

    public ArrayList<Board> getBoards(){
        return boards;
    }

    //Sails
    public void addSail(Sail sail){
        sails.add(sail);
    }

    public void removeSail(int index){
        sails.remove(index);
    }

    public void updateSail(int index, Sail sail){
        sails.set(index, sail);
    }

    public ArrayList<Sail> getSails(){
        return sails;
    }

    //Wishboon
    public void addWishboon(Wishboon wishboon){
        Model.this.wishboons.add(wishboon);
    }

    public void removeWishboon(int index){
        wishboons.remove(index);
    }

    public void updateWishboon(int index, Wishboon wishboon){
        Model.this.wishboons.set(index, wishboon);
    }

    public ArrayList<Wishboon> getWishboons(){
        return wishboons;
    }

    //Mast
    public void addMast(Mast mast){
        Model.this.masts.add(mast);
    }

    public void removeMast(int index){
        masts.remove(index);
    }

    public void updateMast(int index, Mast mast){
        Model.this.masts.set(index, mast);
    }

    public ArrayList<Mast> getMasts(){
        return masts;
    }

    //Fin
    public void addFin(Fin fin){
        Model.this.fins.add(fin);
    }

    public void removeFin(int index){
        fins.remove(index);
    }

    public void updateFin(int index, Fin fin){
        Model.this.fins.set(index, fin);
    }

    public ArrayList<Fin> getFins(){
        return fins;
    }

    //Foil
    public void addFoil(Foil foil){
        Model.this.foils.add(foil);
    }

    public void removeFoil(int index){
        foils.remove(index);
    }

    public void updateFoil(int index, Foil foil){
        Model.this.foils.set(index, foil);
    }

    public ArrayList<Foil> getFoils(){
        return foils;
    }
}
