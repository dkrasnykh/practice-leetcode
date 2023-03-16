package array.unique_email_addresses_929;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> unique = new HashSet<>();
        for (String email : emails) {
            StringBuilder sb = new StringBuilder();
            int p1 = email.indexOf('+');
            int p2 = email.indexOf('@');
            char[] localname = (p1 != -1 && p1 < p2) ? email.substring(0, p1).toCharArray() : email.substring(0, p2).toCharArray();
            String domainName = email.substring(p2);
            int k = 0;
            for(int i = 0; i<localname.length; ++i) {
                if (localname[i] != '.') {
                    localname[k] = localname[i];
                    ++k;
                }
            }
            sb.append(localname, 0, k)
                    .append(domainName);
            unique.add(sb.toString());
        }
        return unique.size();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
        System.out.println(s.numUniqueEmails(new String[]{"a@leetcode.com","b@leetcode.com","c@leetcode.com"}));
    }
}
