package com.example.app;

import com.example.util.Utils;

public class MainApp {
    public static void main(String[] args) {
        String original = "TechfreeKorea";

        String reversed = Utils.reverse(original);
        System.out.println("Original : "+ original);
        System.out.println("Reversed : "+ reversed);
    }
}
