package com.java.team.shippingservice.util;

public class NumberUtils {

    public static Boolean existParam(Long param) {
        if (null != param && param != 0)
            return Boolean.TRUE;
        return Boolean.FALSE;
    }

    public static Boolean existParam(Integer param) {
        if (null != param && param != 0)
            return Boolean.TRUE;
        return Boolean.FALSE;
    }
}
