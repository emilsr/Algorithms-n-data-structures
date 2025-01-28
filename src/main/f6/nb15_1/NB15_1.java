package main.f6.nb15_1;

/**
 * En lek med kulor går till på följande sätt. Man börjar med ett visst antal röda, vita och blå kulor. I en
 * låda ligger obegränsat med röda, vita och blå kulor. Man ska nu se till att växla sina kulor med
 * kulorna i lådan så att man får lika många kulor av varje färg och man ska göra detta på så få växlingar
 * som möjligt. Följande växlingar är tillåtna:
 *  1 blå kula kan växlas mot 1 vit kula och 3 röda kulor.
 *  1 vit kula kan växlas mot 2 blåa kulor och 4 röda kulor.
 *  1 röd kula kan växlas mot 1 blå kula och 5 vita kulor.
 * Exempel:
 *  Om man börjar med 2 blåa, 5 vita och 0 röda kulor behövs 1 växling (byt en vit)
 *  Om man börjar med 1 blå, 0 vita och 1 röd kula behövs 2 växlingar
 *  Om man börjar med 2 blåa, 1 vit och 0 röda kulor behövs 9 växlingar
 *  Om man börjar med 3 blåa, 2 vita och 1 röd kula behövs 9 växlingar
 *  Om man börjar med 5 blåa, 2 vita och 1 röd kula behövs 3 växlingar
 *  Om man börjar med 5 blåa, 1 vita och 3 röd kula behövs 15 växlingar
 * Skriv en metod som tar antalet kulor i de tre färgerna och returnerar antalet växlingar som behövs.
 * Tips: Denna uppgift skiljer sig på en punkt från de vi tittat på hitintills. Om vi naivt testar de tre
 * alternativen rekursivt riskerar vi att hamna i en oändlig loop där vi aldrig når målet. Den här typen av
 * problem behöver ett maxdjup, ett maximalt antal växlingar vi gör innan vi ger upp på just det här
 * försöket. Man behöver då veta hur många växlingar problemet maximalt kan behöva eller så får man
 * testa sig fram. Mer om detta i nästa föreläsning. Du kan utgå ifrån att det alltid räcker med 15
 * växlingar när du löser detta problem.
 */

public class NB15_1 {

    public static void main(String[] args) {}

    public static int tradeMarble(int red, int blue, int white ){
        return 0;
    }

}
