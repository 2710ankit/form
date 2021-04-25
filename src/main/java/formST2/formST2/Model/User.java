package formST2.formST2.Model;

import javax.persistence.*;

@Entity
@Table(name = "information")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
     private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "mobile")
    private String mobile_no;

    @Column(name = "email",unique = true)
    private String email;

    public User(String name, String mobile_no, String email) {
        this.name = name;
        this.mobile_no = mobile_no;
        this.email = email;
    }
    public User(){

    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
