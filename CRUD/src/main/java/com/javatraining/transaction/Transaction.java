package com.javatraining.transaction;
import java.util.Scanner;
import com.javatraining.model.*;
import org.hibernate.*;
import org.springframework.transaction.annotation.Transactional;
public class Transaction {
    @Transactional(rollbackFor = Exception.class)
    public static void createUser(Session session, Scanner scanner) {
        try {
            User newUser = new User();
            System.out.println("Enter fullname:");
            newUser.setFullname(scanner.next());
            System.out.println("Enter username:");
            newUser.setUsername(scanner.next());
            System.out.println("Enter password:");
            newUser.setPassword(scanner.next());
            newUser.setCreatedAt(new java.util.Date());
            newUser.setModifiedAt(new java.util.Date());
            System.out.println("Transaction commit ? 1/0:");
            int commit = Integer.parseInt(scanner.next());
            if(commit == 0) {
                throw new Exception("Khong luu user");
            }
            session.persist(newUser);
        } catch (Exception e) {
            System.out.println("Khong luu user");
        }
    }
}
