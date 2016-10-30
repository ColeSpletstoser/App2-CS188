package cs188.doggydate;

import java.io.Serializable;

/**
 * Created by Spletz on 10/28/16.
 */

public class Profile implements Serializable{
    private String dogName;
    private String dogBreed;
    private char dogGender;
    private String dogDescription;
    private int dogPicture;

    private String ownerName;
    private String ownerDescription;
    private int ownerPicture;

    public Profile(String dName, String dBreed, char dGender, String dDescription, int dPic, String oName, String oDescription, int oPic){
        dogName = dName;
        dogBreed = dBreed;
        dogGender = dGender;
        dogDescription = dDescription;
        dogPicture = dPic;
        ownerName = oName;
        ownerDescription = oDescription;
        ownerPicture = oPic;
    }

    public String getDogName(){
        return dogName;
    }

    public String getDogBreed(){
        return dogBreed;
    }

    public char getDogGender(){
        return dogGender;
    }

    public String getDogDescription(){
        return dogDescription;
    }

    public int getDogPicture(){
        return dogPicture;
    }

    public String getOwnerName(){
        return ownerName;
    }

    public String getOwnerDescription(){
        return ownerDescription;
    }

    public int getOwnerPicture(){
        return ownerPicture;
    }
}
