package com.joantolos.utils;

import java.util.ArrayList;

/**
 *
 * Created by jtolos on 13/01/2015.
 */
public interface JSONUtils {

    String objectToJson(Object o);

    Object jsonToObject(String json, Class c);

    ArrayList<Object> objectListJsonToObjectList(String objectListJSON);

    String objectListToObjectListJson(ArrayList<Object> objectList);
}
