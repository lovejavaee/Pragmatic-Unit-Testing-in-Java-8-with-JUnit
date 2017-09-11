/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/utj2 for more book information.
***/
package iloveyouboss;

import org.junit.*;
import static org.junit.Assert.*;

public class ProfileTest {
   private Profile profile;
   private BooleanQuestion question;
   private Criteria criteria;
   
   @Before
   public void create() {
      profile = new Profile("Bull Hockey, Inc.");
      question = new BooleanQuestion(1, "Got bonuses?");
      criteria = new Criteria();
   }

   @Test
   public void matchAnswersFalseWhenMustMatchCriteriaNotMet() {
      Answer profileAnswer = new Answer(question, Bool.FALSE);
      profile.add(profileAnswer);      
      Answer criteriaAnswer = new Answer(question, Bool.TRUE);
      Criterion criterion = new Criterion(criteriaAnswer, Weight.MustMatch);
      criteria.add(criterion);

      boolean matches = profile.matches(criteria);
      
      assertFalse(matches);
   }
   
   @Test
   public void matchAnswersTrueForAnyDontCareCriteria() {
      Answer profileAnswer = new Answer(question, Bool.FALSE);
      profile.add(profileAnswer);      
      Answer criteriaAnswer = new Answer(question, Bool.TRUE);
      Criterion criterion = new Criterion(criteriaAnswer, Weight.DontCare);
      criteria.add(criterion);

      boolean matches = profile.matches(criteria);
      
      assertTrue(matches);
   }
}
