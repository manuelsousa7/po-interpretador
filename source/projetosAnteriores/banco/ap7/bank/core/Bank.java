package bank.core;

import bank.messages.bank.Messages;

import java.io.*;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe Banco que, para alem de permitir a criacao de bancos (identificados
 * pelo nome), e' responsavel pela gestao de Contas e Titulares atraves de dois
 * HashMaps
 * 
 * Esta classe apresenta ainda a interface com o utilizador e o metodo inicial
 * main da aplicacao bancaria.
 * 
 * @author Programação com Objectos
 * @version 2.1
 */

public class Bank implements Serializable {
	/**
	 * Serial number for serialization.
	 */
	private static final long serialVersionUID = 6525382032511252923L;

	/** Bank name. */
	private String _name;

	/** Account holders. */
	private Map<Integer, Holder> _holders = new HashMap<Integer, Holder>();

	/** Bank accounts. */
	private Map<Integer, BankAccount> _accounts = new HashMap<Integer, BankAccount>();

	/** Account counter. */
	private int _accountNumber = 0;

	/**
	 * Constructor.
	 * 
	 * @param name
	 *            bank name.
	 */
	public Bank(String name) {
		_name = name;
	}

	/**
	 * Returns the name of the bank.
	 * 
	 * @return the name of the bank.
	 */
	public final String getName() {
		return _name;
	}

	/**
	 * Dois objectos Banco sao iguais se ambos tiverem o mesmo nome.
	 * 
	 * @return true se ambos os objectos Banco tem o mesmo nome, false caso
	 *         contrario.
	 */
	@Override
	public final boolean equals(Object o) {
		return o instanceof Bank && _name.equals(((Bank) o).getName());
	}

	/**
	 * Register account.
	 * 
	 * @param account
	 *            the account.
	 * 
	 * @return the number for the registered account.
	 */
	public int addAccount(BankAccount account) {
		int id = ++_accountNumber;
		_accounts.put(id, account);
		return id;
	}

	/**
	 * Remove an account. An account can only be removed if its total balance is
	 * zero. If it is not possible to remove an account, an exception is thrown.
	 * 
	 * @param account
	 *            the account to be removed.
	 * @throws InvalidRemoval
	 */
	public final void removeAccount(BankAccount account)
			throws InvalidRemoval {
		if (account.canBeRemoved())
			_accounts.remove(account.getId());
		else
			throw new InvalidRemoval(Double.toString(account.getBalance()));
	}

	/**
	 * Get the account with the given number.
	 * 
	 * @param id
	 *            the account number.
	 * 
	 * @return the account or null if the number does not correspond to a valid
	 *         account.
	 */
	public final BankAccount getAccount(int id) {
		return _accounts.get(id);
	}

	/**
	 * Return all the accounts as an unmodifiable collection.
	 * 
	 * @return a collection with all the accounts.
	 */
	public Collection<BankAccount> getAccounts() {
		return Collections.unmodifiableCollection(_accounts.values());
	}

	/**
	 * Register an account holder.
	 * 
	 * @param holder
	 *            the account holder.
	 * 
	 * @return true if registered,
	 * 	   false if another holder with the same Id exists.
	 */
	public void addHolder(Holder holder)
			throws InvalidHolder {
	  	if (_holders.containsKey(holder.getId()))
		     throw new InvalidHolder(holder.getId());
		_holders.put(holder.getId(), holder);
	}

	/**
	 * Remove an account holder.
	 * 
	 * @param id
	 *            the account holder's id.
	 * 
	 * @return true, if the holder was removed; false, otherwise.
	 */
	public final boolean removeHolder(int id) {
		Holder holder = getHolder(id);
		if (holder != null) {
			_holders.remove(id);
			return true;
		}
		return false;
	}

	/**
	 * Return all the account holders as an unmodifiable collection.
	 * 
	 * @return a collection with all the account holders.
	 */
	public Collection<Holder> getHolders() {
		return Collections.unmodifiableCollection(_holders.values());
	}

	/**
	 * Get the account holder with the given number.
	 * 
	 * @param id
	 *            the account holder's number.
	 * 
	 * @return the account holder or null if the number does not correspond to a
	 *         valid account holder.
	 */
	public Holder getHolder(int id) {
		return _holders.get(id);
	}

	/**
	 * Get the account holder with the given number.
	 * 
	 * @param id
	 *            the account holder's number.
	 * 
	 * @return the account holder or null if the number does not correspond to a
	 *         valid account holder.
	 */
	public void parseInputFile(String file) {
	      int lineno = 0;
	      try {
		// Reader in = new InputStreamReader(new FileInputStream("file"), "UTF-8"));
		BufferedReader in = new BufferedReader(new FileReader(file));
		String s;

		while ((s = in.readLine()) != null) {
		  String line = new String(s.getBytes(), "UTF-8");
		  lineno++;
		  if (line.charAt(0) == '#') continue;
		  String[] split = line.split(":");
		  if (split[0].equals(Messages.holderKey()))
		    try {
		      new Holder(this, split);
		    } catch (InvalidHolder ih) { System.err.println(ih); }
		  else if (split[0].equals(Messages.accountKey()))
		    new BankAccount(this, split);
		}
	      } catch (FileNotFoundException e) {
		System.out.println("Erro (file not found):"+file+": "+e);
	      } catch (IOException e) {
		System.out.println("Erro (IO):"+file+":"+lineno+": line "+e);
	      }
	}
	
	/**
	 * Carrega o estado anterior da aplicacao que estava guardado num
	 * dado ficheiro.
	 *
	 * @param file o nome do ficheiro com os dados serializados.
	 *
	 * @throws IOException caso aconteca algum erro durante a leitura
	 * do estado.
	 * @return um objecto Telele com dados os recuperados do file.
	 **/
	public static Bank load(String file)
	  throws IOException, ClassNotFoundException{
	  ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));

	  Bank bank = (Bank)in.readObject();
	  in.close();

	  return bank;
	}

	/**
	 * Guarda o estado actual da aplicacao.
	 *
	 * @param file o nome do ficheiro a conter os dados a serializar.
	 *
	 * @throws IOException caso aconteca algum erro durante a gravacao
	 * do estado.
	 **/
	public void save(String file) throws IOException {
	  ObjectOutputStream out =
	    new ObjectOutputStream(new FileOutputStream(file));
	  
	  out.writeObject(this);
	  out.close();
	}
}
