package org.lessons.scelac;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

/** Unit test for simple App. */
public class AppTest {
  /** Rigorous Test :-) */
  @Test
  public void shouldAnswerWithTrue() {
    assertTrue(true);
  }

  @Test
    void passwordEncoder(){
      BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(5);
      String result = encoder.encode("password");
    System.out.println(result );
      assertTrue(encoder.matches("password", result));
  }
}
