package com.amjadcode.ledo_blog_ta.commons;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Random;

@Service
public class CommonMethodService {

    public static String generateUsername(int numberOfWords) {

        String[] randomStrings = new String[numberOfWords];
        Random random = new Random();
        for(int i = 0; i < numberOfWords; i++)
        {
            char[] word = new char[random.nextInt(8)+3];
            for(int j = 0; j < word.length; j++)
            {
                word[j] = (char)('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }

        return Arrays.toString(randomStrings).substring(1, Arrays.toString(randomStrings).length()-1);
    }
}
