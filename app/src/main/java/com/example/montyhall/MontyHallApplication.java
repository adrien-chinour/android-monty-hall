package com.example.montyhall;

import android.app.Application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MontyHallApplication extends Application {

    int winningDoor = 0;

    /**
     * Getter for global application variable winningDoor
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
     * Setter for global application variable winningDoor
     * Set a random integer between 1 and 3
     */
    public void setWinningDoor() {
        Random randomGenerator = new Random();
        this.winningDoor = randomGenerator.nextInt(3) + 1;
    }

    public List<Integer> getDoors(int choosenDoor) {
        List<Integer> doors = new ArrayList<>();
        doors.add(getWinningDoor());

        // select the other door to display with the winning door
        int otherDoor;
        if (winningDoor == choosenDoor) {
            otherDoor = winningDoor % 3 + 1; // select next door
        } else {
            otherDoor = choosenDoor;
        }
        doors.add(otherDoor);

        // sort for doors in correct order
        Collections.sort(doors);

        return doors;
    }

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
