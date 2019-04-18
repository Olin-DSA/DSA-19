import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstFailingVersionTest {

    @Test
    public void caseOne() {
        IsFailingVersion ibv = n -> n >= 8;
        assertEquals(FirstFailingVersion.firstBadVersion(10, ibv), 8L);
    }

    @Test
    public void caseTwo() {
        IsFailingVersion ibv = n -> n >= 14;
        assertEquals(FirstFailingVersion.firstBadVersion(16, ibv), 14L);
    }

    @Test
    public void caseThree() {
        IsFailingVersion ibv = n -> n >= 7830201;
        assertEquals(FirstFailingVersion.firstBadVersion(9000000, ibv), 7830201L);
    }

    @Test
    public void caseFour() {
        IsFailingVersion ibv = n -> n >= 8993820103L;
        assertEquals(FirstFailingVersion.firstBadVersion(10099828403L, ibv), 8993820103L);
    }

    @Test
    public void caseFive() {
        IsFailingVersion ibv = n -> n >= 89938201403L;
        assertEquals(FirstFailingVersion.firstBadVersion(100994828403L, ibv), 89938201403L);
    }

    @Test
    public void caseSix() {
        IsFailingVersion ibv = n -> n >= 932L;
        assertEquals(FirstFailingVersion.firstBadVersion(100994828403L, ibv), 932L);
    }
}
