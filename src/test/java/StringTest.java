import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StringTest {

    long usedMemory;
    long beforeTime;

    @BeforeAll
    void before(){
        Runtime.getRuntime().gc();
        this.usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        this.beforeTime = System.currentTimeMillis();
    }

    @AfterAll
    void after(){
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime)/1000;

        System.out.println(usedMemory + " bytes");
        System.out.println("시간차이(m) : "+secDiffTime);

    }

    @Test
    @DisplayName("String Test")
    void StringTest(){
        String strSql = "";
        for(int i=0 ; i<40000; i++){
            strSql += "select";
            strSql += "* from";
            strSql += "test where";
            strSql += "1=1";
            /*
            4310200 bytes
            시간차이(m) : 4
             */
        }
    }

    @Test
    @DisplayName("String Builder Test")
    void StringBuilderTest(){
        StringBuilder strSql = new StringBuilder();
        for(int i=0 ; i<40000; i++){
            strSql.append("select");
            strSql.append("* from");
            strSql.append("test where");
            strSql.append("1=1");
            /*
            4307080 bytes
            시간차이(m) : 0
             */
        }
    }

    @Test
    @DisplayName("String Buffer Test")
    void StringBufferTest(){
        StringBuffer strSql = new StringBuffer();
        for(int i=0 ; i<40000; i++){
            strSql.append("select");
            strSql.append("* from");
            strSql.append("test where");
            strSql.append("1=1");
        }
        /*
        4307032 bytes
        시간차이(m) : 0
         */
    }
}
