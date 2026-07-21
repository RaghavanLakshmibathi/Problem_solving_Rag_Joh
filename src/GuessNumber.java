import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class GuessNumber {
    public static void main(String[] args) throws IOException{
        Random rand = new Random();
        int randomInt = rand.nextInt(10);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Guess the number da: ");
        int num = Integer.parseInt(br.readLine());


        while (true){
            if (randomInt==num){
                System.out.println("U got it man, Random number is  " + randomInt +":)");
                break;
            }
            else{
                System.out.print("Wrong:( please guess the number again: ");
                int num2 = Integer.parseInt(br.readLine());
                num=num2;
            }

        }

    }
}
