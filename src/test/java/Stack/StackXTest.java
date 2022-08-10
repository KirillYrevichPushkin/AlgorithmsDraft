package Stack;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StackXTest {

    private  StackX<Integer> stackX;

    @BeforeEach
    public void init(){
        stackX = new StackX(5);
    }

//    @ParameterizedTest
//    @CsvSource({5,1 }, {9, 2})
//    public void testAdd(){
//
//        Assertions.
//    }

}
