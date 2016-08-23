/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab7;

import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Henry
 */
public class Collection_HashMap {

    public static void main(String args[]) {
        HashMap h = new HashMap();
        h.put("ABC", "XXXXXXXXXXXX");
        h.put("DEF", "KKKKKKKKKKKKKKK");
        h.put("XYZ", "IOISAGSADGSG");
        System.out.println(h);
        h.put("ABC", "82958298357");
        System.out.println(h);

        Iterator it = h.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) (it.next());
            String value = (String) (h.get(key));
            System.out.println(key + " - " + value);
        }
    }
}
