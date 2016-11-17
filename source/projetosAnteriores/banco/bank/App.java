package bank;

import pt.utl.ist.po.ui.Menu;
import static pt.utl.ist.po.ui.UserInteraction.IO;

import java.io.*;
import bank.core.Bank;
import bank.menu.BankMenu;

/**
 * This is a sample client for bank classes.
 * 
 * @author Programação com Objectos
 * @version 2.0
 */

public class App {
	/**
	 * @param args
	 */
	@SuppressWarnings("nls")
	public static void main(String[] args) {
		Bank bank = null;
		String file = System.getProperty("Save");

		/* Create a Bank instance */
		if (args.length == 1) {
			bank = new Bank(args[0]);
		} else {
			if (file != null)
			  try {
			    bank = Bank.load(file);
			  } catch (Exception e) {
			    System.out.println("Erro : "+file+" : "+e);
			  }
			if (bank == null)
			  bank = new Bank("Banco");
		}

		/* Read an Import file, if any */
		String filename = System.getProperty("Import");
		if (filename != null) bank.parseInputFile(filename);

		/* Start the user interface with the Bank instance */
		IO.setTitle(bank.getName());
		Menu m = new BankMenu(bank);
		m.open();

		/* On end, save file and close IO */
		if (file != null)
		  try {
		     bank.save(file);
		  } catch (IOException e) {
		    System.out.println("Erro : "+file+" : "+e);
		  }
		IO.close();
	}

}
