package com.shazzar.evote.other;

import com.shazzar.evote.entity.Position;

import java.util.Optional;

public class OtherStuff {

    static Position position = new Position();

    public static void main(String[] args) {

        position.getHolder().setFirstName("Daniel");
        position.getHolder().setLastName("Dannie");

        String holderFirstName = position.getHolder().getFirstName();
        String holderLastName = position.getHolder().getFirstName();

        System.out.println(holderFirstName + " " + holderLastName);
    }
}
