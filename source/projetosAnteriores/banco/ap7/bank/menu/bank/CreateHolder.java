package bank.menu.bank;

import java.io.IOException;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import bank.core.Bank;
import bank.core.Holder;
import bank.messages.bank.MenuEntries;
import bank.messages.bank.Messages;

/**
 * Classe CriarTitular que representa o comando que permite a criacao de
 * titulares, representados a partir do seu numero.
 * @version 2.1
 */
public class CreateHolder extends Command<Bank> {
	/**
	 * Construtor da classe CriarTitular.
	 * 
	 * @param bank
	 *            banco a que se refere o comando.
	 */
	public CreateHolder(Bank bank) {
		super(MenuEntries.CREATE_HOLDER, bank);
	}

	/**
	 * Executa o comando. Procede 'a criacao do titular e apresenta feedback ao
	 * utilizador.
	 * 
	 * @throws OperacaoInvalida
	 *             caso aconteca algum erro.
	 */
	@Override
	public final void execute() throws InvalidOperation {
		Form f = new Form(title());
		InputString name = new InputString(f, Messages.requestHolderName());
		InputInteger id = new InputInteger(f, Messages.requestHolderId());
		f.parse();
		Holder holder = new Holder(entity(), id.value(), name.value());
		(new Display(title())).add(Messages.createdHolder(holder)).display();
	}
}
