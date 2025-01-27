package main.F5;

/**
 * En maskin har en display på vilken den visar uppnådd poäng. Från början visar displayen 1 poäng.
 * Genom att stoppa mynt i maskinen kan poängen förändras:
 * • Genom en 10-krona multipliceras poängen på displayen med 3
 * • Genom en 5-krona adderas 4 till poängen på displayen.
 * Skriv ett program som tar emot den poäng som ska uppnås. Programmet ska sedan beräkna lägsta
 * belopp som krävs för att uppnå poängen exakt. Observera att man inte kan nå målet för alla
 * slutpoäng
 *
 * Tips 1: Använd rekursion för att pröva alla lösningar. Försök inte hitta villkor för vilket val som är bäst.
 * Det är inte det vi vill träna på. Försök inte lösa uppgiften baklänges för det är svårare. Räkna istället
 * upp poängen mot det givna målet.
 */

public class NB14 {

    public int points; 
    public int nrOfTurns;


    public static int solvePoints(int target){
        return solvePoints(1, target,0);
    }

    public static int solvePoints(int points, int target, int coinsUsed){
        if (points == target) {
            return target;
        }
        int fiveCrown = solvePoints(points+4, target,coinsUsed+5);

        int tenCrown = solvePoints(points*3, target,coinsUsed+10);

        return Math.min(fiveCrown, tenCrown);
    }

    public static void main(String[] args) {
        
    }

    
    

}
