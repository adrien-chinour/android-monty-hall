package com.example.montyhall;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MontyHallApplication extends Application {

    int winningDoor = 0;

    /**
     * Permet de récupérer la valeur de la porte gagnante
     * La méthode défini une nouvelle valeur si celle ci est à 0
     *
     * @return int : winningDoor
     */
    public int getWinningDoor() {
        if (this.winningDoor == 0) {
            setWinningDoor();
        }

        return this.winningDoor;
    }

    /**
     * Défini une valeur random pour la porte gagnante entre 1 et 3
     */
    public void setWinningDoor() {
        Random randomGenerator = new Random();
        this.winningDoor = randomGenerator.nextInt(3) + 1;
    }

    /**
     * Permet de récupérer les deux portes à afficher lors de l'étape 2
     *
     * @param choosenDoor : la porte choisi par l'utilisateur
     * @return La liste des deux portes à afficher
     */
    public List<Integer> getDoors(int choosenDoor) {
        List<Integer> doors = new ArrayList<>();
        doors.add(getWinningDoor());

        int otherDoor;
        if (winningDoor == choosenDoor) {
            otherDoor = winningDoor % 3 + 1; // choisi la porte suivant de celle gagnante
        } else {
            otherDoor = choosenDoor;
        }
        doors.add(otherDoor);

        return doors;
    }

    /**
     * Permet de récupérer le texte de la porte en fonction de son numéro
     *
     * @param door le numéro de la porte à afficher
     * @return le texte relatif à la porte
     */
    public String getDoorText(int door) {
        String doorMessage;
        switch (door) {
            case 1:
                doorMessage = getResources().getString(R.string.door_a);
                break;
            case 2:
                doorMessage = getResources().getString(R.string.door_b);
                break;
            case 3:
                doorMessage = getResources().getString(R.string.door_c);
                break;
            default:
                throw new IllegalArgumentException("The number " + door + " not exist");
        }

        return doorMessage;
    }
}
