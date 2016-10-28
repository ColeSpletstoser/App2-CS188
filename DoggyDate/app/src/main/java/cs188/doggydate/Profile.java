package cs188.doggydate;

/**
 * Created by Spletz on 10/28/16.
 */

public class Profile {
    private String dogName;
    private String dogBreed;
    private char dogGender;
    private String dogDescription;
    private String dogPicture;

    private String ownerName;
    private String ownerDescription;
    private String ownerPicture;

    public Profile(String dName, String dBreed, char dGender, String dDescription, String dPic, String oName, String oDescription, String oPic){
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

    public String getDogPicture(){
        return dogPicture;
    }

    public String getOwnerName(){
        return ownerName;
    }

    public String getOwnerDescription(){
        return ownerDescription;
    }

    public String getOwnerPicture(){
        return ownerPicture;
    }
}
