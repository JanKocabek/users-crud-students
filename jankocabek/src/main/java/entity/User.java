package entity;

import org.mindrot.jbcrypt.BCrypt;

import java.util.Objects;

public class User {
    private int id;
    private String userName;
    private String passHash;
    private String email;

    public User(String userName, String email, String password) {
        this.id = 0;
        this.userName = userName;
        this.email = email;
        this.passHash = getHashedPass(password);
    }

    public User(int id, String userName, String email, String password) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.passHash = getHashedPass(password);
    }

    public User(int id, String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassHash() {
        return passHash;
    }

    public String getEmail() {
        return email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.passHash = getHashedPass(password);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String getHashedPass(String password) {
        return BCrypt.hashpw(password, generateSalt());
    }

    private String generateSalt() {
        return BCrypt.gensalt();
    }

    public boolean checkPassword(String password) {
        return BCrypt.checkpw(password, this.passHash);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passHash='" + passHash + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getId() == user.getId() && Objects.equals(getUserName(), user.getUserName()) && Objects.equals(getPassHash(), user.getPassHash()) && Objects.equals(getEmail(), user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserName(), getPassHash(), getEmail());
    }
}
