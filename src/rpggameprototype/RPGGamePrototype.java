/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggameprototype;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author c0640780
 */
public class RPGGamePrototype {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Stat declarations
        int STR = 0;
        int DEX = 0;
        int CON = 0;

        int c = 0;
        Scanner keyboard = new Scanner(System.in);
        while (c == 0){
            while (c <= 3){
                // Random number generators for the 3 character stats
                Random rand2 = new Random();
                int randomNum2 = 1 + rand2.nextInt((6 - 1) + 1);
                Random rand3 = new Random();
                int randomNum3 = 1 + rand3.nextInt((6 - 1) + 1);
                
                if (c == 1){
                    STR = (randomNum3 + randomNum2 + 6);
                    System.out.println("STR: " + STR);                  
                } else if (c == 2){
                    DEX = (randomNum3 + randomNum2 + 6);
                    System.out.println("DEX: " + DEX);                   
                } else if (c == 3){
                    CON = (randomNum3 + randomNum2 + 6);
                    System.out.println("CON: " + CON);                   
                }          
                c++;               
            }
            System.out.println("Do you wish to reroll? (0 - yes / 1 - no): ");
            c = keyboard.nextInt();
            
        }
        System.out.println("STR: " + STR);
        System.out.println("DEX: " + DEX);
        System.out.println("CON: " + CON);
        
        // Declarations for player and enemy stats
        int e = 1;
        int contin = 1;
        int enemyHealth = 7;
        int playerHealth = ((CON-10)/2) + 10;
        int enemyArmourClass = 10 + 4 + ((16-10)/2);
        int playerArmourClass = 10 + 6 + ((DEX-10)/2);
        int playerBaseAttack = 1;
        int enemyBaseAttack = 0;
        int totalDamage = 0;
        
        Random rand2 = new Random();
        int enemyNumber = 2 + rand2.nextInt((3 - 2) + 2);
        System.out.println("You encounter " + enemyNumber + " enemies!");
        
        enemyHealth = enemyHealth * enemyNumber;
        
        do {
            Random rand3 = new Random();
            int playerAttack = 1 + rand3.nextInt((20 - 1) + 1);
            playerAttack = playerAttack + playerBaseAttack + ((STR-10)/2);
            if (playerAttack >= enemyArmourClass){
                System.out.println("You hit the enemy!");
                Random rand4 = new Random();
                int playerDamage = 1 + rand4.nextInt((6 - 1) + 1);
                playerDamage = playerDamage + ((STR-10)/2);
                enemyHealth = enemyHealth - playerDamage;
                System.out.println("You deal " + playerDamage + " damage to the enemy!");
                totalDamage = totalDamage + playerDamage;
                if (totalDamage > enemyHealth){
                   System.out.println("You defeated an enemy!");
                    enemyNumber = enemyNumber - 1;
                    totalDamage = 0;
                }
            } else {
                System.out.println("You miss the enemy!");
            }
            if (enemyHealth <= 0){
                contin = 0;               
            } else {
                do {
                    Random rand5 = new Random();
                    int enemyAttack = 1 + rand5.nextInt((20 - 1) + 1);
                    enemyAttack = enemyAttack + enemyBaseAttack + ((12-10)/2);
                    if (enemyAttack >= playerArmourClass){
                        System.out.println("The enemy hits you!");
                        Random rand4 = new Random();
                        int enemyDamage = 1 + rand4.nextInt((6 - 1) + 1);
                        enemyDamage = enemyDamage + ((STR-10)/2);
                        System.out.println("They deal " + enemyDamage + " damage to you!");
                        playerHealth = playerHealth - enemyDamage;
                        System.out.println("You have " + playerHealth + " HP remaining!");
                        System.out.println("");
                        e++;
                    } else {
                        System.out.println("The enemy misses!");
                        e++;
                    }
                } while (e <= enemyNumber);
                e = 1;
            }
            if (playerHealth <= 0){
                contin = 0;
                System.out.println("You died.");
            }
            if (enemyNumber == 0){
                System.out.println("You defeated the enemy!");
            }
        } while ((enemyNumber > 0 && playerHealth > 0) || contin == 1);
        
    }
    
}
