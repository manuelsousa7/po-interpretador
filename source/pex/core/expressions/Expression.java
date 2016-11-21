package pex.core.expressions;

import java.io.Serializable;

/**
 * Classe usada para representar uma expressao no programa
 *
 * @author Manuel e Goncalo
 */
public abstract class Expression implements Serializable {

     /**
     * Retorna o nome da expressao
     *
     * @return String Retorna uma string que representa o nome da expressao
     */
     public abstract String getAsText();

     /**
     * Retorna o valor da expressao
     *
     * @return Expression Retorna uma expressao que representa o valor da expressao
     */
     public abstract Expression evaluate();
}