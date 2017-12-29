package com.example;



public class JokeProvider {
    public static String[] jokes =new String[]{
            "I asked God for a bike, but I know God doesn't work that way. So I stole a bike and asked for forgiveness.",
            "I want to die peacefully in my sleep, like my grandfather.. Not screaming and yelling like the passengers in his car. ",
            "The last thing I want to do is hurt you. But it's still on the list.",
            "If sex is a pain in the ass, then you're doing it wrong."};

    public static String getJoke(int index){
        if(index >= 0){
            return jokes[index];
        }

        return jokes[0];
    }
}
