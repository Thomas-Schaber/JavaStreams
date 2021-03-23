
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class DictionaryTest {

   @Test
   void testDictionary0() throws IOException {
      Dictionary dict = new Dictionary();
      assertTrue(dict.contains("computer"));
   }
   
   @Test
   void testDictionary1() throws IOException {
      Dictionary dict = new Dictionary();
      assertFalse(dict.contains("xyzzy"));
   }
   
   @Test
   void testDictionary2() throws IOException {
      Dictionary dict = new Dictionary();
      assertFalse(dict.contains("II"));
   }

}
