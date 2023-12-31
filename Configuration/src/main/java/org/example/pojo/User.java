package org.example.pojo;

import javax.persistence.*;
import java.io.Serializable;

    @Entity
    @Table(name = "user")
    public class User implements Serializable{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String name;
        private String account;
        private String password;
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getAccount() {
            return account;
        }
        public void setAccount(String account) {
            this.account = account;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
    }
