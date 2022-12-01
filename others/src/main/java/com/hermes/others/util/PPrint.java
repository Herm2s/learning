package com.hermes.others.util;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author liu.zongbin
 * @since 2022/11/30
 */
public class PPrint {

    public static String pformat(Collection<?> c) {
        if (c.isEmpty()) {
            return "";
        }
        StringBuilder result = new StringBuilder("[");
        for (Object elem : c) {
            if (c.size() != 1) {
                result.append("\n ");
            }
            result.append(elem);
        }
        if (c.size() != 1) {
            result.append("\n");
        }
        result.append("]");
        return result.toString();
    }

    public static void pprint(Collection<?> c) {
        System.out.println(pformat(c));
    }

    public static void pprint(Object[] c) {
        System.out.println(pformat(Arrays.asList(c)));
    }

}
