public class FirstFailingVersion {

    public static long firstBadVersion(long n, IsFailingVersion isBadVersion) {
        long lo = 1;
        long hi = n;
        while (lo < hi) {
            long mid = (hi + lo)/2;
            if (isBadVersion.isFailingVersion(mid))
                hi = mid;
            else
                lo = mid+1;
        }
        if (isBadVersion.isFailingVersion(lo))
            return lo;
        return -1;
    }
}
