package com.joantolos.utils;

import com.joantolos.utils.exception.StringManipulationException;

import java.util.ArrayList;

/**
 *
 * Created by jtolos on 13/01/2015.
 */
public interface StringUtils {

    String toCamelCase(String s, String delimiter);

    String toProperCase(String s);

    String firstLetterLowerCase(String s);

    ArrayList<String> stringArrayToArrayList(String[] array);

    String replaceLastChars(String originalString, String replaceString, int endOffset) throws StringManipulationException;
}
