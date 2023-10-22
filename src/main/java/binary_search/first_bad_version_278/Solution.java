package binary_search.first_bad_version_278;

class VersionControl{
    boolean isBadVersion(int version){ return false;}
}

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while(l <= r){
            int m = l + (r - l)/2;
            if(!isBadVersion(m)){
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}
