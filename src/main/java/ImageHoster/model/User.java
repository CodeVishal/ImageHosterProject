package ImageHoster.model;


import javax.persistence.*;

//@Entity annotation specifies that the corresponding class is a JPA entity
@Entity
/*@Table annotation provides more options to customize the mapping.
Here the name of the table to be created in the database is explicitly mentioned as 'users'.
*/

@Table(name = "users")
public class User {

    //@Id annotation specifies that the corresponding attribute is a primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /*@Column annotation specifies that the attribute will be mapped to the column in the database.
    Here the column name is explicitly mentioned as 'id'

     */
    @Column(name ="id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    /*The 'users' table is mapped to 'user_profile' table with One:One mapping
    cascade = CascadeType.ALL specifies that if a record in 'user_profile' table is deleted or
     updated, then all the records in 'users' table associated to that particular record in 'user_profile' table will be deleted or updated  first and then the record in the 'user_profile' table will be deleted or updated
    FetchType is EAGER*/
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //Below annotation indicates that the name of the column in 'users' table referring the primary key in 'user_profile' table will be 'profile_id'
    @JoinColumn(name = "profile_id")
    private UserProfile profile;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserProfile getProfile() {
        return profile;
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }
}

