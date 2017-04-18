/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exercicis.util;

import java.util.Formatter;

/**
 *
 * @author m0r
 */
public class Functions {
    public static String byteToHex(final byte[] hash)
    {
        String result;
        try (Formatter formatter = new Formatter()) {
            for (byte b : hash)
                formatter.format(Constants.STR_HEX_FORMAT, b);
            result = formatter.toString();
        }
        return result;
    }
}
