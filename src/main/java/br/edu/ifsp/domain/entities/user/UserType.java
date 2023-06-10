package br.edu.ifsp.domain.entities.user;

public enum UserType {
    ADMIN("Administrador"){
        public boolean isAdmin(){
            return true ;
        }
    },
    MAINTAINER("Mantenedor"){
        public boolean isAdmin(){
            return false;
        }
    };

    public abstract boolean isAdmin();
    private String label;
    UserType(String label){this.label = label;}

    @Override
    public String toString() {return label;}
}
