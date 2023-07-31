package Algorithm.Stack;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StackXTest {

    private  StackX<Integer> stackX;

    @BeforeEach
    public void init(){
        stackX = new StackX(5);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "3, 3",
            "5, 5",
    })
    public void testPop(Integer set, Integer get){
            stackX.push(9);
            stackX.push(set);
            stackX.push(9);
         assertFalse(stackX.isEmpty());
         stackX.pop();
         assertEquals(get, stackX.peek());
    }

    @ParameterizedTest
    @ValueSource(ints = {3,4})
    public void testAdd(Integer e){
        for (int i = 0; i < e; i++) {
            stackX.push(i);
        }
        assertEquals(e,stackX.size());
    }

}
