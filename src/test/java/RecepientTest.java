import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RecepientTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();


    @Test
    public void Recepient_instantiateCorrectly_true(){
        Recepient testRecepient = new Recepient("Jackie", "O+", "Heart", 1);
        assertTrue(testRecepient instanceof Recepient);
    }

    @Test
    public void Recepient_instantiateWithBloodGroup_true(){
        Recepient testRecepient = new Recepient("Jackie", "O+", "Heart", 1);
        assertEquals("O+", testRecepient.getBloodGroup());
    }

    @Test
    public void Recepient_instantiateWithOrgan_true(){
        Recepient testRecepient = new Recepient("Jackie", "O+", "Heart", 1);
        assertEquals("Heart", testRecepient.getOrgan());

    }
    @Test
    public void equals_retursTrueNamesBloodGroupOrgan_true(){
        Recepient firstRecepient = new Recepient("Jackie", "O+", "Heart", 1);
        Recepient secondRecepient = new Recepient("Jackie", "O+", "Heart", 1);
        assertTrue(firstRecepient.equals(secondRecepient));
    }
    @Test
    public void save_saveInstanceToTheDatabase(){
        Recepient firstRecepient = new Recepient("Jackie", "O+", "Heart", 1);
        firstRecepient.save();
        assertEquals(true, Recepient.allRecepient().get(0).equals(firstRecepient));
    }
    @Test
    public void save_assignsIdToRecepients() {
        Recepient firstRecepient = new Recepient("Jackie", "O+", "Heart", 1);
        firstRecepient.save();
        Recepient savedRecepient = Recepient.allRecepient().get(0);
        assertEquals(savedRecepient.getId(), firstRecepient.getId());
    }
    @Test
    public void all_returnsAllInstancesOfRecepients_true() {
        Recepient firstRecepient = new Recepient("Jackie", "O+", "Heart", 1);
        firstRecepient.save();
        Recepient secondRecepient = new Recepient("Yaska", "A+", "Lungs", 1);
        secondRecepient.save();

        assertEquals(true, Recepient.allRecepient().get(0).equals(firstRecepient));
        assertEquals(true, Recepient.allRecepient().get(1).equals(secondRecepient));
    }
    @Test
    public void find_returnsWithSameId_secondRecepient() {
        Recepient firstRecepient = new Recepient("Jackie", "O+", "Heart", 1);
        firstRecepient.save();
        Recepient secondRecepient = new Recepient("Yaska", "A+", "Lungs", 1);
        secondRecepient.save();
        assertEquals(Recepient.find(secondRecepient.getId()), secondRecepient);
    }
}