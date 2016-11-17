package bank.core;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Classe Calendario que mantem a data actual e permite determinar a diferenca
 * entre duas datas. Cada data e' representada pelo numero de dias passados
 * desde o dia 1 de Janeiro de 1970.
 * 
 * @since Jdk 1.4.0
 * @author Programação com Objectos
 * @version 2.0
 * 
 * @see TestCalendario
 */
public class Calendario {

	private long _actual;

	private GregorianCalendar _cal;

	private static Calendario _calendario = new Calendario();

	private final static int MILIDIA = 24 * 60 * 60 * 1000;

	/**
	 * Selector do calendario.
	 * 
	 * @return a unica instancia desta classe.
	 */
	public static Calendario obtemCalendario() {
		return _calendario;
	}

	/**
	 * Constructor da classe. Inicializa as variaveis com os valores do dia
	 * actual.
	 */
	private Calendario() {
		_cal = new GregorianCalendar();
		// coloca no dia actual

		_cal.setTimeInMillis(System.currentTimeMillis());
		_actual = _cal.getTimeInMillis() / MILIDIA;
	}

	/**
	 * Devolve a data que representa o dia corrente.
	 * 
	 * @return o numero de dias que passaram desde o 01/01/1970.
	 */
	public long hoje() {
		return _actual;
	}

	/**
	 * Devolve o numero de dias de diferenca entre o dia de de hoje e o dia
	 * representado por anterior.
	 * 
	 * @param anterior
	 *            dia inferior do intervalo.
	 * 
	 * @return numero de dias entre um dado dia anterior e o dia de hoje.
	 */
	public int diasPassados(long anterior) {
		return (int) (hoje() - anterior);
	}

	/**
	 * Devolve uma String no formato AAAA MM DD referente 'a data dada como
	 * argumento.
	 * 
	 * @param data
	 *            numero de dias passados desde 01/01/1970.
	 * 
	 * @return String que representa a data.
	 */
	@SuppressWarnings("nls")
	public String obtemData(long data) {
		String str;
		// O 6 e' para resolver possiveis erro de DST
		// (Data Saving Time: horario de Verao).
		// Para manter a compatibilidade entre o Windows e o Linux.
		_cal.set(1970, 0, 1, 6, 0);
		_cal.add(Calendar.DATE, (int) data);

		// Soma-se 1 ao mes porque o mes comeca em 0.
		str = _cal.get(Calendar.YEAR) + " " + (_cal.get(Calendar.MONTH) + 1)
				+ " " + _cal.get(Calendar.DAY_OF_MONTH);

		return str;
	}

	/**
	 * Actualiza a data referente ao dia de hoje. Apenas deve ser utilizado no
	 * modo debug.
	 * 
	 * @param ano
	 *            valor que representa o ano da data actual.
	 * @param mes
	 *            valor que representa o mes da data actual (comeca em 1).
	 * @param dia
	 *            valor que representa o dia da data actual.
	 */
	public void colocaData(int ano, int mes, int dia) {
		if (ano >= 1970)
			_actual = contaDiasAposEpoca(ano, mes, dia);
		else
			_actual = contaDiasAntesEpoca(ano, mes, dia);
	}

	/**
	 * Conta o numero de dias entre data dada como argumento e 01/01/1970. Deve
	 * ser chamada se a data e' posterior a 01/01/1970.
	 * 
	 * @param ano
	 *            ano da data.
	 * @param mes
	 *            mes da data.
	 * @param dia
	 *            dia da data.
	 * 
	 * @return numero de dias decorridos entre 01/01/1970 e a data.
	 */
	private long contaDiasAposEpoca(int ano, int mes, int dia) {
		int t_ano = 1970;
		long dias = 0;

		while (t_ano < ano) {
			if (_cal.isLeapYear(t_ano++))
				dias += 366;
			else
				dias += 365;
		}
		_cal.set(ano, mes - 1, dia);
		dias += _cal.get(Calendar.DAY_OF_YEAR) - 1;
		return dias;
	}

	/**
	 * Conta o numero de dias entre a data dada como argumento e 01/01/1970 So'
	 * deve ser chamada quando a data e' anterior a 01/01/1970.
	 * 
	 * @param ano
	 *            ano da data
	 * @param mes
	 *            mes da data
	 * @param dia
	 *            dia da data
	 * 
	 * @return o numero de dias decorridos entre 01/01/1970 e a data.
	 */
	private long contaDiasAntesEpoca(int ano, int mes, int dia) {
		int t_ano = 1969;
		long dias = 0;

		while (t_ano >= ano) {
			if (_cal.isLeapYear(t_ano--))
				dias -= 366;
			else
				dias -= 365;
		}

		_cal.set(ano, mes - 1, dia);
		dias += _cal.get(Calendar.DAY_OF_YEAR) - 1;
		return dias;
	}

	/**
	 * Actualiza a data referente ao dia de hoje. Apenas deve ser utilizado no
	 * modo debug.
	 * 
	 * @param data
	 *            novo valor temporal em dias a partir de 01/01/1970.
	 */
	public void colocaData(long data) {
		_actual = data;
	}

	/**
	 * Actualiza a data actual, incrementando-a um certo numero de dias.
	 * 
	 * @param dias
	 *            numero de dias a incrementar.
	 */
	public void incrementaData(int dias) {
		colocaData(hoje() + dias);
	} // incrementaData

	/**
	 * Escreve a data actual.
	 */
	@Override
	public final String toString() {
		return obtemData(hoje());
	}

}
