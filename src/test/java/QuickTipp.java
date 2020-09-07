
import de.defdesign.quicktipp.numberGenerators.Blacklist;
import de.defdesign.quicktipp.numberGenerators.TippEuroJackpot;
import de.defdesign.quicktipp.numberGenerators.TippLotto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Set;
import java.util.TreeSet;

public class QuickTipp {

    Set<Integer> testSet;

    @Before
    public void setupData(){
        this.testSet = new TreeSet<>();
        testSet.add(21);
    }

    @Test
    public void getLottoNumbers(){
        TippLotto tippLotto = new TippLotto();
        Set<Integer> resultSet = tippLotto.generateTipp(tippLotto, tippLotto.getMAX_VALUE(), tippLotto.getMAX_SIZE());
        Assert.assertEquals(resultSet.size(), 6, 0);
    }

    @Test
    public void getEuroJackpotNumbersPart1(){
         TippEuroJackpot tippLotto = new TippEuroJackpot();
         Set<Integer> resultSet = tippLotto.generateTipp(tippLotto, tippLotto.getMAX_VALUE_5_OF_50(), tippLotto.getMAX_SIZE_5_OF_50());
         Assert.assertEquals(resultSet.size(), 5, 0);
    }

    @Test
    public void getEuroJackpotNumbersPart2(){
        TippEuroJackpot tippLotto = new TippEuroJackpot();
        Set<Integer> resultSet = tippLotto.generateTipp(tippLotto, tippLotto.getMAX_VALUE_2_OF_10(), tippLotto.getMAX_SIZE_2_OF_10());
        Assert.assertEquals(resultSet.size(), 2, 0);
    }

    @Test
    public void dupecheckBlacklist() {
        boolean resultFalse = Blacklist.getBlacklist().dupeCheck(this.testSet, 21);
        boolean resultTrue = Blacklist.getBlacklist().dupeCheck(this.testSet, 22);
        Assert.assertTrue((resultTrue && !resultFalse));
    }

}
