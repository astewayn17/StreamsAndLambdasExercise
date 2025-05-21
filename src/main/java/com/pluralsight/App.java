package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        ArrayList<Character> characters = new ArrayList<Character>();
        characters.add(new Character("Luke Skywalker", 172, 77, "blue", "male"));
        characters.add(new Character("Darth Vader", 202, 136, "yellow", "male"));
        characters.add(new Character("Leia Organa", 150, 49, "brown", "female"));
        characters.add(new Character("Anakin Skywalker", 188, 84, "blue", "male"));

        // 1. Print names in UPPERCASE using map and forEach
        // Maps transform each element in the stream into something else
        characters.stream() // Every time it maps over a character (c), get its name and makes it upper case
                .map(c -> c.getName().toUpperCase())
                .forEach(n -> System.out.println(n));

        // 2. Filter characters with mass > 80 using .filter and .collect(Collectors.toList())
        // store the results in a variable called heavyCharacters and display the new list
        //Making a new list of heavy characters
        //We are using streams and the filter method to ask if the mass is > 80
        //If it is they get added to the new list, if not they are omitted from the new list
        List<Character> heavyCharacters = characters.stream()
                .filter(character -> character.getMass() > 80)
                .toList();
        //Looping over the heavyCharacters to display the list
        heavyCharacters.forEach(character -> System.out.println(character.getName() + " " + character.getMass()));

        // 3. Create a new list of just character names using .map and .collect(Collectors.toList())
        // the new list should be called names. Display the new list with a loop
        List<String> names = characters.stream()
                .map(character -> character.getName())
                .collect(Collectors.toList());
        names.forEach(name -> System.out.println(name));

        // 4. Use anyMatch to check for blue eyes and let us know if any character has blue eyes
        boolean hasBlueEyes = characters.stream()
                .anyMatch(character -> character.getEyeColor().equalsIgnoreCase("blue"));
        if (hasBlueEyes) System.out.println("One or more characters have blue eyes.");
        else System.out.println("No characters have blue eyes.");

        // 5. Use allMatch to check if all are male and let us know if all characters are male
        boolean allMale = characters.stream()
                .allMatch(character -> character.getGender().equalsIgnoreCase("male"));
        if (allMale) System.out.println("All the characters are male.");
        else System.out.println("There is at least one female.");

        // 6. Use .mapToInt and .sum to calculate total mass of all characters and then display the total mass
        int totalMass = characters.stream()
                .mapToInt(character -> character.getMass())
                .sum();
        System.out.println("The total mass is: " + totalMass);
        System.out.println("The average mass is: " + totalMass / characters.size());
    }
}
