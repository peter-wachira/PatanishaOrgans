import org.junit.rules.ExternalResource;
import org.sql2o.*;
public class DatabaseRule extends ExternalResource {

    @Override
    protected void before() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/patanisha_organs", "alpha", "pw*0711937973");
    }

    @Override
    protected void after() {
        String deleteRecepientsQuery = "DELETE FROM recepients *;";
        String deleteDoctorsQuery = "DELETE FROM doctor *;";
        String deleteDonorsQuery = "DELETE FROM donor *;";
        try(Connection con = DB.sql2o.open()) {
            con.createQuery(deleteRecepientsQuery).executeUpdate();
            con.createQuery(deleteDoctorsQuery).executeUpdate();
            con.createQuery(deleteDonorsQuery).executeUpdate();
        }
    }
}