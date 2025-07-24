package com.example.envdemo.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringCalculator {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("[,:]");
    private String regexPattern = "[,:]";


    /**
     * 스트링 인자에서 숫자값만을 추출해 그 수들의 합을 반환하는 함수
     *
     * @param input 문자열 입력값
     * @return 문자열 중 숫자들의 합(int)
     */
    public int add(String input) {
        if(input.isEmpty()){
            return 0;
        }

        List<Integer> numbers = new ArrayList<>();
        List<Integer> minusNumbers = new ArrayList<>();

        if(input.startsWith("//")){
            String customEndString = "\n";
            int customStringIdx = input.indexOf(customEndString);
            String customString = input.substring(2,customStringIdx);
            input = input.substring(customStringIdx+1);

            if(customString.startsWith("[")){
                Matcher m = Pattern.compile("\\[(.*?)]").matcher(customString);
                m.find();
                regexPattern = Pattern.quote(m.group(1));
            }else{
                regexPattern = Pattern.quote(customString);
            }
        }


        String[] inputs = input.split(regexPattern);

        for (String s : inputs){
            int num = Integer.parseInt(s);
            if(num < 0 ){
                minusNumbers.add(num);
            }

            if(num <= 1000){
                numbers.add(num);
            }
        }

        if (!minusNumbers.isEmpty()){
            throw new IllegalArgumentException("음수는 입력에 올 수 없습니다." + minusNumbers.toString());
        }

        int sum = 0;

        for (int num : numbers){
            if(num > 1000){
                continue;
            }
            sum+=num;
        }

        return sum;
    }
}