import cs.vsu.ru.kapustin.CreatingNewSheet;
import cs.vsu.ru.kapustin.utils.Utils;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

public class CreatingNewSheetTest {
    List<Integer> testList;
    List<Integer> expectedList;
    List<Integer> actualList;
    CreatingNewSheet creating = new CreatingNewSheet();

    @Test
    public void testCreateNewList1() throws FileNotFoundException {
        testList = Utils.readListFromFile("testSrc/testFiles/input01.txt");
        actualList = creating.createNewList(testList);
        expectedList = Utils.readListFromFile("testSrc/testFiles/output01.txt");
        Assert.assertEquals(expectedList, actualList);
    }

    @Test
    public void testCreateNewList2() throws FileNotFoundException {
        testList = Utils.readListFromFile("testSrc/testFiles/input02.txt");
        actualList = creating.createNewList(testList);
        expectedList = Utils.readListFromFile("testSrc/testFiles/output02.txt");
        Assert.assertEquals(expectedList, actualList);
    }

    @Test
    public void testCreateNewList3() throws FileNotFoundException {
        testList = Utils.readListFromFile("testSrc/testFiles/input03.txt");
        actualList = creating.createNewList(testList);
        expectedList = Utils.readListFromFile("testSrc/testFiles/output03.txt");
        Assert.assertEquals(expectedList, actualList);
    }

    @Test
    public void testCreateNewList4() throws FileNotFoundException {
        testList = Utils.readListFromFile("testSrc/testFiles/input04.txt");
        actualList = creating.createNewList(testList);
        expectedList = Utils.readListFromFile("testSrc/testFiles/output04.txt");
        Assert.assertEquals(expectedList, actualList);
    }

    @Test
    public void testCreateNewList5() throws FileNotFoundException {
        testList = Utils.readListFromFile("testSrc/testFiles/input05.txt");
        actualList = creating.createNewList(testList);
        expectedList = Utils.readListFromFile("testSrc/testFiles/output05.txt");
        Assert.assertEquals(expectedList, actualList);
    }

    @Test
    public void testCreateNewList6() throws FileNotFoundException {
        testList = Utils.readListFromFile("testSrc/testFiles/input06.txt");
        actualList = creating.createNewList(testList);
        expectedList = Utils.readListFromFile("testSrc/testFiles/output06.txt");
        Assert.assertEquals(expectedList, actualList);
    }

    @Test
    public void testCreateNewList7() throws FileNotFoundException {
        testList = Utils.readListFromFile("testSrc/testFiles/input07.txt");
        actualList = creating.createNewList(testList);
        expectedList = Utils.readListFromFile("testSrc/testFiles/output07.txt");
        Assert.assertEquals(expectedList, actualList);
    }

    @Test
    public void testCreateNewList8() throws FileNotFoundException {
        testList = Utils.readListFromFile("testSrc/testFiles/input08.txt");
        actualList = creating.createNewList(testList);
        expectedList = Utils.readListFromFile("testSrc/testFiles/output08.txt");
        Assert.assertEquals(expectedList, actualList);
    }

    @Test
    public void testCreateNewList9() throws FileNotFoundException {
        testList = Utils.readListFromFile("testSrc/testFiles/input09.txt");
        actualList = creating.createNewList(testList);
        expectedList = Utils.readListFromFile("testSrc/testFiles/output09.txt");
        Assert.assertEquals(expectedList, actualList);
    }

    @Test
    public void testCreateNewList10() throws FileNotFoundException {
        testList = Utils.readListFromFile("testSrc/testFiles/input10.txt");
        actualList = creating.createNewList(testList);
        expectedList = Utils.readListFromFile("testSrc/testFiles/output10.txt");
        Assert.assertEquals(expectedList, actualList);
    }
}