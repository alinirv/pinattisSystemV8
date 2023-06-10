package br.edu.ifsp.domain.entities.user;

import java.security.SecureRandom;

public class User {
    private Integer idUser;
    private String nameUser;
    private String cpfUser;
    private String passwordUser;
    private UserType typeUser;

    private UserStatus statusUser;

    public User() {
        statusUser = UserStatus.ACTIVE;
    }

    public User(Integer idUser, String nameUser, String cpfUser, String passwordUser, UserType typeUser, UserStatus statusUser) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.cpfUser = cpfUser;
        this.passwordUser = passwordUser;
        this.typeUser = typeUser;
        this.statusUser = statusUser;
    }

    public User(String nameUser, String cpfUser, UserType typeUser) {
        this(null, nameUser, cpfUser, generatePassword(), typeUser, UserStatus.ACTIVE);
    }

    public static String generatePassword() {

        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        int passwordLength = 6;

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < passwordLength; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        return password.toString();
    }


    public UserStatus getStatusUser() {return statusUser;}

    public void setStatusUser(UserStatus statusUser) {this.statusUser = statusUser;}

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getCpfUser() {
        return cpfUser;
    }

    public void setCpfUser(String cpfUser) {
        this.cpfUser = cpfUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public UserType getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(UserType typeUser) {
        this.typeUser = typeUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + idUser +
                ", name='" + nameUser + '\'' +
                ", cpf='" + cpfUser + '\'' +
                ", password='" + passwordUser + '\'' +
                ", type=" + typeUser +
                ", status=" + statusUser +
                '}';
    }
}
