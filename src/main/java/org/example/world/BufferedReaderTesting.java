package org.example.world;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class BufferedReaderTesting {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new StringReader(
                    "StartRoom\n" +
                            "9\n" +
                            "9\n" +
                            "#########\n" +
                            "#FFFFFFW#\n" +
                            "#FFFFFFF#\n" +
                            "#FFFFFFF#\n" +
                            "#FFFFFFFR\n" +
                            "#FFFFFFF#\n" +
                            "#FFFFFFF#\n" +
                            "#FFFFFFF#\n" +
                            "#########"));
        }catch (Exception e){

        }


        String roomType = bufferedReader.readLine();
        System.out.println(roomType);


    }
}
