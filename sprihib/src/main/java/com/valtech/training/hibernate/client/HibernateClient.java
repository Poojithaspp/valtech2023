package com.valtech.training.hibernate.client;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.NamedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.valtech.training.hibernate.Account;
import com.valtech.training.hibernate.Address;
import com.valtech.training.hibernate.AtmTx;
import com.valtech.training.hibernate.BankAccount;
import com.valtech.training.hibernate.BankAccountId;
import com.valtech.training.hibernate.ChequeTx;
import com.valtech.training.hibernate.Customer;
import com.valtech.training.hibernate.Employee;
import com.valtech.training.hibernate.OrderSummary;
import com.valtech.training.hibernate.OrderSummaryId;
import com.valtech.training.hibernate.Registration;
import com.valtech.training.hibernate.TellerTx;
import com.valtech.training.hibernate.Tx;

public class HibernateClient {
	public static void main(String[] args) throws Exception {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Employee.class);
		cfg.addAnnotatedClass(Tx.class).addAnnotatedClass(ChequeTx.class).addAnnotatedClass(TellerTx.class)
				.addAnnotatedClass(AtmTx.class);
		cfg.addAnnotatedClass(Customer.class).addAnnotatedClass(Address.class);
		cfg.addAnnotatedClass(Account.class);
		cfg.addAnnotatedClass(Registration.class).addAnnotatedClass(BankAccount.class);
		cfg.addAnnotatedClass(OrderSummary.class);
		SessionFactory sesFac = cfg.buildSessionFactory();
		Session ses = sesFac.openSession();
		Transaction tx = ses.beginTransaction();
		ses.persist(new BankAccount(new BankAccountId("SB", 1), 30000));

		BankAccountId id = new BankAccountId("SB", 1);
		BankAccount ba = (BankAccount) ses.load(BankAccount.class, id);
		ses.persist(new OrderSummary(1, 2, 3));
		OrderSummary os = (OrderSummary) ses.load(OrderSummary.class, new OrderSummaryId(1, 2));
		System.out.println("quantity=" + os.getQuantity());

//		Customer cus = new Customer("Abc", 23);
//		ses.save(cus);
//
//		Address add = new Address("JP Nagar", "Blr", 560078);
//		ses.save(add);
//		add.setCustomer(cus);
//		cus.setAddress(add);
//		ses.save(add);
//		Account acc = new Account(1000, "SB");
//		Tx tx1 = new Tx(1000);
//		Tx tx2 = new ChequeTx(2000, 123123, 34435);
//		Tx tx3 = new TellerTx(3000, 123, 345);
//		Tx tx4 = new AtmTx(5000, 789);
//
//		Account acc1 = new Account(20000, "CA");
//		Tx tx5 = new ChequeTx(2000, 456277, 345124);
//		Customer cus1 = new Customer("Def", 25);
//		Address add1 = new Address("Jayanagar", "Blr", 560070);
//		Customer cus2 = new Customer("Pqr", 26);
//		Address add2 = new Address("Gandinagar", "Hyd", 560070);
//		ses.persist(acc);
//		ses.persist(tx1);
//		ses.persist(tx2);
//		ses.persist(tx3);
//		ses.persist(tx4);
//		ses.persist(acc1);
//		ses.persist(tx5);
//		ses.persist(cus1);
//		ses.persist(cus2);
//		ses.persist(add1);
//		ses.persist(add2);
//		cus1.setAddress(add1);
//		add1.setCustomer(cus1);
//		cus2.setAddress(add2);
//		add2.setCustomer(cus2);
//		acc.addTx(tx1);
//		acc.addTx(tx2);
//		acc.addTx(tx3);
//		acc.addTx(tx4);
//		acc1.addTx(tx5);
//		acc1.addCustomer(cus2);
//		acc1.addCustomer(cus);
//		acc.addCustomer(cus1);
//		acc.addCustomer(cus2);
//		acc.addCustomer(cus);
//		ses.createQuery("SELECT DISTINCT tx.account FROM Tx tx").list().forEach(t -> System.out.println(t));
//		
//		org.hibernate.Query query = ses.createQuery("SELECT DISTINCT  c FROM Customer c join c.accounts a join a.txs t where t.amount > ? ");
//		query.setFloat(0, 3000);
//		query.list().forEach(t -> System.out.println(t));	
		Query query = ses.getNamedQuery("Tx.findAllByCityAndAmountGreaterThan");
//				ses.createQuery("Select t from Tx t join t.account.customers c where c.address.city=? and t.amount>?");
		query.setString(0, "Blr");
		query.setFloat(1, 3000);
		query.list().forEach(t -> System.out.println(t));
//	ses.persist(new Employee("Abc",LocalDate.of(1947, 8, 15),20000,'M',false));
//		int id= (Integer)ses.save(new Employee("Abc",df.parse("15-08-1947"),20000,'M',false));
//		System.out.println(id);
//		Employee e=(Employee)ses.get(Employee.class, 1);
//		System.out.println(e.getClass().getName());
//		e.setName("Abc2");
		// ses.merge(e);
		System.out.println("loading...");

		tx.commit();
		ses.close();
		sesFac.close();
	}

}
