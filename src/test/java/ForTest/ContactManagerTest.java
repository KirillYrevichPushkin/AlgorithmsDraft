package ForTest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

//определяет жизненный цикл теста на весь класс(т.е. не будет создаваться новый класс для каждого теста)
//-> можно сделать методы beforeAll, afterAll не статическими
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ContactManagerTest {


    private static ContactManager contactManager;

    @BeforeAll
    public void init(){
        System.out.println("Start tests");
    }

    @BeforeEach
    public void setup(){
        contactManager = new ContactManager();
    }

    @Test
    @DisplayName("Should Create Contact")
    public void shouldCreateContact(){
        //ContactManager contactManager = new ContactManager();
        contactManager.addContact("John", "Doe", "0123456789");
        assertFalse(contactManager.getAllContacts().isEmpty());
        assertEquals(1, contactManager.getAllContacts().size());
    }

    //@Test
    @DisplayName("Should Not Create Contact When First Name is Null")
    @RepeatedTest(3) // повторяет тест заданное количество раз
    public void shouldNotCreateContactWhenFirstNameIsNull(){
       // ContactManager contactManager = new ContactManager();
        assertThrows(RuntimeException.class, () -> {
            contactManager.addContact(null,"Doe", "0123456789");
        } );
    }

    @Test
    @DisplayName("Should Not Create Contact When Last Name is Null")
    public void shouldNotCreateContactWhenLastNameIsNull(){
     //   ContactManager contactManager = new ContactManager();
     //   contactManager.addContact("John",null, "0123456789");
        assertThrows(RuntimeException.class, () -> {
            contactManager.addContact("John",null, "0123456789");
        } );
    }

    @Test
    @DisplayName("Should Not Create Contact When Number is Null")
    public void shouldNotCreateContactWhenNumberIsNull(){
     //   ContactManager contactManager = new ContactManager();
        assertThrows(RuntimeException.class, () -> {
            contactManager.addContact("John","Doe", null);
        } );
    }

    //параметризированный тест
    @DisplayName("Phone Number Should Match The Required Format")
    @ParameterizedTest
    @ValueSource(strings = {"0123456789", "0234567890", "0123456789"})
    public void shouldTestNumberFormat(String phoneNumber){
        contactManager.addContact("John", "Doe", phoneNumber);
        assertFalse(contactManager.getAllContacts().isEmpty());
        assertEquals(1, contactManager.getAllContacts().size());
    }

    //параметризированный тест с методом источника данных
    @DisplayName("Phone Number Should Match The Required Format With Method Source")
    @ParameterizedTest
    @MethodSource("phoneNumberList")
    public void shouldTestNumberFormatWithMethodSource(String phoneNumber){
        contactManager.addContact("John", "Doe", phoneNumber);
        assertFalse(contactManager.getAllContacts().isEmpty());
        assertEquals(1, contactManager.getAllContacts().size());
    }

    private List<String>phoneNumberList(){
        return Arrays.asList("0123456789", "0234567890", "0123456789");
    }

    //параметризированный тест с CsvSource
    @DisplayName("CSV Source Case - Phone Number should match the required Format")
    @ParameterizedTest
    @CsvSource({"0123456789", "0234567890","0123456789"})
    public void shouldTestPhoneNumberFormatUsingCSVSource(String phoneNumber) {
        contactManager.addContact("John", "Doe", phoneNumber);
        assertFalse(contactManager.getAllContacts().isEmpty());
        assertEquals(1, contactManager.getAllContacts().size());
    }

    //параметризированный тест с CsvSource с парой значений
    @DisplayName("параметризированный тест с CsvSource с парой значений")
    @ParameterizedTest
    @CsvSource({"abba,  abba ",
                "abba, adda",
                "1, 1"})
    public void testCSVSource(String s1, String s2) {
        assertEquals(s1, s2);
    }

    //параметризированный тест с CsvSource с ArgumentsAccessor
    @DisplayName("параметризированный тест с CsvSource с парой значений и ArgumentsAccessor")
    @ParameterizedTest
    @CsvSource({"abba,  abba ",
            "abba, adda",
            "1, 1"})
    public void testCSVSource2(ArgumentsAccessor arg) {
        assertEquals(arg.get(0), arg.get(1));
    }


    //параметризированный тест с CsvFileSource
    @Disabled
    @DisplayName("CSV File Source Case - Phone Number should match the required Format CsvFileSource")
    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    public void shouldTestPhoneNumberFormatUsingCSVFileSource(String phoneNumber) {
        contactManager.addContact("John", "Doe", phoneNumber);
        assertFalse(contactManager.getAllContacts().isEmpty());
        assertEquals(1, contactManager.getAllContacts().size());
    }

    //вложенные параметризированные тесты
    @Nested
    class ParameterizedTests {
        @DisplayName("Phone Number should match the required Format")
        @ParameterizedTest
        @ValueSource(strings = {"0123456789", "0234567890", "0123456789"})
        public void shouldTestPhoneNumberFormatUsingValueSource(String phoneNumber) {
            contactManager.addContact("John", "Doe", phoneNumber);
            assertFalse(contactManager.getAllContacts().isEmpty());
            assertEquals(1, contactManager.getAllContacts().size());
        }

        @DisplayName("CSV Source Case - Phone Number should match the required Format")
        @ParameterizedTest
        @CsvSource({"0123456789", "1234567890", "+0123456789"})
        public void shouldTestPhoneNumberFormatUsingCSVSource(String phoneNumber) {
            contactManager.addContact("John", "Doe", phoneNumber);
            assertFalse(contactManager.getAllContacts().isEmpty());
            assertEquals(1, contactManager.getAllContacts().size());
        }

        @DisplayName("CSV File Source Case - Phone Number should match the required Format")
        @ParameterizedTest
        @CsvFileSource(resources = "/data.csv")
        public void shouldTestPhoneNumberFormatUsingCSVFileSource(String phoneNumber) {
            contactManager.addContact("John", "Doe", phoneNumber);
            assertFalse(contactManager.getAllContacts().isEmpty());
            assertEquals(1, contactManager.getAllContacts().size());
        }
    }




    @AfterAll
    public void end(){
        System.out.println("End tests");
    }


}
