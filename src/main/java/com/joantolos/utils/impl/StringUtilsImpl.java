package com.joantolos.utils.impl;

import com.joantolos.utils.enums.StringErrorCode;
import com.joantolos.utils.exception.StringManipulationException;
import com.joantolos.utils.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;

@Component
public class StringUtilsImpl implements StringUtils {

    public String toCamelCase(String s, String delimiter){
        String[] parts = s.split(delimiter);
        String camelCaseString = "";
        for (String part : parts){
            camelCaseString = camelCaseString + toProperCase(part);
        }
        return firstLetterLowerCase(camelCaseString);
    }

    public String toProperCase(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    public String firstLetterLowerCase(String s){
        return s.substring(0, 1).toLowerCase() + s.substring(1);
    }

    public ArrayList<String> stringArrayToArrayList(String[] array){
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, array);
        return arrayList;
    }

    public String replaceLastChars(String originalString, String replaceString, int endOffset) throws StringManipulationException {
        if (originalString.length() < endOffset) throw new StringManipulationException(StringErrorCode.STRING_LENGTH_OVERFLOW, String.valueOf(endOffset));
        return originalString.substring(0, originalString.length() - endOffset) + replaceString;
    }
}
