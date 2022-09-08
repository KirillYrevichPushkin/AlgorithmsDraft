package yandex.back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {


    public static void main(String[] args) {

        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        try {
            char [] wordA = bufferRead.readLine().toCharArray();
            char [] wordB = bufferRead.readLine().toCharArray();

            char [] wordC = new char[wordA.length];
            for (int i = 0; i < wordC.length; i++) {
                wordC[i] = 'I';
            }

            for (int i = 0; i < wordB.length; i++) {
                if(wordB[i] == wordA[i]) {
                    wordC[i] = 'P';
                    wordA[i] = '/';
                }
            }

            for (int i = 0; i < wordB.length; i++) {
                if(wordC[i] == 'P' || wordC[i] == 'S') continue;
                for (int j = 0; j < wordA.length; j++) {
                    if(wordB[i] == wordA [j]){
                        wordC[i] = 'S';
                        wordA[j] = '/';
                    }
                }
            }

            System.out.println(String.valueOf(wordC));

        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            bufferRead.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
