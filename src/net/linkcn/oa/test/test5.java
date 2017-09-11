package net.linkcn.oa.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class test5
{
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        Map<Object, String[]> mapInfoMap = new HashMap<Object, String[]>();
        mapInfoMap.put("file", new String[] { "a", "b" });
        Set<Entry<Object, String[]>> set = mapInfoMap.entrySet();
        for (Entry<Object, String[]> entry : set)
        {
            String key = (String) entry.getKey();
            String[] value = entry.getValue();
            String userType = value[0];
            String userMail = value[1];
            System.out.println(key);
            System.out.println(userType);
            System.out.println(userMail);
        }
    }
}
