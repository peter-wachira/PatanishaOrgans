import org.sql2o.Connection;

import java.util.List;

public class Recepient {
    private int id;
    private String name;
    private int doctorid;
    private String bloodgroup;
    private String organ;

    public Recepient(String name, String bloodgroup, String organ, int doctorid) {
        this.name = name;
        this.bloodgroup = bloodgroup;
        this.organ = organ;
        this.doctorid = doctorid;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDoctorId() {
        return doctorid;
    }

    public String getBloodGroup() {
        return bloodgroup;
    }

    public String getOrgan() {
        return organ;
    }
    @Override
    public boolean equals(Object otherRecepient) {
        if (!(otherRecepient instanceof Recepient)) {
            return false;
        } else {
            Recepient newRecepient = (Recepient) otherRecepient;
            return this.id == newRecepient.getId();
        }
    }
    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO recepients(name, bloodgroup, organ, doctorid) VALUES (:name, :bloodgroup, :organ, :doctorid)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("bloodgroup", this.bloodgroup)
                    .addParameter("organ", this.organ)
                    .addParameter("doctorid", this.doctorid)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<Recepient> allRecepient(){
        String sql = "SELECT * FROM recepients";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                    .executeAndFetch(Recepient.class);
        }

    }
    public static Recepient find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM recepients where id=:id";
            Recepient recepient = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Recepient.class);
            return recepient;
        }
    }
}