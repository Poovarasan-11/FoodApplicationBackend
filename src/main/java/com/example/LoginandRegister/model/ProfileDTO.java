package com.example.LoginandRegister.model;

public class ProfileDTO {

        private String name;
        private String email;
        private String phone;
        private String address;
        private long   totalOrders;   // count of orders placed by this user

        // ── Constructor ──
        public ProfileDTO(String name, String email, String phone,
                          String address, long totalOrders) {
            this.name        = name;
            this.email       = email;
            this.phone       = phone;
            this.address     = address;
            this.totalOrders = totalOrders;
        }

        // ── Getters (Jackson needs these to serialize to JSON) ──
        public String getName()        { return name; }
        public String getEmail()       { return email; }
        public String getPhone()       { return phone; }
        public String getAddress()     { return address; }
        public long   getTotalOrders() { return totalOrders; }
    }


